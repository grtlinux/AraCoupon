package kr.co.arajeju.aracoupon3.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon3.dao.AbstractDAO;
import kr.co.arajeju.aracoupon3.dao.Ara3AraDAO;


@SuppressWarnings("unchecked")
@Repository("ara3DAO")
public class Ara3AraDAOImpl extends AbstractDAO implements Ara3AraDAO {

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3.selectItemInfo", param);
	}

	// /registArakey.do
	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3.insertCnntAraKey", param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3.updateAllCnntByCnntid", param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3.updateCnntByCnntid", param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3.selectCnntArakeyInfo", param);
	}

	// /register/registerUsrFormPage.do
	@Override
	public List<Map<String, Object>> selectLocInfoList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara3.selectLocInfoList", param);
	}

	@Override
	public Map<String, Object> selectChkNmMblEml(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3.selectChkNmMblEml", param);
	}

	@Override
	public Map<String, Object> selectUsrNo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3.selectUsrNo", param);
	}

	@Override
	public int insertAra3Usr(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3.insertAra3Usr", param);
	}

	@Override
	public int insertAra3Mbl(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3.insertAra3Mbl", param);
	}

	@Override
	public int insertAra3Eml(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3.insertAra3Eml", param);
	}

	@Override
	public int insertAra3Mrrg(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3.insertAra3Mrrg", param);
	}

	@Override
	public Map<String, Object> selectLoginInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara3.selectLoginInfo", param);
	}

	@Override
	public int insertLoginInfo(Map<String, Object> param) throws Exception {
		return (int) insert("Ara3.insertLoginInfo", param);
	}
}
