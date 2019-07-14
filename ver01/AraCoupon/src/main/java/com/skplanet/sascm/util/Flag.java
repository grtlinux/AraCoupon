package com.skplanet.sascm.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.ui.ModelMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

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

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("deprecation")
	public static String notBeUsed_httpPostSample01(String url, Map<String,String> paramMap) throws Exception {
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

	public static void notBeUsed_httpClientCustomHeaderExample() throws Exception {
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

	public static String testJsonObject() throws Exception {
		String jsonMsg = "";

		if (flag) {
			JsonArray jsonArr = new JsonArray();

			JsonObject jsonSub = null;
			jsonSub = new JsonObject();
			jsonSub.addProperty("to", "+8201042582025");
			jsonSub.addProperty("replaceWord1", "강석1");
			jsonSub.addProperty("replaceWord2", "1억");
			jsonSub.addProperty("replaceWord3", "");
			jsonSub.addProperty("replaceWord4", "");
			jsonSub.addProperty("replaceWord5", "");
			jsonArr.add(jsonSub);

			jsonSub = new JsonObject();
			jsonSub.addProperty("to", "+8201033882025");
			jsonSub.addProperty("replaceWord1", "강석2");
			jsonSub.addProperty("replaceWord2", "2억");
			jsonSub.addProperty("replaceWord3", "");
			jsonSub.addProperty("replaceWord4", "");
			jsonSub.addProperty("replaceWord5", "");
			jsonArr.add(jsonSub);

			JsonObject jsonRoot = new JsonObject();
			jsonRoot.addProperty("title", "임시타이틀");   // 타이틀입니다.
			jsonRoot.addProperty("from", "01042582025"); // SMS보내는 전화번호 국가코드 불필요.
			jsonRoot.addProperty("text", "%CHANGEWORD1%님의 결제금액 %CHANGEWORD2%원이 입급되었습니다."); // 메시지
			jsonRoot.addProperty("fileKey", "");        // MMS 전송시 필요하며 나중에 확인한다.
			jsonRoot.add("destinations", jsonArr);
			jsonRoot.addProperty("ref", "refKey");      // 고객이 설정할수 있고 DB의 키로 활용가능
			jsonRoot.addProperty("ttl", "120");         // 2분후 SMS 못받으면 무시하시라
			jsonRoot.addProperty("paymentCode", "10");  // 센터관리용으로
			jsonRoot.addProperty("clientSubId", "1");   // 영업담당자와 협의후 사용

			if (flag) System.out.println(">>>>> root: " + jsonRoot.toString());
			if (flag) System.out.println(">>>>> root: " + new GsonBuilder().setPrettyPrinting().create().toJson(jsonRoot));
			jsonMsg = jsonRoot.toString();
		}

		return jsonMsg;
	}

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	private static final Gson gson = new Gson();
	private static final String URL_IB_TOKEN = "https://auth.supersms.co:7000/auth/v3/token";

	public static Map<String,Object> getIbTokenInfo(Map<String,Object> map) throws Exception {
		if (flag) {
			// create custom http headers for httpclient
			List<Header> defaultHeaders = new ArrayList<>();
			defaultHeaders.add(new BasicHeader("X-IB-Client-Id", (String) map.get("ARA_ID")));
			defaultHeaders.add(new BasicHeader("X-IB-Client-Passwd", (String) map.get("ARA_PWD")));

			// setting custom http headers on the httpclient
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(defaultHeaders).build();
			try {
				// setting custom http headers on the http request
				HttpUriRequest request = RequestBuilder.post()
						.setUri(URL_IB_TOKEN)
						//.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
						//.setHeader(HttpHeaders.FROM, "https://memorynotfound.com")
						.setHeader("Accept", "application/json")
						.build();
				if (flag) System.out.println(">>>>> Executing Request: " + request.getRequestLine());

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
				// http execution
				String responseBody = httpClient.execute(request, responseHandler);
				if (flag) System.out.println("----------------------------------------------");
				if (flag) System.out.println(">>>>> ResponseBody: " + responseBody);

				// get new map
				map = gson.fromJson(responseBody, new TypeToken<Map<String, Object>>(){}.getType());
			} finally {
				httpClient.close();
			}
		}
		return map;
	}

	private static final String URL_IB_TRANS_FILE = "https://file.supersms.co:7010/sms/v3/file";

	public static Map<String,Object> transIbFile(Map<String,Object> map) throws Exception {
		if (flag) {
			// create custom http headers for httpclient
			List<Header> defaultHeaders = new ArrayList<>();
			defaultHeaders.add(new BasicHeader("X-IB-Client-Id", (String) map.get("ARA_ID")));
			defaultHeaders.add(new BasicHeader("X-IB-Client-Passwd", (String) map.get("ARA_PWD")));

			// setting custom http headers on the httpclient
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(defaultHeaders).build();
			try {
				// setting custom http headers on the http request
				HttpUriRequest request = RequestBuilder.post()
						.setUri(URL_IB_TRANS_FILE)
						//.setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
						//.setHeader(HttpHeaders.FROM, "https://memorynotfound.com")
						.setHeader("Accept", "application/json")
						.build();
				if (flag) System.out.println(">>>>> Executing Request: " + request.getRequestLine());

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
				// http execution
				String responseBody = httpClient.execute(request, responseHandler);
				if (flag) System.out.println("----------------------------------------------");
				if (flag) System.out.println(">>>>> ResponseBody: " + responseBody);

				// get new map
				map = gson.fromJson(responseBody, new TypeToken<Map<String, Object>>(){}.getType());
			} finally {
				httpClient.close();
			}
		}
		return map;
	}

	private static final String URL_IB_SEMD_SMS = "https://sms.supersms.co:7020/sms/v3/multiple-destinations";

	public static Map<String,Object> sendIbSms(Map<String,Object> map) throws Exception {
		if (flag) {
			List<Header> defaultHeaders = new ArrayList<>();
			defaultHeaders.add(new BasicHeader("Authorization", String.format("%s %s", String.valueOf(map.get("SCHM")), String.valueOf(map.get("ACCS_TKN")))));

			// setting custom http headers on the httpclient
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(defaultHeaders).build();
			// setting custom http headers on the httpclient
			//CloseableHttpClient httpClient = HttpClients.createDefault();
			try {
				String json = testJsonObject();
				StringEntity entity = new StringEntity(json, StandardCharsets.UTF_8);

				// setting custom http headers on the http request
				HttpUriRequest request = RequestBuilder.post()
						.setUri(URL_IB_SEMD_SMS)
						.setHeader("Content-Type", "application/json")
						//.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
						.setHeader("Accept", "application/json")
						.setEntity(entity)
						.build();
				if (flag) System.out.println(">>>>> Executing Request: " + request.getRequestLine());

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
				// http execution
				String responseBody = httpClient.execute(request, responseHandler);
				if (flag) System.out.println("----------------------------------------------");
				if (flag) System.out.println(">>>>> ResponseBody: " + responseBody);

				// get new map
				map = gson.fromJson(responseBody, new TypeToken<Map<String, Object>>(){}.getType());
				if (flag) System.out.println(">>>>> ResponseBody: " + new GsonBuilder().setPrettyPrinting().create().toJson(map));
			} finally {
				httpClient.close();
			}
		}
		return map;
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

	public static void main(String[] args) throws Exception {
		notBeUsed_httpClientCustomHeaderExample();
	}
}
