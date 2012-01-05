package evenements.menu.fichier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 */
public class MenuFichier extends JMenuItem implements ActionListener{
	private void parametrerMenu(){
		this.addActionListener(this);
	}
	public MenuFichier(String p_texte){
		super.setText(p_texte);
		this.parametrerMenu();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null,"Cette fonctionnalité n'est pas implémentée");
	}
}
