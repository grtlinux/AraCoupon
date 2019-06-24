package com.skplanet.sascm.service;

import java.util.List;
import java.util.Map;

public interface AraStrService {

	public Map<String,Object> selectStoreInfo(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectApprovalReq(Map<String, Object> param) throws Exception;
	public List<Map<String,Object>> selectApprovalRes(Map<String, Object> param) throws Exception;
}
