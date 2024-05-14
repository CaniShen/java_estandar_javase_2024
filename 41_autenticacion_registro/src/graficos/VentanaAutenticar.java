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
		
		JLabel lblNewLabel_1 = new JLabel("Usuario: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(40, 11, 89, 20);
		contentPane.add(lblNewLabel_1);
		
		jtfPassword = new JTextField();
		jtfPassword.setBounds(204, 43, 86, 20);
		contentPane.add(jtfPassword);
		jtfPassword.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(40, 42, 89, 18);
		contentPane.add(lblNewLabel_2);
		
		jtfUsuario = new JTextField();
		jtfUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jtfUsuario.setBounds(204, 13, 86, 20);
		contentPane.add(jtfUsuario);
		jtfUsuario.setColumns(10);
		
		jbtRegistrar = new JButton("Registrar");
		jbtRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente aux=new Cliente();
				aux.setContraseña(jtfPassword);
				aux.setUsuario(jtfUsuario);
				aux.setUsuario(jtfUsuario);
				aux.setUsuario(jtfUsuario);
				
				String usuario=jtfUsuario.getText();
				String contraseña= jtfPassword.getText();
				String email=jtfEmail.getText();
				int telefono=Integer.parseInt(jtfTelefono.getText());
				ClientesService service=ClientesServiceFactory.getClientesService();
				if(service.registrar(cliente)==(true)) {
					mensaje="Registrado!! ";
					
				}else {
					mensaje="El usuario ya existe!";
				}
				JOptionPane.showMessageDialog(VentanaAutenticar.this, mensaje);
			}
			
		});
		jbtRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jbtRegistrar.setBounds(117, 166, 155, 44);
		contentPane.add(jbtRegistrar);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(40, 75, 79, 20);
		contentPane.add(lblNewLabel_3);
		
		jtfEmail = new JTextField();
		jtfEmail.setBounds(204, 74, 86, 20);
		contentPane.add(jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Telef:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(40, 114, 56, 18);
		contentPane.add(lblNewLabel_4);
		
		jtfTelefono = new JTextField();
		jtfTelefono.setBounds(204, 115, 86, 20);
		contentPane.add(jtfTelefono);
		jtfTelefono.setColumns(10);
	}
}
