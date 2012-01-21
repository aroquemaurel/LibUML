package eltGraphique.eltModelisation;

import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import java.awt.Dimension;
import util.Position;

/**
 * Modélise une interface par un petit cercle et un texte
 */
public class Interface extends ElementModelisation {
    
    /**
     * Constructeur de la classe traitement
     * @param p_graph Le graphe auquel sera ajouter le traitement
     * @param p_texte Le texte qui sera associé au traitement
     */
    public Interface(mxGraph p_graph, String p_texte, Diagramme p_diagramme, Position p_position){
        super(p_graph, p_diagramme, p_texte, new Dimension(10,10), p_position);
    }


    /**
     * Crée la représentation graphique d'un traitement
     */
    @Override
    public final void creer() {
        //TODO création des interfaces
        super.getDiagramme().getElementsGraphiques().add(this);        
    }
}
