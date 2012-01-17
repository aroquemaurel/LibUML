package eltGraphique.ligne;

/**
 * Enumération des différents types de liens
 * 
 * @author Mathieu
 * @author Marie-ly
 */
public enum TypeLien {
	/* Diagramme de classe */
	ASSOCIATION,
	SPECIALISATION,
	COMPOSITION,
	AGREGATION,
	CLASSE_ASSOCIATION,
	GENERALISATION,
	DEPENDANCE,

	/* Diagramme de séquence */
	FLECHE,
	FLECHE_EVENEMENT_DECLENCHEUR
}
