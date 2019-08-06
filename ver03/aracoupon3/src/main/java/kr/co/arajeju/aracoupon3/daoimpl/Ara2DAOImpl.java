package kr.co.arajeju.aracoupon3.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.arajeju.aracoupon3.dao.AbstractDAO;
import kr.co.arajeju.aracoupon3.dao.Ara2DAO;


@SuppressWarnings("unchecked")
@Repository("ara2DAO")
public class Ara2DAOImpl extends AbstractDAO implements Ara2DAO {

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2.selectItemInfo", param);
	}

	// /registArakey.do
	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.insertCnntAraKey", param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.updateAllCnntByCnntid", param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.updateCnntByCnntid", param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2.selectCnntArakeyInfo", param);
	}

	// /register/registerUsrFormPage.do
	@Override
	public List<Map<String, Object>> selectLocInfoList(Map<String, Object> param) throws Exception {
		return (List<Map<String,Object>>) selectList("Ara2.selectLocInfoList", param);
	}

	@Override
	public Map<String, Object> selectChkNmMblEml(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2.selectChkNmMblEml", param);
	}

	@Override
	public Map<String, Object> selectUsrNo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2.selectUsrNo", param);
	}

	@Override
	public int insertAra2Usr(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.insertAra2Usr", param);
	}

	@Override
	public int insertAra2Mbl(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.insertAra2Mbl", param);
	}

	@Override
	public int insertAra2Eml(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.insertAra2Eml", param);
	}

	@Override
	public int insertAra2Mrrg(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.insertAra2Mrrg", param);
	}

	@Override
	public Map<String, Object> selectLoginInfo(Map<String, Object> param) throws Exception {
		return (Map<String,Object>) selectOne("Ara2.selectLoginInfo", param);
	}

	@Override
	public int insertLoginInfo(Map<String, Object> param) throws Exception {
		return (int) insert("Ara2.insertLoginInfo", param);
	}
}
