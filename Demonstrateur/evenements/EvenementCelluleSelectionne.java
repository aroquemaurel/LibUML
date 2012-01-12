/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evenements;

import com.mxgraph.model.mxCell;
import eltGraphique.classe.Classe;
import ihm.PanneauGraph;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author satenske
 */
public class EvenementCelluleSelectionne implements MouseListener {
    private PanneauGraph panneauGraph;
    
    public EvenementCelluleSelectionne(PanneauGraph p_graph){
        this.panneauGraph = p_graph;
        this.panneauGraph.getGraphControl().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        if(this.panneauGraph.getDiagramme().getElementGraphiqueViaCellule((mxCell)
            this.panneauGraph.getGraph().getSelectionCell()) instanceof Classe) {
            System.out.print("test"); 
            // TODO ici, c'est que c'est une classe, on pourra donc afficher le supertableau de la 
            // mort qui tue 
            // this.panneauGauche.insererTableauClasse(Classe classe);
            // this.panneauGauche.supprimerTableauClasse();
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }
    
}