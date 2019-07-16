package com.skplanet.sascm.serviceimpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.Ara2CtrDAO;
import com.skplanet.sascm.service.Ara2CtrService;

@Service("ara2CtrService")
public class Ara2CtrServiceImpl implements Ara2CtrService {

	@Resource(name = "ara2CtrDAO")
	private Ara2CtrDAO ara2CtrDAO;

	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara2CtrDAO.selectItemInfo(param);
	}
}
