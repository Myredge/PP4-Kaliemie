package com.example.android_projet_3_faria;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


public class AfficheListePatient extends Activity {
	
	private ListView listView;
	private Modele modele;
	private List<Patient> listePatient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_affiche_liste_patient);
		listView = (ListView)findViewById(R.id.lvListe);
		modele = new Modele();
		listePatient = modele.listePatient();
		PatientAdapter patientAdapter = new PatientAdapter(this, listePatient);
		listView.setAdapter(patientAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				Toast.makeText(getApplicationContext(),"Choix : "+listePatient.get(position).getIdentifiant(), Toast.LENGTH_SHORT).show();
				Intent myIntent = new Intent(getApplicationContext(), ModificationPatient.class);
				myIntent.putExtra("param1", listePatient.get(position).getIdentifiant());
				startActivity(myIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.affiche_liste_patient, menu);
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
