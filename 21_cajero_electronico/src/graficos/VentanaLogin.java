package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cuenta;
import service.CajeroServiceFactory;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jtfCuenta = new JLabel("Nº CUENTA:");
		jtfCuenta.setBounds(45, 63, 104, 48);
		contentPane.add(jtfCuenta);
		
		textField = new JTextField();
		textField.setBounds(122, 69, 198, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton jbtEntrar = new JButton("ENTRAR");
		jbtEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var service=CajeroServiceFactory.getCajeroService();
				Cuenta cuenta= service.obtenerCuenta(Integer.parseInt(jtfCuenta.getText()));
				String mensaje;
				if(cuenta!=null) {
					mensaje="Existe cuenta";
				}else  {
					mensaje="La cuenta no existe";
				}
				JOptionPane.showMessageDialog(VentanaLogin.this, mensaje);
			}
		});
		jbtEntrar.setBounds(147, 134, 124, 36);
		contentPane.add(jbtEntrar);
	}
}
