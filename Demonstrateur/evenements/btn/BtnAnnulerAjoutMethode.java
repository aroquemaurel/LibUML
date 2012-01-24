package evenements.btn;

import ihm.fenetreClasses.FenetreAjoutMethode;
import java.awt.event.MouseEvent;

/**
 * Annuler l'ajout d'une méthode
 */
public class BtnAnnulerAjoutMethode extends BoutonFenetres {
    
    /**
     * Construit le bouton d'annulation d'ajout d'une méthode
     * @param p_fenetre La fenetre d'ajout de méthode
     */
    public BtnAnnulerAjoutMethode(FenetreAjoutMethode p_fenetre){
        super(p_fenetre, "Je ne veux plus");
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        super.getFenetre().setVisible(false);
    }
}
