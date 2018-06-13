/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.googlemaps.MapContainer;
import com.codename1.maps.Coord;
import com.codename1.ui.Button;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
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
    private MapContainer ctn;
    private Resources theme;
    private frmAdresseAffichage frmAffichage;

    public frmAdresseDetail(AdresseUtile adresse) {

        theme = UIManager.initFirstTheme("/theme");
        this.setLayout(BoxLayout.y());
        this.setTitle(adresse.getNom());
        this.getToolbar().addCommandToRightBar("Back", null, e -> {
            frmAffichage = new frmAdresseAffichage();
            frmAffichage.show();
        });
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
        btnMap = new Button(theme.getImage("maps.png").scaled(24, 24));
        btnMap.addActionListener((evt) -> {
            String longi = adresse.getGps().substring(0, adresse.getGps().indexOf(","));
            String lati = adresse.getGps().substring(adresse.getGps().indexOf(",") + 1);
            //ctn.setCameraPosition(new Coord(Double.parseDouble(longi), Double.parseDouble(lati)));
            Coord coo=new Coord(Double.parseDouble(longi), Double.parseDouble(lati));
            ctn.zoom(coo, 8);
            Style s = new Style();
            s.setFgColor(0xff0000);
            s.setBgTransparency(0);
            FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, 3);
            EncodedImage encImg = EncodedImage.createFromImage(markerImg, false);
            ctn.addMarker(
                    EncodedImage.createFromImage(markerImg, false),
                    coo,
                    "",
                    "",
                     evtt -> {
                         ctn.zoom(coo, 13);
                     }
            );
        });

        ctn = new MapContainer("AIzaSyA05SEH4coDJXkud9GF2qhrn1ee750_jz0");
        ctn.setNextFocusDown(this);
        this.addComponent(lblDesc);
        this.addComponent(lblAdresse);
        this.addComponent(lblTel);
        this.addComponent(lblSite);
        this.addComponent(btnMap);
        this.add(ctn);
    }

}
