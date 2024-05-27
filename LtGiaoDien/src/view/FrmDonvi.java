package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.table.DefaultTableModel;

import Bean.donvibean;
import Bo.donvibo;
import Dao.donvidao;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDonvi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmadv;
	private JTextField txttendv;
	donvibo dvbo= new donvibo();
	ArrayList<donvibean> ds;
	void Napbang(ArrayList<donvibean> ds) {
		DefaultTableModel mh= new DefaultTableModel();
		mh.addColumn("Madv"); 
		mh.addColumn("Tendv");
		for(donvibean dv: ds) {
			Object[] t= new Object[2];
			t[0]= dv.getMadv(); t[1]= dv.getTendv();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDonvi frame = new FrmDonvi();
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
	public FrmDonvi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ds=dvbo.getdv();Napbang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(50, 141, 323, 95);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		tabbedPane.addTab("Danh sach", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				String ma=table.getValueAt(d, 0).toString();
				String kh=table.getValueAt(d, 1).toString();
				txtmadv.setText(ma);
				txttendv.setText(kh);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Madv");
		lblNewLabel.setBounds(50, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tendv");
		lblNewLabel_1.setBounds(50, 47, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtmadv = new JTextField();
		txtmadv.setBounds(151, 8, 125, 20);
		contentPane.add(txtmadv);
		txtmadv.setColumns(10);
		
		txttendv = new JTextField();
		txttendv.setBounds(151, 44, 125, 20);
		contentPane.add(txttendv);
		txttendv.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ds= dvbo.Them(txtmadv.getText(), txttendv.getText());
					if(ds==null) {
						JOptionPane.showConfirmDialog(null, "Trung ma");
					}else {
						Napbang(ds);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 72, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int t=JOptionPane.showConfirmDialog(null, "Xoa hay khong");
					if(t==0) {
						dvbo.Xoa(txtmadv.getText());
						Napbang(ds);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(109, 75, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ds= dvbo.Sua(txtmadv.getText(), txttendv.getText());
					Napbang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(224, 75, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter f= new FileWriter("donvi.txt");
					PrintWriter b= new PrintWriter(f);
					for(donvibean dv: ds) {
						b.println(dv.getMadv()+";"+dv.getTendv());
					}
					
					b.close();
					JOptionPane.showConfirmDialog(null, "Da luu");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				Napbang(ds);
			}
		});
		btnNewButton_3.setBounds(335, 75, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
