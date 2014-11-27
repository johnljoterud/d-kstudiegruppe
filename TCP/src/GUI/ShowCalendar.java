package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ShowCalendar extends JPanel{
    private JLabel lblWeek, lblYear;
    private JButton btnPrev, btnNext;
    private JTable tblCalendar;
    private JComboBox cmbYear;
    private DefaultTableModel mtblCalendar; //Table model
    private JScrollPane stblCalendar; //The scrollpane
    private int realYear, realWeek, realDay, currentYear, currentWeek;
     private JTextField txtTekstTilEvents;
     private JTextField textField_1;
     private JLabel lblWeatherForecast;
     private JTextField textField_2;
     private JLabel lblQotd;
     private JButton btnLogout;
     private JButton btnChangeCalendar;
     private JButton btnShareCalendar;
     private JButton btnAddCalendar;
     private JButton btnAddEvent;
     private JButton btnAddNote;
    
    public ShowCalendar(){
        //Look and feel
//        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
//        catch (ClassNotFoundException e) {}
//        catch (InstantiationException e) {}
//        catch (IllegalAccessException e) {}
//        catch (UnsupportedLookAndFeelException e) {}
        
        //Prepare frame
        setLayout(null);//Create frame
        setSize(1366, 768); //Set size to 400x400 pixels
  
       
        //Create controls
        lblWeek = new JLabel ("January");
        btnPrev = new JButton ("<<");
        btnNext = new JButton (">>");
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        
        //Set border
        setBorder(BorderFactory.createTitledBorder("Calendar"));
        setBounds(6, 6, 1354, 734);
        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        
        //Add controls to pane
       
        add(lblWeek);
        add(btnPrev);
        add(btnNext);
        add(stblCalendar);
        
        //Set bounds
       
        lblWeek.setBounds(160-lblWeek.getPreferredSize().width/2, 25, 100, 25);
        btnPrev.setBounds(10, 25, 50, 25);
        btnNext.setBounds(260, 25, 50, 25);
        stblCalendar.setBounds(10, 183, 1189, 451);
        
        //Make frame visible
        setVisible(true);
        
        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_WEEK); //Get day
        realWeek = cal.get(GregorianCalendar.WEEK_OF_YEAR); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentWeek = realWeek; //Match month and year
        currentYear = realYear;
        
        //Add headers
        String[] headers = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}; //All headers
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(60);
        cmbYear = new JComboBox();
        cmbYear.setBounds(1063, 25, 136, 32);
        add(cmbYear);
        lblYear = new JLabel ("Change year:");
        lblYear.setBounds(931, 21, 108, 32);
        add(lblYear);
        
        btnChangeCalendar = new JButton("Change calendar");
        btnChangeCalendar.setBounds(1218, 564, 117, 29);
        add(btnChangeCalendar);
        
        btnShareCalendar = new JButton("Share calendar");
        btnShareCalendar.setBounds(1218, 523, 117, 29);
        add(btnShareCalendar);
        
        btnAddCalendar = new JButton("Add calendar");
        btnAddCalendar.setBounds(1218, 482, 117, 29);
        add(btnAddCalendar);
        
        btnAddEvent = new JButton("Add event");
        btnAddEvent.setBounds(1218, 441, 117, 29);
        add(btnAddEvent);
        
        btnAddNote = new JButton("Add note");
        btnAddNote.setBounds(1218, 400, 117, 29);
        add(btnAddNote);
        
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(1218, 605, 117, 29);
        add(btnLogout);
        
        txtTekstTilEvents = new JTextField();
        txtTekstTilEvents.setBounds(6, 646, 1197, 82);
        add(txtTekstTilEvents);
        txtTekstTilEvents.setText("Tekst til events!");
        txtTekstTilEvents.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(83, 89, 400, 82);
        add(textField_2);
        textField_2.setColumns(10);
        
        lblQotd = new JLabel("QOTD");
        lblQotd.setBounds(23, 122, 61, 16);
        add(lblQotd);
        
        textField_1 = new JTextField();
        textField_1.setBounds(799, 89, 400, 82);
        add(textField_1);
        textField_1.setColumns(10);
        
        lblWeatherForecast = new JLabel("Weather Forecast");
        lblWeatherForecast.setBounds(680, 122, 124, 16);
        add(lblWeatherForecast);
        cmbYear.addActionListener(new cmbYear_Action());
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(14);
        
        //Populate table
        for (int i=realYear-100; i<=realYear+100; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        
        //Refresh calendar
        refreshCalendar (realWeek, realYear); //Refresh calendar
        
        
        
    }
    public void addActionlistener(ActionListener l){
    	btnNext.addActionListener(l);
    	btnPrev.addActionListener(l);
    }
    public JButton getBtnPrev() {
		return btnPrev;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnChangeCalendar() {
		return btnChangeCalendar;
	}

	public JButton getBtnShareCalendar() {
		return btnShareCalendar;
	}

	public JButton getBtnAddCalendar() {
		return btnAddCalendar;
	}

	public JButton getBtnAddEvent() {
		return btnAddEvent;
	}

	public JButton getBtnAddNote() {
		return btnAddNote;
	}

	public void refreshCalendar(int week, int year){
        //Variables
        String[] weeks =  {"Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7", "Week 8", "Week 9", "Week 10", "Week 11", "Week 12", "Week 13", "Week 14", "Week 15", "Week 16", "Week 17", "Week 18", "Week 19", "Week 20", "Week 21", "Week 22", "Week 23", "Week 24", "Week 25", "Week 26", "Week 27", "Week 28", "Week 29", "Week 30", "Week 31", "Week 32", "Week 33", "Week 34", "Week 35", "Week 36", "Week 37", "Week 38", "Week 39", "Week 40", "Week 41", "Week 42", "Week 43", "Week 44", "Week 45", "Week 46", "Week 47", "Week 48", "Week 49", "Week 50", "Week 51", "Week 52"};
//        int nod, sow; //Number Of Days, Start Of Weeks
        
        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (week == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
        if (week == 51 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
        lblWeek.setText(weeks[week]); //Refresh the month label (at the top)
        lblWeek.setBounds(160-lblWeek.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        
        //Clear table
        for (int i=0; i<14; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
//        //Get first day of month and number of days
//        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
//        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
//        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
//        
//        //Draw calendar
//        for (int i=1; i<=nod; i++){
//            int row = new Integer((i+som-2)/7);
//            int column  =  (i+som-2)%7;
//            mtblCalendar.setValueAt(i, row, column);
//        }
//        
//            
          
    
        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
  
    
    private class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 5 || column == 6){ //Week-end
                setBackground(new Color(255, 220, 220));
            }
            else{ //Week
                setBackground(new Color(220, 255, 220));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentWeek == realWeek && currentYear == realYear){ //Today
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
    private class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentWeek == 0){ //Back one year
                currentWeek = 51;
                currentYear -= 1;
            }
            else{ //Back one month
                currentWeek -= 1;
            }
            refreshCalendar(currentWeek, currentYear);
        }
    }
    private class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentWeek == 51){ //Foward one year
                currentWeek = 0;
                currentYear += 1;
            }
            else{ //Foward one month
                currentWeek += 1;
            }
            refreshCalendar(currentWeek, currentYear);
        }
    }
    private class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentWeek, currentYear);
            }
        }
    }
}