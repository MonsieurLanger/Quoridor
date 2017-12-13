package Graphique.Game_Core;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

/**
 * Conteneur principal pour une session de jeu
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public class Game_Conatiner_IHM extends JPanel implements MouseListener, MouseMotionListener {

    private JPanel gameTimer;
    private JLabel currentPlayerTimer;
    private JPanel currentPlayerName;
    private Board_IHM board;
    private JPanel verticalWall;
    private JPanel horizontalWall;
    private JPanel actionsPannel;
    private JPanel boardCentredPanel;
    private JPanel wallNumber;

    private JLayeredPane layeredPane;
    private CaseContentIHM pieceDeplaced;
    private TypeCaseIHM typePieceDeplaced;

    private int nbBarrieres;
    private int gameTime;
    private int numJoueur;
    private boolean fromStock;

    public Game_Conatiner_IHM() {
        // Mise en place de la mise en page
        super(new BorderLayout());

        // Initialisation de la partie supérieure du JPanel
        JPanel infosPanel = new JPanel(new GridLayout(1, 3));
        this.gameTime = 0;
        this.gameTimer = new JPanel();
        this.updateGameTime();
        this.currentPlayerTimer = new JLabel();
        this.currentPlayerName = new JPanel();
        this.numJoueur = 2;
        this.updateCurrentPlayer();
        infosPanel.add(this.gameTimer);
        infosPanel.add(this.currentPlayerTimer);
        infosPanel.add(this.currentPlayerName);

        // Initialisation du plateau de jeu
        this.boardCentredPanel = new JPanel();
        this.board = new Board_IHM();
        layeredPane = new JLayeredPane();

        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
        layeredPane.add(this.board, JLayeredPane.DEFAULT_LAYER);
        boardCentredPanel.add(layeredPane, BorderLayout.CENTER);

        // Initalisation de la partie basse du JPanel
        this.actionsPannel = new JPanel();
        this.actionsPannel.setLayout(null);
        this.actionsPannel.addMouseListener(this);
        this.actionsPannel.addMouseMotionListener(this);

        this.verticalWall = new JPanel();
        this.verticalWall.add(new CaseContentIHM("wall_v.jpg"));
        this.actionsPannel.add(this.verticalWall);

        this.horizontalWall = new JPanel();
        this.horizontalWall.add(new CaseContentIHM("wall_h.jpg"));
        this.actionsPannel.add(this.horizontalWall);

        this.wallNumber = new JPanel();
        this.actionsPannel.add(this.wallNumber);
        this.nbBarrieres = 10;
        this.updateWallNumbers(this.nbBarrieres);

        // Ajout des composants au continer
        this.add(infosPanel, BorderLayout.NORTH);
        this.add(boardCentredPanel, BorderLayout.CENTER);
        this.add(actionsPannel, BorderLayout.SOUTH);

        // Mise à jour de la taille des composants
        this.updateComponentAndSubComponentsSize();

        // Mise en place d'un timer de jeu
        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateGameTime();
            }
        };
        Timer timer = new Timer(1000, taskPerformer);
        timer.setRepeats(true);
        timer.start();
    }

    public void updateComponentAndSubComponentsSize() {
        // Calcul d'une unité de lauteur et largeur (% de la taille de la fenêtre)
        int uniteHauteur = (int) (this.getSize().height * 0.01);
        int uniteLargeur = (int) (this.getSize().width * 0.01);
        // dimmensionnement de la grille de jeu
        int tailleGrille = (uniteHauteur < uniteLargeur) ? uniteHauteur * 85 : uniteLargeur * 85;
        this.layeredPane.setMaximumSize(new Dimension(tailleGrille, tailleGrille));
        this.layeredPane.setMinimumSize(new Dimension(tailleGrille, tailleGrille));
        this.layeredPane.setPreferredSize(new Dimension(tailleGrille, tailleGrille));
        this.board.setBounds(0, 0, tailleGrille, tailleGrille);
        // dimmensionnement des actions de jeu (ajout des barrières)
        if (this.actionsPannel != null) {
            this.actionsPannel.setPreferredSize(new Dimension(uniteLargeur * 100 - 1, uniteHauteur * 14));
            this.actionsPannel.setMaximumSize(new Dimension(uniteLargeur * 100 - 1, uniteHauteur * 14));
            this.actionsPannel.setMinimumSize(new Dimension(uniteLargeur * 100 - 1, uniteHauteur * 14));
        }
        if (this.verticalWall != null) {
            this.verticalWall.setBounds(uniteLargeur * 30, 0, (int) (uniteHauteur * 2.5), uniteHauteur * 10);
        }
        if (this.horizontalWall != null) {
            this.horizontalWall.setBounds(uniteLargeur * 60, uniteHauteur * 5, uniteHauteur * 10, (int) (uniteHauteur * 2.5));
        }
        if (this.wallNumber != null) {
            this.wallNumber.setBounds(uniteLargeur * 40, uniteHauteur * 5, uniteHauteur * 10, (int) (uniteHauteur * 2.5));
        }
        // rafraichissement de l'IHM
        this.repaint();
        this.revalidate();
    }

    private void updateWallNumbers(int nb) {
        this.wallNumber.removeAll();
        this.wallNumber.add(new JLabel("x " + nb));
        this.wallNumber.repaint();
    }

    private void updateGameTime() {
        this.gameTime++;
        this.gameTimer.removeAll();
        if (gameTime % 60 < 10) {
            this.gameTimer.add(new JLabel("Temps de jeu: " + (this.gameTime / 60) + ":0" + (this.gameTime % 60)));
        } else {
            this.gameTimer.add(new JLabel("Temps de jeu: " + (this.gameTime / 60) + ":" + (this.gameTime % 60)));
        }
        this.gameTimer.repaint();
        this.gameTimer.revalidate();

    }

    private void updateCurrentPlayer() {
        if (this.numJoueur == 1) {
            this.numJoueur = 2;
        } else {
            this.numJoueur = 1;
        }
        this.currentPlayerName.removeAll();
        this.currentPlayerName.add(new JLabel("Joueur courrant: " + this.numJoueur));
        this.currentPlayerName.revalidate();
        this.currentPlayerName.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        // Mise à zero de la pièce déplacée et du faite qu'il s'agit d'un mur du stock
        pieceDeplaced = null;
        this.fromStock = false;

        // Recherche de la pièce à déplacer dans le tableau de jeu
        Component c = this.board.findComponentAt(me.getX(), me.getY());
        if (c != null && c instanceof CaseContentIHM) {
            CaseIHM currentCase = (CaseIHM) c.getParent();
            // On enlève la pièce de la case
            currentCase.setUse(false);
            // On crée une pièce pour la partie Drag n Drop
            pieceDeplaced = (CaseContentIHM) c;
            pieceDeplaced.setLocation(me.getX(), me.getY());
            pieceDeplaced.setSize(c.getWidth(), c.getHeight());
            pieceDeplaced.stopAutoFit();
            // On met à jour le type de la pièce
            this.typePieceDeplaced = currentCase.getType();
            // On ajoute la pièce sur la partie Drag n Drop
            layeredPane.add(pieceDeplaced, JLayeredPane.DRAG_LAYER);
        }

        // On recherche si la pièce est dans le stock de barrières
        c = this.actionsPannel.findComponentAt(me.getX(), me.getY());
        if (c != null && c instanceof CaseContentIHM) {
            int uniteHauteur = (int) (this.getSize().height * 0.01);
            // On met à jour le fait que la pièce vient du stock
            this.fromStock = true;
            JPanel parent = (JPanel) c.getParent();
            // On crée une pièce pour la partie Drag n Drop
            // & on met à jour le type de la pièce
            if (parent.equals(this.horizontalWall)) {
                pieceDeplaced = new CaseContentIHM("wall_h.jpg", false);
                this.typePieceDeplaced = TypeCaseIHM.HORIZNTAL_WALL;
                pieceDeplaced.updateSize(uniteHauteur * 10, (int) (uniteHauteur * 2.5));
                pieceDeplaced.setSize(uniteHauteur * 10, (int) (uniteHauteur * 2.5));
            }
            if (parent.equals(this.verticalWall)) {
                pieceDeplaced = new CaseContentIHM("wall_v.jpg", false);
                this.typePieceDeplaced = TypeCaseIHM.VERTICAL_WALL;
                pieceDeplaced.updateSize((int) (uniteHauteur * 2.5), uniteHauteur * 10);
                pieceDeplaced.setSize((int) (uniteHauteur * 2.5), uniteHauteur * 10);
            }
            pieceDeplaced.getMaximumSize();
            // On ajoute la pièce sur la partie Drag n Drop
            pieceDeplaced.setLocation(-100, -100);
            layeredPane.add(pieceDeplaced, JLayeredPane.DRAG_LAYER);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {

        if (pieceDeplaced == null) {
            return;
        }

        // On rends invisible la pièce sur la partie Drag n Drop
        pieceDeplaced.setVisible(false);

        // On recherche l'emplacement de la pièce sur le plateau
        int X = me.getLocationOnScreen().x - this.board.getLocationOnScreen().x;
        int Y = me.getLocationOnScreen().y - this.board.getLocationOnScreen().y;

        Component c = this.board.findComponentAt(X, Y);

        if (c instanceof CaseIHM) {
            // Si on es dans une case, alors on la met à jour
            // et on enlève le focus
            CaseIHM caseCourrante = (CaseIHM) c;
            caseCourrante.setUse(true);
            caseCourrante.setFocus(false);
            // On met à jour l'indicateur de barrières en stock
            if (this.fromStock) {
                this.updateWallNumbers(--this.nbBarrieres);
            }
        }
        // On met à jour le joueuer courrant et les cases mises en focus
        this.updateCurrentPlayer();
        this.board.resetFocusedCases();

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (pieceDeplaced == null) {
            return;
        }

        // On recherche l'emplacement de la pièce sur le plateau
        int X = me.getLocationOnScreen().x - this.board.getLocationOnScreen().x;
        int Y = me.getLocationOnScreen().y - this.board.getLocationOnScreen().y;
        pieceDeplaced.setLocation(X, Y);

        Component c = this.board.findComponentAt(X, Y);

        if (c instanceof CaseIHM) {
            // Si on es dans une case, alors on la met à jour son focus
            CaseIHM caseCourrante = (CaseIHM) c;
            int x = caseCourrante.getCoords().x;
            int y = caseCourrante.getCoords().y;
            this.board.resetFocusedCases();
            if (caseCourrante.getType() == this.typePieceDeplaced) {
                this.board.setFocusOnCase(x, y);
                switch (this.typePieceDeplaced) {
                    case HORIZNTAL_WALL:
                        this.board.setFocusOnCase(x + 1, y);
                        this.board.setFocusOnCase(x + 2, y);
                        break;
                    case VERTICAL_WALL:
                        this.board.setFocusOnCase(x, y + 1);
                        this.board.setFocusOnCase(x, y + 2);
                        break;
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

}
