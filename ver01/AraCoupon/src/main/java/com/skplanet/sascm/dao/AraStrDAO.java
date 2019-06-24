package com.skplanet.sascm.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AraStrDAO {

	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws SQLException;
	public List<Map<String,Object>> selectApprovalReq(Map<String, Object> param) throws SQLException;
	public List<Map<String,Object>> selectApprovalRes(Map<String, Object> param) throws SQLException;
	public List<Map<String,Object>> giveCouponList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listCouponList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listPaymentList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listCalculateList(Map<String, Object> param) throws Exception;
}
