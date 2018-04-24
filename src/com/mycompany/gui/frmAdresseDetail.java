/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.AdresseUtile;

/**
 *
 * @author Tijani
 */
public class frmAdresseDetail extends Form {

    private Label lblNom, lblAdresse, lblTel, lblSite;
    private SpanLabel lblDesc;
    private Button btnMap;
    private Container ctn1;
    private Resources theme;
    private frmAdresseDetail frmD;

    public frmAdresseDetail(AdresseUtile adresse) {

        theme = UIManager.initFirstTheme("/theme");
        this.setLayout(BoxLayout.y());
        this.setTitle(adresse.getNom());
        Font myFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);

        lblDesc = new SpanLabel(adresse.getDescription());
        lblDesc.getTextAllStyles().setFont(myFont);
        lblAdresse = new Label(adresse.getAdresse());
        lblAdresse.getUnselectedStyle().setFont(myFont);        
        FontImage.setMaterialIcon(lblAdresse, FontImage.MATERIAL_HOME);        
        lblTel = new Label(adresse.getTel());
        lblTel.getUnselectedStyle().setFont(myFont);
        FontImage.setMaterialIcon(lblTel, FontImage.MATERIAL_PHONE); 
        lblSite = new Label(adresse.getSiteWeb().toString());
        lblSite.getUnselectedStyle().setFont(myFont);
        FontImage.setMaterialIcon(lblSite, FontImage.MATERIAL_LANGUAGE); 
        btnMap = new Button(theme.getImage("info.png").scaled(24, 24));
        btnMap.addActionListener((evt) -> {

            //TODO: Implementation de Google Map
        });
        this.addComponent(lblDesc);
        this.addComponent(lblAdresse);
        this.addComponent(lblTel);
        this.addComponent(lblSite);
    }

}
