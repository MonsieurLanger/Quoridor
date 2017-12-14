/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Eddine Langer
 */
public class Menu_Joueur extends Menu{
private JLabel labelJoueur;
private JTextField nomJoueur;

private JLabel couleur;
private JLabel nomCouleur;
private JButton droite;
private JButton gauche;

private JLabel imagePion;
private JButton pret;
private JButton annuler;

    public Menu_Joueur(Game_IHM gIHM) {
        super(gIHM);
        c.insets = new Insets(15, 15, 15, 15);
        labelJoueur = new JLabel("Nom du Joueur :");
        labelJoueur.setPreferredSize(new Dimension(100, 50));
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=1;
        this.add(labelJoueur,c);
        
        nomJoueur = new JTextField();
        nomJoueur.setColumns(10);
        nomJoueur.setPreferredSize(new Dimension(200, 50));
        c.gridx=1;
        c.gridy=0;
        c.gridwidth=2;
        this.add(nomJoueur,c);
        
        couleur = new JLabel("Couleur du Pion : ");
        couleur.setPreferredSize(new Dimension(100, 50));
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=3;
        this.add(couleur,c);
        
        gauche = new JButton("<");
        gauche.setPreferredSize(new Dimension(50, 50));
        c.gridx=0;
        c.gridy=2;
        c.gridwidth=1;
        this.add(gauche,c);
        
        nomCouleur = new JLabel("<Couleur du Pion>");
        nomCouleur.setPreferredSize(new Dimension(115, 50));
        c.gridx=1;
        c.gridy=2;
        c.gridwidth=1;
        this.add(nomCouleur,c);
        
        
        
        droite = new JButton(">");
        droite.setPreferredSize(new Dimension(50, 50));
        c.gridx=2;
        c.gridy=2;
        c.gridwidth=1;
        this.add(droite,c);
        
        imagePion = new JLabel("Image Pion");
        imagePion.setPreferredSize(new Dimension(100, 50));
        c.gridx=0;
        c.gridy=3;
        c.gridwidth=3;
        this.add(imagePion,c);
        
        pret = new JButton("Prêt");
        pret.setPreferredSize(new Dimension(200,50));
        c.gridx=0;
        c.gridy=4;
        c.gridwidth=3;
        this.add(pret,c);
        
        annuler = new JButton("Annuler");
        annuler.setPreferredSize(new Dimension(200,50));
        c.gridx=0;
        c.gridy=5;
        c.gridwidth=3;
        this.add(annuler,c);
        
        initButtonListener();
        this.setVisible(true);
    }

@Override
    protected void initButtonListener() {
        super.initButtonListener(); //To change body of generated methods, choose Tools | Templates.
        pret.addActionListener(this);
        annuler.addActionListener(this);
        nomJoueur.addActionListener(this);
    
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String text = nomJoueur.getText();
       System.out.println(text);
       Object src=ae.getSource();
       if(src==annuler){
            this.parentPanel.afficheChoix(this);
        }
       if(src==pret){
            this.parentPanel.afficheJeu(this);
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
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
