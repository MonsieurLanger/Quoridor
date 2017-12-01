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

    public CaseContentIHM(String image) {
        this.image = image;
    }

    private void loadScaledImage() {
        this.setIcon(GetIHMRessources.getScaledIconFromRessources(this.image, this.getParent().getSize().width, this.getParent().getSize().height));
    }

    @Override
    public Dimension getPreferredSize() {
        this.loadScaledImage();
        return new Dimension(this.getParent().getSize().width, this.getParent().getSize().height);
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
