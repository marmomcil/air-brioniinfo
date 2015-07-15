package hr.foi.air.brioniinfo.ws;

import hr.foi.air.brioniinfo.db.Linija;
import hr.foi.air.brioniinfo.db.Mjesta;
import hr.foi.air.brioniinfo.db.Stanice;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonAdapter {

	public static String getJsonArrayString(JSONObject jsonObject) {
		if (jsonObject != null) {
			JSONArray tmp = new JSONArray();
			tmp.put(jsonObject);
			return tmp.toString();
		} else
			return "[]"; // an empty array
	}

	public static ArrayList<Mjesta> getmjesta(String jsonString)
			throws Exception {
		ArrayList<Mjesta> mjesta = new ArrayList<Mjesta>();
		if (jsonString.length() == 0)
			jsonString = '[' + jsonString + ']';

		if (!jsonString.startsWith("["))
			jsonString = '[' + jsonString + ']';

		JSONArray jsonArr = new JSONArray(jsonString);
		int size = jsonArr.length();

		for (int i = 0; i < size; i++) {
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			Mjesta Mjesta = new Mjesta(jsonObj.getLong("mjesto_id"),
					jsonObj.getString("naziv"),
					jsonObj.getLong("maps_latitude"),
					jsonObj.getLong("maps_longitude"));
			mjesta.add(Mjesta);
		}

		return mjesta;
	}

	public static ArrayList<Stanice> getstanice(String jsonString)
			throws Exception {
		ArrayList<Stanice> stanice = new ArrayList<Stanice>();
		if (jsonString.length() == 0)
			jsonString = '[' + jsonString + ']';

		if (!jsonString.startsWith("["))
			jsonString = '[' + jsonString + ']';

		JSONArray jsonArr = new JSONArray(jsonString);
		int size = jsonArr.length();

		for (int i = 0; i < size; i++) {
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			Stanice Stanice = new Stanice(jsonObj.getLong("mjesto_id"),
					jsonObj.getLong("linija_id"),
					jsonObj.getLong("kilometar"),
					jsonObj.getLong("vrijeme"),
					jsonObj.getLong("cijena"));
			stanice.add(Stanice);
		}

		return stanice;
	}
	
	public static ArrayList<Linija> getlinija(String jsonString)
			throws Exception {
		ArrayList<Linija> linija = new ArrayList<Linija>();
		if (jsonString.length() == 0)
			jsonString = '[' + jsonString + ']';

		if (!jsonString.startsWith("["))
			jsonString = '[' + jsonString + ']';

		JSONArray jsonArr = new JSONArray(jsonString);
		int size = jsonArr.length();

		for (int i = 0; i < size; i++) {
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			Linija Linija = new Linija(jsonObj.getLong("linija_id"),
					jsonObj.getString("opis"));
			linija.add(Linija);
		}

		return linija;
	}

}