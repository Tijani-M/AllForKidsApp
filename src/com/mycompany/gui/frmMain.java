/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Tijani
 */
public class frmMain extends Form{
    private ImageViewer imgv;
    private Resources theme;
    private frmAdresseAffichage frmAffichage;
    
    public frmMain(){
        theme = UIManager.initFirstTheme("/theme");
        this.setLayout(new BorderLayout());
        this.getToolbar().addCommandToSideMenu("Adresses Utiles", null, ev->{
            frmAffichage=new frmAdresseAffichage();
            frmAffichage.show();
        });
        imgv = new ImageViewer(theme.getImage("logo1.png"));
        this.addComponent(BorderLayout.CENTER, imgv);
    }
}
