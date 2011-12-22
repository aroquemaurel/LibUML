package eltGraphique;

import com.mxgraph.view.mxGraph;

/**
 *
 * @author satenske
 */
abstract public class Acteur extends ElementModelisation {        
    public Acteur(mxGraph p_graph, String p_nom){
        super(p_nom, p_graph);
    }

    @Override
    public void setNom(String p_nom){
        super.setNom(p_nom);
        super.cellule.setValue(p_nom);
    }


}
