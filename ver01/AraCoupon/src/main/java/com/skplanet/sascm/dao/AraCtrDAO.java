package com.skplanet.sascm.dao;

import java.sql.SQLException;
import java.util.Map;

public interface AraCtrDAO {

	public Map<String,Object> selectCenterInfo(Map<String, Object> param) throws SQLException;
}
