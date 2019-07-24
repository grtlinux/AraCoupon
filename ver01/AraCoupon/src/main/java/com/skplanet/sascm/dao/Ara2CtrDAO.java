package com.skplanet.sascm.dao;

import java.util.List;
import java.util.Map;

public interface Ara2CtrDAO {

	// /index.do
	public Map<String,Object> selectItemInfo(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCampPeriod(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectAraCpnTyp(Map<String, Object> param) throws Exception;


	// /coupon/createCampFormPage.do
	public Map<String,Object> selectSeqCampKey(Map<String, Object> param) throws Exception;
	public int insertCampInfo(Map<String, Object> param) throws Exception;


	// /coupon/executeCampListPage.do
	public List<Map<String,Object>> selectCampList1(Map<String, Object> param) throws Exception;
	public int deleteCampCpnSht(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCampNoInfo(Map<String, Object> param) throws Exception;
	public int insertCampCpnSht(Map<String, Object> param) throws Exception;
	public int updateCampNoInfo(Map<String, Object> param) throws Exception;


	// /coupon/resultCampListPage.do
	public List<Map<String,Object>> selectCampList2(Map<String, Object> param) throws Exception;


	// /payment/paymentCpnListPage.do
	public List<Map<String,Object>> selectPaymentCpnList(Map<String, Object> param) throws Exception;
	public int updateCpnNosPhs(Map<String, Object> param) throws Exception;
	public int insertAcntDpst(Map<String, Object> param) throws Exception;


	// /account/createAcntListPage.do
	public List<Map<String,Object>> selectStrAcntList(Map<String, Object> param) throws Exception;
	public int insertStrAcnt(Map<String, Object> param) throws Exception;


	// /account/selectAcntListPage.do
	public List<Map<String,Object>> selectAcntList(Map<String, Object> param) throws Exception;


	// /account/selectAcntInOutListPage.do
	public List<Map<String,Object>> selectStrList(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectAcntInOutList(Map<String, Object> param) throws Exception;
	public int insertStrDpstProc(Map<String, Object> param) throws Exception;
	public int insertStrWthdProc(Map<String, Object> param) throws Exception;


	// /manage/manageForTestPage.do
	public int deleteTableAcnt(Map<String, Object> param) throws Exception;
	public int deleteTableAcnthist(Map<String, Object> param) throws Exception;
	public int deleteTableCamp(Map<String, Object> param) throws Exception;
	public int deleteTableCpn(Map<String, Object> param) throws Exception;
	public int deleteTableCnnt(Map<String, Object> param) throws Exception;
	public int deleteTableLogin(Map<String, Object> param) throws Exception;
}
