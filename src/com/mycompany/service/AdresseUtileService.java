/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.FontImage;
import com.mycompany.entity.AdresseUtile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tijani
 */
public class AdresseUtileService {

    public ArrayList<AdresseUtile> getList2() {
        ArrayList<AdresseUtile> listAdresses = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/AllForKids/web/app_dev.php/adresseutile/json");
        con.addResponseListener(e -> {
            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> adressesUtiles = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                //System.out.println(adressesUtiles);
                List<Map<String, Object>> list = (List<Map<String, Object>>) adressesUtiles.get("root");
                for (Map<String, Object> obj : list) {
                    //System.out.println(obj);
                    AdresseUtile adresseUtile = new AdresseUtile();
                    Float id = Float.parseFloat(obj.get("id").toString());

                    adresseUtile.setId(id);
                    adresseUtile.setNom(obj.get("nom").toString());
                    if (obj.containsKey("description")) 
                        adresseUtile.setDescription(obj.get("description").toString());
                     else 
                        adresseUtile.setDescription("");                    
                    if (obj.containsKey("adresse")) 
                        adresseUtile.setAdresse(obj.get("adresse").toString());
                    else
                        adresseUtile.setAdresse("");                    
                    if (obj.containsKey("tel")) 
                        adresseUtile.setTel(obj.get("tel").toString());
                    else
                       adresseUtile.setTel("");                    
                    if (obj.containsKey("siteWeb")) 
                        adresseUtile.setSiteWeb(obj.get("siteWeb").toString());
                    else
                        adresseUtile.setSiteWeb("");
                    if (obj.containsKey("gps")) 
                        adresseUtile.setGps(obj.get("gps").toString());
                    else
                        adresseUtile.setGps("");
                    //System.out.println(adresseUtile);
                    listAdresses.add(adresseUtile);

                }
            } catch (IOException ex) {

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAdresses;
    }
    public void add(AdresseUtile adresse) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/AllForKids/web/app_dev.php/adresseutile/json/new?" 
                + "nom="+ adresse.getNom() 
                + "&adresse=" + adresse.getAdresse()
                + "&description=" + adresse.getDescription()
                + "&tel=" + adresse.getTel()
                + "&site=" + adresse.getSiteWeb()
                + "&gps=" + adresse.getGps()
                ;
        con.setUrl(Url);

        System.out.println("URL: "+Url);

        
        con.addResponseListener(e -> {
            String str = new String(con.getResponseData());
            System.out.println("Response: " + str);
            ToastBar.showMessage(str, FontImage.MATERIAL_INFO);
            
        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);        
    }
}
