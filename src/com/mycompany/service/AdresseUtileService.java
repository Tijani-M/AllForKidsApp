/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
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
        con.addResponseListener(e->{
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
                        adresseUtile.setDescription(obj.get("description").toString());
//                        adresseUtile.setAdresse(obj.get("adresse").toString());
//                        adresseUtile.setTel(obj.get("tel").toString());
//                        adresseUtile.setSiteWeb(obj.get("siteweb").toString());
//                        adresseUtile.setGps(obj.get("gps").toString());
                        //System.out.println(adresseUtile);
                        listAdresses.add(adresseUtile);

                    }
                } catch (IOException ex) {
                    
                }            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAdresses;
    }
}
