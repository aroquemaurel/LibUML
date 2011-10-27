/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evenements.menu;

import figures.Carre;
import java.awt.Point;
import java.awt.event.ActionEvent;
import org.jgraph.JGraph;

/**
 *
 * @author satenske
 */
public class EvenementMenuCarre extends EvenementMenu {
	public EvenementMenuCarre(JGraph p_graph){
		super(p_graph);
	}
	@Override
	public void actionPerformed(ActionEvent event){
       Carre carre = new Carre(new Point(100, 100), 90, 100, super.getGraph());
	   carre.afficher();
	}

}
