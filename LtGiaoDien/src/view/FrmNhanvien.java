package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.NA;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Bean.nhanvienbean;
import Bo.donvibo;
import Bo.nhanvienbo;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class FrmNhanvien extends JFrame {

	private JPanel contentPane;
	private JTable table;

	donvibo dvbo= new donvibo();
	nhanvienbo nvbo= new nhanvienbo();
	ArrayList<nhanvienbean> ds;
	private JTextField txtmadv;
	
	void Napbang(ArrayList<nhanvienbean> ds) {
		DefaultTableModel mh= new DefaultTableModel();
		mh.addColumn("Manv"); 
		mh.addColumn("Hoten");
		mh.addColumn("Gioitinh");
		mh.addColumn("Ngaysinh"); 
		mh.addColumn("Hsl");
		mh.addColumn("Madv");
		for(nhanvienbean nv:ds) {
			Object[] t= new Object[6];
			t[0] = nv.getManv();
			t[1] = nv.getHoten();
			t[2] = nv.getGioitinh();
			t[3] = nv.getNgaysinh();
			t[4] = nv.getHsl();
			t[5] = nv.getMadv();
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhanvien frame = new FrmNhanvien();
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
	public FrmNhanvien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ds=nvbo.getnv();
					Napbang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(52, 193, 537, 180);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sach", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				String m0 = table.getValueAt(d, 0).toString();
				txtmadv.setText(m0);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("Madv");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(52, 44, 60, 29);
		contentPane.add(lblNewLabel_5);
		
		txtmadv = new JTextField();
		txtmadv.setBounds(122, 52, 130, 20);
		contentPane.add(txtmadv);
		txtmadv.setColumns(10);
	}
}
