package kr.co.arajeju.aracoupon3.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon3.dao.AbstractDAO;
import kr.co.arajeju.aracoupon3.dao.Ara2UsrDAO;

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

	@Override
	public Map<String, Object> selectStrInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Usr.selectStrInfo", param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Usr.updateAllCnntByCnntid", param);
	}

	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2Usr.insertCnntAraKey", param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2Usr.selectCnntArakeyInfo", param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Usr.updateCnntByCnntid", param);
	}

	@Override
	public int updateCpnNoList(Map<String, Object> param) throws Exception {
		return (int) update("Ara2Usr.updateCpnNoList", param);
	}

}
