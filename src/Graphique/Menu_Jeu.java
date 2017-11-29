/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import static Graphique.Game_IHM.rules;
import Modèle.Regle;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Eddine Langer
 */
public class Menu_Jeu extends Menu {
private JButton pause;
private JButton regles;
private JButton giveup;

  
    public Menu_Jeu(Game_IHM gIHM) {
        super(gIHM);
         c.insets = new Insets(30, 30, 30, 30);

         pause = new JButton("Pause");
         pause.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=0;
        this.add(pause,c);
        
        regles = new JButton("Règles");
        regles.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=1;
        this.add(regles,c);
        
        giveup = new JButton("Abandonner");
        giveup.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=2;
        this.add(giveup,c);
        initButtonListener();
        this.setVisible(true);
    }
    
    

    
    protected void initButtonListener(){
       pause.addActionListener(this);
       regles.addActionListener(this);
       giveup.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
Object src=ae.getSource();
        if(src==pause){
            System.out.println("Pause");
            
        }
        else if(src==regles){
           
            JOptionPane.showMessageDialog(this.parentPanel,
    rules.get(0).getRecap()+"\n"+rules.get(0).getDescribeRule()+"\n"+rules.get(1).getRecap()+"\n"+rules.get(1).getDescribeRule());
        }
        else if(src==giveup){
            
            this.parentPanel.afficheAccueil(this);
        }
    
    
    
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
