package com.skplanet.sascm.dao;

import java.util.Map;

public interface Ara2IbDAO {

	public Map<String,Object> selectAraInfo(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectLastIbTkn(Map<String, Object> param) throws Exception;
	public int insertIbTkn(Map<String, Object> param) throws Exception;
}
