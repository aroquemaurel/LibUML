package evenements.menu.fichier;

import java.awt.event.ActionEvent;

/**
 * Implémentation d'une action sur l'élément Quitter
 */
public class MenuFichierQuitter extends MenuFichier {

	public MenuFichierQuitter(String p_string) {
		super(p_string);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.exit(0);
	}

}
