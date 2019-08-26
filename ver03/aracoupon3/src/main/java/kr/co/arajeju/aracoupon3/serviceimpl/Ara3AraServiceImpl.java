package kr.co.arajeju.aracoupon3.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon3.dao.Ara3AraDAO;
import kr.co.arajeju.aracoupon3.service.Ara3AraService;

@Service("ara3Service")
public class Ara3AraServiceImpl implements Ara3AraService {

	@Resource(name = "ara3DAO")
	private Ara3AraDAO ara3DAO;

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara3DAO.selectItemInfo(param);
	}

	// /registArakey.do
	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return this.ara3DAO.insertCnntAraKey(param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara3DAO.updateAllCnntByCnntid(param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara3DAO.updateCnntByCnntid(param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return this.ara3DAO.selectCnntArakeyInfo(param);
	}

	// /register/registerUsrFormPage.do
	@Override
	public List<Map<String, Object>> selectLocInfoList(Map<String, Object> param) throws Exception {
		return this.ara3DAO.selectLocInfoList(param);
	}

	@Override
	public Map<String, Object> selectChkNmMblEml(Map<String, Object> param) throws Exception {
		return this.ara3DAO.selectChkNmMblEml(param);
	}

	@Override
	public Map<String, Object> selectUsrNo(Map<String, Object> param) throws Exception {
		return this.ara3DAO.selectUsrNo(param);
	}

	@Override
	public int insertAra3Usr(Map<String, Object> param) throws Exception {
		return this.ara3DAO.insertAra3Usr(param);
	}

	@Override
	public int insertAra3Mbl(Map<String, Object> param) throws Exception {
		return this.ara3DAO.insertAra3Mbl(param);
	}

	@Override
	public int insertAra3Eml(Map<String, Object> param) throws Exception {
		return this.ara3DAO.insertAra3Eml(param);
	}

	@Override
	public int insertAra3Mrrg(Map<String, Object> param) throws Exception {
		return this.ara3DAO.insertAra3Mrrg(param);
	}

	@Override
	public Map<String, Object> selectLoginInfo(Map<String, Object> param) throws Exception {
		return this.ara3DAO.selectLoginInfo(param);
	}

	@Override
	public int insertLoginInfo(Map<String, Object> param) throws Exception {
		return this.ara3DAO.insertLoginInfo(param);
	}
}
