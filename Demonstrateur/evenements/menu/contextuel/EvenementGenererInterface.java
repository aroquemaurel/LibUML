/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evenements.menu.contextuel;

import eltGraphique.eltModelisation.Classe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mathieu
 */
public class EvenementGenererInterface implements ActionListener {
    private Classe classe;
    
    public EvenementGenererInterface(Classe p_classe) {
        this.classe = p_classe;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.classe.genererInterface();
    }
	
}
