package evenements.btn;

import eltGraphique.CasUtilisation;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
 * Implémentation d'un click sur le bouton BtnUseCase
 */
public class BtnUseCase extends Btn {
    public BtnUseCase(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

	@Override
    public void mouseClicked(MouseEvent event) {
        CasUtilisation useCase = new CasUtilisation(fenetre.getPanneauGraph().getGraph(),
            fenetre.getPanneauGraph().getDiagramme(), "Mon useCase");
        useCase.creer();
    }

}
