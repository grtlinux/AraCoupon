package kr.co.arajeju.aracoupon2.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon2.dao.Ara2UsrDAO;
import kr.co.arajeju.aracoupon2.service.Ara2UsrService;

@Service("ara2UsrService")
public class Ara2UsrServiceImpl implements Ara2UsrService {

	@Resource(name = "ara2UsrDAO")
	private Ara2UsrDAO ara2UsrDAO;

	// /index.do
	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara2UsrDAO.selectItemInfo(param);
	}

	// /coupon/stateCpnListPage.do
	@Override
	public List<Map<String, Object>> selectStateCpnList(Map<String, Object> param) throws Exception {
		return this.ara2UsrDAO.selectStateCpnList(param);
	}
	
	// /coupon/useCpnListPage.do
	@Override
	public List<Map<String, Object>> selectUseCpnList(Map<String, Object> param) throws Exception {
		return this.ara2UsrDAO.selectUseCpnList(param);
	}

	@Override
	public Map<String, Object> selectStrInfo(Map<String, Object> param) throws Exception {
		return this.ara2UsrDAO.selectStrInfo(param);
	}

	@Override
	public int updateAllCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara2UsrDAO.updateAllCnntByCnntid(param);
	}

	@Override
	public int insertCnntAraKey(Map<String, Object> param) throws Exception {
		return this.ara2UsrDAO.insertCnntAraKey(param);
	}

	@Override
	public Map<String, Object> selectCnntArakeyInfo(Map<String, Object> param) throws Exception {
		return this.ara2UsrDAO.selectCnntArakeyInfo(param);
	}

	@Override
	public int updateCnntByCnntid(Map<String, Object> param) throws Exception {
		return this.ara2UsrDAO.updateCnntByCnntid(param);
	}

	@Override
	public int updateCpnNoList(Map<String, Object> param) throws Exception {
		return this.ara2UsrDAO.updateCpnNoList(param);
	}
}
