public static void main(String[] args){
	int valeurMinX = 0, valeurMaxX = 1300;
	int valeurMinY = 0, valeurMaxY = 700;
	Random r;
	Position position;

	Classe classes[] = new Classe[20];
	CasUtilisation casUtilisations[] = new CasUtilisation[20];
	Traitement traitements[] = new Traitement[20];
	Acteur acteursActifs[] = new ActeurActif[20];
	Acteur acteursPassifs[] = new ActeurPassif[20];
	Lien liens[] = new Lien[60];
	
	ChargeTest fenetre = new ChargeTest();
	fenetre.afficherFenetre();
	
	/* créer des éléments */
	for(int i = 0; i < 20 ; ++i) {
		/* on instancie une classe */
		position = calculPositionAleatoire();
		classes[i] = new Classe(fenetre.getPanneauGraph().getGraph(), 
				new Diagramme(), "Test "+i, position);
		
		/* on instancie un cas d'utilisation */
		position = calculPositionAleatoire();
		casUtilisations[i] = new CasUtilisation(
				fenetre.getPanneauGraph().getGraph(), 
				new Diagramme(), "Test "+i, position);

		/* on instancie un traitement */
		position = calculPositionAleatoire();
		traitements[i] = new Traitement(
				fenetre.getPanneauGraph().getGraph(), 
				new Diagramme(), "Test "+i, null, position, false);
		
		/* on instancie un acteur passif*/
		position = calculPositionAleatoire();
		acteursPassifs[i] = new ActeurPassif(
				fenetre.getPanneauGraph().getGraph(), 
				new Diagramme(), "Test "+i, position);
				
		/* on instancie un acteur actif*/
		position = calculPositionAleatoire();
		acteursActifs[i] = new ActeurActif(
				fenetre.getPanneauGraph().getGraph(), 
				new Diagramme(), "Test "+i, position);

		/* on créer tous les éléments instanciés précédemment */
		classes[i].creer();
		casUtilisations[i].creer();
		traitements[i].creer();
		acteursPassifs[i].creer();
		acteursActifs[i].creer();
	
		/* on relie les éléménts créer */
		if(i != 0) {
		   traitements[i].ajouterMessage(traitements[i-1], "test", TypeLien.ASSOCIATION);
		}
		liens[i+1] = new Lien(acteursActifs[i], classes[i], fenetre.getPanneauGraph().getGraph(), new Diagramme(), 
				TypeLien.AGREGATION);
		liens[i+2] = new Lien(acteursPassifs[i], casUtilisations[i], fenetre.getPanneauGraph().getGraph(), 
				new Diagramme(), TypeLien.SPECIALISATION);

		/* on affiche les liens */
		liens[i+1].creer();
		liens[i+2].creer();
	}
	
	/* on supprime une vingtaine d'éléments */
	for(int i =0 ; i < 20 ; i++){
		if(i % 2 == 0){
			acteursActifs[i].supprimer();
		} else if(i % 3 == 0) {
			classes[i].supprimer();
		} else if(i% 5 == 0){
			traitements[i].supprimer();
		} else {
			casUtilisations[i].supprimer();
		}
	}
}
	  
