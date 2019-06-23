package com.skplanet.sascm.daoimpl;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.AraStrDAO;

@SuppressWarnings("unchecked")
@Repository("araStrDAO")
public class AraStrDAOImpl extends AbstractDAO implements AraStrDAO {

	@Override
	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("AraStr.selectStoreInfo", param);
	}
}
