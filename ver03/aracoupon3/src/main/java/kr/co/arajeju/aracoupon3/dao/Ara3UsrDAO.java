package kr.co.arajeju.aracoupon3.dao;

import java.util.List;
import java.util.Map;

public interface Ara3UsrDAO {

	// /index.do
	public Map<String,Object> selectItemInfo(Map<String, Object> param) throws Exception;

	// /coupon/stateCpnListPage.do
	public List<Map<String,Object>> selectStateCpnList(Map<String, Object> param) throws Exception;

	// /coupon/useCpnListPage.do
	public List<Map<String,Object>> selectUseCpnList(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectStrInfo(Map<String, Object> param) throws Exception;
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception;
	public int insertCnntAraKey(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception;
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception;
	public int updateCpnNoList(Map<String, Object> param) throws Exception;
}
