package com.skplanet.sascm.daoimpl;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.AraCtrDAO;

@SuppressWarnings("unchecked")
@Repository("araCtrDAO")
public class AraCtrDAOImpl extends AbstractDAO implements AraCtrDAO {

	@Override
	public Map<String,Object> selectCenterInfo(Map<String, Object> param) throws SQLException {
		return (Map<String,Object>) selectOne("AraCtr.selectCenterInfo", param);
	}
}
