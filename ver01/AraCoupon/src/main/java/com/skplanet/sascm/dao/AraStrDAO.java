package com.skplanet.sascm.dao;

import java.sql.SQLException;
import java.util.Map;

public interface AraStrDAO {

	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws SQLException;
}
