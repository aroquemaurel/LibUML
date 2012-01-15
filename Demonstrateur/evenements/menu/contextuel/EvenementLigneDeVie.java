package evenements.menu.contextuel;

import eltGraphique.Acteur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
* Cette classe gère l'affichage ou non de la ligne de vie
*/
public class EvenementLigneDeVie implements ActionListener {
    private final Acteur element;
    
    /**
    * Créer l'objet pour l'évenement sur un clique de l'élément passé en paramètre
    * @param p_element L'acteur à qui ont veut ajouter la ligne de vie
    */
    public EvenementLigneDeVie (Acteur p_element){
        this.element = p_element;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.element.afficherLigneDeVie(!this.element.getVisibiliteLigneDeVie());
    }

}
