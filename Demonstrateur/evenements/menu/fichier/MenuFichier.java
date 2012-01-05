package evenements.menu.fichier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * superclasse des évenements sur les éléments du menu.
 */
public class MenuFichier extends JMenuItem implements ActionListener{
	/* Paramètres du menu */
	private void parametrerMenu(){
		this.addActionListener(this);
	}

	/* Construit le menu avec comme titre p_texte */
	public MenuFichier(String p_texte){
		super.setText(p_texte);
		this.parametrerMenu();
	}

	 /* Si les classes filles ne redéfinissent pas l'implémentation en cas d'action sur le menu,
	  * on affiche un message.
	  */
	@Override
	public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null,"Cette fonctionnalité n'est pas implémentée");
	}
}
