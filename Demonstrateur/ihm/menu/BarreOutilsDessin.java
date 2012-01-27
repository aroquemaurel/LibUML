package ihm.menu;

import evenements.Btn;
import evenements.btn.toolbar.*;
import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.JToolBar;

/**
 * Barre d'outils permettant d'afficher les différents outils de dessins
 */
public class BarreOutilsDessin extends JToolBar {
    private final FenetreDemo fenetre; // La fenêtre dans laquelle s'affiche la toolbar
    private final Dimension taille;

    /** 
     * Paramètres de la barre d'outils 
     */
    private void parametrerBarreOutils(){
		this.setPreferredSize(this.taille);
        this.setFloatable(false);
    }

    /** 
     * Construit la barre d'outils 
     */
    public BarreOutilsDessin(Dimension p_taille, FenetreDemo p_fenetre) {
            this.fenetre = p_fenetre;
            this.taille = p_taille;
            this.parametrerBarreOutils();
    }

    /** 
     * Ajoute les différents objets graphiques qui doivent s'afficher dans la barre d'outils 
     */
    public void ajouterObjetsGraphiques() {
        /* Instanciations et déclarations des différents boutons */
        Btn useCase = new BtnUseCase("usecase", this.fenetre);
        Btn classe = new BtnClasse("classe", this.fenetre);
        Btn acteurActif = new BtnActeurActif("acteurActif", this.fenetre);
        Btn acteurPassif = new BtnActeurPassif("acteurPassif", this.fenetre);
        Btn traitement = new BtnTraitement("traitement", this.fenetre);
        Btn association = new BtnAssociation("association", this.fenetre);
        Btn fonctionnelle = new BtnDependanceFonctionnelle("dependanceFonctionnelle", this.fenetre);
        Btn generalisation = new BtnSpecialisation("generalisation", this.fenetre);
        Btn messageSynchrone = new BtnMessageSynchrone("messageSynchrone", this.fenetre);
        Btn agregation = new BtnAgregation("agregation", this.fenetre);
        Btn composition = new BtnComposition("composition", this.fenetre);

        /* Ajouts des boutons dans la barre d'outils */
        this.add(useCase);
        this.add(classe);
        this.add(acteurActif);
        this.add(acteurPassif);
        this.add(traitement);
        this.add(association);
        this.add(fonctionnelle);
        this.add(generalisation);
        this.add(messageSynchrone);
        this.add(agregation);
        this.add(composition);
    }

}
