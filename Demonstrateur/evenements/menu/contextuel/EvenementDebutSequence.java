package evenements.menu.contextuel;

import eltGraphique.Traitement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class EvenementDebutSequence implements ActionListener {
    private Traitement element;

    public EvenementDebutSequence(Traitement element) {
        this.element = element;
    }
     
    @Override
    public void actionPerformed(ActionEvent event) {
        this.element.setDebutSequence(!this.element.estDebutSequence());
    }
    
}
