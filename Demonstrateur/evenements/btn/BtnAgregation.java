package evenements.btn;

import eltGraphique.ligne.TypeLien;
import evenements.Btn;
import evenements.EvenementsEltGraphiques;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Implémentation d'un click sur le bouton Agrégation
 */
public class BtnAgregation extends Btn{
   
    public BtnAgregation(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }
	@Override
    public void mouseClicked(MouseEvent event) {
        EvenementsEltGraphiques evenement = 
            new EvenementsEltGraphiques(super.fenetre.getPanneauGraph(), TypeLien.AGREGATION);
        super.fenetre.getPanneauGraph().getGraphControl().addMouseListener(evenement);
    }    
}
