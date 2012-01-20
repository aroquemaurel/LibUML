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
	MESSAGE_SYNCHRONE,

	/* Diagramme de séquence */
	FLECHE,
	FLECHE_POINTILLEE,
	FLECHE_EVENEMENT_DECLENCHEUR
}
