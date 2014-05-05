package com.jsstack.javastack.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class DBHelper {
	private static DataSource dataSource;

	private static String URL;
	private static String USER_NAME;
	private static String PASSWORD;

	private DBHelper() {
	}

	private static DataSource setupDataSource() {
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
				URL, USER_NAME, PASSWORD);

		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(
				connectionFactory, null);

		ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(
				poolableConnectionFactory);

		poolableConnectionFactory.setPool(connectionPool);

		PoolingDataSource<PoolableConnection> dataSource = new PoolingDataSource<>(
				connectionPool);

		return dataSource;
	}

	public static QueryRunner getQueryRunner() {
		if (DBHelper.dataSource == null) {
			initParameters();
			DBHelper.dataSource = setupDataSource();

			System.out.println("Initialize dbcp...");
		}

		return new QueryRunner(DBHelper.dataSource);
	}

	public static ResultSet getColumns(String tableName) throws SQLException {
		return getMetaData().getColumns(null, null, tableName, null);
	}

	public static String getPrimaryKey(String className) throws SQLException {
		ResultSet rs = getMetaData().getPrimaryKeys(null, null, className);

		String primaryKey = null;
		while (rs.next()) {
			primaryKey = rs.getString("Column_name");
		}

		return primaryKey;
	}

	private static DatabaseMetaData getMetaData() throws SQLException {
		return DBHelper.dataSource.getConnection().getMetaData();
	}

	private static void initParameters() {
		Properties ps = System.getProperties();
		String host = ps.getProperty("mysql-host");
		String port = ps.getProperty("mysql-port");
		String db = ps.getProperty("mysql-db");

		StringBuilder url = new StringBuilder();

		url.append("jdbc:mysql://")
				.append(host)
				.append(":")
				.append(port)
				.append("/")
				.append(db)
				.append("?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		URL = url.toString();
		USER_NAME = ps.getProperty("mysql-username");
		PASSWORD = ps.getProperty("mysql-password");
	}

	private static boolean pmdKnownBroken = false;

	public static void fillStatement(PreparedStatement stmt, Object... params)
			throws SQLException {

		// check the parameter count, if we can
		ParameterMetaData pmd = null;
		if (!pmdKnownBroken) {
			pmd = stmt.getParameterMetaData();
			int stmtCount = pmd.getParameterCount();
			int paramsCount = params == null ? 0 : params.length;

			if (stmtCount != paramsCount) {
				throw new SQLException("Wrong number of parameters: expected "
						+ stmtCount + ", was given " + paramsCount);
			}
		}

		// nothing to do here
		if (params == null) {
			return;
		}

		for (int i = 0; i < params.length; i++) {
			if (params[i] != null) {
				stmt.setObject(i + 1, params[i]);
			} else {
				// VARCHAR works with many drivers regardless
				// of the actual column type. Oddly, NULL and
				// OTHER don't work with Oracle's drivers.
				int sqlType = Types.VARCHAR;
				if (!pmdKnownBroken) {
					try {
						/*
						 * It's not possible for pmdKnownBroken to change from
						 * true to false, (once true, always true) so pmd cannot
						 * be null here.
						 */
						sqlType = pmd.getParameterType(i + 1);
					} catch (SQLException e) {
						pmdKnownBroken = true;
					}
				}
				stmt.setNull(i + 1, sqlType);
			}
		}
	}

	private static void rethrow(SQLException cause, String sql,
			Object... params) throws SQLException {

		String causeMessage = cause.getMessage();
		if (causeMessage == null) {
			causeMessage = "";
		}
		StringBuffer msg = new StringBuffer(causeMessage);

		msg.append(" Query: ");
		msg.append(sql);
		msg.append(" Parameters: ");

		if (params == null) {
			msg.append("[]");
		} else {
			msg.append(Arrays.deepToString(params));
		}

		SQLException e = new SQLException(msg.toString(), cause.getSQLState(),
				cause.getErrorCode());
		e.setNextException(cause);

		throw e;
	}

	public static int insert(String sql, Object... params) throws SQLException {
		Connection conn = dataSource.getConnection();
		if (conn == null) {
			throw new SQLException("Null connection");
		}

		if (sql == null) {
			throw new SQLException("Null SQL statement");
		}

		PreparedStatement stmt = null;
		int rows = 0;

		try {
			stmt = conn.prepareStatement(sql);
			fillStatement(stmt, params);
			rows = stmt.executeUpdate();

			if (rows == 1) {
				ResultSet rs = stmt.getGeneratedKeys();
				return rs.next() ? rs.getInt(1) : -1;
			}
		} catch (SQLException e) {
			rethrow(e, sql, params);
		} finally {
			DbUtils.close(stmt);
		}

		return -1;
	}
}
