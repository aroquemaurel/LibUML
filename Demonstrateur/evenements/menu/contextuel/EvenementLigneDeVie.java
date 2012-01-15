package evenements.menu.contextuel;

import eltGraphique.Acteur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
* Cette classe gère l'évènement ligne de vie.
*/
public class EvenementLigneDeVie implements ActionListener {
    private final Acteur element;
    
    /**
    * Cette classe gère l'évènement ligne de vie.
    * @param p_element acteur ajouter sur la ligne de vie
    */
    public EvenementLigneDeVie (Acteur p_element){
        this.element = p_element;
    }

    
    @Override
    public void actionPerformed(ActionEvent event) {
        this.element.afficherLigneDeVie(!this.element.getVisibiliteLigneDeVie());
    }

}
