package com.skplanet.sascm.service;

import java.sql.SQLException;
import java.util.Map;

public interface AraService {

	public int insertUsrAraKey(Map<String, Object> param) throws SQLException;
	public Map<String,Object> selectUsrAraKeyInfo(Map<String, Object> param) throws SQLException;
	public int updateCnntByUsrid(Map<String, Object> param) throws SQLException;
	public int updateAllCnntByUsrid(Map<String, Object> param) throws SQLException;

	public int insertStrAraKey(Map<String, Object> param) throws SQLException;
	public Map<String,Object> selectStrAraKeyInfo(Map<String, Object> param) throws SQLException;
	public int updateCnntByStrid(Map<String, Object> param) throws SQLException;
	public int updateAllCnntByStrid(Map<String, Object> param) throws SQLException;

	public int insertCtrAraKey(Map<String, Object> param) throws SQLException;
	public Map<String,Object> selectCtrAraKeyInfo(Map<String, Object> param) throws SQLException;
	public int updateCnntByCtrid(Map<String, Object> param) throws SQLException;
	public int updateAllCnntByCtrid(Map<String, Object> param) throws SQLException;
}
