package com.skplanet.sascm.service;

import java.util.List;
import java.util.Map;

public interface AraUsrService {

	public List<Map<String,Object>> takeCouponList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listCouponList(Map<String, Object> param) throws Exception;

	public Map<String,Object> selectUserInfo(Map<String, Object> param) throws Exception;
	
	public List<Map<String,Object>> selectAllCpnList(Map<String, Object> param) throws Exception;

	public List<Map<String,Object>> selectUseCpnList(Map<String, Object> param) throws Exception;

	public int useCpnList(Map<String, Object> param) throws Exception;
}
