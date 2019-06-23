package com.skplanet.sascm.dao;

import java.sql.SQLException;
import java.util.Map;

public interface AraUsrDAO {

	public Map<String,Object> selectUserInfo(Map<String, Object> param) throws SQLException;
}
