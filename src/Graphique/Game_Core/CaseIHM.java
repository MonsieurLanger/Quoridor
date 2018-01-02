package Graphique.Game_Core;

import Graphique.Ressources.GetIHMRessources;
import Modèle.Coord;
import Modèle.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe permettant de symboliser une case de plateau
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public class CaseIHM extends JPanel {

    private final TypeCaseIHM type;
    private boolean isUsed;
    private boolean isFocused;
    private int x;
    private int y;

    private static List<String> playersImgs;
    private static int currentPlayerImg;

    public static void updatePlayersImgs(Player p1, Player p2, Player p3, Player p4) {
        CaseIHM.playersImgs = new ArrayList<String>();
        CaseIHM.playersImgs.add(p1.getColorPlyer().getImgName());
        CaseIHM.playersImgs.add(p2.getColorPlyer().getImgName());
        CaseIHM.currentPlayerImg = 0;
    }

    public static void forcePlayerImg(int id) {
        CaseIHM.currentPlayerImg = id;
    }

    public CaseIHM(int x, int y) {
        // Initialisation du statut non utilisé ni focused + cooredonnées
        this.isUsed = false;
        this.isFocused = false;
        this.x = x;
        this.y = y;
        // Recherche du type de case en fonction de ses coordonnées
        int i = y * 17 + x;
        if ((i / 17) % 2 == 0) {
            this.type = (i % 2) == 1 ? TypeCaseIHM.VERTICAL_WALL : TypeCaseIHM.PIECE;
        } else {
            this.type = (i % 2 == 1) ? TypeCaseIHM.HORIZNTAL_WALL : TypeCaseIHM.CENTRAL_WALL;
        }
        // Création des bordures de la case
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        // Mise à jour graphique de la case
        this.updateCase();
    }

    private void updateCaseColor() {
        if (this.isFocused) {
            // Si on es focus et qu'il n'y a pas de pièce, alors on es coloré en jaune
            if (this.isUsed) {
                this.setBackground(Color.red);
            } else {
                // Si on es focus et qu'il y a une pièce, alors on es coloré en rouge
                this.setBackground(Color.yellow);
            }
        } else if (this.isUsed) {
            // Si on est utilisé alors on colore en fonction de s'il s'agit d'une case pièce ou mur
            switch (this.type) {
                case PIECE:
                    this.setBackground(Color.white);
                    break;
                default:
                    this.setBackground(Color.darkGray);
                    break;
            }
        } else {
            // Si on n'est pas utilisé alors on colore en fonction de s'il s'agit d'une case pièce ou mur
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
        // Mise à jour de l'image en fonction de si l'on a une pièce ou un mur dans la case
        this.removeAll();
        if (this.isUsed) {
            JLabel caseContent = new JLabel();
            switch (this.type) {
                case PIECE:
                    if(CaseIHM.currentPlayerImg == -1)
                    {
                    caseContent = new CaseContentIHM("piece.png");
                    }
                    else
                    {
                        String test = CaseIHM.playersImgs.get(CaseIHM.currentPlayerImg)+"Pion.png";
                        caseContent = new CaseContentIHM(CaseIHM.playersImgs.get(CaseIHM.currentPlayerImg)+"Pion.png");
                        CaseIHM.currentPlayerImg = -1;
                    }
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
        // Mise à jour graphique de la case:
        //    Sa couleur
        this.updateCaseColor();
        //    Son contenu
        this.updateContent();
        //    MaJ Swing
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
