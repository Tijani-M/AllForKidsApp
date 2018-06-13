/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entity.AdresseUtile;
import com.mycompany.service.AdresseUtileService;
import java.util.ArrayList;

/**
 *
 * @author Tijani
 */
public class frmAffichage extends Form {

    private Label createSeparator() {
        Label sep = new Label(" ");
        sep.setUIID("Separator");
        // the separator line  is implemented in the theme using padding and background color, by default labels
        // are hidden when they have no content, this method disables that behavior
        sep.setShowEvenIfBlank(true);
        return sep;
    }

    public frmAffichage() {
        this.setTitle("Affichage");
        this.setLayout(BoxLayout.y());

        AdresseUtileService adresseService = new AdresseUtileService();
        ArrayList<AdresseUtile> listAdresses = adresseService.getList2();
        //System.out.println(listAdresses.size());
        for (int i = 0; i < listAdresses.size(); i++) {
            //System.out.println("----"+listAdresses.get(i).toString());
            this.addComponent(new ctnAdresse(listAdresses.get(i)));
            this.addComponent(createSeparator());
        }
    }
}
