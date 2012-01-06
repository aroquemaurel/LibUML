package eltGraphique;

import com.mxgraph.view.mxGraph;
import java.awt.Dimension;

/**
 * Modélise une interface par un petit cercle et un texte
 *
 */
public class Interface extends ElementModelisation {
    /**
     * Constructeur de la classe traitement
     * @param p_graph Le graphe auquel sera ajouter le traitement
     * @param p_texte Le texte qui sera associé au traitement
     */
    public Interface(mxGraph p_graph, String p_texte){
        super(p_graph, p_texte, new Dimension(10,10));
    }


    /**
     * Crée la représentation graphique d'un traitement
     */
    @Override
    public final void creer() {
        //TODO
    }
}
