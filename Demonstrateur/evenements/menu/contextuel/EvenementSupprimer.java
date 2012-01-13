package evenements.menu.contextuel;

import eltGraphique.ElementGraphique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class EvenementSupprimer implements ActionListener {
	private ElementGraphique element;

	public EvenementSupprimer(ElementGraphique p_element){
		this.element = p_element;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.element.supprimer();
	}

}
