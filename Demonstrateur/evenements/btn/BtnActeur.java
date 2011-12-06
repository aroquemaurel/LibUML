/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evenements.btn;

import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
 *
 * @author satenske
 */
public class BtnActeur extends Btn {
    public BtnActeur(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }
    
    public void mouseClicked(MouseEvent event) {
        super.fenetre.getPanneauGraph().getGraph().getModel().beginUpdate();
        Object parent = super.fenetre.getPanneauGraph().getGraph().getDefaultParent();

        super.fenetre.getPanneauGraph().getGraph().insertVertex(parent, null, "Acteur", 20, 20,75, 100, "ACTEUR");

        super.fenetre.getPanneauGraph().getGraph().getModel().endUpdate();
    }
}
