package kr.co.arajeju.aracoupon3.service;

import java.util.List;
import java.util.Map;

public interface Ara2StrService {

	// /index.do
	public Map<String,Object> selectItemInfo(Map<String, Object> param) throws Exception;

	// /coupon/buyCpnListPage.do
	public List<Map<String,Object>> selectCampList2(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectStrAcntInfo(Map<String, Object> param) throws Exception;
	public int updateBuyCpnSht(Map<String, Object> param) throws Exception;
	public int insertBuyCpnSum(Map<String, Object> param) throws Exception;

	// /coupon/stateCpnListPage.do
	public List<Map<String,Object>> selectStateCpnList(Map<String, Object> param) throws Exception;

	// /coupon/giveCpnListPage.do
	public List<Map<String,Object>> selectTrmList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectGiveCpnList(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectUsrInfo(Map<String, Object> param) throws Exception;
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception;
	public int insertCnntAraKey(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception;
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception;
	public int updateCpnNo(Map<String, Object> param) throws Exception;

	// /payment/paymentCpnListPage.do
	public List<Map<String,Object>> selectPaymentCpnList(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCtrInfo(Map<String, Object> param) throws Exception;
	public int updateAllCnntByCnntidOnCtr(Map<String, Object> param) throws Exception;
	public int insertCnntAraKeyOnCtr(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCnntArakeyInfoOnCtr(Map<String, Object> param) throws Exception;
	public int updateCpnNoListOnCtr(Map<String, Object> param) throws Exception;
	public int updateCnntByCnntidOnCtr(Map<String, Object> param) throws Exception;

	// /account/selectAcntInOutListPage.do
	public List<Map<String,Object>> selectAcntInOutList(Map<String, Object> param) throws Exception;
}
