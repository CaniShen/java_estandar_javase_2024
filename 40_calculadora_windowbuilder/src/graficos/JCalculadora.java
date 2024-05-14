package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField jtf1;
	private JTextField jtf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
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
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(54, 39, 81, 14);
		contentPane.add(lblNewLabel);
		
		jtf1 = new JTextField();
		jtf1.setBounds(172, 38, 86, 20);
		contentPane.add(jtf1);
		jtf1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Número 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(54, 100, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		jtf2 = new JTextField();
		jtf2.setBounds(172, 99, 86, 20);
		contentPane.add(jtf2);
		jtf2.setColumns(10);
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(159, 215, 99, 14);
		contentPane.add(lblResultado);
		JButton jbtSumar = new JButton("Sumar");
		jbtSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int suma=Integer.parseInt(jtf1.getText())+Integer.parseInt(jtf2.getText());
				lblResultado.setText("Suma: "+suma);
			}
		});
		jbtSumar.setBounds(76, 163, 89, 23);
		contentPane.add(jbtSumar);
		
		JButton jbtMultiplicar = new JButton("Multiplicar");
		jbtMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int multi=Integer.parseInt(jtf1.getText())*Integer.parseInt(jtf2.getText());
				lblResultado.setText("Producto: "+multi);
			}
		});
		jbtMultiplicar.setBounds(215, 163, 89, 23);
		contentPane.add(jbtMultiplicar);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JCalculadora.this.dispose();
			}
		});
		btnNewButton.setBounds(140, 206, 89, 23);
		contentPane.add(btnNewButton);
		
		jtf1 = new JTextField();
		jtf1.setBounds(145, 38, 86, 20);
		contentPane.add(jtf1);
		jtf1.setColumns(10);
		
		jtf2 = new JTextField();
		jtf2.setBounds(143, 99, 86, 20);
		contentPane.add(jtf2);
		jtf2.setColumns(10);
		
	}
}
