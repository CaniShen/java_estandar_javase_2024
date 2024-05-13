package graficos;

import java.awt.Color;

import javax.swing.JFrame;

public class MiVentana extends JFrame {
	public MiVentana() {
		//título
		super("Primera ventana swing");
		this.setBounds(100,100,700,300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.YELLOW);
		this.setVisible(true);
	}

}
