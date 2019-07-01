package com.skplanet.sascm.service;

import java.util.List;
import java.util.Map;

public interface AraStrService {

	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> giveCouponList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listCouponList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listPaymentList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listCalculateList(Map<String, Object> param) throws Exception;

	
	
	public Map<String,Object> selectCampId(Map<String, Object> param) throws Exception;
	public int insertAraCamp(Map<String, Object> param) throws Exception;
	public int insertAraCampInfo(Map<String, Object> param) throws Exception;
	public int insertAraCampOff(Map<String, Object> param) throws Exception;
	public int insertAraCampChl(Map<String, Object> param) throws Exception;
	public int insertAraOffCpn(Map<String, Object> param) throws Exception;
	public int insertAraChlSms(Map<String, Object> param) throws Exception;
	
	public int insertApprReq(Map<String, Object> param) throws Exception;

	public List<Map<String,Object>> selectApprReqList(Map<String, Object> param) throws Exception;

	public List<Map<String,Object>> selectApprResList(Map<String, Object> param) throws Exception;

	
	public List<Map<String,Object>> selectAllCpnList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectCouponList(Map<String, Object> param) throws Exception;
	public int giveCpnList(Map<String, Object> param) throws Exception;

	public List<Map<String,Object>> selectPayCpnList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectNoPayCpnList(Map<String, Object> param) throws Exception;
}
