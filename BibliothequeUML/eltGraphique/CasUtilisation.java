package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 * Modélise un cas d'utilisation par une ellipse et un texte
 *
 * @author satenske
 */
public class CasUtilisation extends ElementModelisation {

    public CasUtilisation(mxGraph p_graph, String p_texte) {
		super(p_graph, p_texte);
        this.creer();        
    }
    
    public final void creer(){
        Object parent = this.graph.getDefaultParent();
        this.cellule = (mxCell) this.graph.insertVertex(
            parent, null, super.getTexte(), 30, 30, 150, 75, "USECASE");
        this.cellule.setVisible(false);
    }
  
    public void afficher(){
        this.cellule.setVisible(true);     
    }
    
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        this.cellule.setValue(p_texte);
    }
}
