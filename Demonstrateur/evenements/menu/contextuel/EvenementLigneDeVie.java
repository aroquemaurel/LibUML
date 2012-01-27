package evenements.menu.contextuel;

import eltGraphique.eltModelisation.Acteur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
* Cette classe gère l'affichage ou non de la ligne de vie
*/
public class EvenementLigneDeVie implements ActionListener {
    private final Acteur element;
    
    /**
    * Construit l'objet pour l'affichage de la ligne de vie pour l'élément passé en paramètre
    */
    public EvenementLigneDeVie (Acteur p_element){
        this.element = p_element;
    }

    /** Action sur le menu contextuel */
    @Override
    public void actionPerformed(ActionEvent event) {
        this.element.afficherLigneDeVie(!this.element.getVisibiliteLigneDeVie());
    }

}
