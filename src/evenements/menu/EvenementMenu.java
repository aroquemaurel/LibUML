/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evenements.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author satenske
 */
public class EvenementMenu implements ActionListener{
	public void actionPerformed(ActionEvent event){
		JOptionPane boiteNonImplementee;

		boiteNonImplementee= new JOptionPane();
		boiteNonImplementee.showMessageDialog(null, "Cette fonctionnalité n'est pas implémentée.",
				"Attention", JOptionPane.WARNING_MESSAGE);
	}
}
