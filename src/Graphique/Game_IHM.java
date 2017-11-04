/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Eddine Langer
 */
public class Game_IHM extends JFrame{
  private Menu_Accueil accueilPanel;
  private Menu_Choix choixPanel;
  private Menu_Configuration configPanel;
  private Menu_Jeu jeuPanel;
  private Menu_Joueur joueurPanel;
  private Menu_Lobby lobbyPanel;
  
  private Plateau_IHM monPlato;
 private GridBagConstraints c;
  
    public Game_IHM() {
        
        //Construction générale de la fenêtre
        this.setTitle("Koridunor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        init();
        c.gridx = 0;
        c.gridy = 0;
      
       
       //this.add(accueilPanel, c);
      //  this.add(partiePanel, c);
        this.add(joueurPanel, c);
        c.gridx = 1;
        c.gridy = 0;
        monPlato.setVisible(true);
        this.add(monPlato, c);
        this.pack();
        this.setVisible(true);
        this.repaint();
    }
    private void init() {
        c = new GridBagConstraints();
        monPlato = new Plateau_IHM();
        monPlato.setPreferredSize(new Dimension(675, 675));
        monPlato.setLayout(new GridBagLayout());
        accueilPanel = new Menu_Accueil(this);
        choixPanel=new Menu_Choix(this);
        configPanel=new Menu_Configuration(this);
        joueurPanel=new Menu_Joueur(this);
        
        
        accueilPanel.setPreferredSize(new Dimension(300, 675));
        this.setLayout(new GridBagLayout());
    }
    
       public void actualisation() {
       
        this.revalidate();
        this.repaint();
    }

    void afficheChoix() {
        this.remove(accueilPanel);
        c.gridx = 0;
        c.gridy = 0;

        this.add(choixPanel, c);
        this.setVisible(true);

        actualisation();
    }
    
    void afficheAccueil(Object t) {
        this.remove(choixPanel);
        c.gridx = 0;
        c.gridy = 0;

        this.add(accueilPanel, c);
        this.setVisible(true);

        actualisation();
    }
    
    
    
     void afficheLobby() {
        this.remove(joueurPanel);
        c.gridx = 0;
        c.gridy = 0;

        this.add(accueilPanel, c);
        this.setVisible(true);

        actualisation();
    }
    /*
    
     void affichePartie(Object t) {
        this.remove(partiePanel);
        c.gridx = 0;
        c.gridy = 0;

        this.add(accueilPanel, c);
        this.setVisible(true);

        actualisation();
    }
     */
    void afficheJoueur(Object t) {
        if(t==choixPanel){
         this.remove(choixPanel);
        }
       if(t==configPanel){
         this.remove(configPanel);
        }
        c.gridx = 0;
        c.gridy = 0;

        this.add(joueurPanel, c);
        this.setVisible(true);

        actualisation();
    }
}
