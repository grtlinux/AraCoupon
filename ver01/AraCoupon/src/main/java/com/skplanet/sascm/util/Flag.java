package com.skplanet.sascm.util;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("unchecked")
public class Flag {

	public static boolean flag = true;
	
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
}
