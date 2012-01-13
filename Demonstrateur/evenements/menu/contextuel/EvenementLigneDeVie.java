package evenements.menu.contextuel;

import eltGraphique.Acteur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *

 */
public class EvenementLigneDeVie implements ActionListener {
    private Acteur element;

    public EvenementLigneDeVie (Acteur p_element){
        this.element = p_element;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.element.afficherLigneDeVie(!this.element.getVisibiliteLigneDeVie());
    }

}
