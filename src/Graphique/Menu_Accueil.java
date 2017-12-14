/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Eddine Langer
 */
public class Menu_Accueil extends Menu{
    private JButton jouer;
    private JButton classment;
    private JButton quitter;
    public Menu_Accueil(Game_IHM gIHM) {
        super(gIHM);
        //c.ipady=3;
        c.insets = new Insets(30, 30, 30, 30);

         jouer = new JButton("Jouer");
         jouer.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=0;
        this.add(jouer,c);
        
        classment = new JButton("Classement");
        classment.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=1;
        this.add(classment,c);
        
        quitter = new JButton("Quitter");
        quitter.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=2;
        this.add(quitter,c);
        initButtonListener();
        this.setVisible(true);
    }
    
    @Override
    protected void initButtonListener(){
       jouer.addActionListener(this);
       classment.addActionListener(this);
       quitter.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src=ae.getSource();
        if(src==quitter){
            System.out.println("Quitter");
            System.exit(0);
        }
        else if(src==jouer){
            
            this.parentPanel.afficheChoix(this);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

  

    
    
    

    

  

