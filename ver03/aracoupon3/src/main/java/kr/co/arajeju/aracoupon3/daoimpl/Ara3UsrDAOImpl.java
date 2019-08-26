package kr.co.arajeju.aracoupon3.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon3.dao.AbstractDAO;
import kr.co.arajeju.aracoupon3.dao.Ara3UsrDAO;

@SuppressWarnings("unchecked")
@Repository("ara3UsrDAO")
public class Ara3UsrDAOImpl extends AbstractDAO implements Ara3UsrDAO {

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Usr.selectItemInfo", param);
	}

	// /coupon/stateCpnListPage.do
	@Override
	public List<Map<String,Object>> selectStateCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Usr.selectStateCpnList", param);
	}

	// /coupon/useCpnListPage.do
	@Override
	public List<Map<String,Object>> selectUseCpnList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3Usr.selectUseCpnList", param);
	}

	@Override
	public Map<String, Object> selectStrInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Usr.selectStrInfo", param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Usr.updateAllCnntByCnntid", param);
	}

	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3Usr.insertCnntAraKey", param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3Usr.selectCnntArakeyInfo", param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Usr.updateCnntByCnntid", param);
	}

	@Override
	public int updateCpnNoList(Map<String, Object> param) throws Exception {
		return (int) update("Ara3Usr.updateCpnNoList", param);
	}

}
