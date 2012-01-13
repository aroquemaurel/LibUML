/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evenements;

import com.mxgraph.model.mxCell;
import eltGraphique.Acteur;
import eltGraphique.ElementGraphique;
import eltGraphique.Traitement;
import eltGraphique.classe.Classe;
import evenements.menu.contextuel.EvenementAfficherLigneDeVie;
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

	private FenetreDemo fenetre;


    public EvenementCelluleSelectionne(PanneauGraph p_graph, FenetreDemo p_fenetre){
        this.panneauGraph = p_graph;
        
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
                JPopupMenu menuContextuel;
                
		if(element != null){
			
			if(event.getButton() == MouseEvent.BUTTON3){
                            if(element instanceof Acteur){
                                menuContextuel = construireMenuContextuel((Acteur) element);
                            } else if (element instanceof Traitement){
                                menuContextuel = construireMenuContextuel((Traitement) element);                                
                            } else {
                                menuContextuel = construireMenuContextuel((ElementGraphique) element);                                
                            }
                            
                            /* On affiche le menu contextuel*/
                            menuContextuel.show(this.fenetre.getPanneauPrincipal(), event.getX(),event.getY());
                            menuContextuel.show(this.panneauGraph, event.getX(), event.getY());
			}
		}
	}

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}
    
    private JPopupMenu construireMenuContextuel(Acteur element){
	JPopupMenu menuContextuel = new JPopupMenu();
	JMenuItem itemSupprimer = new JMenuItem("Supprimer");
        JMenuItem itemAfficherLigneDeVie = new JMenuItem("Afficher ligne de vie");
        
	EvenementSupprimer evenementSupprimer = new EvenementSupprimer(element);
        EvenementAfficherLigneDeVie evenementAfficherLigneDeVie = new EvenementAfficherLigneDeVie(element);
        menuContextuel.add(itemSupprimer);
        menuContextuel.add(itemAfficherLigneDeVie);
        this.fenetre.getPanneauPrincipal().add(menuContextuel);
        
        itemSupprimer.addActionListener(evenementSupprimer);
        itemAfficherLigneDeVie.addActionListener(evenementAfficherLigneDeVie);
        return menuContextuel;
    }
    
    private JPopupMenu construireMenuContextuel(Traitement element){
	JPopupMenu menuContextuel = new JPopupMenu();
	JMenuItem itemSupprimer = new JMenuItem("Supprimer");           
        
        return menuContextuel;
    }   
    
    private JPopupMenu construireMenuContextuel(ElementGraphique element){
	JPopupMenu menuContextuel = new JPopupMenu();
	JMenuItem itemSupprimer = new JMenuItem("Supprimer");               
        
        return menuContextuel;
    }    
}