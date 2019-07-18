package com.skplanet.sascm.dao;

import java.util.List;
import java.util.Map;

public interface Ara2UsrDAO {

	// /index.do
	public Map<String,Object> selectItemInfo(Map<String, Object> param) throws Exception;

	// /coupon/stateCpnListPage.do
	public List<Map<String,Object>> selectStateCpnList(Map<String, Object> param) throws Exception;

	// /coupon/useCpnListPage.do
	public List<Map<String,Object>> selectUseCpnList(Map<String, Object> param) throws Exception;
}
