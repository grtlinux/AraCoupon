package com.skplanet.sascm.serviceimpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.AraCtrDAO;
import com.skplanet.sascm.service.AraCtrService;

@Service("araCtrService")
public class AraCtrServiceImpl implements AraCtrService {

	@Resource(name = "araCtrDAO")
	private AraCtrDAO araCtrDAO;

	@Override
	public Map<String,Object> selectCenterInfo(Map<String, Object> param) throws Exception {
		return this.araCtrDAO.selectCenterInfo(param);
	}
}
