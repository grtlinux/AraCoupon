package com.skplanet.sascm.dao;

import java.util.Map;

public interface Ara2DAO {

	public Map<String,Object> selectItemInfo(Map<String, Object> param) throws Exception;

	public int insertCnntAraKey(Map<String, Object> param) throws Exception;
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception;
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception;
}
