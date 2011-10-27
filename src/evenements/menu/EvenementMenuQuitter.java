/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evenements.menu;

import java.awt.event.ActionEvent;

/**
 *
 * @author satenske
 */
public class EvenementMenuQuitter extends EvenementMenu {
	@Override
	public void actionPerformed(ActionEvent event){
		System.exit(0);
	}
}
