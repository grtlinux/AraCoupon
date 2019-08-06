package kr.co.arajeju.aracoupon3.serviceimpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon3.dao.Ara2IbDAO;
import kr.co.arajeju.aracoupon3.service.Ara2IbService;

@Service("ara2IbService")
public class Ara2IbServiceImpl implements Ara2IbService {

	@Resource(name = "ara2IbDAO")
	private Ara2IbDAO ara2IbDAO;

	@Override
	public Map<String, Object> selectAraInfo(Map<String, Object> param) throws Exception {
		return this.ara2IbDAO.selectAraInfo(param);
	}

	@Override
	public Map<String, Object> selectLastIbTkn(Map<String, Object> param) throws Exception {
		return this.ara2IbDAO.selectLastIbTkn(param);
	}

	@Override
	public int insertIbTkn(Map<String, Object> param) throws Exception {
		return this.ara2IbDAO.insertIbTkn(param);
	}





}
