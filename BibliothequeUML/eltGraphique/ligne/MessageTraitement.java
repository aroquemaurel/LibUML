package eltGraphique.ligne;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import eltGraphique.Traitement;

/**
 *
 * @author Antoine
 */
public class MessageTraitement extends Lien {
    private mxCell sourceSousCellule;
    private mxCell destinationSousCellule;
    
    public MessageTraitement(Traitement p_source, Traitement p_destination, 
                mxCell p_sourceSousCellule, mxCell p_destinationSousCellule, mxGraph p_graph,
		Diagramme p_diagramme, TypeLien p_typeLien){
        super(p_source, p_destination, p_graph, p_diagramme, p_typeLien);
            this.sourceSousCellule = p_sourceSousCellule;
            this.destinationSousCellule = p_destinationSousCellule;
    }
    
    @Override
    public void creer(){
        super.creerLesStylesDeFleches();
        super.setCellule((mxCell) super.getGraph().insertEdge(
        super.getGraph().getDefaultParent(), null, null,
        this.sourceSousCellule, this.destinationSousCellule, super.getTypeLien().toString()));

    }
}
