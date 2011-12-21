package evenements.btn;

import eltGraphique.CasUtilisation;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
 *
 * @author satenske
 */
public class BtnUseCase extends Btn {
    public BtnUseCase(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

	@Override
    public void mouseClicked(MouseEvent event) {
        CasUtilisation useCase = new CasUtilisation(fenetre.getPanneauGraph().getGraph(), 
            "Mon useCase");        
       super.fenetre.getPanneauGraph().getGraph().getModel().beginUpdate();     
       useCase.afficher();
       fenetre.getPanneauGraph().getGraph().getModel().endUpdate();
       super.fenetre.getPanneauGraph().getGraph().getModel().endUpdate();
    }

}
