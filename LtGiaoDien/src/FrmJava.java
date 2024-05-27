import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmJava extends JFrame {

	private JPanel contentPane;
	private JTextField txtth;
	private JTextField txtg;
	ArrayList<String> ds = new ArrayList<String>();
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	void NapBang(ArrayList<String> ds2 ) {
		DefaultTableModel mh= new DefaultTableModel();
		
		mh.addColumn("Ten hang");
		mh.addColumn("Gia");
		
		for(String h: ds) {
			String [] tt = h.split("[;]");
			Object [] t= new Object[2];
			t[0] =tt[0];
			t[1] =tt[1];
			mh.addRow(t);
		}
		table.setModel(mh);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmJava frame = new FrmJava();
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
	public FrmJava() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader f=new FileReader("hang.txt");
					BufferedReader b=new BufferedReader(f);
					while(true) {
						String st=b.readLine();
						if(st==null || st =="") break;
						ds.add(st);
					}
					b.close();
				} catch (Exception e2) {
					e2.getStackTrace();
				}
				NapBang(ds);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Ten Hang");
		lblNewLabel.setBounds(25, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gia");
		lblNewLabel_1.setBounds(25, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtth = new JTextField();
		txtth.setBounds(96, 8, 86, 20);
		contentPane.add(txtth);
		txtth.setColumns(10);
		
		txtg = new JTextField();
		txtg.setBounds(96, 36, 86, 20);
		contentPane.add(txtg);
		txtg.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String h = txtth.getText() + ";" + txtg.getText();
				ds.add(h);
				NapBang(ds);
			}
		});
		btnNewButton.setBounds(192, 7, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st= JOptionPane.showInputDialog("Nhap ten can xoa");
				for(String h: ds) {
					String[] t=h.split("[;]");
					if(t[0].equals(st)) {
						ds.remove(h); 
						break;
					}
				}
				NapBang(ds);
			}
		});
		btnNewButton_1.setBounds(192, 32, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Find");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st = JOptionPane.showInputDialog("Nhap ten hang can tim");
				for (String h:ds)
				{
					String [] t = h.split("[;]");
					if(t[0].equals(st)) {
						JOptionPane.showInternalMessageDialog(null, t[0] +" : "+ t[1]);
					}
				}
				NapBang(ds);
			}
		});
		btnNewButton_2.setBounds(322, 32, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter  f = new FileWriter("hang.txt");
					PrintWriter ghi= new PrintWriter(f);
					for(String h:ds)
					{
						ghi.println(h);
					}
					
					ghi.close();
					JOptionPane.showInternalMessageDialog(null, "Da luu");
				} catch (Exception e2) {
					e2.getStackTrace();
				}
				NapBang(ds);
			}
		});
		btnNewButton_3.setBounds(322, 7, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th=txtth.getText();
				int n=ds.size();
				for (int i=0;i<n;i++)
				{	
					
					String h=ds.get(i);
					String [] t = h.split("[;]");
					if(t[0].equals(th)) {
						ds.set(i,th+";"+txtg.getText()); break;
					}
				}
				NapBang(ds);
			}
		});
		btnNewButton_4.setBounds(257, 66, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 125, 314, 125);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				String th=table.getValueAt(d, 0).toString();
				String gia=table.getValueAt(d, 1).toString();
				txtth.setText(th);
				txtg.setText(gia);
			}
		});
		scrollPane.setViewportView(table);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setColumnHeaderView(tabbedPane);
		tabbedPane.setToolTipText("");
	}
}
