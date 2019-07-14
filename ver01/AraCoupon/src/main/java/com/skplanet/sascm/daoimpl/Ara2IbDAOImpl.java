package com.skplanet.sascm.daoimpl;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.Ara2IbDAO;

@SuppressWarnings("unchecked")
@Repository("ara2IbDAO")
public class Ara2IbDAOImpl extends AbstractDAO implements Ara2IbDAO {

	@Override
	public Map<String, Object> selectAraInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("Ara2Ib.selectAraInfo", param);
	}

	@Override
	public Map<String, Object> selectLastIbTkn(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("Ara2Ib.selectLastIbTkn", param);
	}

	@Override
	public int insertIbTkn(Map<String, Object> param) throws SQLException {
		return (int) insert("Ara2Ib.insertIbTkn", param);
	}
}
