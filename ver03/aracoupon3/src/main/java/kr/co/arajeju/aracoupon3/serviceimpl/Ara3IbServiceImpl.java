package kr.co.arajeju.aracoupon3.serviceimpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon3.dao.Ara3IbDAO;
import kr.co.arajeju.aracoupon3.service.Ara3IbService;

@Service("ara3IbService")
public class Ara3IbServiceImpl implements Ara3IbService {

	@Resource(name = "ara3IbDAO")
	private Ara3IbDAO ara3IbDAO;

	@Override
	public Map<String, Object> selectAraInfo(Map<String, Object> param) throws Exception {
		return this.ara3IbDAO.selectAraInfo(param);
	}

	@Override
	public Map<String, Object> selectLastIbTkn(Map<String, Object> param) throws Exception {
		return this.ara3IbDAO.selectLastIbTkn(param);
	}

	@Override
	public int insertIbTkn(Map<String, Object> param) throws Exception {
		return this.ara3IbDAO.insertIbTkn(param);
	}





}
