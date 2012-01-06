package eltGraphique.ligne;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import eltGraphique.ElementModelisation;
import eltGraphique.EltGraphique;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe servant à la modélistaion des liens dans les différents diagrammes
 * 
 * Les différents types de liens sont gérés grâce à un attribut de type TypeLien
 * 
 * @see TypeLien
 */
public class Lien extends EltGraphique {
    /**
     * Element à l'origine du lien
     * @see ElementModelisation
     */
    private ElementModelisation origine;
    /**
     * Element à l'extremite du lien
     * @see ElementModelisation
     */
    private ElementModelisation extremite;
    /**
     * Rôle du côté de l'origine du lien
     */
    private String texteOrigine;
    /**
     * Rôle du côté de l'extrémité du lien
     */
    private String texteExtremite;
    /**
     * Le type de la flèche à l'extrémité
     */
    private String typeFlecheExtremite;
    /**
     * Le type de la flèche à l'origine
     */
    private String typeFlecheOrigine;
    /**
     * La cardinalité à l'origine
     * @see Cardinalite
     */
    private Cardinalite cardinaliteOrigine;
    /**
     * La cardinalité à l'extrémité
     * @see Cardinalite
     */
    private Cardinalite cardinaliteExtremite;
    /**
     * Le type de la flèche 
     */
    private TypeLien typeFleche;
    
    public Lien(ElementModelisation p_origine, ElementModelisation p_extremite, mxGraph p_graph,
        TypeLien p_typeFleche){
        super(p_graph);
        this.origine = p_origine;
        this.extremite = p_extremite;
        this.typeFleche = p_typeFleche;
    }
	/*
	 * Getters
	 */
	public ElementModelisation getExtremite() {
		return (this.extremite);
	}

	public ElementModelisation getOrigine() {
		return (this.origine);
	}

	public String getTexteOrigine() {
		return (this.texteOrigine);
	}

	public String getTypeFlecheExtremite() {
		return (this.typeFlecheExtremite);
	}

	public String getTypeFlecheOrigine() {
		return (this.typeFlecheOrigine);
	}

	/*
	 * Setters
	 */
	public void setExtremite(ElementModelisation p_extremite) {
		this.extremite = p_extremite;
	}

	public void setOrigine(ElementModelisation p_origine) {
		this.origine = p_origine;
	}

	public void setTexteExtremite(String p_texteExtremite) {
		this.texteExtremite = p_texteExtremite;
	}

	public void setTexteOrigine(String p_texteOrigine) {
		this.texteOrigine = p_texteOrigine;
	}

	public void setTypeFlecheExtremite(String p_typeFlecheExtremite) {
		this.typeFlecheExtremite = p_typeFlecheExtremite;
	}

	public void setTypeFlecheOrigine(String p_typeFlecheOrigine) {
		this.typeFlecheOrigine = p_typeFlecheOrigine;
	}
    
	@Override
    public void creer(){
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		
		nouveauStyle.put(mxConstants.STYLE_EDGE,
		mxConstants.EDGESTYLE_ORTHOGONAL);
		nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
		nouveauStyle.put(mxConstants.STYLE_MOVABLE, 50);
		nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
		feuilleStyles.putCellStyle("SPECIALISATION", nouveauStyle);
		
		super.setCellule((mxCell) super.getGraph().insertEdge(
			super.getGraph().getDefaultParent(), null, null,
			this.getOrigine().getCellule(), this.getExtremite().getCellule(), 
			this.typeFleche.toString()));
		super.setConnectable(false);        
    }

}
