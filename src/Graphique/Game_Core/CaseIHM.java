package Graphique.Game_Core;

import Graphique.Ressources.GetIHMRessources;
import Modèle.Coord;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public class CaseIHM extends JPanel {

    private TypeCaseIHM type;
    private boolean isUsed;
    private boolean isFocused;
    private int x;
    private int y;

    public CaseIHM(int x, int y) {
        this.type = type;
        this.isUsed = false;
        this.x = x;
        this.y = y;
        int i = y * 17 + x;
        if ((i / 17) % 2 == 0) {
            this.type = (i % 2) == 1 ? TypeCaseIHM.VERTICAL_WALL : TypeCaseIHM.PIECE;
        } else {
            this.type = (i % 2 == 1) ? TypeCaseIHM.HORIZNTAL_WALL : TypeCaseIHM.CENTRAL_WALL;
        }
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        this.updateCase();
    }

    private void updateCaseColor() {
        if (this.isFocused) {
            if (this.isUsed) {
                this.setBackground(Color.red);
            } else {
                this.setBackground(Color.yellow);
            }
        } else if (this.isUsed) {
            switch (this.type) {
                case PIECE:
                    this.setBackground(Color.white);
                    break;
                default:
                    this.setBackground(Color.darkGray);
                    break;
            }
        } else {
            switch (this.type) {
                case PIECE:
                    this.setBackground(Color.white);
                    break;
                default:
                    this.setBackground(Color.lightGray);
                    break;
            }
        }
    }

    private void updateContent() {
        this.removeAll();
        if (this.isUsed) {
            JLabel caseContent = new JLabel();
            switch (this.type) {
                case PIECE:
                    caseContent = new CaseContentIHM("piece.png");
                    break;
                case HORIZNTAL_WALL:
                    caseContent = new CaseContentIHM("wall_h.jpg");
                    break;
                case VERTICAL_WALL:
                    caseContent = new CaseContentIHM("wall_v.jpg");
                    break;
                default:
                    break;
            }
            this.add(caseContent);
        }
    }

    private void updateCase() {
        this.updateCaseColor();
        this.updateContent();
        this.revalidate();
        this.repaint();
    }

    public void updateSize(int width, int height) {
        // Calculs préliminaires
        int nbCasesPionAvtCelleCiDansLigne = this.x / 2 + (this.x % 2);
        int nbCasesBarriereAvtCelleCiDansLigne = (this.x / 2);

        int nbCasesPionAvtCelleCiDansColonne = this.y / 2 + (this.y % 2);
        int nbCasesBarriereAvtCelleCiDansColonne = (this.y / 2);

        int tailleCasePion = width / 11;
        int tailleCaseBarriere = width / 44;

        // Calcul des coordonnées de la case dans la gille
        int xGille = nbCasesPionAvtCelleCiDansLigne * tailleCasePion + nbCasesBarriereAvtCelleCiDansLigne * tailleCaseBarriere;
        int yGrille = nbCasesPionAvtCelleCiDansColonne * tailleCasePion + nbCasesBarriereAvtCelleCiDansColonne * tailleCaseBarriere;

        // Calcul des mesures de la case
        int largeur = 0;
        int hauteur = 0;
        switch (this.type) {
            case PIECE:
                largeur = tailleCasePion;
                hauteur = tailleCasePion;
                break;
            case CENTRAL_WALL:
                largeur = tailleCaseBarriere;
                hauteur = tailleCaseBarriere;
                break;
            case VERTICAL_WALL:
                largeur = tailleCaseBarriere;
                hauteur = tailleCasePion;
                break;
            case HORIZNTAL_WALL:
                largeur = tailleCasePion;
                hauteur = tailleCaseBarriere;
                break;
        }

        // Mise à jour de la case
        this.setBounds(xGille, yGrille, largeur, hauteur);
    }

    public void setUse(boolean isUsed) {
        this.isUsed = isUsed;
        this.updateCase();
    }

    public void setFocus(boolean isFocused) {
        this.isFocused = isFocused;
        this.updateCase();
    }

    public TypeCaseIHM getType() {
        return this.type;
    }

    public Coord getCoords() {
        return new Coord(this.x, this.y);
    }
}
