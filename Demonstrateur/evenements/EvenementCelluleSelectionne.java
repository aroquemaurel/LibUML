/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evenements;

import com.mxgraph.model.mxCell;
import eltGraphique.ElementGraphique;
import eltGraphique.classe.Classe;
import evenements.menu.contextuel.EvenementSupprimer;
import ihm.FenetreDemo;
import ihm.PanneauGraph;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author satenske
 */
public class EvenementCelluleSelectionne implements MouseListener {
    private PanneauGraph panneauGraph;
	private JPopupMenu menuConxtuelle;
	private JMenuItem itemSupprimer;
	private FenetreDemo fenetre;
	private EvenementSupprimer evenementSupprimer;

    public EvenementCelluleSelectionne(PanneauGraph p_graph, FenetreDemo p_fenetre){
        this.panneauGraph = p_graph;
		this.menuConxtuelle = new JPopupMenu();
		this.itemSupprimer = new JMenuItem("Supprimer");
        this.panneauGraph.getGraphControl().addMouseListener(this);
		this.fenetre = p_fenetre;
    }
    @Override
    public void mouseClicked(MouseEvent event) {
        if(this.panneauGraph.getDiagramme().getElementGraphiqueViaCellule((mxCell)
            this.panneauGraph.getGraph().getSelectionCell()) instanceof Classe) {
            // TODO ici, c'est que c'est une classe, on pourra donc afficher le supertableau de la
				// mort qui tue

        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) { }

    @Override
    public void mouseReleased(MouseEvent event) {
		ElementGraphique element = this.panneauGraph.getDiagramme().getElementGraphiqueViaCellule(
				(mxCell) this.panneauGraph.getGraph().getSelectionCell());

		if(element != null){
			this.evenementSupprimer = new EvenementSupprimer(element);
			if(event.getButton() == MouseEvent.BUTTON3){
				this.menuConxtuelle.add(this.itemSupprimer);
				this.fenetre.getPanneauPrincipal().add(this.menuConxtuelle);
				this.itemSupprimer.addActionListener(evenementSupprimer);
				/* On affiche le menu contextuel*/
				this.menuConxtuelle.show(this.fenetre.getPanneauPrincipal(), event.getX(),event.getY());
				this.menuConxtuelle.show(this.panneauGraph, event.getX(), event.getY());
			}
		}
	}

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

}