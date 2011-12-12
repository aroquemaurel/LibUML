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
		/* Lorsque nous aurons des images pour les boutons
		 * , nous ferons passer le lien de l'image
		 TODO images pour les boutons */
//        Btn useCase = new BtnUseCase("images/1.jpg", this.fenetre) ;
		Btn useCase = new BtnUseCase("UseCase", this.fenetre);
		Btn classe = new BtnClasse("Classe", this.fenetre);
		Btn acteur = new BtnActeur("Acteur", this.fenetre);

		this.add(useCase);
		this.add(classe);
		this.add(acteur);
    }

}
