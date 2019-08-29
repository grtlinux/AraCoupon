package kr.co.arajeju.aracoupon3.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon3.dao.Ara3AraDAO;
import kr.co.arajeju.aracoupon3.service.Ara3AraService;

@Service("ara3AraService")
public class Ara3AraServiceImpl implements Ara3AraService {

	@Resource(name = "ara3AraDAO")
	private Ara3AraDAO ara3AraDAO;

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.selectItemInfo(param);
	}

	// /registArakey.do
	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.insertCnntAraKey(param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.updateAllCnntByCnntid(param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.updateCnntByCnntid(param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.selectCnntArakeyInfo(param);
	}

	// /register/registerUsrFormPage.do
	@Override
	public List<Map<String, Object>> selectLocInfoList(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.selectLocInfoList(param);
	}

	@Override
	public Map<String, Object> selectChkNmMblEml(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.selectChkNmMblEml(param);
	}

	@Override
	public Map<String, Object> selectUsrNo(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.selectUsrNo(param);
	}

	@Override
	public int insertAra3Usr(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.insertAra3Usr(param);
	}

	@Override
	public int insertAra3Mbl(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.insertAra3Mbl(param);
	}

	@Override
	public int insertAra3Eml(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.insertAra3Eml(param);
	}

	@Override
	public int insertAra3Mrrg(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.insertAra3Mrrg(param);
	}

	@Override
	public Map<String, Object> selectLoginInfo(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.selectLoginInfo(param);
	}

	@Override
	public int insertLoginInfo(Map<String, Object> param) throws Exception {
		return this.ara3AraDAO.insertLoginInfo(param);
	}
}
