package com.example.android_projet_3_faria;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.os.Environment;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Modele {
	private String db4oFileName;
	private ObjectContainer dataBase;
	private File appDir;

	public Modele() {
		createDirectory();
		open();
		dataBase.close();
	}


	public void createDirectory() {
		appDir = new File(Environment.getExternalStorageDirectory()	+ "/baseDB4o");
		// Ligne suivant à enlever si pas genymotion car pas de sdcard sur GM
		appDir = new File("/data/test" + "/baseDB4o");
		if (!appDir.exists() && !appDir.isDirectory()) {
			appDir.mkdirs();
		}
	}
	
	public void open() {

		db4oFileName = Environment.getExternalStorageDirectory() + "/baseDB4o" + "/BasePatient.db4o";
		// Ligne suivant à enlever si pas genymotion car pas de sdcard sur GM
		db4oFileName = "/data/test/baseDB4o" + "/BasePatient.db4o";
		dataBase = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),db4oFileName);
	}

	public ArrayList<Patient> listePatient() {
		open();
		ArrayList<Patient> listePatient = new ArrayList<Patient>();
		ObjectSet<Patient> result = dataBase.queryByExample(Patient.class);
		while (result.hasNext()) {
			listePatient.add(result.next());
		}
		dataBase.close();
		return listePatient;
	}

	public Patient trouvePatient (String id) {
		open();
		Patient vretour = new Patient();
		vretour.setIdentifiant(id);
		ObjectSet<Patient> result = dataBase.queryByExample(vretour);
		vretour = (Patient) result.next();
		dataBase.close();
		return vretour;
	}

	public void savePatient(Patient patient) {
		open();
		Patient vretour = new Patient();
		vretour.setIdentifiant(patient.getIdentifiant());
		ObjectSet<Patient> result = dataBase.queryByExample(vretour);
		if (result.size() == 0) {
			dataBase.store(patient);
		} else {
			vretour = (Patient) result.next();
			vretour.recopiePatient(patient);
			dataBase.store(vretour);
		}
		dataBase.close();
	}
	
	public void deletePatient() {
		open();
		ObjectSet<Patient> result = dataBase.queryByExample(Patient.class);
		while (result.hasNext()) {
			dataBase.delete(result.next());
		}
		dataBase.close();
	}
	
	public void addPatient(ArrayList<Patient> vPatient) {
		open();
		for (Patient v : vPatient) {
			dataBase.store(v);
		}
		dataBase.close();
	}

}
