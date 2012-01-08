package eltGraphique.classe;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import eltGraphique.Liste;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Classe extends eltGraphique.ElementModelisation {
	/**
	 * Classe abstraite ?
	 */
    private boolean abstraite;
	/**
	 * Visibilité de la classe
	 * @see Visibilite
	 */
    private Visibilite visibilite;
	/**
	 * Liste des méthodes de la classe
	 * @see Methode
	 */
    private Liste<Methode> methodes;
	/**
	 * Liste des attributs de la classe
	 * @see Attribut
	 */
    private Liste<Attribut> attributs;
	/**
	 * Classe cosntante ?
	 */
    private boolean constante;

    private mxCell celluleAttributs;
    private mxCell celluleMethodes;
    
    /**
	 * Constructeur d'un élément 'classe'
	 * @param p_graph Le graphe auquel sera ajouter la classe
	 * @param p_texte Le texte associé à la classe (son nom)
	 */
    public Classe(mxGraph p_graph, String p_texte){
        super(p_graph, p_texte, new Dimension(125,150));
    }

	/**
	 * Ajoute une méthode à la liste des méthoes de la classe
	 * @param p_nomMethode Nom de la méthode
	 * @param p_typeDeRetour Type de retour de la méthode
	 * @param p_visibilite Visibilité de al méthode
	 * @param p_parametres Parametres de la méthode
	 * @param p_abstraite Méthode abstraite ?
	 * @param p_deClasse Méthode de classe ?
	 * @param p_constante Méthode constante ?
	 */
    public void ajouterMethode(String p_nomMethode, String p_typeDeRetour,
			       Visibilite p_visibilite,
			       List<Variable> p_parametres,
			       boolean p_abstraite, boolean p_deClasse,
			       boolean p_constante) {
        
	    this.methodes.ajouterElement(new Methode(p_visibilite, p_typeDeRetour,
					p_nomMethode,
					p_parametres,
					p_abstraite, p_deClasse, p_constante));
    }

	/**
	 * Ajoue un attribut à la liste d'attributs de la classe
	 * @param p_type Type de l'atribut
	 * @param p_nom Nom de l'attribut
	 * @param p_visibilite Visibilité de l'atribut
	 * @param p_constante Attribut constant ?
	 * @param p_deClasse Attribut de classe ?
	 */
    public void ajouterAttribut(String p_type, String p_nom,
                                 Visibilite p_visibilite, boolean p_constante,
                                 boolean p_deClasse) {
		this.attributs.ajouterElement(new Attribut(p_visibilite,
										p_deClasse,
										p_constante,
										p_type,
										p_nom));
    }

    /*
     * Guetteurs
     */
	/**
	 * Retourne vrai si la classe est constante, faux sinon.
	 * @return Classe constante ?
	 */
    public boolean estConstante() {
        return (this.constante);
    }

	/**
	 * Retourne vrai si la classe est abstraite, faux sinon.
	 * @return si la classe est abstraite ou non.
	 */
    public boolean estAbstraite() {
        return (this.abstraite);
    }

	/**
	 * Retourne la liste des attributs de la classe
	 * @return Liste des attributs de la classe
	 * @see Attribut
	 */
    public Liste<Attribut> getAttributs() {
        return (this.attributs);
    }

	/**
	 * Retourne la liste des méthodes de la classe
	 * @return Liste des méthodes de la classe
	 * @see Methode
	 */
    public Liste<Methode> getMethodes() {
        return (this.methodes);
    }

	/**
	 * Retourne la visibilité de la classe
	 * @return Visibilite de al classe
	 * @see Visibilite
	 */
    public Visibilite getVisibilite() {
        return (this.visibilite);
    }

	/*
	 * Setters
	 */
	/**
	 * Modifie la visibilité de la classe
	 * @param p_visibilite Le nouvelle visibilite de la classe
	 * @see Visibilite
	 */
	public void setVisibilite(Visibilite p_visibilite) {
        this.visibilite = p_visibilite;
    }

	/**
	 * Modifie la constance de la classe
	 * @param p_constante Classe constante ?
	 */
    public void setConstante(boolean p_constante) {
        this.constante = p_constante;
    }

	/**
	 * Modifie l'abstraction de la classe
	 * @param p_abstraite Classe abstraite ?
	 */
    public void setAbstraite(boolean p_abstraite) {
        this.abstraite = p_abstraite;
    }

	/**
	 * Remplace la liste des attributs de la classe
	 * @param p_attributs La nouvelle liste d'attributs
	 * @see Attribut
	 */
    public void setAttributs(Liste<Attribut> p_attributs) {
        this.attributs = p_attributs;
    }

	/**
	 * Remlpace la liste des méthodes de la classe
	 * @param p_methodes La nouvelle liste de méthodes
	 * @see Methode
	 */
    public void setMethodes(Liste<Methode> p_methodes) {
        this.methodes = p_methodes;
    }

	/**
	 * Crée la représentation graphique de la classe
	 */
    @Override
    public final void creer() {
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		
		nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_SWIMLANE);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
		nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		feuilleStyles.putCellStyle("CLASSE", nouveauStyle);
		
		super.setCellule((mxCell) super.getGraph().insertVertex(
            super.getParent(), null, super.getTexte(), 350, 350,
			super.getDimension().getWidth(), super.getDimension().getHeight(), "CLASSE"));
        
		this.celluleAttributs = (mxCell) super.getGraph().insertVertex(
            super.getCellule(), null, "Attributs", 0, 0,
			super.getDimension().getWidth(), 60);       
        this.celluleMethodes = (mxCell) super.getGraph().insertVertex(
            super.getCellule(), null, "Méthodes", 0, 100,
			super.getDimension().getWidth(), 60);   
        
        this.celluleAttributs.setConnectable(false);
        this.celluleAttributs.setCollapsed(false);        
        this.celluleMethodes.setConnectable(false);  
        this.celluleAttributs.setCollapsed(false);        

    }
}
