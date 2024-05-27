import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmTestFrame extends JFrame {
	
	ArrayList<String> ds= new ArrayList<String>();
	private JPanel contentPane;
	private JTextField txtgia;
	private JTextField txtsl;
	private JTextField txttt;
	JComboBox cmbch = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTestFrame frame = new FrmTestFrame();
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
	public FrmTestFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader f= new FileReader("hang.txt");
					BufferedReader b=new BufferedReader(f);
					while(true) {
						String st=b.readLine();
						if(st==null || st=="") break;
						
							String[] t=st.split("[;]");
							cmbch.addItem(t[0]);
							ds.add(st);
						}
					b.close();
				} catch(Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chon hang");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 27, 80, 35);
		contentPane.add(lblNewLabel);
		
//		JComboBox cmbch = new JComboBox();
		cmbch.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String tenhang=cmbch.getSelectedItem().toString();
				for(String h:ds) {
					//Che Hang ra thanh 2 thong tin
					String [] t=h.split("[;]");
					if(t[0].equals(tenhang))
						txtgia.setText(t[1]);
				}
			}
		});
		cmbch.setBounds(132, 35, 201, 22);
		contentPane.add(cmbch);
		
		JLabel lblNewLabel_1 = new JLabel("Gia");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 88, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		txtgia = new JTextField();
		txtgia.setBounds(132, 87, 128, 20);
		contentPane.add(txtgia);
		txtgia.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nhap so luong");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 148, 121, 19);
		contentPane.add(lblNewLabel_2);
		
		txtsl = new JTextField();
		txtsl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10)
				{
					double a= Double.parseDouble(txtgia.getText());
					double b= Double.parseDouble(txtsl.getText());
					Double kq=a*b;
					txttt.setText(kq.toString());
				}
			}
		});
		txtsl.setBounds(132, 149, 123, 20);
		contentPane.add(txtsl);
		txtsl.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Thanh tien");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 195, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		txttt = new JTextField();
		txttt.setBounds(132, 194, 123, 20);
		contentPane.add(txttt);
		txttt.setColumns(10);
		
	}
}
