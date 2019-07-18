package com.skplanet.sascm.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.Ara2UsrDAO;

@SuppressWarnings("unchecked")
@Repository("ara2UsrDAO")
public class Ara2UsrDAOImpl extends AbstractDAO implements Ara2UsrDAO {

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Usr.selectItemInfo", param);
	}

	// /coupon/stateCpnListPage.do
	@Override
	public List<Map<String,Object>> selectStateCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Usr.selectStateCpnList", param);
	}

	// /coupon/useCpnListPage.do
	@Override
	public List<Map<String,Object>> selectUseCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Usr.selectUseCpnList", param);
	}

}
