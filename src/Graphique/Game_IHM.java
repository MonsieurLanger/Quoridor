/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import Graphique.Game_Core.Game_Conatiner_IHM;
import Modèle.Regle;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Graphique.Game_Core.Game_Conatiner_IHM;
import Modèle.Board;
import Modèle.Color;
import Modèle.Game;
import Modèle.Player;

/**
 *
 * @author Eddine Langer
 */
public class Game_IHM extends JFrame implements ComponentListener {

    private Menu_Accueil accueilPanel;
    private Menu_Choix choixPanel;
    private Menu_Configuration configPanel;
    private Menu_Jeu jeuPanel;
    private Menu_Joueur joueurPanel;
    private Menu_Lobby lobbyPanel;
    public Game myGame;
    public Game_Conatiner_IHM monPlato;

    public static ArrayList<Regle> rules;

    private GridBagConstraints c;

    public Game_IHM() {
        //Construction générale de la fenêtre
        this.setTitle("Koridunor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(900, 700));
        this.addComponentListener(this);
        init();
        c.gridx = 0;
        c.gridy = 0;

        this.add(accueilPanel, c);
        //  this.add(partiePanel, c);
        //this.add(joueurPanel, c);
        //this.add(configPanel,c);
        c.gridx = 1;
        c.gridy = 0;

//        this.add(monPlato, c);
//        monPlato.setVisible(false);
        this.pack();
        this.setVisible(true);
        this.repaint();
    }

    private void init() {
        c = new GridBagConstraints();
        myGame = new Game(new Player("Joueur 1", Color.BLEU), new Player("Joueur 2", Color.ROUGE), new Board());
        monPlato = null;
        accueilPanel = new Menu_Accueil(this);
        choixPanel = new Menu_Choix(this);
        configPanel = new Menu_Configuration(this);
        joueurPanel = new Menu_Joueur(this);
        jeuPanel = new Menu_Jeu(this);
        this.setLayout(new GridBagLayout());
    }

    public void actualisation() {
        this.revalidate();
        this.repaint();
    }

    void afficheChoix(Object t) {
        if (t == accueilPanel) {
            this.remove(accueilPanel);
        }
        if (t == configPanel) {
            this.remove(configPanel);
        }
        if (t == joueurPanel) {
            this.remove(joueurPanel);
        }

        c.gridx = 0;
        c.gridy = 0;

        this.add(choixPanel, c);
        this.setVisible(true);

        actualisation();
    }

    void afficheAccueil(Object t) {
        if (t == choixPanel) {
            this.remove(choixPanel);
        }
        if (t == jeuPanel) {
            this.remove(jeuPanel);
            this.remove(monPlato);
        }
        //monPlato = new JPanel();
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

    void afficheConfig(Object t) {
        if (t == choixPanel) {
            this.remove(choixPanel);
        } else {
            System.out.println("Nono");
        }

        c.gridx = 0;
        c.gridy = 0;
        this.add(configPanel, c);

        this.setVisible(true);

        actualisation();
    }

    void afficheJoueur(Object t) {
        if (t == choixPanel) {
            this.remove(choixPanel);
        }
        if (t == configPanel) {
            this.remove(configPanel);
        }
        if (t == joueurPanel) {
            this.remove(joueurPanel);
        }

        c.gridx = 0;
        c.gridy = 0;

        this.add(joueurPanel, c);
        this.setVisible(true);

        actualisation();
    }

    void afficheJeu(Object t) {
        if (t == joueurPanel) {
            this.remove(joueurPanel);
            if (this.monPlato != null) {
                this.remove(monPlato);
            }
        }
        if (t == configPanel) {
            this.remove(configPanel);
            this.remove(monPlato);
        }

        c.gridx = 0;
        c.gridy = 0;

        this.add(jeuPanel, c);

        c.gridx = 1;
        c.gridy = 0;

        this.monPlato = new Game_Conatiner_IHM(this.myGame);
        this.add(monPlato, c);
        monPlato.setVisible(true);

        this.setVisible(true);

        actualisation();
        monPlato.updateCurrentPlayer();
        monPlato.updateCurrentPlayer();
        this.updateSubComponentsSize();
        monPlato.updateComponentAndSubComponentsSize();

    }

    @Override
    public void componentResized(ComponentEvent e) {
        this.updateSubComponentsSize();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void updateSubComponentsSize() {
        int height = this.getSize().height;
        int width = this.getSize().width;
        int widthpcent = width / 100;
        Dimension dimPlateau = new Dimension(widthpcent * 70, height);
        if (this.monPlato != null) {
            this.monPlato.setPreferredSize(dimPlateau);
            this.monPlato.setMaximumSize(dimPlateau);
            this.monPlato.setMinimumSize(dimPlateau);
            if (this.monPlato instanceof Game_Conatiner_IHM) {
                Game_Conatiner_IHM tmpPlateau = (Game_Conatiner_IHM) this.monPlato;
                tmpPlateau.updateComponentAndSubComponentsSize();
            }
        }
        Dimension dimAccueil = new Dimension(widthpcent * 30, height);
        if (this.accueilPanel != null) {
            this.accueilPanel.setPreferredSize(dimAccueil);
            this.accueilPanel.setMaximumSize(dimAccueil);
            this.accueilPanel.setMinimumSize(dimAccueil);
        }
        this.actualisation();
    }

}
