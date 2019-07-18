package com.skplanet.sascm.dao;

import java.util.List;
import java.util.Map;

public interface Ara2StrDAO {

	// /index.do
	public Map<String,Object> selectItemInfo(Map<String, Object> param) throws Exception;
	
	// /coupon/buyCpnListPage.do
	public List<Map<String,Object>> selectCampList2(Map<String, Object> param) throws Exception;
	public int updateBuyCpnSht(Map<String, Object> param) throws Exception;

	// /coupon/stateCpnListPage.do
	public List<Map<String,Object>> selectStateCpnList(Map<String, Object> param) throws Exception;

	// /coupon/giveCpnListPage.do
	public List<Map<String,Object>> selectGiveCpnList(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectUsrInfo(Map<String, Object> param) throws Exception;
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception;
	public int insertCnntAraKey(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception;
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception;
	public int updateCpnNo(Map<String, Object> param) throws Exception;
}
