package eltGraphique.ligne;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import eltGraphique.eltModelisation.Traitement;

/**
 *
 */
public class MessageTraitement extends Lien {
    private mxCell sourceSousCellule;
    private mxCell destinationSousCellule;
    private String message;
    private final double OFFSET_MESSAGE = -4.2;
    
    public MessageTraitement(Traitement p_source, Traitement p_destination, 
                mxCell p_sourceSousCellule, mxCell p_destinationSousCellule, String p_message, mxGraph p_graph,
		Diagramme p_diagramme, TypeLien p_typeLien){
        super(p_source, p_destination, p_graph, p_diagramme, p_typeLien);
        this.message = p_message;
        this.sourceSousCellule = p_sourceSousCellule;
        this.destinationSousCellule = p_destinationSousCellule;
    }
    
    @Override
    public void creer(){
        super.creerLeStyleDeLien();
        super.setCellule((mxCell) super.getGraph().insertEdge(
        super.getGraph().getDefaultParent(), null, this.message,
        this.sourceSousCellule, this.destinationSousCellule, super.getTypeLien().toString()));
        this.getCellule().getGeometry().setOffset(new mxPoint(0, OFFSET_MESSAGE));
        
        super.getSource().getLiens().ajouterElement(this);
        super.getDestination().getLiens().ajouterElement(this);
    }
}
