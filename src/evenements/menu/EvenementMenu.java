/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evenements.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.jgraph.JGraph;

/**
 *
 * @author satenske
 */
public class EvenementMenu implements ActionListener{
	private JGraph m_graph;

	public EvenementMenu(JGraph p_graph){
		m_graph = p_graph;
	}
	public void actionPerformed(ActionEvent event){
		JOptionPane.showMessageDialog(null, "Veuillez nous excuser, mais cette fonctionnalité n'est pas implémentée "
				+ "pour le moment.",
				"Attention", JOptionPane.WARNING_MESSAGE);
	}
	public JGraph getGraph() {
		return m_graph;
	}
}
