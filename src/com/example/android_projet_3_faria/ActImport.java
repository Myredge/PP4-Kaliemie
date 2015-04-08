package com.example.android_projet_3_faria;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class ActImport extends Activity {
	
	private Button mBouton = null;
	private AsyncTask<String, String, Boolean> mThreadCon = null;
	private Modele modele;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_import);
		mBouton= (Button)findViewById(R.id.vimport);
		mBouton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				String[] mesparams = { "http://192.168.69.113/PATIENT/import.php" };
				mThreadCon = new Async (ActImport.this).execute(mesparams);
			}
		});
		modele=new Modele();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_import, menu);
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
	
	public void alertmsg(String title, String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
		builder.setMessage(msg).setTitle(title);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// User clicked OK button
		    }
		});

		AlertDialog dialog = builder.create();
		dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);  
		dialog.show();
	}

	public void retourImport(StringBuilder sb)
	{
		JsonElement json = new JsonParser().parse(sb.toString());
		JsonArray varray = json.getAsJsonArray();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
		ArrayList<Patient> listePatient = new ArrayList<Patient>();
		for (JsonElement obj : varray) {
			Patient patient = gson.fromJson(obj.getAsJsonObject(), Patient.class);
			patient.setCommentaireVisite("");
			listePatient.add(patient);
		}
		modele.deletePatient();
		modele.addPatient(listePatient);
	}
}