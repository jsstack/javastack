package com.jsstack.javastack.dao;

import java.util.List;
import java.util.Map;

public interface IDao {
	/**
	 * @param <T>
	 *            查询list<entry>
	 * @param clazz
	 * @return
	 */
	public <T> List<T> findAll(Class<T> clazz);
	public <T> List<T> findAll(Class<T> clazz, String where);

	/**
	 * @param <T>
	 *            根据主键查找entry
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T findById(Class<T> clazz, int id);

	/**
	 * @param <T>
	 *            仅仅适合存在一个主键，且主键递增的情况
	 * @param clazz
	 * @param map
	 * @return
	 */
	public int insert(Object obj);

	/**
	 * @param <T>
	 *            根据条件更新entry
	 * @param clazz
	 * @param map
	 * @return
	 */
	public <T> int update(Object obj, String where);
	
	public <T> int update(Object obj);

	/**
	 * @param <T>
	 *            根据条件更新entry
	 * @param clazz
	 * @param map
	 * @return
	 */
	public <T> int delete(Class<T> clazz, int id);

	// 以下为自定义
	public int insertSql(String sql, Object... args);

	public int updateSql(String sql, Object... args);

	public void deleteSql(String sql, Object... args);

	public List<Map<String, Object>> executeQuerySql(String sql, Object... args);

	/**
	 * @param sql
	 *            批量更新
	 * @param objs
	 * @return
	 */
	public void batchUpdateSql(String sql, Object[][] objs);
}
