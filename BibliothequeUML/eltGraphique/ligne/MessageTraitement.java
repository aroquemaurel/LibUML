package eltGraphique.ligne;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import eltGraphique.eltModelisation.Traitement;

/**
 * Classe spécifique aux messages entre traitement
 * 
 * La création de ceux-ci diffèrent des liens ordinaires
 */
public class MessageTraitement extends Lien {
	/**
	 * Sous-cellule source du message
	 */
    private mxCell sourceSousCellule;
	/**
	 * Sous-cellule de destination du message
	 */
    private mxCell destinationSousCellule;
	/**
	 * Le message en lui-même
	 */
    private String message;
	/**
	 * Constante du décalage du texte du message
	 */
    private final double OFFSET_MESSAGE = -4.2;
    
	/**
	 * Constructeur d'un message entre traitement
	 * @param p_source Traitement émetteur
	 * @param p_destination Traitement récepteur
	 * @param p_sourceSousCellule Sous-cellule source
	 * @param p_destinationSousCellule Sous-cellule de destinataire
	 * @param p_message Le message à transmettre
	 * @param p_graph Le graphe auquel sera ajouté le message
	 * @param p_diagramme Le diagramme auquel sera ajouté le message
	 * @param p_typeLien Le type de lien du message
	 * 
	 * @see eltGraphique.eltModelisation.Traitement
	 * @see eltGraphique.ligne.TypeLien
	 */
    public MessageTraitement(Traitement p_source, Traitement p_destination, 
                mxCell p_sourceSousCellule, mxCell p_destinationSousCellule, String p_message, mxGraph p_graph,
		Diagramme p_diagramme, TypeLien p_typeLien){
        super(p_source, p_destination, p_graph, p_diagramme, p_typeLien);
        this.message = p_message;
        this.sourceSousCellule = p_sourceSousCellule;
        this.destinationSousCellule = p_destinationSousCellule;
    }
    
	/**
	 * Crée le style et la représentation de la flèche en fonction
	 * des attributs de la classe.
	 */
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
