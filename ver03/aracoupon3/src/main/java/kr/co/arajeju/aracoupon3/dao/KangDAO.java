package kr.co.arajeju.aracoupon3.dao;

import java.util.List;
import java.util.Map;

public interface KangDAO {

	public String getMessage(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectCommCodeListOnMap(Map<String, Object> param) throws Exception;
}
