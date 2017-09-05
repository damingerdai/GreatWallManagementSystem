package org.aming.gwms.jdbc;


import com.google.common.collect.Lists;
import org.aming.gwms.exceptions.AmingException;
import org.aming.gwms.exceptions.Exceptions;
import org.aming.gwms.factory.DataSourceFactory;
import org.aming.gwms.jdbc.datasource.DataSourceUtils;
import org.aming.gwms.jdbc.support.RowMapper;
import org.aming.gwms.logger.AmingLogger;
import org.aming.gwms.logger.LoggerManager;

import javax.annotation.Nullable;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * jdbc模板
 * 参考：
 * <p>org.springframework.jdbc.core.JdbcTemplate</p>
 * <p>org.springframework.jdbc.support.JdbcUtils</p>
 *
 * @author daming
 * @version 2017/7/4.
 */
public class JdbcUtils {

    private static final AmingLogger logger = LoggerManager.getLogger(JdbcUtils.class.getName());

    private static final DataSource dataSource = DataSourceFactory.getDataSource();

    public static void execute(final String sql) throws AmingException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DataSourceUtils.getConnection(dataSource);
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (Exception ex) {
            closeStatement(stmt);
            stmt = null;
            DataSourceUtils.releaseConnection(conn);
            conn = null;
            throw Exceptions.toRuntimeException(ex);
        } finally {
            closeStatement(stmt);
            DataSourceUtils.releaseConnection(conn);
        }
    }

    public static void execute(final String sql, final Object[] parameters) throws AmingException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DataSourceUtils.getConnection(dataSource);
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
            ps.execute();
        } catch (Exception ex) {
            closeStatement(ps);
            ps = null;
            DataSourceUtils.releaseConnection(conn);
            conn = null;
            throw Exceptions.toRuntimeException(ex);
        } finally {
            closeStatement(ps);
            DataSourceUtils.releaseConnection(conn);
        }
    }

    public static <T> List<T> query(final String sql, final Object[] parameters, RowMapper<T> rowMapper) throws AmingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> result = Lists.newArrayList();
        try {
            conn = DataSourceUtils.getConnection(dataSource);
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(rowMapper.mapRow(rs));
            }
        } catch (Exception ex) {
            closeResultSet(rs);
            rs = null;
            closeStatement(ps);
            ps = null;
            DataSourceUtils.releaseConnection(conn);
            conn = null;
            throw Exceptions.toRuntimeException(ex);
        } finally {
            closeStatement(ps);
            DataSourceUtils.releaseConnection(conn);
        }
        return result;
    }

    public static int queryCount(final String sql,final Object[] parameters){
        int count = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DataSourceUtils.getConnection(dataSource);
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                rs.getInt(1);
            }
        } catch (Exception ex){
            closeResultSet(rs);
            rs = null;
            closeStatement(ps);
            ps = null;
            DataSourceUtils.releaseConnection(conn);
            conn = null;
            throw  Exceptions.toAmingException(ex);
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            DataSourceUtils.releaseConnection(conn);
        }
        return count;
    }


    private static void closeStatement(@Nullable Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.debug("Could not close JDBC Statement", ex);
            } catch (Throwable ex) {
                // We don't trust the JDBC driver: It might throw RuntimeException or Error.
                logger.debug("Unexpected exception on closing JDBC Statement", ex);
            }
        }
    }

    private static void closeResultSet(@Nullable ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                logger.trace("Could not close JDBC ResultSet", ex);
            } catch (Throwable ex) {
                // We don't trust the JDBC driver: It might throw RuntimeException or Error.
                logger.trace("Unexpected exception on closing JDBC ResultSet", ex);
            }
        }
    }
}
