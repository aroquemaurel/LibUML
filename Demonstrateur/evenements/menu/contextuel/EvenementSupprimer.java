package evenements.menu.contextuel;

import eltModelisation.ElementGraphique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Cette classe gère l'affichage ou non de la ligne de vie
 */
public class EvenementSupprimer implements ActionListener {
	/* L'élément que l'on veut supprimer */
	private ElementGraphique element;

	/* Construit l'objet en fonction de l'élément que l'on veut supprime */
	public EvenementSupprimer(ElementGraphique p_element){
		this.element = p_element;
	}

	/* 
	 * Action sur supprimer, on supprime la cellule et on met l'élément graphique à null
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if(this.element != null){
			this.element.supprimer();
			this.element = null;
		}
	}

}
