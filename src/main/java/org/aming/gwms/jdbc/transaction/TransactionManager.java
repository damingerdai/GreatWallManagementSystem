package org.aming.gwms.jdbc.transaction;

import org.aming.gwms.constants.ErrorCodeConstants;
import org.aming.gwms.exceptions.AmingException;
import org.aming.gwms.exceptions.ExceptionBuilder;
import org.aming.gwms.jdbc.datasource.DataSourceUtils;

import javax.annotation.Nonnull;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    private static final String ERROR_BEGIN_TRANSACTION = "fail to begin transaction";
    private static final String ERROR_COMMIT_TRANSACTION = "fail to commit transaction";
    private static final String ERROR_ROLLBACK_TRANSACTION = "fail to rollback transaction";
    private static final String ERROR_CLOSE_TRANSACTION = "fail to close transaction";

	private DataSource dataSource;

	private static TransactionManager transactionManager = new TransactionManager();


	public final void beginTransaction() throws AmingException {
		try{
			doBeginTransaction();
		}catch (Exception ex){
            throw ExceptionBuilder.buildAmingException(ErrorCodeConstants.ERROR_TRANSACTION,ERROR_BEGIN_TRANSACTION,ex);
		}
	}

	private final void doBeginTransaction() throws SQLException {
		Connection conn = obtianConnection();
		conn.setAutoCommit(false);
	}

	public final void commitTransaction() throws AmingException{
        try{
            doCommitTransaction();
        }catch (Exception ex){
            throw ExceptionBuilder.buildAmingException(ErrorCodeConstants.ERROR_TRANSACTION,ERROR_COMMIT_TRANSACTION,ex);
        }
    }

    private final void doCommitTransaction() throws SQLException{
	    Connection conn = obtianConnection();
	    conn.commit();
    }

    public final void rollbacTransaction() throws AmingException{
	    try{
	        doRollbackTransaction();
        }catch (Exception ex){
	        throw ExceptionBuilder.buildAmingException(ErrorCodeConstants.ERROR_TRANSACTION,ERROR_ROLLBACK_TRANSACTION,ex);
        }
    }

    private final void doRollbackTransaction() throws SQLException{
	    Connection conn = obtianConnection();
	    conn.rollback();
    }

    public final void closeTransaction() throws  AmingException{
	    try{
            doCloseTransaction();
        }catch (Exception ex){
	        throw ExceptionBuilder.buildAmingException(ErrorCodeConstants.ERROR_TRANSACTION,ERROR_CLOSE_TRANSACTION,ex);
        }
    }

    private final void doCloseTransaction() throws SQLException{
	    Connection conn = obtianConnection();
	    conn.setAutoCommit(true);
	    conn.setReadOnly(false);
	    conn.close();
	    DataSourceUtils.releaseConnection(conn);
    }


	public static TransactionManager getInstance(@Nonnull DataSource dataSource){
		transactionManager.dataSource = dataSource;
		return transactionManager;
	}

	public DataSource obtainDataSource() {
		return dataSource;
	}

	private Connection obtianConnection(){
		return DataSourceUtils.getConnection(obtainDataSource());
	}

	private TransactionManager(){}
}

