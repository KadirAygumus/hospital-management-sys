package GUI;
import Classes.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.Color;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField hospitalNameTf;
	private JTextField hospitalYearTf;
	private JTextField hospitalCityTf;
	private JTextField docNameTf;
	private JTextField docSurnameTf;
	private final ButtonGroup genderButtonGroup = new ButtonGroup();
	private JTextField docIdTf;
	private JTextField docAgeTf;
	private JTextField docWeightTf;
	private JTextField docHeightTf;
	private JTextField docSalaryTf;
	private JTextField docDeptTf;
	private JTextField patNameTf;
	private JTextField patSurnameTf;
	private JTextField patSsnTf;
	private final ButtonGroup patGenderButtonGroup = new ButtonGroup();
	private JTextField patAgeTf;
	private JTextField patDiseaseTf;
	private JTextField patHeightTf;
	private JTextField patWeightTf;
	private JTextField hospitalManPswdTf;
	private JTextField hospitalManIdTf;
	private JTextField docPswdTf;
	private JComboBox hospitalComboBoxP;
	private JComboBox hospitalComboBox;
	private JComboBox doctorComboBox;
	
	/**
	 * Create the frame.
	 */
	public AddFrame(MainFrame mainFrame) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\hms_icon.png"));
		setTitle("Add Information");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 960, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(470, 23, 474, 524);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(textArea);
		
		
		JPanel hospitalPanel = new JPanel();
		hospitalPanel.setBackground(new Color(255, 255, 255));
		hospitalPanel.setBounds(10, 63, 450, 407);
		contentPane.add(hospitalPanel);
		hospitalPanel.setLayout(null);
		hospitalPanel.setVisible(true);
		
		JLabel hospitalNameLbl = new JLabel("Hospital Name :");
		hospitalNameLbl.setBounds(37, 58, 160, 17);
		hospitalPanel.add(hospitalNameLbl);
		
		JLabel hospitalFoundYearLbl = new JLabel("Founded Year :");
		hospitalFoundYearLbl.setBounds(37, 118, 160, 17);
		hospitalPanel.add(hospitalFoundYearLbl);
		
		JLabel hospitalCityLbl = new JLabel("City :");
		hospitalCityLbl.setBounds(37, 176, 160, 17);
		hospitalPanel.add(hospitalCityLbl);
		
		hospitalNameTf = new JTextField();
		hospitalNameTf.setBounds(215, 56, 205, 21);
		hospitalPanel.add(hospitalNameTf);
		hospitalNameTf.setColumns(10);
		
		hospitalYearTf = new JTextField();
		hospitalYearTf.setBounds(215, 116, 205, 21);
		hospitalPanel.add(hospitalYearTf);
		hospitalYearTf.setColumns(10);
		
		hospitalCityTf = new JTextField();
		hospitalCityTf.setBounds(215, 174, 205, 21);
		hospitalPanel.add(hospitalCityTf);
		hospitalCityTf.setColumns(10);
		
		JLabel hospitalManPwdLbl = new JLabel("Password of the Hospital Manager :");
		hospitalManPwdLbl.setBounds(37, 310, 230, 17);
		hospitalPanel.add(hospitalManPwdLbl);
		
		hospitalManPswdTf = new JTextField();
		hospitalManPswdTf.setBounds(37, 335, 383, 21);
		hospitalPanel.add(hospitalManPswdTf);
		hospitalManPswdTf.setColumns(10);
		
		JLabel hospitalManIdLbl = new JLabel("Hospital Manager Id :");
		hospitalManIdLbl.setBounds(37, 235, 230, 17);
		hospitalPanel.add(hospitalManIdLbl);
		
		hospitalManIdTf = new JTextField();
		hospitalManIdTf.setBounds(37, 260, 383, 21);
		hospitalPanel.add(hospitalManIdTf);
		hospitalManIdTf.setColumns(10);
		
		JPanel patientPanel = new JPanel();
		patientPanel.setBackground(new Color(255, 255, 255));
		patientPanel.setBounds(10, 63, 450, 407);
		contentPane.add(patientPanel);
		patientPanel.setLayout(null);
		patientPanel.setVisible(false);
		
		JLabel hospitalNamesLblPat = new JLabel("Hospital Names :");
		hospitalNamesLblPat.setBounds(12, 17, 132, 17);
		patientPanel.add(hospitalNamesLblPat);
		
		
		JLabel lblDoctorNames = new JLabel("Doctor Names :");
		lblDoctorNames.setBounds(12, 138, 132, 17);
		patientPanel.add(lblDoctorNames);
		
		doctorComboBox = new JComboBox();
		doctorComboBox.setBounds(151, 133, 279, 26);
		patientPanel.add(doctorComboBox);
		
		JLabel patNameLbl = new JLabel("Name :");
		patNameLbl.setBounds(12, 249, 60, 17);
		patientPanel.add(patNameLbl);
		
		patNameTf = new JTextField();
		patNameTf.setBounds(73, 249, 114, 21);
		patientPanel.add(patNameTf);
		patNameTf.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname :");
		lblSurname.setBounds(227, 249, 60, 17);
		patientPanel.add(lblSurname);
		
		patSurnameTf = new JTextField();
		patSurnameTf.setBounds(316, 249, 114, 21);
		patientPanel.add(patSurnameTf);
		patSurnameTf.setColumns(10);
		
		JLabel lblSocialSecNum = new JLabel("SSN :");
		lblSocialSecNum.setBounds(12, 285, 60, 17);
		patientPanel.add(lblSocialSecNum);
		
		patSsnTf = new JTextField();
		patSsnTf.setBounds(73, 285, 114, 21);
		patientPanel.add(patSsnTf);
		patSsnTf.setColumns(10);
		
		JRadioButton rdbtnMaleP = new JRadioButton("Male");
		rdbtnMaleP.setBackground(new Color(255, 255, 255));
		patGenderButtonGroup.add(rdbtnMaleP);
		patGenderButtonGroup.add(rdbtnMaleP);
		rdbtnMaleP.setBounds(240, 282, 75, 25);
		patientPanel.add(rdbtnMaleP);
		
		JRadioButton rdbtnFemaleP = new JRadioButton("Female");
		rdbtnFemaleP.setBackground(new Color(255, 255, 255));
		patGenderButtonGroup.add(rdbtnFemaleP);
		patGenderButtonGroup.add(rdbtnFemaleP);
		rdbtnFemaleP.setBounds(330, 282, 75, 25);
		patientPanel.add(rdbtnFemaleP);
		
		JLabel patAgeLbl = new JLabel("Age :");
		patAgeLbl.setBounds(12, 320, 60, 17);
		patientPanel.add(patAgeLbl);
		
		patAgeTf = new JTextField();
		patAgeTf.setBounds(73, 320, 114, 21);
		patientPanel.add(patAgeTf);
		patAgeTf.setColumns(10);
		
		JLabel patDiseaseLbl = new JLabel("Disease :");
		patDiseaseLbl.setBounds(227, 320, 60, 17);
		patientPanel.add(patDiseaseLbl);
		
		patDiseaseTf = new JTextField();
		patDiseaseTf.setBounds(316, 320, 114, 21);
		patientPanel.add(patDiseaseTf);
		patDiseaseTf.setColumns(10);
		
		JLabel patHeightLbl = new JLabel("Height :");
		patHeightLbl.setBounds(12, 353, 60, 17);
		patientPanel.add(patHeightLbl);
		
		patHeightTf = new JTextField();
		patHeightTf.setBounds(73, 353, 114, 21);
		patientPanel.add(patHeightTf);
		patHeightTf.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(227, 353, 60, 17);
		patientPanel.add(lblWeight);
		
		patWeightTf = new JTextField();
		patWeightTf.setBounds(316, 353, 114, 21);
		patientPanel.add(patWeightTf);
		patWeightTf.setColumns(10);
		
		
		JPanel doctorPanel = new JPanel();
		doctorPanel.setBackground(new Color(255, 255, 255));
		doctorPanel.setBounds(10, 63, 450, 407);
		contentPane.add(doctorPanel);
		doctorPanel.setLayout(null);
		doctorPanel.setVisible(false);
		
		hospitalComboBox = new JComboBox();
		hospitalComboBox.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
		hospitalComboBox.setBounds(151, 12, 271, 26);
		doctorPanel.add(hospitalComboBox);
		
		JLabel docNameLbl = new JLabel("Name :");
		docNameLbl.setBounds(12, 168, 68, 17);
		doctorPanel.add(docNameLbl);
		
		JLabel docSurnameLbl = new JLabel("Surname :");
		docSurnameLbl.setBounds(239, 168, 68, 17);
		doctorPanel.add(docSurnameLbl);
		
		docNameTf = new JTextField();
		docNameTf.setBounds(62, 168, 132, 21);
		doctorPanel.add(docNameTf);
		docNameTf.setColumns(10);
		
		docSurnameTf = new JTextField();
		docSurnameTf.setBounds(308, 168, 130, 21);
		doctorPanel.add(docSurnameTf);
		docSurnameTf.setColumns(10);
		
		JRadioButton rdbtnMaleD = new JRadioButton("Male");
		rdbtnMaleD.setBackground(new Color(255, 255, 255));
		genderButtonGroup.add(rdbtnMaleD);
		rdbtnMaleD.setBounds(12, 200, 68, 25);
		doctorPanel.add(rdbtnMaleD);
		
		JRadioButton rdbtnFemaleD = new JRadioButton("Female");
		rdbtnFemaleD.setBackground(new Color(255, 255, 255));
		genderButtonGroup.add(rdbtnFemaleD);
		rdbtnFemaleD.setBounds(113, 200, 81, 25);
		doctorPanel.add(rdbtnFemaleD);
		
		JLabel docIdLbl = new JLabel("Id :");
		docIdLbl.setBounds(244, 204, 60, 17);
		doctorPanel.add(docIdLbl);
		
		docIdTf = new JTextField();
		docIdTf.setBounds(308, 204, 130, 21);
		doctorPanel.add(docIdTf);
		docIdTf.setColumns(10);
		
		JLabel docAgeLbl = new JLabel("Age :");
		docAgeLbl.setBounds(12, 245, 48, 17);
		doctorPanel.add(docAgeLbl);
		
		docAgeTf = new JTextField();
		docAgeTf.setBounds(74, 245, 120, 21);
		doctorPanel.add(docAgeTf);
		docAgeTf.setColumns(10);
		
		JLabel docHeightLbl = new JLabel("Height :");
		docHeightLbl.setBounds(239, 285, 65, 17);
		doctorPanel.add(docHeightLbl);
		
		docWeightTf = new JTextField();
		docWeightTf.setBounds(72, 285, 122, 21);
		doctorPanel.add(docWeightTf);
		docWeightTf.setColumns(10);
		
		JLabel docWeightLbl = new JLabel("Weight :");
		docWeightLbl.setBounds(12, 285, 60, 17);
		doctorPanel.add(docWeightLbl);
		
		docHeightTf = new JTextField();
		docHeightTf.setBounds(308, 285, 130, 21);
		doctorPanel.add(docHeightTf);
		docHeightTf.setColumns(10);
		
		JLabel docSalaryLbl = new JLabel("Salary :");
		docSalaryLbl.setBounds(239, 245, 60, 17);
		doctorPanel.add(docSalaryLbl);
		
		docSalaryTf = new JTextField();
		docSalaryTf.setBounds(308, 245, 130, 21);
		doctorPanel.add(docSalaryTf);
		docSalaryTf.setColumns(10);
		
		JLabel docDeptLbl = new JLabel("Department :");
		docDeptLbl.setBounds(12, 325, 103, 17);
		doctorPanel.add(docDeptLbl);
		
		JRadioButton doctorRadioBtn = new JRadioButton("Doctor");
		doctorRadioBtn.setBackground(new Color(255, 255, 255));
		buttonGroup.add(doctorRadioBtn);
		doctorRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (HospitalSys.displayAllHospitalName().length == 0)
					hospitalComboBox.setModel(new DefaultComboBoxModel(new String[] {"No hospitals!"}));
					
				hospitalPanel.setVisible(false);
				doctorPanel.setVisible(true);
				patientPanel.setVisible(false);
			}
		});
		doctorRadioBtn.setHorizontalAlignment(SwingConstants.LEFT);
		doctorRadioBtn.setBounds(187, 11, 112, 40);
		contentPane.add(doctorRadioBtn);
		
		JRadioButton patientRadioBtn = new JRadioButton("Patient");
		patientRadioBtn.setBackground(new Color(255, 255, 255));
		buttonGroup.add(patientRadioBtn);
		patientRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hospitalPanel.setVisible(false);
				doctorPanel.setVisible(false);
				patientPanel.setVisible(true);
				
				hospitalComboBoxP.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
				String hName = hospitalComboBoxP.getSelectedItem().toString();
				doctorComboBox.setModel(new DefaultComboBoxModel(HospitalSys.displayHospitalDoctorsId(hName)));
			}
		});
		patientRadioBtn.setHorizontalAlignment(SwingConstants.LEFT);
		patientRadioBtn.setBounds(346, 11, 112, 40);
		contentPane.add(patientRadioBtn);
		
		JRadioButton hospitalRadioBtn = new JRadioButton("Hospital");
		hospitalRadioBtn.setBackground(new Color(255, 255, 255));
		buttonGroup.add(hospitalRadioBtn);
		hospitalRadioBtn.setSelected(true);
		hospitalRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctorPanel.setVisible(false);
				patientPanel.setVisible(false);
				hospitalPanel.setVisible(true);
			}
		});
		
		docDeptTf = new JTextField();
		docDeptTf.setBounds(112, 325, 192, 21);
		doctorPanel.add(docDeptTf);
		docDeptTf.setColumns(10);
		
		JLabel hospitalNamesLbl = new JLabel("Hospital Names :");
		hospitalNamesLbl.setBounds(12, 17, 132, 17);
		doctorPanel.add(hospitalNamesLbl);
		
		JLabel docPswdLbl = new JLabel("Doctor Password :");
		docPswdLbl.setBounds(12, 367, 122, 17);
		doctorPanel.add(docPswdLbl);
		
		docPswdTf = new JTextField();
		docPswdTf.setBounds(141, 365, 289, 21);
		doctorPanel.add(docPswdTf);
		docPswdTf.setColumns(10);
		hospitalRadioBtn.setHorizontalAlignment(SwingConstants.LEFT);
		hospitalRadioBtn.setBounds(29, 11, 112, 40);
		contentPane.add(hospitalRadioBtn);
		
		hospitalComboBoxP = new JComboBox();
		hospitalComboBoxP.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
		hospitalComboBoxP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hName = hospitalComboBoxP.getSelectedItem().toString();
				
				if (hName.equalsIgnoreCase("No hospitals!"))
					doctorComboBox.setModel(new DefaultComboBoxModel(new String[] {"No doctors!"}));
				else
					doctorComboBox.setModel(new DefaultComboBoxModel(HospitalSys.displayHospitalDoctorsId(hName)));
			}
		});
		hospitalComboBoxP.setBounds(151, 12, 279, 26);
		patientPanel.add(hospitalComboBoxP);
		
		JButton addButton = new JButton("Add Info");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String city, name, surname, docId, year, manId, manPwd, age, salary, weight, height, dept, docPwd, gender = "?", ssn, disease, output = "";
				
				if (hospitalRadioBtn.isSelected()) {
	                
					name = hospitalNameTf.getText();
	                year = hospitalYearTf.getText();
	                city = hospitalCityTf.getText();
	                manId = hospitalManIdTf.getText();
	                manPwd = hospitalManPswdTf.getText();
					
					if (name.isEmpty() || year.isEmpty() || city.isEmpty() || city.isEmpty() || manId.isEmpty() || manPwd.isEmpty())
						output += "Missing inputs!! Please insert all the information!";
					else {						
						try {

							int y = Integer.parseInt(year);
							int id = Integer.parseInt(manId);
							
							output += (HospitalSys.addHospital(new Hospital(name, y, city, id, manPwd))) ? "New Hospital is added to the System." 
									: "Hospital can not be added to the System, SAME HOSPITAL ID";
							
						} catch (NumberFormatException exc) {
							output += "Number Format Excepiton" + "\n" + "Please enter integers to the integers input sides!";
						}
					}
				}
				else if (doctorRadioBtn.isSelected()) {
					
					 name = docNameTf.getText();
	                 surname = docSurnameTf.getText();
	                 docId = docIdTf.getText();
	                 gender = (rdbtnFemaleD.isSelected()) ? "F" : "M";
	                 age = docAgeTf.getText();
	                 salary = docSalaryTf.getText();
	                 weight = docWeightTf.getText();
	                 height = docHeightTf.getText();
	                 dept = docDeptTf.getText();
	                 docPwd = docPswdTf.getText();
					
	                 if (name.isEmpty() || surname.isEmpty() || docId.isEmpty() || age.isEmpty() || salary.isEmpty() || weight.isEmpty() || height.isEmpty() 
	                		 || dept.isEmpty() || docPwd.isEmpty())
	                	 output += "Missing inputs!! Please insert all the information!";
	                 else {
	                	try {
	                		int doctorId = Integer.parseInt(docId);
	                		int doctorAge = Integer.parseInt(age);
	                		double doctorSalary = Double.parseDouble(salary);
	                		double wei = Double.parseDouble(weight); 
	                		double hei = Double.parseDouble(height);
	                		
	                		String hName = hospitalComboBox.getSelectedItem().toString();
	                		
	                		if (hName.equalsIgnoreCase("No hospitals!"))
	                			output+= "No hospital found!";
	                		else
	                			output += (HospitalSys.addDoctor(hName, new Doctor(name, surname, gender, doctorAge, wei, hei, doctorId, doctorSalary, dept, docPwd))) ? 
	                				"New Doctor is added to the selected hospital!" : "Doctor cannot be added to the selected hospital, SAME ID";
	                		
	                	} catch (NumberFormatException exc) {
	                		output += "Number Format Excepiton" + "\n" + "Please enter integers to the integers input sides!";
	                	}              	 
	                 }
				}
				else if (patientRadioBtn.isSelected()) {
					
					name = patNameTf.getText();
                    surname = patSurnameTf.getText();
                    ssn = patSsnTf.getText();
                    gender = (rdbtnFemaleP.isSelected()) ? "F" : "M";
                    age = patAgeTf.getText();
                    disease = patDiseaseTf.getText();
                    height = patHeightTf.getText();
                    weight = patWeightTf.getText();
					
                    if (name.isEmpty() || surname.isEmpty() || age.isEmpty() || weight.isEmpty() || height.isEmpty() || ssn.isEmpty() || gender.isEmpty() || disease.isEmpty())
                    	output += "Missing inputs!! Please insert all the information!";
                    else {
                    	try {
                    		int patientAge = Integer.parseInt(age);
                    		double wei = Double.parseDouble(weight);
                    		double hei = Double.parseDouble(height);
                    		int patientSsn = Integer.parseInt(ssn);
                    		
                    		String hName = hospitalComboBoxP.getSelectedItem().toString();
                    		String idOfDoc = doctorComboBox.getSelectedItem().toString();
                    		
                    		if (hName.equalsIgnoreCase("No hospitals!") || idOfDoc.equalsIgnoreCase("No doctors!"))
                    			output += "No hospitals or doctors found!";
                    		else
                    			output += (HospitalSys.addPatient(hName, Integer.valueOf(idOfDoc), new Patient(name, surname, gender, patientAge, wei, hei, patientSsn, disease))) ? 
                    				"New Patient is added to the selected hospitals selected doctor!!" : "Patient cannot be added to the selected hospitals selected doctor, SAME SSN";	
                    	} catch (NumberFormatException exc) {
                    		output += "Number Format Excepiton" + "\n" + "Please enter integers to the integers input sides!";
                    	}
                    }
				}
				
				textArea.setText(output);
				
				hospitalComboBox.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
				hospitalComboBoxP.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
			}
		});
		addButton.setBounds(20, 493, 112, 42);
		contentPane.add(addButton);
		
		JButton calculateButton = new JButton("Calculate All");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// for all patient and doctors, calculate something :)
				// do smt
				
				textArea.setText("All doctors and patients calculations' are implemented!");
			}
		});
		calculateButton.setBounds(164, 493, 112, 42);
		contentPane.add(calculateButton);
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(true);
				dispose();
			}
		});
		closeButton.setBounds(318, 493, 112, 42);
		contentPane.add(closeButton);
	}
}