package Graphique.Game_Core;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Plateau de jeu (damier)
 * @author MOREL Charles
 */
public class Board_IHM extends JPanel {

    private List<List<CaseIHM>> boadCases;
    private List<CaseIHM> focusedCases;

    public Board_IHM() {
        // On initialise le layout
        this.setLayout(null);
        // On générèe le tableau
        this.generateBoard();
        // On met en place la liste des cases focused
        this.focusedCases = new ArrayList<CaseIHM>();
        this.boadCases.get(8).get(0).setUse(true);
        this.boadCases.get(8).get(16).setUse(true);
    }

    private void generateBoard() {
        // On remet à zéro le damier
        this.removeAll();
        this.boadCases = new ArrayList<List<CaseIHM>>();
        for (int i = 0; i < 17; i++) {
            this.boadCases.add(new ArrayList<CaseIHM>());
        }

        //L'objet servant à positionner les composants
        for (int i = 0; i < 289; i++) {
            int x = i % 17;
            int y = i / 17;
            CaseIHM currentCase = new CaseIHM(x, y);
            this.add(currentCase);
            this.boadCases.get(x).add(currentCase);
        }
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        // Mise à jour de la taille du plateau
        super.setBounds(x, y, width, height);
        // Mise à jour de la taille des cases
        for (List<CaseIHM> listeCases : this.boadCases) {
            for (CaseIHM caseCourrante : listeCases) {
                caseCourrante.updateSize(width, height);
            }
        }
    }

    public void resetFocusedCases() {
        // On remet à zero toutes les cases focused
        for (CaseIHM caseToUnfosus : this.focusedCases) {
            caseToUnfosus.setFocus(false);
        }
        // On remet à zerola liste des cases où enlever le focus
        this.focusedCases.clear();
    }

    public void setFocusOnCase(int x, int y) {
        // On met le focus sur une case
        if (x >= 0 && x <= 16 && y >= 0 && y <= 16) {
            this.focusedCases.add(this.boadCases.get(x).get(y));
            this.boadCases.get(x).get(y).setFocus(true);
        }
    }

}
