package evenements.btn;

import ihm.fenetreClasses.FenetreAjoutMethode;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 */
public class BtnAnnulerAjoutMethode extends BoutonFenetres {
    
    public BtnAnnulerAjoutMethode(FenetreAjoutMethode p_fenetre){
        super(p_fenetre, "Je ne veux plus");
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        super.getFenetre().setVisible(false);
    }
}
