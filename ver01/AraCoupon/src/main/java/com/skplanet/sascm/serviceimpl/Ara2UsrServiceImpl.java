package com.skplanet.sascm.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.Ara2UsrDAO;
import com.skplanet.sascm.service.Ara2UsrService;

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
}
