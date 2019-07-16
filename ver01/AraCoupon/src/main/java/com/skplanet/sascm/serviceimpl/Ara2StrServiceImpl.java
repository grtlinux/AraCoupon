package com.skplanet.sascm.serviceimpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.skplanet.sascm.dao.Ara2StrDAO;
import com.skplanet.sascm.service.Ara2StrService;

@Service("ara2StrService")
public class Ara2StrServiceImpl implements Ara2StrService {

	@Resource(name = "ara2StrDAO")
	private Ara2StrDAO ara2StrDAO;

	@Override
	public Map<String, Object> selectItemInfo(Map<String, Object> param) throws Exception {
		return this.ara2StrDAO.selectItemInfo(param);
	}
}
