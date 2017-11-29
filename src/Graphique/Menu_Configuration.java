/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import static Graphique.Game_IHM.rules;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Eddine Langer
 */
public class Menu_Configuration extends Menu{
private JLabel nmbjoueur;
private JLabel definirGame;
private JRadioButton twoPlayB;
private JRadioButton fourPlayB ;

private JRadioButton localB;
private JRadioButton onlineB ;

private JButton lancer;
private JButton retour;

private JLabel rule1;
private JLabel rule2;

private JCheckBox rule1cb ;
private JCheckBox rule2cb ;

    public Menu_Configuration(Game_IHM gIHM) {
        super(gIHM);
        c.insets = new Insets(15, 15, 15, 15);
        nmbjoueur = new JLabel("Nombre de joueurs :");
        nmbjoueur.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=2;
        this.add(nmbjoueur,c);
      
        
        twoPlayB = new JRadioButton("2");
        twoPlayB.setPreferredSize(new Dimension(50, 50));
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=1;
        this.add(twoPlayB,c);
        
        fourPlayB = new JRadioButton("4");
        fourPlayB.setPreferredSize(new Dimension(50, 50));
        c.gridx=1;
        c.gridy=1;
         c.gridwidth=1;
        this.add(fourPlayB,c);
        
        definirGame = new JLabel("Définir la partie :");
        definirGame.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=2;
        c.gridwidth=2;
        this.add(definirGame,c);
        
        localB = new JRadioButton("Local");
        localB.setPreferredSize(new Dimension(90, 50));
        c.gridx=0;
        c.gridy=3;
        c.gridwidth=1;
        this.add(localB,c);
        
        onlineB = new JRadioButton("En Ligne");
        onlineB.setPreferredSize(new Dimension(90, 50));
        c.gridx=1;
        c.gridy=3;
        c.gridwidth=1;
        this.add(onlineB,c);
        
        rule1cb = new JCheckBox(rules.get(0).getRecap());
        rule1cb.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=4;
        c.gridwidth=2;
        this.add(rule1cb,c);
        
        rule2cb = new JCheckBox(rules.get(1).getRecap());
        rule2cb.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=5;
        c.gridwidth=2;
        this.add(rule2cb,c);
       
        lancer=new JButton("Lancer");
        lancer.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=6;
        c.gridwidth=2;
        this.add(lancer,c);
        
        retour=new JButton("Retour");
        retour.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=7;
        c.gridwidth=2;
        this.add(retour,c);
       
        initButtonListener();
        this.setVisible(true);
    }

    @Override
    protected void initButtonListener() {
        //super.initButtonListener(); //To change body of generated methods, choose Tools | Templates.
//        twoPlayB.addActionListener(this);
//        fourPlayB.addActionListener(this);
        retour.addActionListener(this);
        lancer.addActionListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
            Object src=ae.getSource();
        if(src==lancer){
            this.parentPanel.afficheJoueur(this);
            
        }
        if(src==retour){
            this.parentPanel.afficheChoix(this);
        }
        else{
            System.out.println("Config no choice"+src.toString().getClass());
        }
      
    }
    
}
