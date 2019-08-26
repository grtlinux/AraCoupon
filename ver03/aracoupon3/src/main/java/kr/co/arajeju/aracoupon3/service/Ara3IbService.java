package kr.co.arajeju.aracoupon3.service;

import java.util.Map;

public interface Ara3IbService {

	public Map<String,Object> selectAraInfo(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectLastIbTkn(Map<String, Object> param) throws Exception;
	public int insertIbTkn(Map<String, Object> param) throws Exception;
}
