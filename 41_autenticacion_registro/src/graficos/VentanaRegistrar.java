package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import service.ClientesService;
import service.ClientesServiceFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfUsuario;
	private JTextField jtfContrasenia;
	private JTextField jtfTelefono;
	private JTextField jtfEmail;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaRegistrar frame = new VentanaRegistrar();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(45, 45, 64, 27);
		contentPane.add(lblNewLabel);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(132, 48, 86, 20);
		contentPane.add(jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL:");
		lblNewLabel_1.setBounds(45, 148, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		jtfContrasenia = new JTextField();
		jtfContrasenia.setBounds(132, 80, 86, 20);
		contentPane.add(jtfContrasenia);
		jtfContrasenia.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Teléfono:");
		lblNewLabel_2.setBounds(45, 108, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		jtfTelefono = new JTextField();
		jtfTelefono.setBounds(132, 111, 86, 20);
		contentPane.add(jtfTelefono);
		jtfTelefono.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setBounds(45, 83, 64, 14);
		contentPane.add(lblNewLabel_3);
		
		jtfEmail = new JTextField();
		jtfEmail.setBounds(132, 145, 86, 20);
		contentPane.add(jtfEmail);
		jtfEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("REGISTRAR!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensaje;
				Cliente cliente=new Cliente();
				cliente.setUsuario(jtfUsuario.getText());
				cliente.setPassword(jtfContrasenia.getText());
				cliente.setTelefono(jtfTelefono.getText().isEmpty() ? 0: Integer.parseInt(jtfTelefono.getText()));
				cliente.setEmail(jtfEmail.getText());
				
				ClientesService service=ClientesServiceFactory.getClientesService();
				if(service.registrar(cliente)) {
					mensaje="Registrado!";
				}else {
					mensaje="Usuario ya existente!";
				}
				JOptionPane.showMessageDialog(VentanaRegistrar.this, mensaje);
				
			}
		});
		btnNewButton.setBounds(242, 197, 127, 23);
		contentPane.add(btnNewButton);
	}
}
