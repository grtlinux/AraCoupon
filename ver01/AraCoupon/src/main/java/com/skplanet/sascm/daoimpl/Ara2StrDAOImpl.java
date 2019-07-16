package com.skplanet.sascm.daoimpl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.Ara2StrDAO;

@SuppressWarnings("unchecked")
@Repository("ara2StrDAO")
public class Ara2StrDAOImpl extends AbstractDAO implements Ara2StrDAO {

	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Str.selectItemInfo", param);
	}

}
