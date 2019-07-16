package com.skplanet.sascm.daoimpl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.Ara2UsrDAO;

@SuppressWarnings("unchecked")
@Repository("ara2UsrDAO")
public class Ara2UsrDAOImpl extends AbstractDAO implements Ara2UsrDAO {

	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Usr.selectItemInfo", param);
	}

}
