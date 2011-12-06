package evenements.btn;

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
    
    public void mouseClicked(MouseEvent event) {
        super.fenetre.getPanneauGraph().getGraph().getModel().beginUpdate();

        Object parent = super.fenetre.getPanneauGraph().getGraph().getDefaultParent();

        super.fenetre.getPanneauGraph().getGraph().insertVertex(
            parent, null, "UseCase", 30, 30,150, 75, "USECASE");

        super.fenetre.getPanneauGraph().getGraph().getModel().endUpdate();
    }
  
}
