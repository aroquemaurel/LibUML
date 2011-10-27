/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evenements.menu;

import java.awt.event.ActionEvent;
import org.jgraph.JGraph;

/**
 *
 * @author satenske
 */
public class EvenementMenuQuitter extends EvenementMenu {
	public EvenementMenuQuitter(JGraph p_graph){
		super(p_graph);
	}
	@Override
	public void actionPerformed(ActionEvent event){
		System.exit(0);
	}
}
