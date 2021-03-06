package hr.foi.air.brioniinfo.ws;

import hr.foi.air.brioniinfo.R;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Implements all functionality of asynchronously calling web service,
 * processing response, returning the data and calling the callBack method. The
 * most important part of this process are parameters which should be prepared
 * and sent to the object. These parameters will be accepted by doInBackground
 * method.<br>
 * <br>
 * 
 * params[0] -> Context<br>
 * params[1] -> String json (returned by JsonAdapter.getJsonArrayString(json))<br>
 * params[2] -> String serviceName<br>
 * params[3] -> String methodName<br>
 * params[4] -> String resultAttribute (which will be returned to Callback)<br>
 * params[5] -> ProgressDialog<br>
 * params[6] -> WebServiceResultHandler<br>
 * 
 */
public class WebServiceAsyncTask extends AsyncTask<Object, Void, Object[]> {

	@Override
	protected Object[] doInBackground(Object... params) {
		Object result[] = new Object[] { "", false, null, null };

		Context context = (Context) params[0];
		String json = (String) params[1];
		String service = (String) params[2];
		String method = (String) params[3];
		String resultAttribute = (String) params[4];

		result[2] = (ProgressDialog) params[5];
		result[3] = (WebServiceResultHandler) params[6];

		try {

			String serviceResult;

			// call service
			serviceResult = callWebService(service, method, json);

			if (serviceResult != "") {
				JSONObject jsonResponse = new JSONArray(serviceResult)
						.getJSONObject(0);
				if (jsonResponse.has("mjesto_id")) {
					if (jsonResponse.getInt("responseId") == 100) {
						if (resultAttribute != "") {
							result[0] = jsonResponse.getString(resultAttribute);
						} else {
							result[0] = jsonResponse.getString("responseText");
						}
						result[1] = true;
					} else {
						result[0] = jsonResponse.getString("responseText");
					}
				} else {
					result[0] = context.getResources().getString(
							R.string.msg_uknown_problem);
				}
			} else {
				result[0] = context.getResources().getString(
						R.string.msg_check_internet);
			}

		} catch (JSONException e) {
			result[0] = context.getResources().getString(
					R.string.msg_check_data_and_internet);
		}

		return result;
	}

	/**
	 * This method is executed automatically and is not accessible from other
	 * objects.
	 * 
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 * 
	 */
	@Override
	protected void onPostExecute(Object[] result) {
		if ((ProgressDialog) result[2] != null) {
			((ProgressDialog) result[2]).cancel();
		}
		if ((WebServiceResultHandler) result[3] != null) {
			((WebServiceResultHandler) result[3]).handleResult(
					(String) result[0], (Boolean) result[1]);
		}
	}
	
	/**
	 * Acts as a gateway to php service, providing the possibility of accessing the service with 
	 * different parameters and thus accessing different methods offered by this service.
	 * 
	 * @param name		Specifies a web service to connect to.
	 * @param method	Specifies a web service method to be used.
	 * @param jsonData	Specifies a data necessary for chosen method. The data should be packed as JSON array string (i.e. with []).
	 * @return			JSON formated string containing the service response code, response text and sometimes additional parameters.
	 * 
	 */
	public String callWebService(String name, String method, String jsonData)
	{
		/*String result = "";
		
		HttpClient httpclient = new DefaultHttpClient();
		//HttpPost httppost = new HttpPost("http://localhost/test/" + name + ".php");
		//HttpPost httppost = new HttpPost("http://localhost/test/linije.php?polID=1&dolID=10");
		
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("method", method));
        nameValuePairs.add(new BasicNameValuePair("json", jsonData));
        //httppost.addHeader("Content-Type", "application/x-www-form-urlencoded, charset=UTF-8");
        
        try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
			ResponseHandler<String> handler = new BasicResponseHandler();
			result = httpclient.execute(httppost, handler);
			httpclient.getConnectionManager().shutdown();
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (result != "" && result.charAt(0) != '[')
			result = "[" + result + "]";

		return result;*/
		
		HttpClient httpKlijent = new DefaultHttpClient();
		 
		HttpGet httpGetZahtjev = new HttpGet("http://10.0.3.2/test/mjesta.php");
		String jsonResult = "";
		ResponseHandler<String> handler = new BasicResponseHandler();
		
		
		try {			
				  
			jsonResult = httpKlijent.execute(httpGetZahtjev, handler);
		}
		catch(ClientProtocolException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		httpKlijent.getConnectionManager().shutdown();
		return jsonResult;
	}
}
