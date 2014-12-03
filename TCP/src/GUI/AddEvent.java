package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

	public class AddEvent extends JPanel {
		private JTextField textField_Location;
		private JTextField textFieldStartYear;
		private JButton btnSubmit;
		private JButton btnBack;
		private JLabel lblCreate;
		private JLabel lblEnd;
		private JLabel lblName;
		private JLabel lblText;
		private JLabel lblEmail;
		private JLabel lblCreateddate;
		private JTextField textField_Name;
		private JTextField textField_Text;
		private JLabel lblType;
		private JTextField textField_Type;
		private JTextField textFieldStartMonth;
		private JTextField textFieldStartHour;
		private JTextField textFieldStartMinute;
		private JTextField textFieldEndMinute;
		private JTextField textFieldEndHour;
		private JTextField textFieldEndMonth;
		private JTextField textFieldEndYear;
		private JTextField textFieldStartDateDay;
		private JTextField textFieldEndDateDay;
		private JLabel lblStartDate;
		private JLabel lblHour;
		private JLabel lblNewLabel_1;

		//Tilføjer et panel der kan tilføje events. Heri oprettes alle JLabels, JButtons og JTextfields.
		public AddEvent() {
			setPreferredSize(new Dimension(1366, 768));
			setSize(new Dimension(1366, 768));
			setLayout(null);
			
			textFieldEndDateDay = new JTextField();
			textFieldEndDateDay.setForeground(SystemColor.controlDkShadow);
			textFieldEndDateDay.setColumns(10);
			textFieldEndDateDay.setBounds(885, 346, 53, 34);
			add(textFieldEndDateDay);
			
			textFieldStartDateDay = new JTextField();
			textFieldStartDateDay.setForeground(SystemColor.controlDkShadow);
			textFieldStartDateDay.setColumns(10);
			textFieldStartDateDay.setBounds(885, 297, 53, 34);
			add(textFieldStartDateDay);

			textFieldEndMonth = new JTextField();
			textFieldEndMonth.setForeground(SystemColor.controlDkShadow);
			textFieldEndMonth.setColumns(10);
			textFieldEndMonth.setBounds(820, 346, 53, 34);
			add(textFieldEndMonth);

			textFieldEndMinute = new JTextField();
			textFieldEndMinute.setForeground(SystemColor.controlDkShadow);
			textFieldEndMinute.setColumns(10);
			textFieldEndMinute.setBounds(1015, 346, 53, 34);
			add(textFieldEndMinute);

			textFieldEndHour = new JTextField();
			textFieldEndHour.setForeground(SystemColor.controlDkShadow);
			textFieldEndHour.setColumns(10);
			textFieldEndHour.setBounds(950, 346, 53, 34);
			add(textFieldEndHour);

			textFieldEndYear = new JTextField();
			textFieldEndYear.setForeground(SystemColor.controlDkShadow);
			textFieldEndYear.setColumns(10);
			textFieldEndYear.setBounds(755, 346, 53, 34);
			add(textFieldEndYear);

			textFieldStartMinute = new JTextField();
			textFieldStartMinute.setForeground(SystemColor.controlDkShadow);
			textFieldStartMinute.setColumns(10);
			textFieldStartMinute.setBounds(1015, 297, 53, 34);
			add(textFieldStartMinute);

			textFieldStartHour = new JTextField();
			textFieldStartHour.setForeground(SystemColor.controlDkShadow);
			textFieldStartHour.setColumns(10);
			textFieldStartHour.setBounds(950, 297, 53, 34);
			add(textFieldStartHour);

			textFieldStartMonth = new JTextField();
			textFieldStartMonth.setForeground(SystemColor.controlDkShadow);
			textFieldStartMonth.setColumns(10);
			textFieldStartMonth.setBounds(820, 297, 53, 34);
			add(textFieldStartMonth);
			
			btnBack = new JButton("Back");
			btnBack.setBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0,
							0), new Color(255, 255, 255), new Color(0, 0, 0)),
					new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255),
							new Color(0, 0, 0), new Color(255, 255, 255),
							new Color(0, 0, 0))));
			btnBack.setForeground(new Color(0, 0, 0));
			btnBack.setFont(new Font("Arial", Font.BOLD, 30));
			btnBack.setContentAreaFilled(false);
			btnBack.setBounds(753, 667, 194, 50);
			add(btnBack);

			textField_Location = new JTextField();
			textField_Location.setForeground(new Color(105, 105, 105));
			textField_Location.setColumns(10);
			textField_Location.setBounds(753, 231, 380, 34);
			add(textField_Location);

			lblEmail = new JLabel("Location");
			lblEmail.setForeground(new Color(0, 0, 0));
			lblEmail.setFont(new Font("Arial", Font.BOLD, 26));
			lblEmail.setBounds(483, 235, 109, 30);
			add(lblEmail);

			textFieldStartYear = new JTextField();
			textFieldStartYear.setForeground(new Color(105, 105, 105));
			textFieldStartYear.setColumns(10);
			textFieldStartYear.setBounds(755, 297, 53, 34);
			add(textFieldStartYear);

			lblCreateddate = new JLabel("Start");
			lblCreateddate.setForeground(new Color(0, 0, 0));
			lblCreateddate.setFont(new Font("Arial", Font.BOLD, 26));
			lblCreateddate.setBounds(483, 300, 159, 31);
			add(lblCreateddate);

			btnSubmit = new JButton("Create");
			btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			btnSubmit.setContentAreaFilled(false);
			btnSubmit.setBorder(new CompoundBorder(new BevelBorder(
					BevelBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0,
							0), new Color(255, 255, 255), new Color(0, 0, 0)),
					new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255),
							new Color(0, 0, 0), new Color(255, 255, 255),
							new Color(0, 0, 0))));
			btnSubmit.setForeground(new Color(0, 0, 0));
			btnSubmit.setFont(new Font("Arial", Font.BOLD, 30));
			btnSubmit.setBounds(752, 604, 194, 50);
			add(btnSubmit);

			lblCreate = new JLabel("Create event");
			lblCreate.setForeground(new Color(0, 0, 0));
			lblCreate.setFont(new Font("Arial", Font.BOLD, 78));
			lblCreate.setBounds(572, 55, 466, 91);
			add(lblCreate);

			lblEnd = new JLabel("End");
			lblEnd.setForeground(new Color(0, 0, 0));
			lblEnd.setFont(new Font("Arial", Font.BOLD, 26));
			lblEnd.setBounds(483, 349, 159, 31);
			add(lblEnd);

			lblName = new JLabel("Name");
			lblName.setForeground(new Color(0, 0, 0));
			lblName.setFont(new Font("Arial", Font.BOLD, 26));
			lblName.setBounds(483, 182, 159, 31);
			add(lblName);

			lblText = new JLabel("Text");
			lblText.setForeground(new Color(0, 0, 0));
			lblText.setFont(new Font("Arial", Font.BOLD, 26));
			lblText.setBounds(483, 406, 159, 31);
			add(lblText);

			textField_Name = new JTextField();
			textField_Name.setForeground(SystemColor.controlDkShadow);
			textField_Name.setColumns(10);
			textField_Name.setBounds(753, 182, 380, 34);
			add(textField_Name);

			textField_Text = new JTextField();
			textField_Text.setForeground(SystemColor.controlDkShadow);
			textField_Text.setColumns(10);
			textField_Text.setBounds(755, 386, 378, 86);
			add(textField_Text);

			textField_Type = new JTextField();
			textField_Type.setForeground(SystemColor.controlDkShadow);
			textField_Type.setColumns(10);
			textField_Type.setBounds(755, 485, 378, 34);
			add(textField_Type);

			lblType = new JLabel("Type");
			lblType.setForeground(new Color(0, 0, 0));
			lblType.setFont(new Font("Arial", Font.BOLD, 26));
			lblType.setBounds(483, 483, 159, 31);
			add(lblType);
			
			JLabel lblYear = new JLabel("Year");
			lblYear.setBounds(755, 275, 61, 16);
			add(lblYear);
			
			JLabel lblNewLabel = new JLabel("Month");
			lblNewLabel.setBounds(820, 275, 61, 16);
			add(lblNewLabel);
			
			lblStartDate = new JLabel("Date");
			lblStartDate.setBounds(885, 275, 61, 16);
			add(lblStartDate);
			
			lblHour = new JLabel("Hour");
			lblHour.setBounds(950, 275, 61, 16);
			add(lblHour);
			
			lblNewLabel_1 = new JLabel("Minute");
			lblNewLabel_1.setBounds(1015, 275, 61, 16);
			add(lblNewLabel_1);

		}
		// Actionlisteners tilføjes
		public void addActionListener(ActionListener l) {
			btnSubmit.addActionListener(l);
			btnBack.addActionListener(l);
		}
		// Her samles alt input fra textfields angående startdate til en lang string.
		public String startDateTimeToString(){
			
			String start = getTextFieldStartYear().getText()+"-" + getTextFieldStartMonth().getText() + "-" + 
					getTextFieldStartDateDay().getText() + " " + getTextFieldStartHour().getText()+":"+getTextFieldStartMinute().getText() + ":" +
					"00";
			
			return start;
		}
		// Her samles alt input fra textfields angående enddate til en lang string.
		public String endDateTimeToString(){
			
			String end = getTextFieldEndYear().getText()+"-" + getTextFieldEndMonth().getText() + "-" + 
					getTextFieldEndDateDay().getText() + " " + getTextFieldEndHour().getText()+":"+getTextFieldEndMinute().getText() + ":" +
					"00";
			
			return end;
		}
		

		public JTextField getTextFieldStartDateDay() {
			return textFieldStartDateDay;
		}

		public JTextField getTextFieldEndDateDay() {
			return textFieldEndDateDay;
		}

		public JTextField getTextFieldStartYear() {
			return textFieldStartYear;
		}

		public JTextField getTextFieldStartMonth() {
			return textFieldStartMonth;
		}

		public JTextField getTextFieldStartHour() {
			return textFieldStartHour;
		}

		public JTextField getTextFieldStartMinute() {
			return textFieldStartMinute;
		}


		public JTextField getTextFieldEndMinute() {
			return textFieldEndMinute;
		}

		public JTextField getTextFieldEndHour() {
			return textFieldEndHour;
		}

		public JTextField getTextFieldEndMonth() {
			return textFieldEndMonth;
		}

		public JTextField getTextFieldEndYear() {
			return textFieldEndYear;
		}

		public JTextField getTextField_Location() {
			return textField_Location;
		}

		public JTextField getTextField_Name() {
			return textField_Name;
		}

		public JTextField getTextField_Text() {
			return textField_Text;
		}

		public JTextField getTextField_Type() {
			return textField_Type;
		}

		public JButton getBtnSubmit() {
			return btnSubmit;
		}

		public JButton getBtnBack() {
			return btnBack;
		}
		
}
