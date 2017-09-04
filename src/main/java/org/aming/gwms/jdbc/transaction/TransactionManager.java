package org.aming.gwms.jdbc.transaction;

import java.sql.Connection;

public class TransactionManager {

	private ThreadLocal<Connection> localConnection = new ThreadLocal<>();

	public void addTransaction(Connection conn) {
		localConnection.set(conn);
	}

	public void beginTransaction() {

	}

	public static TransactionManager getInstance(Connection conn) {
		TransactionManager transaction = TransactionHolder.transaction;
		transaction.localConnection.set(conn);
		return transaction;
	}

	private static class TransactionHolder {
		private static final TransactionManager transaction = new TransactionManager();
	}

	private TransactionManager() {
	}
}
