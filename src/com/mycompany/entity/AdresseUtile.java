/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;


/**
 *
 * @author Tijani
 */
public class AdresseUtile {
    
    private float id;
    private String nom;
    private String description;
    private String adresse;
    private String tel;
    private String siteWeb;
    private String gps;
    private Boolean valide;
    private String dateAjout;
    private String dateValidation;
    private int imageLieu;
    private int categorie;
    private int membreProposant;
    private int validateur;

    public AdresseUtile() {
        //this.dateAjout=LocalDate.now().toString();
        
    }

    @Override
    public String toString() {
        return "AdresseUtile{" 
                + "id=" + id 
                + ", nom=" + nom 
                + ", description=" 
                + description 
                + ", adresse=" + adresse 
                + ", tel=" + tel 
                + ", siteWeb=" + siteWeb 
                + ", gps=" + gps 
                + ", valide=" + valide 
                + ", dateAjout=" + dateAjout 
                + ", dateValidation=" + dateValidation 
                + ", imageLieu=" + imageLieu 
                + ", categorie=" + categorie 
                + ", membreProposant=" + membreProposant 
                + ", validateur=" + validateur 
                + '}';
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(String dateValidation) {
        this.dateValidation = dateValidation;
    }

    public int getImageLieu() {
        return imageLieu;
    }

    public void setImageLieu(int imageLieu) {
        this.imageLieu = imageLieu;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public int getMembreProposant() {
        return membreProposant;
    }

    public void setMembreProposant(int membreProposant) {
        this.membreProposant = membreProposant;
    }

    public int getValidateur() {
        return validateur;
    }

    public void setValidateur(int validateur) {
        this.validateur = validateur;
    }

    
    

    
}
