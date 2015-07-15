package hr.foi.air.brioniinfo;

import hr.foi.air.brioniinfo.db.Mjesta;
import hr.foi.air.brioniinfo.ws.WebServiceAsyncTask;
import hr.foi.air.brioniinfo.ws.JsonAdapter;
import hr.foi.air.brioniinfo.ws.WebServiceResultHandler;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class VozniRedActivity extends Activity {

	private ArrayList<Mjesta> mjesta;
	private boolean mjestaLoaded;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vozni_red);
		setTitle("VOZNI RED");
		
		WebServiceAsyncTask asyncTaskMjesta = new WebServiceAsyncTask();
		Object paramsMjesta[] = new Object[]{this, "", "mjesta", "getAll", "items", null, acceptMjesta};
		asyncTaskMjesta.execute(paramsMjesta);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vozni_red, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	//implementacija interface-a
	WebServiceResultHandler acceptMjesta = new WebServiceResultHandler() {
		
		@Override
		public void handleResult(String result, boolean ok) {
			//convert to List<Stores>
			if (ok)
			{
				try {
					mjesta = JsonAdapter.getmjesta(result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			mjestaLoaded = true;
			showLoadedData();
		}

		private void showLoadedData() {
			// TODO Auto-generated method stub
			
		}
	};
}
