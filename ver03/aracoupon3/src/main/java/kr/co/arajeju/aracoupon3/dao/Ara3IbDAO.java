package kr.co.arajeju.aracoupon3.dao;

import java.util.Map;

public interface Ara3IbDAO {

	public Map<String,Object> selectAraInfo(Map<String, Object> param) throws Exception;
	public Map<String,Object> selectLastIbTkn(Map<String, Object> param) throws Exception;
	public int insertIbTkn(Map<String, Object> param) throws Exception;
}
