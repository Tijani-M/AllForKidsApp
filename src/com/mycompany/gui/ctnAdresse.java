/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.AdresseUtile;

/**
 *
 * @author Tijani
 */
public class ctnAdresse extends Container {

    private Label lblNom, lblAdresse, lblTel, lblSite;
    private SpanLabel lblDesc;
    private Button btnDetail;
    private Container ctn1;
    private Resources theme;
    private frmAdresseDetail frmD;

    public ctnAdresse(AdresseUtile adresse) {
        theme = UIManager.initFirstTheme("/theme");
        this.setLayout(BoxLayout.y());
        Font myFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
        lblNom = new Label(adresse.getNom());
        lblDesc = new SpanLabel(adresse.getDescription());
        lblDesc.getTextAllStyles().setFont(myFont);
        lblAdresse = new Label(adresse.getAdresse());
        lblAdresse.getUnselectedStyle().setFont(myFont);
        lblTel = new Label(adresse.getTel());
        lblTel.getUnselectedStyle().setFont(myFont);
        lblSite = new Label(adresse.getSiteWeb().toString());
        lblSite.getUnselectedStyle().setFont(myFont);
        btnDetail = new Button(theme.getImage("info.png").scaled(32, 32));
        btnDetail.getUnselectedStyle().setBorder(RoundBorder.create().shadowOpacity(90));
        btnDetail.addActionListener((evt) -> {
            frmD = new frmAdresseDetail(adresse);
            frmD.show();
        });
        ctn1 = new Container(new BorderLayout());
        ctn1.addComponent(BorderLayout.WEST, lblNom);
        ctn1.addComponent(BorderLayout.EAST, btnDetail);
        this.addComponent(ctn1);
        this.addComponent(lblDesc);
        this.addComponent(lblAdresse);
        this.addComponent(lblTel);
        this.addComponent(lblSite);
    }
}
