package evenements.btn;

import eltGraphique.ligne.TypeLien;
import evenements.Btn;
import evenements.EvenementsLienElementGraphique;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
 *
 */
public class BtnMessageSynchrone extends Btn {

	public BtnMessageSynchrone(String p_string, FenetreDemo p_fenetre) {
        super(p_string, p_fenetre);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
            EvenementsLienElementGraphique evenement =
                    new EvenementsLienElementGraphique(this.fenetre, 
                    this.fenetre.getPanneauGraph().getDiagramme(), TypeLien.SPECIALISATION);
		
            this.fenetre.getPanneauGraph().getGraphControl().addMouseListener(evenement);
	}
}
