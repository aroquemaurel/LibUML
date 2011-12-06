package ihm.Menu;

import evenements.Btn;
import evenements.btn.BtnActeur;
import evenements.btn.BtnClasse;
import evenements.btn.BtnUseCase;
import ihm.FenetreDemo;

/**
 *
 * @author satenske
 */
public class MenuGauche extends Menu {
    public MenuGauche(int p_largeurPanneau, int p_longueurPanneau, FenetreDemo p_fenetre){
        super(p_largeurPanneau, p_longueurPanneau, p_fenetre);
    }
    
    @Override
    public void ajouterObjetsGraphiques() {
        Btn useCase = new BtnUseCase("useCase", super.fenetre) ;
        Btn classe = new BtnClasse("Classe", super.fenetre) ;
        Btn acteur = new BtnActeur("Acteur", super.fenetre) ;
        
        super.add(useCase);
        super.add(acteur);
        super.add(classe);
    }
    
}
