package kr.co.arajeju.aracoupon3.service;

import java.util.List;
import java.util.Map;

public interface Ara3AraService {

	// /index.do
	public Map<String,Object> selectItemInfo(Map<String, Object> param) throws Exception;

	// /registArakey.do
	public int insertCnntAraKey(Map<String, Object> param) throws Exception;
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception;
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception;
	
	// /register/registerUsrFormPage.do
	public List<Map<String,Object>> selectLocInfoList(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectChkNmMblEml(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectUsrNo(Map<String, Object> param) throws Exception;
	public int insertAra3Usr(Map<String, Object> param) throws Exception;
	public int insertAra3Mbl(Map<String, Object> param) throws Exception;
	public int insertAra3Eml(Map<String, Object> param) throws Exception;
	public int insertAra3Mrrg(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectLoginInfo(Map<String, Object> param) throws Exception;
	public int insertLoginInfo(Map<String, Object> param) throws Exception;
}
