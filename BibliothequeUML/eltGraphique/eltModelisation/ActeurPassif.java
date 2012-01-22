package eltGraphique.eltModelisation;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import util.Constantes;
import util.Position;

/**
 * Classe représentant un acteur passif
 * 
 * @author Antoine
 * @author Mathieu
 */
public class ActeurPassif extends Acteur {
    /**
    * Créer le style d'un acteur passif
    */
    private void creerStyleActeurPassif(){
            Map<String, Object> nouveauStyle = new HashMap<String, Object>();
    mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
    nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
	nouveauStyle.put(mxConstants.STYLE_FOLDABLE, mxConstants.NONE);
    nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
    nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
    nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_BORDURE);
    feuilleStyles.putCellStyle("ACTEUR_PASSIF", nouveauStyle);
    }
    
    /**
    * Constructeur de la classe ActeurPassif
    * @param p_graph Le graphe dans lequel sera ajouté l'acteur passif
    * @param p_texte Le texte qui sera lié à l'acteur passif
    *
    * @see eltGraphique.eltModelisation.Acteur
    * @see diagramme.Diagramme
	* @see util.Position
    */
    public ActeurPassif(mxGraph p_graph, Diagramme p_diagramme, String p_texte, Position p_position) {
        super(p_graph, p_diagramme, "<<passif>>\n"+p_texte, new Dimension(100,35), p_position);
    }

    /**
    * Methode qui permet de créer l'apparence graphique de l'acteur passif
    */
    @Override
    public final void creer(){
        this.creerStyleActeurPassif();
        super.setCellule((mxCell) super.getGraph().insertVertex( super.getParent(), null, super.getTexte(),
                        super.getPosition().getAbscisse(), 
                        super.getPosition().getOrdonnee(), super.getDimension().getWidth(),
                        super.getDimension().getHeight(), "ACTEUR_PASSIF"));

        super.getDiagramme().getElementsGraphiques().add(this);

        super.creerLigneDeVie();
        super.afficherLigneDeVie(false);
    }

    /**
    * Changer le texte lié à l'acteur passif
    * @param p_texte Le nouveau texte à lier
    */
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        super.setValue(p_texte);
    }
}
