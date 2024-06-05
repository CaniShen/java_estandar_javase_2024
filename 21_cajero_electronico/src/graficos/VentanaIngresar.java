package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cuenta;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaIngresar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Cuenta cuenta;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresar frame = new VentanaIngresar();
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
	public VentanaIngresar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setBounds(50, 44, 72, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(132, 41, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var servuce=Caja
				service.ingreso(cuenta.getNumeroCuenta(),Double.parseDouble(jtfCantidad.getText()));
			}
		});
		btnNewButton.setBounds(114, 109, 89, 23);
		contentPane.add(btnNewButton);
	}

}
