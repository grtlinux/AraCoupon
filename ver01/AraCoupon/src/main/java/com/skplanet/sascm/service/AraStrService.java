package com.skplanet.sascm.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AraStrService {

	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> giveCouponList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listCouponList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listPaymentList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listCalculateList(Map<String, Object> param) throws Exception;

	public Map<String,Object> selectCampId(Map<String, Object> param) throws SQLException;
	public int insertAraCamp(Map<String, Object> param) throws SQLException;
	public int insertAraCampInfo(Map<String, Object> param) throws SQLException;
	public int insertAraCampOff(Map<String, Object> param) throws SQLException;
	public int insertAraCampChl(Map<String, Object> param) throws SQLException;
	public int insertAraOffCpn(Map<String, Object> param) throws SQLException;
	public int insertAraChlSms(Map<String, Object> param) throws SQLException;
	
	public int insertApprReq(Map<String, Object> param) throws SQLException;

	public List<Map<String,Object>> selectApprReqList(Map<String, Object> param) throws Exception;

	public List<Map<String,Object>> selectApprResList(Map<String, Object> param) throws Exception;
}
