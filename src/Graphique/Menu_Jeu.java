/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import Modèle.Regle;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
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
        c.gridx = 0;
        c.gridy = 0;
        this.add(pause, c);

        regles = new JButton("Règles");
        regles.setPreferredSize(new Dimension(200, 50));
        c.gridx = 0;
        c.gridy = 1;
        this.add(regles, c);

        giveup = new JButton("Abandonner");
        giveup.setPreferredSize(new Dimension(200, 50));
        c.gridx = 0;
        c.gridy = 2;
        this.add(giveup, c);

        initButtonListener();
        this.setVisible(true);
    }

    protected void initButtonListener() {
        pause.addActionListener(this);
        regles.addActionListener(this);
        giveup.addActionListener(this);
    }

    private String messageRule() {
        String s = new String();
        for (Regle object : this.parentPanel.myGame.getRules()) {
            if (object.isActive() == true) {
                s += object.getRecap() + "\n" + object.getDescribeRule() + "\n";
            }
        }
        return s;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if (src == pause) {
            this.parentPanel.monPlato.switchTimePause();
        } else if (src == regles) {
            JOptionPane.showMessageDialog(this.parentPanel, messageRule());
        } else if (src == giveup) {
            Object[] options = {"Oui, je suis un lâche",
                "Non j'irais jusqu'au bout"};
            int n = JOptionPane.showOptionDialog(this.parentPanel,
                    "Voulez-vous vraiment abandonner?",
                    "Abandon",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //do not use a custom Icon
                    options, //the titles of buttons
                    options[0]); //default button title

            System.out.println(n + "\n");
            if (n == 0) {
                this.parentPanel.afficheAccueil(this);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
