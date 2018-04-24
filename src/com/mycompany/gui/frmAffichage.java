/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entity.AdresseUtile;
import com.mycompany.service.AdresseUtileService;
import java.util.ArrayList;

/**
 *
 * @author Tijani
 */
public class frmAffichage extends Form {

    private SpanLabel lb = new SpanLabel("");

    public frmAffichage() {
        this.setTitle("Affichage");
        this.setLayout(BoxLayout.y());
        AdresseUtileService adresseService = new AdresseUtileService();
        ArrayList<AdresseUtile> listAdresses = adresseService.getList2();
        //System.out.println(listAdresses.size());
        for (int i = 0; i < listAdresses.size(); i++) {
            //System.out.println("----"+listAdresses.get(i).toString());
            this.addComponent(new ctnAdresse(listAdresses.get(i)));
        }
    }
}
