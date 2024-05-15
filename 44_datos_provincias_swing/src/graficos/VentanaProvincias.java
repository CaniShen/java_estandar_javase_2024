package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adaptadores.ComboBoxModelComunidadesImpl;
import service.DatosProvinciasService;
import service.DatosProvinciasServiceFactory;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class VentanaProvincias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProvincias frame = new VentanaProvincias();
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
	public VentanaProvincias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECCIONE COMUNIDAD:");
		lblNewLabel.setBounds(133, 11, 142, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSeleccioneProvincias = new JLabel("SELECCIONE PROVINCIAS:");
		lblSeleccioneProvincias.setBounds(133, 78, 142, 14);
		contentPane.add(lblSeleccioneProvincias);
		
		JLabel lblNewLabel_1 = new JLabel("MUNICIPIOS:");
		lblNewLabel_1.setBounds(38, 141, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboComunidades = new JComboBox();
		comboComunidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		comboComunidades.addItemListener( new ItemListener() {
			public void itemStateChanged(ItemEvent e)  {
				if(e.getStateChange()== ItemEvent.SELECTED) {
				String seleccionado=(String)comboComunidades.getSelectedItem();
				var service= DatosProvinciasServiceFactory.getDatosProvinciasService();
				//JOptionPane.showMessageDialog(VentanaPaises.this, "Paises de "+seleccionado+" :"+service.getPaisesFiltradosPor(seleccionado).size());
				//creamos adaptador con los datos de los paises
				//y lo volvamos en JTable
				var adaptador=new ComboBoxModelComunidadesImpl(seleccionado);
				table.setModel(adaptador);
				}
			}
		});
		comboComunidades.setBounds(133, 30, 133, 22);
		contentPane.add(comboComunidades);
		
		JComboBox comboProvincias = new JComboBox();
		comboProvincias.setBounds(133, 102, 133, 22);
		contentPane.add(comboProvincias);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 166, 341, 84);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
