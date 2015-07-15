package hr.foi.air.brioniinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnPregledInformacija;
	Button btnCjenikUsluga;
	Button btnVozniRed;
	Button btnPosebanVozniRed;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("GLAVNI IZBORNIK");
		
		btnPregledInformacija = (Button)findViewById(R.id.btnPregledInformacija);
		btnPregledInformacija.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),InformacijeActivity.class);
				startActivity(i);
			}
		});
		
		btnCjenikUsluga = (Button)findViewById(R.id.btnCjenikUsluga);
		btnCjenikUsluga.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),CjenikActivity.class);
				startActivity(i);
			}
		});
		
		btnVozniRed = (Button)findViewById(R.id.btnVozniRed);
		btnVozniRed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),VozniRedActivity.class);
				startActivity(i);
			}
		});
		
		btnPosebanVozniRed = (Button)findViewById(R.id.btnPosebanVozniRed);
		btnPosebanVozniRed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),PosebanVozniRedActivity.class);
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
