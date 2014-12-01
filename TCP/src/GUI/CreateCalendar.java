package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

//import model.QueryBuild.QueryBuilder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;



public class CreateCalendar extends JPanel {
	private JLabel lblBackground;
	private JLabel label;
	private JLabel lblHeader;
	private JButton btnBack;
	private JButton btnLogout;
	private JButton btnSubmit;
	private JLabel lblName;
	private JLabel lblShareWith;
	private JLabel lblPrivateOrPublic;
	private JTextField textName;
	private JTextField textPrivateOrPublic;
	private JTextField txtShare;
	private JCheckBox chckbxIfYesCheck;
	
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private Object[] objects;
//	QueryBuilder qb = new QueryBuilder();
	ResultSet rs;
	private JLabel lblShareCalendar;
	
	
	public CreateCalendar() {
		setSize(new Dimension(1366, 768));
		setLayout(null);
		
		String[] columnNames = { "Email" };
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnNames);
		
		chckbxIfYesCheck = new JCheckBox("If yes, check this box");
		chckbxIfYesCheck.setBounds(737, 436, 167, 25);
		add(chckbxIfYesCheck);
		
		lblShareCalendar = new JLabel("Share this calendar?");
		lblShareCalendar.setForeground(new Color (0, 0, 0));
		lblShareCalendar.setFont(new Font("Arial", Font.BOLD, 26));
		lblShareCalendar.setBounds(476, 425, 260, 39);
		add(lblShareCalendar);
		table.setSurrendersFocusOnKeystroke(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				null));
		scrollPane.setBounds(547, 184, 260, 148);

		// Add the scroll pane to this panel.
		add(scrollPane);
		lblShareWith = new JLabel("Share with:");
		lblShareWith.setForeground(new Color (0, 0, 0));
		lblShareWith.setFont(new Font("Arial", Font.BOLD, 26));
		lblShareWith.setBounds(476, 468, 147, 39);
		lblShareWith.setVisible(false);
		add(lblShareWith);
		
		txtShare = new JTextField();
		txtShare.setColumns(10);
		txtShare.setBounds(737, 477, 149, 28);
		txtShare.setVisible(false);
		add(txtShare);
		
		lblHeader = new JLabel("Add Calendar");
		lblHeader.setForeground(new Color (0, 0, 0));
		lblHeader.setFont(new Font("Arial", Font.BOLD, 78));
		lblHeader.setBounds(424, 81, 515, 90);
		add(lblHeader);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color (0, 0, 0));
		btnBack.setFont(new Font("Arial", Font.BOLD, 30));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnBack.setBounds(601, 590, 194, 50);
		add(btnBack);
		
		btnLogout = new JButton("Log out");
		btnLogout.setForeground(new Color (0, 0, 0));
		btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnLogout.setBounds(601, 660, 194, 50);
		add(btnLogout);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(new Color (0, 0, 0));
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0)), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0))));
		btnSubmit.setBounds(601, 520, 194, 50);
		add(btnSubmit);
		
		lblName = new JLabel("Name:");
		lblName.setForeground(new Color (0, 0, 0));
		lblName.setFont(new Font("Arial", Font.BOLD, 26));
		lblName.setBounds(476, 345, 147, 39);
		add(lblName);
		
		lblPrivateOrPublic = new JLabel("Private or public:");
		lblPrivateOrPublic.setForeground(new Color (0, 0, 0));
		lblPrivateOrPublic.setFont(new Font("Arial", Font.BOLD, 26));
		lblPrivateOrPublic.setBounds(476, 385, 223, 39);
		add(lblPrivateOrPublic);
		
		textName = new JTextField();
		textName.setBounds(737, 354, 149, 28);
		add(textName);
		textName.setColumns(10);
		
		textPrivateOrPublic = new JTextField();
		textPrivateOrPublic.setBounds(737, 394, 149, 28);
		add(textPrivateOrPublic);
		textPrivateOrPublic.setColumns(10);
		
		}
	
	public void addActionListener(ActionListener l) {
		btnLogout.addActionListener(l);
		btnBack.addActionListener(l);
		btnSubmit.addActionListener(l);
	}
//	public void updateTable() {
//		try {
//			model.getDataVector().removeAllElements();
//
//			QueryBuilder qb = new QueryBuilder();
//			String[] values = {"email"};
//			rs = qb.selectFrom(values, "users").all().ExecuteQuery();
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int colNo = rsmd.getColumnCount();
//
//			while (rs.next()) {
//
//				objects = new Object[colNo];
//
//				for (int i = 0; i < colNo; i++) {
//					objects[i] = rs.getObject(i + 1);
//				}
//				model.addRow(objects);
//			}
//			table.setModel(model);
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
	
	public JCheckBox getChckbxIfYesCheck() {
		return chckbxIfYesCheck;
	}

	public void setChckbxIfYesCheck(JCheckBox chckbxIfYesCheck) {
		this.chckbxIfYesCheck = chckbxIfYesCheck;
	}

	public JLabel getLblShareWith() {
		return lblShareWith;
	}

	public void setLblShareWith(JLabel lblShareWith) {
		this.lblShareWith = lblShareWith;
	}
	public void showShareFields(){
		lblShareWith.setVisible(true);
		txtShare.setVisible(true);
	}

	public void setTxtShare(JTextField txtShare) {
		this.txtShare = txtShare;
	}

	public JButton getBtnBack() {
		return btnBack;
	}
	public JButton getBtnLogout() {
		return btnLogout;
	}
	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public JTextField getTxtShare() {
		return txtShare;
	}

	public JTextField getTextName() {
		return textName;
	}

	public JTextField getTextPrivateOrPublic() {
		return textPrivateOrPublic;
	}
}
