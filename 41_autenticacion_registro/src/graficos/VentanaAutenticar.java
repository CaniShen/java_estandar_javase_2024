package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ClientesDao;
import dao.ClientesDaoFactory;
import model.Cliente;
import service.ClientesService;
import service.ClientesServiceFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;

public class VentanaAutenticar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfPassword;
	private JTextField jtfUsuario;
	private JButton jbtRegistrar;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaAutenticar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(118, 34, 64, 14);
		contentPane.add(lblNewLabel);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(192, 31, 86, 20);
		contentPane.add(jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(118, 88, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		jtfPassword = new JTextField();
		jtfPassword.setColumns(10);
		jtfPassword.setBounds(192, 85, 86, 20);
		contentPane.add(jtfPassword);
		
		JButton jbtAutenticar = new JButton("Autenticar");
		jbtAutenticar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensaje;
				String usuario=jtfUsuario.getText();
				String password=jtfPassword.getText();
				ClientesService service=ClientesServiceFactory.getClientesService();
				if(service.autenticar(usuario, password)) {
					mensaje="Autenticado!";
				}else {
					mensaje="Usuario o contraseña no válidos!";
				}
				JOptionPane.showMessageDialog(VentanaAutenticar.this, mensaje);
				
			}
		});
		jbtAutenticar.setBounds(156, 133, 112, 23);
		contentPane.add(jbtAutenticar);
		
		JButton jptRegistrar = new JButton("Registrar");
		jptRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				VentanaRegistrar frame = new VentanaRegistrar();
				frame.setVisible(true);

			}
		});
		jptRegistrar.setBounds(266, 190, 89, 23);
		contentPane.add(jptRegistrar);
	}
	
	

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				VentanaAutenticar frame = new VentanaAutenticar();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}