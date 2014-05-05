package com.jsstack.javastack.dao;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class Dao implements IDao {

	private QueryRunner qryRun = null;

	public Dao() {
		qryRun = DBHelper.getQueryRunner();
	}

	public <T extends Object> List<T> findAll(Class<T> clazz) {
		return findAll(clazz, "");
	}

	public <T extends Object> List<T> findAll(Class<T> clazz, String where) {
		if (where == null) {
			where = "";
		}
		ResultSetHandler<List<T>> rsh = new BeanListHandler<T>(clazz);
		List<T> result = null;
		try {
			result = qryRun.query("select * from " + clazz.getSimpleName()
					+ " " + where, rsh);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;
	}

	public <T> T findById(Class<T> clazz, int id) {
		ResultSetHandler<T> rsh = new BeanHandler<T>(clazz);
		T result = null;
		try {
			String primary_key = DBHelper.getPrimaryKey(clazz.getSimpleName());
			if (!"".equals(primary_key) || null != primary_key) {
				result = qryRun.query("select * from " + clazz.getSimpleName()
						+ " where " + primary_key + "=?", rsh,
						new Object[] { id });

			} else {
				throw new SQLException("This table has not primary key");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;
	}

	public List<Map<String, Object>> executeQuery(String sql, Object... args) {
		MapListHandler rsh = new MapListHandler();
		List<Map<String, Object>> result = null;
		try {
			result = qryRun.query(sql, rsh, args);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;
	}

	public int insertSql(String sql, Object... args) {
		return executeUpdateSql(sql, args);
	}

	public int updateSql(String sql, Object... args) {
		return executeUpdateSql(sql, args);
	}

	public void deleteSql(String sql, Object... args) {
		executeUpdateSql(sql, args);
	}

	public int executeUpdateSql(String sql, Object... args) {
		int rows = 0;
		try {
			rows = qryRun.update(sql, args);
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return rows;
	}

	public void batchUpdateSql(String sql, Object[][] objs) {
		try {
			qryRun.batch(sql, objs);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public int insert(Object obj) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Field[] field = obj.getClass().getDeclaredFields();
			Field.setAccessible(field, true);
			for (Field f : field) {
				Object o = f.get(obj);
				map.put(f.getName(), o);
			}
			Class<? extends Object> clazz = obj.getClass();
			String table = clazz.getSimpleName();

			StringBuffer s = new StringBuffer("insert into " + table + "(");
			StringBuffer sv = new StringBuffer(" values(");

			ResultSet rs1 = DBHelper.getColumns(table);
			rs1.last();
			int m = rs1.getRow();
			Object[] objs = new Object[m - 1];
			int count = 0;
			rs1.first();

			String primary_key = DBHelper.getPrimaryKey(clazz.getSimpleName());
			while (rs1.next()) {
				String column = rs1.getString("Column_name");
				if (!column.equals(primary_key)) {
					boolean b = rs1.isLast();
					if (b) {
						s.append(column + ")");
						sv.append("?)");
					} else {
						s.append(column + ",");
						sv.append("?,");
					}
					objs[count] = map.get(column);
					count++;
				}
			}
			String sql = s.append(sv).toString();
			int id = DBHelper.insert(sql, objs);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int update(Object obj) {
		return update(obj, "");
	}

	public int update(Object obj, String where) {
		if (where == null) {
			where = "";
		}

		Class<? extends Object> clazz = obj.getClass();
		String table = clazz.getSimpleName();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Field[] field = obj.getClass().getDeclaredFields();
			Field.setAccessible(field, true);
			for (Field f : field) {
				Object o = f.get(obj);
				map.put(f.getName(), o);
			}
			String primary_key = DBHelper.getPrimaryKey(clazz.getSimpleName());
			ResultSet rs1 = DBHelper.getColumns(table);
			StringBuffer s = new StringBuffer("update " + table + " set ");
			rs1.last();
			int m = rs1.getRow();
			Object[] objs = new Object[m - 1];
			int count = 0;
			rs1.first();
			while (rs1.next()) {
				String column = rs1.getString("Column_name");
				if (!column.equals(primary_key)) {
					boolean b = rs1.isLast();

					if (!b) {
						s.append(column + "=?, ");
					} else {
						s.append(column + "=? ");
					}
					objs[count] = map.get(column);
					count++;
				}
			}
			String sql = s.append(where).toString();
			System.out.println("=======" + sql);
			return qryRun.update(sql, objs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public <T> int delete(Class<T> clazz, int id) {
		String table = clazz.getSimpleName();
		try {
			StringBuffer s = new StringBuffer("delete from " + table
					+ " where " + DBHelper.getPrimaryKey(clazz.getSimpleName())
					+ "=?");
			String sql = s.toString();
			System.out.println("=======" + sql);
			return qryRun.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Map<String, Object>> executeQuerySql(String sql, Object... args) {
		MapListHandler rsh = new MapListHandler();
		List<Map<String, Object>> result = null;
		try {
			result = qryRun.query(sql, rsh, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}