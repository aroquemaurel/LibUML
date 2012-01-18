package evenements;

import ihm.BoiteDialogueDiagramme;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 */
public class EvenementChoixDiagramme implements MouseListener {
    BoiteDialogueDiagramme boiteDialogue;
    
    public EvenementChoixDiagramme(BoiteDialogueDiagramme p_boiteDialogue){
        this.boiteDialogue = p_boiteDialogue;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        this.boiteDialogue.setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
     }
    
}
