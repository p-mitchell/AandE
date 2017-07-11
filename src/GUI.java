import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

public class GUI extends JFrame {

	// variables for creating a new patient
	private JPanel contentPane;
	private JTextField firstname_TA;
	private JTextField lastname_TA;
	private JTextField nextOfKin_TA;
	private JTextField diagnosis_TA;
	private JTextField updatePriority_TA;
	
	// double linked list for the patients
	DoubleLinkedList dll = new DoubleLinkedList();
	// sqlite database
	SqliteDB db = new SqliteDB();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	///////////////////// METHODS /////////////////////
	
	// method for creating a patient. called by 'add' button
	/*public void addPatient()
	{
		String fname = firstname_TA.getText();				// get all the user inputs
		String lname = lastname_TA.getText();
		int age = Integer.parseInt(age_TA.getText());
		String nok = nextOfKin_TA.getText();
		String diagnosis = diagnosis_TA.getText();
		
		if () 
		{		// check to see if all of the inputs are ok
			
		}
		else
		{		// create a patient and add it to the list
			Patient temp = new Patient(fname, lname, age, nok, diagnosis);
			dll.add(temp);
			db.insert(fname, lname, age, nok, diagnosis);
		}
		
		// create a patient and add it to the list
		Patient temp = new Patient(fname, lname, age, nok, diagnosis);
		dll.add(temp);
		db.insert(fname, lname, age, nok, diagnosis);
		
		// reset all the text fields to blank
		firstname_TA.setText("");
		lastname_TA.setText("");
		age_TA.setText("");
		nextOfKin_TA.setText("");
		diagnosis_TA.setText("");
	}*/
	
	
	
	
	
	
	
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		//*****************************************************************//
		///////////////////////////// TAB MENU //////////////////////////////
		//*****************************************************************//
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 347, 520);
		contentPane.add(tabbedPane);
		
		JPanel Reception_PNL = new JPanel();
		tabbedPane.addTab("Receptionist", null, Reception_PNL, null);
		Reception_PNL.setLayout(null);
		
		//*****************************************************************//
		///////////////////// DETAILS FOR THE RECEPTION /////////////////////
		//*****************************************************************//
		
		JLabel PatientDetails_LBL = new JLabel("PATIENT DETAILS:");
		PatientDetails_LBL.setBounds(98, 64, 141, 20);
		Reception_PNL.add(PatientDetails_LBL);
		PatientDetails_LBL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel firstname_LBL = new JLabel("First Name:");
		firstname_LBL.setBounds(60, 130, 67, 16);
		Reception_PNL.add(firstname_LBL);
		
		firstname_TA = new JTextField();
		firstname_TA.setBounds(147, 127, 116, 22);
		Reception_PNL.add(firstname_TA);
		
		lastname_TA = new JTextField();
		lastname_TA.setBounds(147, 170, 116, 22);
		Reception_PNL.add(lastname_TA);
		lastname_TA.setColumns(10);
		
		JLabel lastname_LBL = new JLabel("Last Name:");
		lastname_LBL.setBounds(60, 173, 75, 16);
		Reception_PNL.add(lastname_LBL);
		
		JLabel age_LBL = new JLabel("Age:");
		age_LBL.setBounds(60, 219, 56, 16);
		Reception_PNL.add(age_LBL);
		
		JSpinner age_SPIN = new JSpinner();
		age_SPIN.setBounds(207, 216, 56, 22);
		Reception_PNL.add(age_SPIN);
		
		nextOfKin_TA = new JTextField();
		nextOfKin_TA.setBounds(147, 260, 116, 22);
		Reception_PNL.add(nextOfKin_TA);
		nextOfKin_TA.setColumns(10);
		
		JLabel nextOfKin_LBL = new JLabel("Next of Kin:");
		nextOfKin_LBL.setBounds(60, 263, 75, 16);
		Reception_PNL.add(nextOfKin_LBL);
		
		JLabel diagnosis_LBL = new JLabel("Diagnosis:");
		diagnosis_LBL.setBounds(60, 301, 75, 16);
		Reception_PNL.add(diagnosis_LBL);
		
		diagnosis_TA = new JTextField();
		diagnosis_TA.setBounds(147, 304, 116, 22);
		Reception_PNL.add(diagnosis_TA);
		diagnosis_TA.setHorizontalAlignment(SwingConstants.LEFT);
		diagnosis_TA.setColumns(10);
		
		JButton addPatient_BTN = new JButton("Add");
		addPatient_BTN.setBounds(111, 356, 97, 25);
		Reception_PNL.add(addPatient_BTN);
		
		JLabel added_LBL = new JLabel("");
		added_LBL.setBounds(26, 407, 304, 44);
		Reception_PNL.add(added_LBL);
		addPatient_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				String fname = firstname_TA.getText();				// get all the user inputs
				String lname = lastname_TA.getText();
				int age = (int) age_SPIN.getValue();
				String nok = nextOfKin_TA.getText();
				String diagnosis = diagnosis_TA.getText();
				
				if (fname.isEmpty() || lname.isEmpty() || nok.isEmpty() || diagnosis.isEmpty()) 
				{		// check to see if all of the inputs are ok
					added_LBL.setText("<html>Missing Information. <br>please re-enter patient details</html>");
				}
				else
				{		// create a patient and add it to the list
					
					Patient temp = new Patient(fname, lname, age, nok, diagnosis);
					dll.add(temp);
					db.insert(fname, lname, age, nok, diagnosis);
					added_LBL.setText(firstname_TA.getText() + " " + lastname_TA.getText() + " added to the waiting list.");	// print out message saying pantients name
				}
				
				// reset all the text fields to blank
				firstname_TA.setText("");
				lastname_TA.setText("");
				age_SPIN.setValue(0);
				nextOfKin_TA.setText("");
				diagnosis_TA.setText("");
			}
		});
		
		//*****************************************************************//
		/////////////////////// DETAILS FOR THE NURSE ///////////////////////
		//*****************************************************************//
		
		JPanel Nurse_PNL = new JPanel();
		tabbedPane.addTab("Nurse", null, Nurse_PNL, null);
		Nurse_PNL.setLayout(null);
		
		JLabel nextPatient_LBL = new JLabel("NEXT PATIENT:");
		nextPatient_LBL.setBounds(95, 65, 134, 16);
		Nurse_PNL.add(nextPatient_LBL);
		nextPatient_LBL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel next_LBL = new JLabel("");
		next_LBL.setBounds(95, 186, 122, 76);
		Nurse_PNL.add(next_LBL);
		next_LBL.setHorizontalAlignment(SwingConstants.LEFT);
		next_LBL.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblNext = new JLabel("Next:");
		lblNext.setBounds(94, 157, 56, 16);
		Nurse_PNL.add(lblNext);
		
		JLabel updatePriority_LBL = new JLabel("Update Priority (1-10) :");
		updatePriority_LBL.setBounds(83, 275, 134, 16);
		Nurse_PNL.add(updatePriority_LBL);
		
		JLabel confirmation_LBL = new JLabel("");
		confirmation_LBL.setBounds(93, 401, 134, 44);
		Nurse_PNL.add(confirmation_LBL);
		
		updatePriority_TA = new JTextField();
		updatePriority_TA.setBounds(83, 324, 44, 25);
		Nurse_PNL.add(updatePriority_TA);
		updatePriority_TA.setColumns(10);
		

		JButton next_Patient_BTN = new JButton("Next");
		next_Patient_BTN.setBounds(119, 107, 67, 25);
		Nurse_PNL.add(next_Patient_BTN);
		
		JButton updatePriority_BTN = new JButton("Confirm");
		updatePriority_BTN.setBounds(139, 324, 88, 25);
		Nurse_PNL.add(updatePriority_BTN);
		
		next_Patient_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				Node n = dll.updatePriority();		// use the 'updatePriority' method to find the next patient who hasn't updated priority
				
				if (n == null)																		// error checking to see if all the priorities have been updated yet.
				{																					// in 'updatePriority' method, if no priorities == 0, node = null. 
					next_LBL.setText("<html><b>No more patients in the waiting room</b></html>");	// if n = null. update the text box to say no more patients
				}
				else
				{
					// display the information about the patient (name and diagnosis). decide on priority from that
					next_LBL.setText("<html> <u>Name:</u> " + ((Patient)n.getData()).firstname + " " + ((Patient)n.getData()).lastname + ". <br> "
							+ "<u>Diagnosis:</u> " + ((Patient)n.getData()).diagnosis + "</html>");
					confirmation_LBL.setText("");
					updatePriority_TA.setText("");
				}						
			}
		});
		
		updatePriority_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String entered = updatePriority_TA.getText();						// the priority value entered
				int enter;
				Node n = dll.updatePriority();										// find the right patient again
				
				
				if (n == null)
				{
					confirmation_LBL.setText("<html>No patient to update</html>");
				}
				else
				{
					try {
						enter = Integer.parseInt(entered);
						if (enter < 1 || enter > 10) 
						{
							confirmation_LBL.setText("<html>Please enter a priority between 1 and 10</html>");
						}
						else
						{
							((Patient)n.getData()).setPriority(enter);						// set the priority as the entered number
							db.addPriority(enter, ((Patient)n.getData()).firstname, ((Patient)n.getData()).lastname);
							
							confirmation_LBL.setText("<html> Priority updated!<br> Patient: " + ((Patient)n.getData()).firstname + " " + ((Patient)n.getData()).lastname + "<br>"
									+ "Priority set to: " + ((Patient)n.getData()).priority + " </hmtl>");
							updatePriority_TA.setText("");
						}
						
					} catch (NumberFormatException e) {
						confirmation_LBL.setText("<html>Please enter a number</html>");
					}
				}
			}
		});
				
		//*****************************************************************//
		////////////////////// DETAILS FOR THE DOCTOR ///////////////////////
		//*****************************************************************//		
				
		JPanel Doctor_PNL = new JPanel();
		tabbedPane.addTab("Doctor", null, Doctor_PNL, null);
		Doctor_PNL.setLayout(null);
		
		JLabel priorityPatient_LBL = new JLabel("PRIORITY PATIENT:");
		priorityPatient_LBL.setBounds(99, 40, 157, 16);
		Doctor_PNL.add(priorityPatient_LBL);
		priorityPatient_LBL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel LBLnext = new JLabel("Next:");
		LBLnext.setBounds(99, 98, 56, 16);
		Doctor_PNL.add(LBLnext);
		
		JLabel nextPriority_LBL = new JLabel("");
		nextPriority_LBL.setBounds(99, 127, 141, 74);
		Doctor_PNL.add(nextPriority_LBL);
		
		JLabel lblRecommendedTreatment = new JLabel("Recommended treatment:");
		lblRecommendedTreatment.setBounds(61, 226, 179, 16);
		Doctor_PNL.add(lblRecommendedTreatment);
		lblRecommendedTreatment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JTextArea summary_TA = new JTextArea();
		summary_TA.setBounds(61, 257, 179, 61);
		Doctor_PNL.add(summary_TA);
		summary_TA.setLineWrap(true);
		summary_TA.setWrapStyleWord(true);
		
		JLabel finish_LBL = new JLabel("");
		finish_LBL.setBounds(61, 393, 179, 44);
		Doctor_PNL.add(finish_LBL);
		
		JButton nextPriority_BTN = new JButton("Next");
		nextPriority_BTN.setBounds(136, 65, 67, 25);
		Doctor_PNL.add(nextPriority_BTN);
		
		nextPriority_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				finish_LBL.setText("");
				if (dll.size == 0)
				{
					nextPriority_LBL.setText("<html><b>No Patients in waiting room!</b></html>");
				}
				else
				{

					Node n = dll.queue();		// use the 'queue' method to find the patient with the highest priority
					nextPriority_LBL.setText("<html> <u>Name:</u> " + ((Patient)n.getData()).firstname + " " + ((Patient)n.getData()).lastname + ". <br>"
												  + "<u>Priority:</u> " + ((Patient)n.getData()).priority + ". <br>"
												  + "<u>Diagnosis:</u> " + ((Patient)n.getData()).diagnosis + "</html>");	
				}	
			}
		});
				
		JButton summary_BTN = new JButton("Confirm");
		summary_BTN.setBounds(143, 342, 97, 25);
		Doctor_PNL.add(summary_BTN);
		summary_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String treatment = summary_TA.getText();
				Node n = dll.queue();			// find the priority node we are working with
				
				
				if (dll.size > 1)
				{
					int pos = dll.getPosition(n);	// get it's position in the list
					dll.remove(pos);				// remove that node from the list
					//((Patient)n.getData()).summary = treatment;		// update the treatment string for the patient   ** not really needed if it's being removed from the dll anyway?
					db.addSummary(treatment, ((Patient)n.getData()).firstname, ((Patient)n.getData()).lastname);
					finish_LBL.setText("<html>Patient has been seen!</html>");
				}
				else if (dll.size == 1)
				{
					int pos = dll.getPosition(n);
					dll.removeLast(pos);
					db.addSummary(treatment, ((Patient)n.getData()).firstname, ((Patient)n.getData()).lastname);
					//nextPriority_LBL.setText("<html><b>No more patients left!</b></html>");	// once the last patient has been seen
					finish_LBL.setText("<html>Patient has been seen!</html>");					// couldnt remove the last node without crashing the dll
					dll.size = dll.size-1;														// so reduce the size by 1, to hit the next else statement
				}
				else 
				{
					nextPriority_LBL.setText("<html><b>No more patients left!</b></html>");		// if there are no patients unseen
					finish_LBL.setText("<html>No more patients left!</html>");					// update the text areas to say so
				}
				
				summary_TA.setText("");
				
			}
		});
	}
}
