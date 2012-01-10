package evenements.btn;

import eltGraphique.classe.Classe;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
 * Implémentation d'un click sur le bouton Classe
 */
public class BtnClasse extends Btn {
    public BtnClasse(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

	@Override
	public void mouseClicked(MouseEvent event) {
        Classe acteur = new Classe(super.fenetre.getPanneauGraph().getGraph(),
            fenetre.getPanneauGraph().getDiagramme(), "Ma classe");
        acteur.creer();
	}
}
