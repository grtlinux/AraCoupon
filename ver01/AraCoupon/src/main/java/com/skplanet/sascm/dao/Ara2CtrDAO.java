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


}