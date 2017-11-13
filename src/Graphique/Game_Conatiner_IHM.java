package Graphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public class Game_Conatiner_IHM extends JPanel {

    private JLabel gameTimer;
    private JLabel currentPlayerTimer;
    private JLabel currentPlayerName;
    private Board_IHM board;
    private JLabel verticalWall;
    private JLabel horizontalWall;

    public Game_Conatiner_IHM() {
        // Mise en place de la mise en page
        super(new BorderLayout());

        // Initialisation de la partie supérieure du JPanel
        JPanel infosPanel = new JPanel(new GridLayout(1, 3));
        this.gameTimer = new JLabel("Temps de jeu: 00:00");
        this.currentPlayerTimer = new JLabel("Temps restant joueur: 00:00");
        this.currentPlayerName = new JLabel("Joueur corrant: John");
        infosPanel.add(this.gameTimer);
        infosPanel.add(this.currentPlayerTimer);
        infosPanel.add(this.currentPlayerName);

        // Initialisation du plateau de jeu
        JPanel boardCentredPanel = new JPanel();
        this.board = new Board_IHM();
        boardCentredPanel.add(this.board, BorderLayout.CENTER);

        // Initalisation de la partie basse du JPanel
        JPanel actionsPannel = new JPanel(new GridLayout(1, 5));
        this.verticalWall = new JLabel(getIconFromRessources("wall_v.jpg"));
        actionsPannel.add(this.verticalWall);
        this.horizontalWall = new JLabel(getIconFromRessources("wall_h.jpg"));
        actionsPannel.add(this.horizontalWall);

        // Ajout des composants au continer
        this.add(infosPanel, BorderLayout.NORTH);
        this.add(boardCentredPanel, BorderLayout.CENTER);
        this.add(actionsPannel, BorderLayout.SOUTH);
    }

    private ImageIcon getIconFromRessources(String ressourceName) {
        File g = new File("");
        String imgPath = g.getAbsolutePath() + "/src/Graphique/Ressources/" + ressourceName;
        return new ImageIcon(imgPath);
    }
}
