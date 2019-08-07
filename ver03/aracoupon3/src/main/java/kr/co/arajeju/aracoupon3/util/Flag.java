package kr.co.arajeju.aracoupon3.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.ui.ModelMap;

@SuppressWarnings("unchecked")
public class Flag {

	public static boolean flag = true;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
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
				case "araSalesType":
				case "araSalesOpenTime":
				case "araSalesCloseTime":
				case "araDbBackupTime":
				case "araNowTime":
				case "araSalesOk":
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

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/*
	 * get date time   'yyyyMMddHHmmss'
	 */
	public static String getDateTime(String strFormat) throws Exception {
		return new SimpleDateFormat(strFormat).format(new Date());
	}

	public static String getYYMMDD() throws Exception {
		return getDateTime("yyMMdd");
	}

	public static String getYYYYMMDD() throws Exception {
		return getDateTime("yyyyMMdd");
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/*
	 * coupon number
	 */
	private static final int[] MULTI = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static String getCouponNo(String cpnMst, int seq) throws Exception {
		String ret = String.format("%s%04d", cpnMst, seq);
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

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	public static String getPhoneNumber(String str) throws Exception {
		int length = str.length();
		if (length < 8)
			return str;
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, 3)).append("-");
		sb.append(str.substring(3, length - 4)).append("-");
		sb.append(str.substring(length - 4));
		return sb.toString();
	}
	
	public static String getPhoneNumberWithMask(String str) throws Exception {
		int length = str.length();
		if (length < 8)
			return str;
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, 3)).append("-");
		sb.append("****").append("-");
		sb.append(str.substring(length - 4));
		return sb.toString();
	}
	
	public static String getEmailWithMask(String str) throws Exception {
		int idx = str.indexOf('@');
		if (idx < 0)
			return str;
		//
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, 3));
		sb.append("*****");
		sb.append(str.substring(idx));
		return sb.toString();
	}
	
	public static String getNameWithMask(String str) throws Exception {
		String ret = str;
		int len = str.length();
		if (len == 2) {
			ret = str.substring(0, 1) + "****";
		} else if (len > 2) {
			ret = str.substring(0, 2) + "****";
		}
		return ret;
	}
	/*
	public static void main(String[] args) throws Exception {
		System.out.println(">>>>> " + getPhoneNumber("01012341234"));
		System.out.println(">>>>> " + getPhoneNumber("0101231234"));
		System.out.println(">>>>> " + getPhoneNumberWithMask("01012341234"));
		System.out.println(">>>>> " + getPhoneNumberWithMask("0101231234"));
		System.out.println(">>>>> " + getEmailWithMask("grtlinux@naver.com"));
	}
	*/
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("deprecation")
	public static String NOTUSE_httpPostSample01(String url, Map<String,String> paramMap) throws Exception {
		String strReturn = null;

		String responseBody = "";
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			Builder builder = RequestConfig.custom();

			builder.setConnectTimeout(4000);
			builder.setSocketTimeout(4000);
			builder.setStaleConnectionCheckEnabled(false);
			RequestConfig config = builder.build();

			try {
				HttpPost httpPost = new HttpPost(url);

				List<NameValuePair> postParams = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					postParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				httpPost.setEntity(new UrlEncodedFormEntity(postParams));
				httpPost.setConfig(config);

				if (flag) System.out.println(">>>>> url: " + url);
				if (flag) System.out.println(">>>>> Executing request: " + httpPost.getRequestLine());

				// create a custom response hander
				ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
					@Override
					public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
						int status = response.getStatusLine().getStatusCode();
						if (status >= 200 && status < 300) {
							HttpEntity entity = response.getEntity();
							String responseStr = "";
							if (entity != null) {
								responseStr = EntityUtils.toString(entity);
							}
							return responseStr;
						} else {
							throw new ClientProtocolException("Unexpected response status: " + status);
						}
					}
				};
				responseBody = httpClient.execute(httpPost, responseHandler);

				if (flag) System.out.println(">>>>> ResponseBody: " + responseBody);

			} finally {
				httpClient.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return strReturn;
	}

	public static void NOTUSE_httpClientCustomHeaderExample() throws Exception {
		// create custom http headers for httpclient
		List<Header> defaultHeaders = new ArrayList<>();
		defaultHeaders.add(new BasicHeader("X-IB-Client-Id", "tain_msg"));
		defaultHeaders.add(new BasicHeader("X-IB-Client-Passwd", "PWFCE101010X0EOZRO95"));

		// setting custom http headers on the httpclient
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(defaultHeaders).build();

		try {
			// setting custom http headers on the http request
			HttpUriRequest request = RequestBuilder.post()
					.setUri("https://auth.supersms.co:7000/auth/v3/token")
					//.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
					//.setHeader(HttpHeaders.FROM, "https://memorynotfound.com")
					.setHeader("Accept", "application/json")
					.build();
			if (flag) System.out.println(">>>>> Executing request: " + request.getRequestLine());

			// create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						String responseStr = "";
						if (entity != null) {
							responseStr = EntityUtils.toString(entity);
						}
						return responseStr;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			String responseBody = httpClient.execute(request, responseHandler);
			if (flag) System.out.println("----------------------------------------------");
			if (flag) System.out.println("ResponseBody: " + responseBody);
		} finally {
			httpClient.close();
		}
	}


	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/*


	 */
}
