package Graphique.Game_Core;

import Graphique.Ressources.GetIHMRessources;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
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
        int imgWidth = 0;
        int imgHeight = 0;
        if (this.autoFit) {
            imgWidth = this.getParent().getSize().width - 2;
            imgHeight = this.getParent().getSize().height - 2;
        } else {
            imgWidth = this.width - 2;
            imgHeight = this.height - 2;
        }
        this.setIcon(GetIHMRessources.getScaledIconFromRessources(this.image, imgWidth, imgHeight));
    }

    public void updateSize(int width, int height) {
        this.width = width;
        this.height = height;
        this.setSize(width, height);
    }

    public void stopAutoFit() {
        this.autoFit = false;
    }

    @Override
    public Dimension getPreferredSize() {
        this.loadScaledImage();
        if (this.autoFit) {
            this.width = this.getParent().getSize().width;
            this.height = this.getParent().getSize().height;
        } 
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
