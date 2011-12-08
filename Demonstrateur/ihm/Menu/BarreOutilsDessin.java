package ihm.Menu;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 *
 * @author satenske
 */
public class BarreOutilsDessin extends JToolBar {
	public BarreOutilsDessin(Dimension p_taille) {
		this.setPreferredSize(p_taille);
	}

    public void ajouterObjetsGraphiques() {
//        Btn useCase = new BtnUseCase("images/1.jpg", this.fenetre) ;
    //    Btn classe = new BtnClasse("images/1.jpg", super.fenetre) ;
    //    Btn acteur = new BtnActeur("images/1.jpg", super.fenetre) ;
		this.add(new JButton("caca"));
        //super.add(useCase);
        //super.add(acteur);
       // super.add(classe);
    }

}
