package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

public class ProjekatForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjekatForm frame = new ProjekatForm();
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
	public ProjekatForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setTitle("Prikaz projekta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o projektu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 11, 340, 437);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Naziv:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(92, 30, 30, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(155, 27, 165, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Naziv klijenta:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(55, 58, 67, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 55, 165, 20);
		panel.add(textField_1);
		
		JLabel lblZaposleniciNaProjektu = new JLabel("Zaposlenici na projektu:");
		lblZaposleniciNaProjektu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposleniciNaProjektu.setBounds(10, 83, 114, 14);
		panel.add(lblZaposleniciNaProjektu);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setBounds(155, 83, 165, 121);
		panel.add(list);
		
		JLabel lblNadreeni = new JLabel("Nadređeni:");
		lblNadreeni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNadreeni.setBounds(69, 218, 53, 14);
		panel.add(lblNadreeni);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(155, 215, 165, 20);
		panel.add(comboBox);
		
		JButton button = new JButton("Dodaj");
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setBounds(231, 403, 89, 23);
		panel.add(button);
		
		JLabel lblDodajZaposlenike = new JLabel("Dodaj zaposlenike:");
		lblDodajZaposlenike.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDodajZaposlenike.setBounds(31, 243, 114, 14);
		panel.add(lblDodajZaposlenike);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_1.setBounds(155, 243, 165, 121);
		panel.add(list_1);
		
		JButton btnUkloniZaposlenikaSa = new JButton("Ukloni zaposlenika sa projekta");
		btnUkloniZaposlenikaSa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUkloniZaposlenikaSa.setBounds(31, 403, 195, 23);
		panel.add(btnUkloniZaposlenikaSa);
	}
}
