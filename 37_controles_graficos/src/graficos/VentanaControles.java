package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaControles extends JFrame {
	public VentanaControles() {
		super("Ventana controles");
		this.setBounds(100,80,800,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//creacion y configuración de contraoles
		initComponents();
		this.setVisible(true);
		
	}
	private void initComponents() {
		this.setLayout(null);
		JButton jbt1=new JButton("Pulsar aquí");
		jbt1.setBounds(50,50,300,50);
		this.add(jbt1);
	}
}
