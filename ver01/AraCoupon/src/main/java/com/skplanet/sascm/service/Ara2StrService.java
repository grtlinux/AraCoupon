package com.skplanet.sascm.service;

import java.util.List;
import java.util.Map;

public interface Ara2StrService {

	// /index.do
	public Map<String,Object> selectItemInfo(Map<String, Object> param) throws Exception;
	
	// /coupon/buyCpnListPage.do
	public List<Map<String,Object>> selectCampList2(Map<String, Object> param) throws Exception;
	public int updateBuyCpnSht(Map<String, Object> param) throws Exception;

	// /coupon/stateCpnListPage.do
	public List<Map<String,Object>> selectStateCpnList(Map<String, Object> param) throws Exception;

	// /coupon/giveCpnListPage.do
	public List<Map<String,Object>> selectGiveCpnList(Map<String, Object> param) throws Exception;
}
