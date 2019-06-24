package com.skplanet.sascm.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AraCtrService {

	public Map<String,Object> selectCenterInfo(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectApprovalReq(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectApprovalRes(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCampaignInfo(Map<String, Object> param) throws Exception;
	public int insertCouponSheet(Map<String, Object> param) throws SQLException;
	public List<Map<String,Object>> listCalculateList(Map<String, Object> param) throws Exception;
}
