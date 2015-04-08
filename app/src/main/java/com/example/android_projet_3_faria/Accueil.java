package com.example.android_projet_3_faria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Accueil extends Activity {

	private Modele monModele;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		monModele=new Modele();
	}
// test modif test
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_list:
			Toast.makeText(getApplicationContext(),	"clic sur list",Toast.LENGTH_LONG).show();
			Intent myIntent = new Intent(getApplicationContext(), AfficheListePatient.class);
			startActivity(myIntent);
			
			return true;
		case R.id.menu_import:
			Toast.makeText(getApplicationContext(),	"clic sur import",Toast.LENGTH_LONG).show();
			Intent myIntent2 = new Intent(getApplicationContext(), ActImport.class);
			startActivity(myIntent2);
			return true;
			
		case R.id.menu_export:
			Toast.makeText(getApplicationContext(),	"clic sur export",Toast.LENGTH_LONG).show();
			Intent myIntent3 = new Intent(getApplicationContext(), ActExport.class);
			startActivity(myIntent3);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
