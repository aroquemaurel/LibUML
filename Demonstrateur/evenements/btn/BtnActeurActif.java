package evenements.btn;

import eltGraphique.Acteur;
import eltGraphique.ActeurActif;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
 * Implémentation d'un click sur le bouton Acteur actif
 */
public class BtnActeurActif extends Btn {
    public BtnActeurActif(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        Acteur acteur = new ActeurActif(super.fenetre.getPanneauGraph().getGraph(),
            "Mon acteur Actif");
        acteur.creer();
    }
}
