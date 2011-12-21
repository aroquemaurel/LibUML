package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 * Modélise un cas d'utilisation par une ellipse et un texte
 *
 * @author satenske
 */
public class CasUtilisation extends ElementModelisation {
    private mxGraph graph;
    private mxCell cellule;

    public CasUtilisation(mxGraph p_graph, String p_texte){
        this.graph = p_graph;
        super.setNom(p_texte);
        this.creer();        
    }
    
    public final void creer(){
        Object parent = this.graph.getDefaultParent();
        this.cellule = (mxCell) this.graph.insertVertex(
            parent, null, super.getNom(), 30, 30, 150, 75, "USECASE");
        this.cellule.setVisible(false);
    }
  
    public void afficher(){
        this.cellule.setVisible(true);     
    }
    
    @Override
    public void setNom(String p_nom){
        super.setNom(p_nom);
        this.cellule.setValue(p_nom);
    }
}
