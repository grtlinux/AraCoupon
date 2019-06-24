package com.skplanet.sascm.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AraCtrDAO {

	public Map<String,Object> selectCenterInfo(Map<String, Object> param) throws SQLException;
	public List<Map<String,Object>> selectApprovalReq(Map<String, Object> param) throws SQLException;
	public List<Map<String,Object>> selectApprovalRes(Map<String, Object> param) throws SQLException;
}
