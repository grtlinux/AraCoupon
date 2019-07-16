package com.skplanet.sascm.daoimpl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.Ara2DAO;

@SuppressWarnings("unchecked")
@Repository("ara2DAO")
public class Ara2DAOImpl extends AbstractDAO implements Ara2DAO {

	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2.selectItemInfo", param);
	}

	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.insertCnntAraKey", param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.updateAllCnntByCnntid", param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.updateCnntByCnntid", param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2.selectCnntArakeyInfo", param);
	}
}
