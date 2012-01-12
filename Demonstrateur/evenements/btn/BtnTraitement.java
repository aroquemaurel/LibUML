package evenements.btn;

import eltGraphique.Traitement;
import eltGraphique.ligne.Lien;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;


/**
 * Implémentation d'un click sur le bouton Traitement
 */
public class BtnTraitement extends Btn {

    public BtnTraitement (String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        Traitement traitement = new Traitement (super.fenetre.getPanneauGraph().getGraph(),
            fenetre.getPanneauGraph().getDiagramme(),
<<<<<<< HEAD
                "Mon traitement", new Lien(null, null, super.fenetre.getPanneauGraph().getGraph(),
													super.fenetre.getPanneauGraph().getDiagramme(), null), true);
=======
                "Mon traitement" );
>>>>>>> b2d6e6139ba7daba6c03671af7e185c3332123c6
        traitement.creer();
    }

}
