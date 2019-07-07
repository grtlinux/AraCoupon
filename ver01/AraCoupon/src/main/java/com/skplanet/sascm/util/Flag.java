package com.skplanet.sascm.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;

@SuppressWarnings("unchecked")
public class Flag {

	public static boolean flag = true;
	
	/*
	 * request
	 */
	public static void printRequestParameters(HttpServletRequest request) throws Exception {
		if (!flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				System.out.printf("KANG-request.Parameter [%s] = %s\n", key, Arrays.asList(vals));
			}
		}
		if (flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				System.out.printf("KANG-request.Parameter [%s] = [%s]\n", key, StringUtils.join(Arrays.asList(vals), ", "));
			}
		}
	}
	
	public static void printRequestAttributes(HttpServletRequest request) throws Exception {
		if (flag) {
			Enumeration<String> enums = request.getAttributeNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String val;
				switch (key) {
				case "staticPATHSvaurl":
				case "staticServerType":
				case "staticServerTypeAprvid":
				case "staticPATHSasurl":
				case "staticURL":
				case "staticPATH":
					val = (String) request.getAttribute(key);
					System.out.printf("KANG-request.Attribute [%s] = [%s]\n", key, val);
					break;
				default:
					val = ""; //(String) request.getAttribute(key);
					if (!flag) System.out.printf("KANG-request.Attribute [%s] = [%s]\n", key, val);
					break;
				}
			}
		}
	}
	
	public static void printRequest(HttpServletRequest request) throws Exception {
		if (flag) printRequestParameters(request);
		if (flag) printRequestAttributes(request);
	}

	public static ModelMap setModelMap(ModelMap modelMap, HttpServletRequest request) throws Exception {
		//copy request.Parameters to modelMap
		//modelMap.putAll(request.getParameterMap());
		if (Flag.flag) {
			Enumeration<String> enums = request.getParameterNames();
			while (enums.hasMoreElements()) {
				String key = enums.nextElement();
				String[] vals = request.getParameterValues(key);
				modelMap.addAttribute(key, StringUtils.join(Arrays.asList(vals), ","));
			}
		}
		//modelMap.addAttribute("TODAY1", Flag.getDateTime("yyyy-MM-dd"));
		//modelMap.addAttribute("TODAY2", Flag.getDateTime("yyyyMMdd"));
		return modelMap;
	}
	
	/*
	 * get date time
	 */
	public static String getYYMMDD() throws Exception {
		return getDateTime("yyMMdd");
	}
	
	public static String getYYYYMMDD() throws Exception {
		return getDateTime("yyyyMMdd");
	}

	public static String getDateTime(String strFormat) throws Exception {
		return new SimpleDateFormat(strFormat).format(new Date());
	}

	/*
	 * coupon number
	 */
	private static final int[] MULTI = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9 };
	
	public static String getCouponNo(String cpnMst, int seq) throws Exception {
		String ret = String.format("%s%03d", cpnMst, seq);
		char[] arrChar = ret.toCharArray();
		int sum = 0;
		for (int i=0; i < arrChar.length; i++) {
			int val = (arrChar[i] - '0') * MULTI[i];
			sum += val;
			if (!flag) System.out.printf(">>>>> %c * %d = %d   sum = %d%n", arrChar[i], MULTI[i], val, sum);
		}
		sum %= 100;
		
		return String.format("%s%02d", ret, sum);
	}
	
	public static String getCouponNo(String cpnMst, String cpnTyp, int seq) throws Exception {
		String ret = String.format("%s%s%03d", cpnMst, cpnTyp, seq);
		char[] arrChar = ret.toCharArray();
		int sum = 0;
		for (int i=0; i < arrChar.length; i++) {
			int val = (arrChar[i] - '0') * MULTI[i];
			sum += val;
			if (!flag) System.out.printf(">>>>> %c * %d = %d   sum = %d%n", arrChar[i], MULTI[i], val, sum);
		}
		sum %= 100;
		
		return String.format("%s%02d", ret, sum);
	}
}
