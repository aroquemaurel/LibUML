package evenements.btn;

import eltGraphique.ActeurPassif;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
 *
 * @author satenske
 */
public class BtnActeurPassif extends Btn {
    public BtnActeurPassif(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        ActeurPassif acteur = new ActeurPassif(super.fenetre.getPanneauGraph().getGraph(), 
            "Mon acteur Passif");
        acteur.afficher();
    }
}
