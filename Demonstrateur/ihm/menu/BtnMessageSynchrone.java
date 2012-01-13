/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.menu;

import eltGraphique.ligne.TypeLien;
import evenements.Btn;
import evenements.EvenementsEltGraphiques;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
 *
 * @author satenske
 */
class BtnMessageSynchrone extends Btn {

	public BtnMessageSynchrone(String p_string, FenetreDemo p_fenetre) {
        super(p_string, p_fenetre);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		EvenementsEltGraphiques evenement =
			new EvenementsEltGraphiques(this.fenetre.getPanneauGraph(),
					this.fenetre.getPanneauGraph().getDiagramme(), TypeLien.SPECIALISATION);
		this.fenetre.getPanneauGraph().getGraphControl().addMouseListener(evenement);
	}
}
