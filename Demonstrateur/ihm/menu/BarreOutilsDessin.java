package ihm.menu;

import evenements.Btn;
import evenements.btn.BtnActeurActif;
import evenements.btn.BtnActeurPassif;
import evenements.btn.BtnAgregation;
import evenements.btn.BtnAssociation;
import evenements.btn.BtnClasse;
import evenements.btn.BtnComposition;
import evenements.btn.BtnGeneralisation;
import evenements.btn.BtnUseCase;
import evenements.btn.BtnTraitement;
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
        this.setFloatable(false);
		this.fenetre = p_fenetre;
	}

    public void ajouterObjetsGraphiques() {
		Btn useCase = new BtnUseCase("usecase", this.fenetre);
		Btn classe = new BtnClasse("classe", this.fenetre);
		Btn acteurActif = new BtnActeurActif("acteurActif", this.fenetre);
		Btn acteurPassif = new BtnActeurPassif("acteurPassif", this.fenetre);
        Btn traitement = new BtnTraitement("traitement", this.fenetre);
        Btn association = new BtnAssociation("association", this.fenetre);
        Btn generalisation = new BtnGeneralisation("generalisation", this.fenetre);        
        Btn agregation = new BtnAgregation("agregation", this.fenetre);
        Btn composition = new BtnComposition("composition", this.fenetre);        
		this.add(useCase);
		this.add(classe);
		this.add(acteurActif);  
        this.add(acteurPassif);
        this.add(traitement);
        this.add(association);
        this.add(generalisation);
        this.add(agregation);        
        this.add(composition);        
    }

}
