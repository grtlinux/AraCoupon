package com.skplanet.sascm.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AraUsrDAO {

	public Map<String,Object> selectUserInfo(Map<String, Object> param) throws SQLException;
	public List<Map<String,Object>> takeCouponList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listCouponList(Map<String, Object> param) throws Exception;
}
