package com.skplanet.sascm.daoimpl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.Ara2CtrDAO;

@SuppressWarnings("unchecked")
@Repository("ara2CtrDAO")
public class Ara2CtrDAOImpl extends AbstractDAO implements Ara2CtrDAO {

	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Ctr.selectItemInfo", param);
	}
	
}
