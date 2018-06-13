/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.googlemaps.MapContainer;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.AdresseUtile;
import com.mycompany.service.AdresseUtileService;
//import java.time.LocalDate;

/**
 *
 * @author Tijani
 */
public class frmAdresseAjout extends Form {

    private TextField txtNom, txtAdresse, txtTel, txtSite, txtGPS;
    private TextArea txtDesc;
    private Button btnSave;
    private Resources theme;
    private frmAdresseAffichage frmAffichage;

    public frmAdresseAjout() {
        theme = UIManager.initFirstTheme("/theme");
        this.setLayout(BoxLayout.y());
        this.setTitle("Ajout");
        this.getToolbar().addCommandToRightBar("Back", null, e -> {
            frmAffichage = new frmAdresseAffichage();
            frmAffichage.show();
        });

        txtNom = new TextField();
        txtAdresse = new TextField();
        txtDesc = new TextArea();
        txtTel = new TextField();
        txtSite = new TextField();
        txtGPS = new TextField();
        btnSave = new Button(theme.getImage("floppy.png").scaled(24, 24));
        btnSave.addActionListener((evt) -> {
            AdresseUtileService adresseService = new AdresseUtileService();
            AdresseUtile adresse = new AdresseUtile();
            adresse.setNom(txtNom.getText());
            adresse.setAdresse(txtAdresse.getText());
            adresse.setDescription(txtDesc.getText());
            adresse.setTel(txtTel.getText());
            adresse.setSiteWeb(txtSite.getText());
            adresse.setGps(txtGPS.getText());
            adresseService.add(adresse);
            frmAffichage = new frmAdresseAffichage();
            frmAffichage.show();
        });
        
        this.addComponent(new Label("Nom"));
        this.addComponent(txtNom);
        this.addComponent(new Label("Adresse"));
        this.addComponent(txtAdresse);
        this.addComponent(new SpanLabel("Description"));
        this.addComponent(txtDesc);
        this.addComponent(new Label("Tél"));
        this.addComponent(txtTel);
        this.addComponent(new Label("Site Web"));
        this.addComponent(txtSite);
        this.addComponent(new Label("Localisation"));
        this.addComponent(txtGPS);
        this.addComponent(btnSave);
    }
}
