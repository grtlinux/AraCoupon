package com.skplanet.sascm.service;

import java.util.List;
import java.util.Map;

public interface AraCtrService {

	public Map<String,Object> selectCenterInfo(Map<String, Object> param) throws Exception;
	
	public List<Map<String,Object>> selectApprReqList(Map<String, Object> param) throws Exception;
	public int insertApprRes(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCampInfoForCpnPkg(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectApprResList(Map<String, Object> param) throws Exception;

	public int insertCouponSheet(Map<String, Object> param) throws Exception;

	public List<Map<String,Object>> selectCalcList(Map<String, Object> param) throws Exception;

	public List<Map<String,Object>> listCalculateList(Map<String, Object> param) throws Exception;
}
