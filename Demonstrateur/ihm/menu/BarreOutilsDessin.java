package ihm.menu;

import evenements.Btn;
import evenements.btn.BtnActeurActif;
import evenements.btn.BtnActeurPassif;
import evenements.btn.BtnClasse;
import evenements.btn.BtnUseCase;
import ihm.FenetreDemo;
import java.awt.Dimension;
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
		Btn acteurActif = new BtnActeurActif("Acteur Actif", this.fenetre);
		Btn acteurPassif = new BtnActeurPassif("Acteur Passif", this.fenetre);
		this.add(useCase);
		this.add(classe);
		this.add(acteurActif);
        this.add(acteurPassif);
    }

}
