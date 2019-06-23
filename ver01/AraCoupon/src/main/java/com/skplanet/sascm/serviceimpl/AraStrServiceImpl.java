package com.skplanet.sascm.serviceimpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.AraStrDAO;
import com.skplanet.sascm.service.AraStrService;

@Service("araStrService")
public class AraStrServiceImpl implements AraStrService {

	@Resource(name = "araStrDAO")
	private AraStrDAO araStrDAO;

	@Override
	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws Exception {
		return this.araStrDAO.selectStoreInfo(param);
	}
}
