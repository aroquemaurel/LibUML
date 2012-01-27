package evenements.menu.contextuel;

import eltGraphique.eltModelisation.Traitement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe permettant de gérer l'affichage ou non de la flèche de début de séquence
 */
public class EvenementDebutSequence implements ActionListener {
    private Traitement element;

    /** 
     * Construit l'objet pour l'affichage de la flèche pour l'élément passé en paramètre
     */
    public EvenementDebutSequence(Traitement element) {
        this.element = element;
    }
     
    /** Action sur le menu contextuel */
    @Override
    public void actionPerformed(ActionEvent event) {
        this.element.setDebutSequence(!this.element.estDebutSequence());
    }
    
}
