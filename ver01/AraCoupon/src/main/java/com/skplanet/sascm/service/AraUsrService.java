package com.skplanet.sascm.service;

import java.util.List;
import java.util.Map;

public interface AraUsrService {

	public Map<String,Object> selectUserInfo(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> takeCouponList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> listCouponList(Map<String, Object> param) throws Exception;
}
