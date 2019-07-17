package com.skplanet.sascm.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skplanet.sascm.common.dao.AbstractDAO;
import com.skplanet.sascm.dao.Ara2StrDAO;

@SuppressWarnings("unchecked")
@Repository("ara2StrDAO")
public class Ara2StrDAOImpl extends AbstractDAO implements Ara2StrDAO {

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Str.selectItemInfo", param);
	}

	// /coupon/buyCpnListPage.do
	@Override
	public List<Map<String, Object>> selectCampList2(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Str.selectCampList2", param);
	}

	@Override
	public int updateBuyCpnSht(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Str.updateBuyCpnSht", param);
	}

	// /coupon/stateCpnListPage.do
	@Override
	public List<Map<String, Object>> selectStateCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Str.selectStateCpnList", param);
	}

	// /coupon/giveCpnListPage.do
	@Override
	public List<Map<String, Object>> selectGiveCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2Str.selectGiveCpnList", param);
	}
}
