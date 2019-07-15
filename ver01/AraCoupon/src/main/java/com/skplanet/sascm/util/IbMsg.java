package com.skplanet.sascm.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class IbMsg {

	public static boolean flag = true;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	private static final Gson gson = new Gson();
	
	/*
	 * getIbTokenInfo
	 */
	private static final String URL_IB_TOKEN = "https://auth.supersms.co:7000/auth/v3/token";

	public static Map<String,Object> getIbTokenInfo(Map<String,Object> map) throws Exception {
		if (flag) System.out.println(">>>>> map for Request: " + new GsonBuilder().setPrettyPrinting().create().toJson(map));
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
				if (!flag) System.out.println(">>>>> ResponseBody: " + responseBody);
				// get new map
				map = gson.fromJson(responseBody, new TypeToken<Map<String, Object>>(){}.getType());
				if (flag) System.out.println(">>>>> ResponseBody: " + new GsonBuilder().setPrettyPrinting().create().toJson(map));
			} finally {
				httpClient.close();
			}
		}
		return map;
	}

	/*
	 * sendIbSms
	 */
	private static final String URL_IB_SEMD_SMS = "https://sms.supersms.co:7020/sms/v3/multiple-destinations";

	public static Map<String,Object> sendIbSms(Map<String,Object> map) throws Exception {
		if (flag) System.out.println(">>>>> map for Request: " + new GsonBuilder().setPrettyPrinting().create().toJson(map));
		if (flag) {
			List<Header> defaultHeaders = new ArrayList<>();
			defaultHeaders.add(new BasicHeader("Authorization", String.format("%s %s", String.valueOf(map.get("SCHM")), String.valueOf(map.get("ACCS_TKN")))));
			// setting custom http headers on the httpclient
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(defaultHeaders).build();
			//CloseableHttpClient httpClient = HttpClients.createDefault();
			try {
				// entity data
				String json = testJsonObject(map);
				StringEntity entity = new StringEntity(json, StandardCharsets.UTF_8);   // UTF-8 encoding
				// setting custom http headers on the http request
				HttpUriRequest request = RequestBuilder.post()
						.setUri(URL_IB_SEMD_SMS)
						.setHeader("Content-Type", "application/json")
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
				if (!flag) System.out.println(">>>>> ResponseBody: " + responseBody);
				// get new map
				map = gson.fromJson(responseBody, new TypeToken<Map<String, Object>>(){}.getType());
				if (flag) System.out.println(">>>>> ResponseBody: " + new GsonBuilder().setPrettyPrinting().create().toJson(map));
			} finally {
				httpClient.close();
			}
		}
		return map;
	}
	
	private static String testJsonObject(Map<String,Object> map) throws Exception {
		String jsonMsg = "";

		if (flag) {
			JsonArray jsonArr = new JsonArray();

			JsonObject jsonSub = null;
			jsonSub = new JsonObject();
			jsonSub.addProperty("to", "+8201042582025");
			jsonSub.addProperty("replaceWord1", "2025");
			jsonSub.addProperty("replaceWord2", "아라");
			jsonSub.addProperty("replaceWord3", "");
			jsonSub.addProperty("replaceWord4", "");
			jsonSub.addProperty("replaceWord5", "");
			jsonArr.add(jsonSub);

			/*
			jsonSub = new JsonObject();
			jsonSub.addProperty("to", "+8201033882025");
			jsonSub.addProperty("replaceWord1", "1234");
			jsonSub.addProperty("replaceWord2", "고객");
			jsonSub.addProperty("replaceWord3", "");
			jsonSub.addProperty("replaceWord4", "");
			jsonSub.addProperty("replaceWord5", "");
			jsonArr.add(jsonSub);
			*/
			
			JsonObject jsonRoot = new JsonObject();
			jsonRoot.addProperty("title", String.valueOf(map.get("MSG_NM")));   // 타이틀입니다.
			jsonRoot.addProperty("from", String.valueOf(map.get("ARA_MBL"))); // SMS보내는 전화번호 국가코드 불필요.
			jsonRoot.addProperty("text", String.valueOf(map.get("MSG_CNTNT"))); // 메시지
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

	/*
	 * transIbFile
	 */
	private static final String URL_IB_TRANS_FILE = "https://file.supersms.co:7010/sms/v3/file";

	public static Map<String,Object> notBeUsed_transIbFile(Map<String,Object> map) throws Exception {
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
}
