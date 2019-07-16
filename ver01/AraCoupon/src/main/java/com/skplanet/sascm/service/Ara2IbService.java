package com.skplanet.sascm.service;

import java.util.Map;

public interface Ara2IbService {

	public Map<String,Object> selectAraInfo(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectLastIbTkn(Map<String, Object> param) throws Exception;
	public int insertIbTkn(Map<String, Object> param) throws Exception;
}
