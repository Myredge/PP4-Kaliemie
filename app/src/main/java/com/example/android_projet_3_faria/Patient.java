package com.example.android_projet_3_faria;

import java.util.Date;

public class Patient {

	/*
	 * Données ne pouvant être modifiées
	 */
	private String identifiant,nom,prenom,adresse,codePostal,ville,telephone;
	private Date dateNaiss;
	/*
	 * Données à saisir
	 */
	private String commentaireVisite;
	
	
	public String getIdentifiant() {
		return identifiant;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public String getVille() {
		return ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public String getCommentaireVisite() {
		return commentaireVisite;
	}
	
	
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public void setCommentaireVisite(String commentaireVisite) {
		this.commentaireVisite = commentaireVisite;
	}
	
	public Patient(){}
	
	public Patient(String videntifiant, String vnom, String vprenom, String vadresse, String vcp, String vville, String vtl, Date vdateNaiss) {
		identifiant = videntifiant;
		nom = vnom;
		prenom = vprenom;
		adresse = vadresse;
		codePostal = vcp;
		ville = vville;
		telephone = vtl;
		dateNaiss = vdateNaiss;
		commentaireVisite = "";
	}
	
	public void recopiePatient(Patient patient)
	{
		identifiant= patient.identifiant;
		nom=patient.nom;
		prenom=patient.prenom;
		adresse=patient.adresse;
		codePostal=patient.codePostal;
		ville=patient.ville;
		telephone=patient.telephone;
		dateNaiss=patient.dateNaiss;
		commentaireVisite=patient.commentaireVisite;
	}

}
