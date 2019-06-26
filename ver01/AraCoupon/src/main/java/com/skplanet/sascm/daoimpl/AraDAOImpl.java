package com.skplanet.sascm.daoimpl;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.AraDAO;

@SuppressWarnings("unchecked")
@Repository("araDAO")
public class AraDAOImpl extends AbstractDAO implements AraDAO {

	// Usr
	@Override
	public int insertUsrAraKey(Map<String, Object> param) throws SQLException {
		return (int) insert("Ara.insertUsrAraKey", param);
	}

	@Override
	public Map<String,Object> selectUsrAraKeyInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("Ara.selectUsrAraKeyInfo", param);
	}

	@Override
	public int updateCnntByUsrid(Map<String, Object> param) throws SQLException {
		return (int) update("Ara.updateCnntByUsrid", param);
	}

	@Override
	public int updateAllCnntByUsrid(Map<String, Object> param) throws SQLException {
		return (int) update("Ara.updateAllCnntByUsrid", param);
	}



	// Str
	@Override
	public int insertStrAraKey(Map<String, Object> param) throws SQLException {
		return (int) insert("Ara.insertStrAraKey", param);
	}

	@Override
	public Map<String,Object> selectStrAraKeyInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("Ara.selectStrAraKeyInfo", param);
	}

	@Override
	public int updateCnntByStrid(Map<String, Object> param) throws SQLException {
		return (int) update("Ara.updateCnntByStrid", param);
	}

	@Override
	public int updateAllCnntByStrid(Map<String, Object> param) throws SQLException {
		return (int) update("Ara.updateAllCnntByStrid", param);
	}



	// Ctr
	@Override
	public int insertCtrAraKey(Map<String, Object> param) throws SQLException {
		return (int) insert("Ara.insertCtrAraKey", param);
	}

	@Override
	public Map<String,Object> selectCtrAraKeyInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("Ara.selectCtrAraKeyInfo", param);
	}

	@Override
	public int updateCnntByCtrid(Map<String, Object> param) throws SQLException {
		return (int) update("Ara.updateCnntByCtrid", param);
	}

	@Override
	public int updateAllCnntByCtrid(Map<String, Object> param) throws SQLException {
		return (int) update("Ara.updateAllCnntByCtrid", param);
	}
}
