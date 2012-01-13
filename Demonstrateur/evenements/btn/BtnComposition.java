package evenements.btn;

import eltGraphique.ligne.TypeLien;
import evenements.Btn;
import evenements.EvenementsLienElementGraphique;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
 * Implémentation d'un click sur le bouton Composition
 */
public class BtnComposition extends Btn {
    public BtnComposition(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }
	
	@Override
	public void mouseClicked(MouseEvent event) {
		EvenementsLienElementGraphique evenement =
			new EvenementsLienElementGraphique(this.fenetre.getPanneauGraph(),
					this.fenetre.getPanneauGraph().getDiagramme(), TypeLien.COMPOSITION);
		this.fenetre.getPanneauGraph().getGraphControl().addMouseListener(evenement);
	}
}
