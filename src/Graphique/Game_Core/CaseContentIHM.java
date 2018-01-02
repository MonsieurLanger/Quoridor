package Graphique.Game_Core;

import Graphique.Ressources.GetIHMRessources;
import Modèle.Color;
import Modèle.Player;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

/**
 * Contenu image d'une case qui prends la taille du conteneur ou une taille
 * fixée
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public class CaseContentIHM extends JLabel {

    String image;

    int width;
    int height;
    boolean autoFit;

    public CaseContentIHM(String image, boolean autoFit) {
        this.image = image;
        this.width = 1;
        this.height = 1;
        this.autoFit = autoFit;
    }

    public CaseContentIHM(String image) {
        this(image, true);
    }

    private void loadScaledImage() {
        // On définit la taille de l'image:
        int imgWidth = 0;
        int imgHeight = 0;
        //    -> si on colle à la case parente alors c'est sa taille moins deux pixels
        if (this.autoFit) {
            imgWidth = this.getParent().getSize().width - 2;
            imgHeight = this.getParent().getSize().height - 2;
        } else {
            //    -> sinon c'est la taille définie précédement moins deux pixels
            imgWidth = this.width - 2;
            imgHeight = this.height - 2;
        }
        // On charge l'image avec la bonne taille
        this.setIcon(GetIHMRessources.getScaledIconFromRessources(this.image, imgWidth, imgHeight));
    }

    public void updateSize(int width, int height) {
        // Mise à jour manuelle de la taille
        this.width = width;
        this.height = height;
        this.setSize(width, height);
    }

    public void stopAutoFit() {
        this.autoFit = false;
    }

    @Override
    public Dimension getPreferredSize() {
        // Fonction qui permet de fixer la taille du JPannel
        //    -> mise à jour de la taille de l'image
        this.loadScaledImage();
        //    -> si l'on es en auto-fit alors la taille est automatiquement déterminée par la taille du conteneur parent
        if (this.autoFit) {
            this.width = this.getParent().getSize().width;
            this.height = this.getParent().getSize().height;
        }
        //    -> on renvoie la dimmension
        return new Dimension(this.width, this.height);
    }

    @Override
    public Dimension getMaximumSize() {
        return this.getPreferredSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return this.getPreferredSize();
    }

}
