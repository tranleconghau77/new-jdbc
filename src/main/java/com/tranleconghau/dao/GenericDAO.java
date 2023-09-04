package com.tranleconghau.dao;

import java.util.List;

import com.tranleconghau.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... paramaters);
	void update (String sql, Object... parameters);
	Long insert (String sql, Object... parameters);
}
