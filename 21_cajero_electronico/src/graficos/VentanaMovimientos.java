package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cuenta;
import service.CajeroServiceFactory;

import javax.swing.JLabel;

public class VentanaMovimientos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMovimientos frame = new VentanaMovimientos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMovimientos(Cuenta cuenta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saldo:");
		lblNewLabel.setBounds(91, 27, 68, 29);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 61, 359, 161);
		contentPane.add(panel);
		JButton btnSalir= new JButton("Salir");
		btnSalir.setBounds(156,227,89,23);
		contentPane.add(btnSalir);
		
	var service=CajeroServiceFactory.getCajeroService();
	iblSaldo.setText(""+service.obtenerSaldo(cuenta.getNumeroCuenta()));
	tableMovimientos.setModel(new TableMovimeintosImpl(cuenta.getNumeroCuenta()));
		
	this.setVisible(true);
	}
}
