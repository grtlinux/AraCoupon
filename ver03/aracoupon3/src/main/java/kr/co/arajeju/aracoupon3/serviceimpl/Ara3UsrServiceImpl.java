package kr.co.arajeju.aracoupon3.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon3.dao.Ara3UsrDAO;
import kr.co.arajeju.aracoupon3.service.Ara3UsrService;

@Service("ara3UsrService")
public class Ara3UsrServiceImpl implements Ara3UsrService {

	@Resource(name = "ara3UsrDAO")
	private Ara3UsrDAO ara3UsrDAO;

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara3UsrDAO.selectItemInfo(param);
	}

	// /coupon/stateCpnListPage.do
	@Override
	public List<Map<String, Object>> selectStateCpnList(Map<String, Object> param) throws Exception {
		return this.ara3UsrDAO.selectStateCpnList(param);
	}
	
	// /coupon/useCpnListPage.do
	@Override
	public List<Map<String, Object>> selectUseCpnList(Map<String, Object> param) throws Exception {
		return this.ara3UsrDAO.selectUseCpnList(param);
	}

	@Override
	public Map<String, Object> selectStrInfo(Map<String, Object> param) throws Exception {
		return this.ara3UsrDAO.selectStrInfo(param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara3UsrDAO.updateAllCnntByCnntid(param);
	}

	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return this.ara3UsrDAO.insertCnntAraKey(param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return this.ara3UsrDAO.selectCnntArakeyInfo(param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara3UsrDAO.updateCnntByCnntid(param);
	}

	@Override
	public int updateCpnNoList(Map<String, Object> param) throws Exception {
		return this.ara3UsrDAO.updateCpnNoList(param);
	}
}
