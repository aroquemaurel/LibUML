package ihm.Menu;

import evenements.Btn;
import evenements.btn.BtnActeur;
import evenements.btn.BtnClasse;
import evenements.btn.BtnUseCase;
import ihm.FenetreDemo;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 *
 * @author satenske
 */
public class BarreOutilsDessin extends JToolBar {
	private final FenetreDemo fenetre;
	
	public BarreOutilsDessin(Dimension p_taille, FenetreDemo p_fenetre) {
		this.setPreferredSize(p_taille);
		this.fenetre = p_fenetre;
	}

    public void ajouterObjetsGraphiques() {
        Btn useCase = new BtnUseCase("images/1.jpg", this.fenetre) ;
        Btn classe = new BtnClasse("images/1.jpg", this.fenetre) ;
        Btn acteur = new BtnActeur("images/1.jpg", this.fenetre) ;
		
		this.add(new JButton("useCase"));
		this.add(new JButton("classe"));
		this.add(new JButton("acteur"));
    }

}
