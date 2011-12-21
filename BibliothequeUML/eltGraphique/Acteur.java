package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 * Classe ancête aux deux types d'acteurs : actifs et passifs.
 * Ces deux types d'acteurs sont différenciers pour une raison de 
 * représentation graphique principalement
 * 
 * @see ActeurActif
 * @see ActeurPassif
 *
 * @author satenske
 */
abstract public class Acteur extends ElementModelisation {
    private mxGraph graph;
    private mxCell cellule;

    abstract public void creer();
  
    abstract public void afficher();
        
    public Acteur(mxGraph p_graph, String p_nom){
        this.graph = p_graph;
        super.setNom(p_nom);
    }
    public mxCell getCellule(){
        return this.cellule;
    }
    public void setCellule(mxCell p_cellule){
        this.cellule = p_cellule;
    }
    public mxGraph getGraph(){
        return this.graph;
    }

    @Override
    public void setNom(String p_nom){
        super.setNom(p_nom);
        this.cellule.setValue(p_nom);
    }

}
