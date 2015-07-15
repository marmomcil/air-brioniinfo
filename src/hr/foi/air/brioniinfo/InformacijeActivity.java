package hr.foi.air.brioniinfo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class InformacijeActivity extends Activity {

	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_informacije);
		list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(new VivzAdapter(this));

	}

	class JedanRed {
		String naslovi;
		String opisi;

		JedanRed(String naslovi, String opisi) {
			this.naslovi = naslovi;
			this.opisi = opisi;

		}
	}

	class VivzAdapter extends BaseAdapter {

		ArrayList<JedanRed> list;
		Context context;

		VivzAdapter(Context c) {

			context = c;
			list = new ArrayList<JedanRed>();

			Resources res = c.getResources();
			String[] naslovi = res.getStringArray(R.array.naslovi);
			String[] opisi = res.getStringArray(R.array.opisi);
			for (int i = 0; i < 4; i++) {
				list.add(new JedanRed(naslovi[i], opisi[i]));
			}
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int i) {
			return list.get(i);
		}

		@Override
		public long getItemId(int i) {
			return i;
		}

		@Override
		public View getView(int i, View convertView, ViewGroup parent) {

			View red = convertView;
			if (red == null) {
				LayoutInflater inflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				red = inflater.inflate(R.layout.jedan_red_info, parent, false);
			}
			TextView naslovi = (TextView) red.findViewById(R.id.textView1);
			TextView opisi = (TextView) red.findViewById(R.id.textView2);

			JedanRed temp = list.get(i);
			naslovi.setText(temp.naslovi);
			opisi.setText(temp.opisi);

			return red;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.informacije, menu);
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
}
