package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.HospitalSys;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.Color;

public class DeleteFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox hospComboBoxH;
	private JComboBox hospComboBoxD;
	private JComboBox hospComboBoxP;
	private JComboBox doctorComboBoxD;
	private JComboBox doctorComboBoxP;
	private JComboBox patientComboBox;
	private JTextArea textArea;
	
	public DeleteFrame(MainFrame mainFrame) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\hms_icon.png"));
		setTitle("Delete Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 960, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 11, 439, 539);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(textArea);
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				mainFrame.setVisible(true);
				
				dispose();
			}
		});
		closeButton.setBounds(346, 493, 112, 42);
		contentPane.add(closeButton);
		
		JPanel hospitalPane = new JPanel();
		hospitalPane.setBackground(new Color(255, 255, 255));
		hospitalPane.setBounds(10, 63, 464, 407);
		hospitalPane.setVisible(false);
		contentPane.add(hospitalPane);
		
		JPanel doctorPane = new JPanel();
		doctorPane.setBackground(new Color(255, 255, 255));
		doctorPane.setBounds(10, 63, 464, 407);
		doctorPane.setVisible(true);
		contentPane.add(doctorPane);
		
		JPanel patientPane = new JPanel();
		patientPane.setBackground(new Color(255, 255, 255));
		patientPane.setBounds(10, 63, 464, 407);
		contentPane.add(patientPane);
		patientPane.setVisible(false);
		doctorPane.setLayout(null);
		
		JLabel hospNameLblD = new JLabel("Hospital Names :");
		hospNameLblD.setFont(new Font("Dialog", Font.BOLD, 15));
		hospNameLblD.setBounds(37, 18, 304, 17);
		doctorPane.add(hospNameLblD);
		
		JLabel doctorNameLblD = new JLabel("Doctor ID :");
		doctorNameLblD.setFont(new Font("Dialog", Font.BOLD, 15));
		doctorNameLblD.setBounds(37, 149, 304, 17);
		doctorPane.add(doctorNameLblD);
		
		JLabel hospNameLblH = new JLabel("Hospital Names :");
		hospNameLblH.setFont(new Font("Dialog", Font.BOLD, 15));
		hospNameLblH.setBounds(37, 18, 304, 17);
		hospitalPane.add(hospNameLblH);
		
		JLabel hospNameLblP = new JLabel("Hospital Names :");
		hospNameLblP.setBounds(37, 18, 304, 17);
		hospNameLblP.setFont(new Font("Dialog", Font.BOLD, 15));
		patientPane.add(hospNameLblP);
		
		JLabel doctorNameLblP = new JLabel("Doctor Names :");
		doctorNameLblP.setFont(new Font("Dialog", Font.BOLD, 15));
		doctorNameLblP.setBounds(37, 149, 304, 17);
		patientPane.add(doctorNameLblP);
		
	    hospComboBoxH = new JComboBox();
	    hospComboBoxH.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
		hospComboBoxH.setBounds(37, 47, 304, 32);
		hospitalPane.add(hospComboBoxH);
		patientPane.setLayout(null);
		
		hospComboBoxD = new JComboBox();
		hospComboBoxD.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
		hospComboBoxD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hName = hospComboBoxD.getSelectedItem().toString();
				
				if (HospitalSys.displayHospitalDoctorsId(hName).length != 0)
					doctorComboBoxD.setModel(new DefaultComboBoxModel(HospitalSys.displayHospitalDoctorsId(hName)));
				else
					textArea.setText("There is NO doctor in the " + hName);
			}
		});
		hospComboBoxD.setBounds(37, 47, 304, 32);
		doctorPane.add(hospComboBoxD);
		
		hospComboBoxP = new JComboBox();
		hospComboBoxP.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
		hospComboBoxP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hName = hospComboBoxP.getSelectedItem().toString();
				
				if (HospitalSys.displayHospitalDoctorsId(hName).length != 0)
					doctorComboBoxP.setModel(new DefaultComboBoxModel(HospitalSys.displayHospitalDoctorsId(hName)));
				else
					textArea.setText("There is NO doctor in the " + hName);
			}
		});
		hospComboBoxP.setBounds(37, 47, 304, 32);
		patientPane.add(hospComboBoxP);
		
		doctorComboBoxD = new JComboBox();
		doctorComboBoxD.setModel(new DefaultComboBoxModel(HospitalSys.displayHospitalDoctorsId(hospComboBoxD.getSelectedItem().toString())));
		doctorComboBoxD.setBounds(37, 178, 304, 32);
		doctorPane.add(doctorComboBoxD);
		hospitalPane.setLayout(null);
		
		doctorComboBoxP = new JComboBox();
		doctorComboBoxP.setModel(new DefaultComboBoxModel(HospitalSys.displayHospitalDoctorsId(hospComboBoxP.getSelectedItem().toString())));
		doctorComboBoxP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hName = hospComboBoxP.getSelectedItem().toString();
				int docId = Integer.valueOf(doctorComboBoxP.getSelectedItem().toString());
				
				if (HospitalSys.displayDoctorPatientsSsn(hName, docId).length != 0)
					patientComboBox.setModel(new DefaultComboBoxModel(HospitalSys.displayDoctorPatientsSsn(hName, docId)));
				else
					textArea.setText("There is NO patient for the doctor with ID: " + docId);
			}
		});
		doctorComboBoxP.setBounds(37, 178, 304, 32);
		patientPane.add(doctorComboBoxP);
	
		patientComboBox = new JComboBox();
		patientComboBox.setModel(new DefaultComboBoxModel(HospitalSys.displayDoctorPatientsSsn(hospComboBoxP.getSelectedItem().toString(), Integer.valueOf(doctorComboBoxP.getSelectedItem().toString()))));
		patientComboBox.setBounds(37, 304, 304, 32);
		patientPane.add(patientComboBox);
		
		JLabel lblPatientNames = new JLabel("Patient SSN :");
		lblPatientNames.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPatientNames.setBounds(37, 275, 304, 17);
		patientPane.add(lblPatientNames);
		
		JRadioButton hospitalRadioBtn = new JRadioButton("Hospital");
		hospitalRadioBtn.setBackground(new Color(255, 255, 255));
		hospitalRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (HospitalSys.getHospitalAL().size() != 0) {
					doctorPane.setVisible(false);
					patientPane.setVisible(false);
					hospitalPane.setVisible(true);			
				} else {
					textArea.setText("There is NO hospital in the System!");
					emptyAllComboBoxes();
				}
			}
		});
		hospitalRadioBtn.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(hospitalRadioBtn);
		hospitalRadioBtn.setBounds(29, 11, 112, 40);
		contentPane.add(hospitalRadioBtn);
		
		JRadioButton doctorRadioBtn = new JRadioButton("Doctor");
		doctorRadioBtn.setSelected(true);
		doctorRadioBtn.setBackground(new Color(255, 255, 255));
		doctorRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (HospitalSys.getHospitalAL().size() != 0) {
					doctorPane.setVisible(true);
					patientPane.setVisible(false);
					hospitalPane.setVisible(false);			
				} else {
					textArea.setText("There is NO hospital in the System!");
					emptyAllComboBoxes();
				}
			}
		});
		doctorRadioBtn.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(doctorRadioBtn);
		doctorRadioBtn.setBounds(187, 11, 112, 40);
		contentPane.add(doctorRadioBtn);
		
		JRadioButton patientRadioBtn = new JRadioButton("Patient");
		patientRadioBtn.setBackground(new Color(255, 255, 255));
		patientRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (HospitalSys.getHospitalAL().size() != 0) {
					doctorPane.setVisible(false);
					patientPane.setVisible(true);
					hospitalPane.setVisible(false);			
				} else {
					textArea.setText("There is NO hospital in the System!");
					emptyAllComboBoxes();
				}
				
				if (doctorComboBoxP.getSelectedItem().toString().equalsIgnoreCase("No doctors!"))
					patientComboBox.setModel(new DefaultComboBoxModel(new String[] {"No patient!"}));
			}
		});
		patientRadioBtn.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(patientRadioBtn);
		patientRadioBtn.setBounds(346, 11, 112, 40);
		contentPane.add(patientRadioBtn);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hName;
				int docId, ssn;
				
				if (hospitalRadioBtn.isSelected()) {
					
					hName = hospComboBoxH.getSelectedItem().toString();
					
					if (HospitalSys.deleteHospital(hName)) {
						textArea.setText("Hospital named [" + hName + "] is deleted!");
							
					} else
						textArea.setText("Hospital named [" + hName + "] is NOT deleted!");
					
				}
				else if (doctorRadioBtn.isSelected()) {
					
					hName = hospComboBoxD.getSelectedItem().toString();
					
					if (!doctorComboBoxD.getSelectedItem().toString().equalsIgnoreCase("No doctors!")) {
						docId = Integer.valueOf(doctorComboBoxD.getSelectedItem().toString());
					
						if (HospitalSys.deleteDoctor(hName, docId))
							textArea.setText("Doctor with id [" + docId + "] is removed!");
						else 
							textArea.setText("Doctor with id [" + docId + "] is NOT removed!");
					}
					
				}
				else if (patientRadioBtn.isSelected()) {
					
					hName = hospComboBoxP.getSelectedItem().toString();
					
					if (!doctorComboBoxP.getSelectedItem().toString().equalsIgnoreCase("No doctors!") && !patientComboBox.getSelectedItem().toString().equalsIgnoreCase("No patient!")) {
					
						docId = Integer.valueOf(doctorComboBoxP.getSelectedItem().toString());
						ssn = Integer.valueOf(patientComboBox.getSelectedItem().toString());
					
						if (HospitalSys.deletePatient(hName, docId, ssn))
							textArea.setText("Patient with ssn [" + ssn + "] is removed!");
						else
							textArea.setText("Patient with ssn [" + ssn + "] is NOT removed!");
					}
						
				}
									
				
				// necessary combobox update
				updateComboBoxes();
			}
		});
		deleteButton.setBounds(29, 493, 112, 42);
		contentPane.add(deleteButton);
		
	}
	
	public void updateComboBoxes() {
		
		try {
			hospComboBoxH.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
			hospComboBoxD.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
			hospComboBoxP.setModel(new DefaultComboBoxModel(HospitalSys.displayAllHospitalName()));
		
			doctorComboBoxD.setModel(new DefaultComboBoxModel(HospitalSys.displayHospitalDoctorsId(hospComboBoxD.getSelectedItem().toString())));
			doctorComboBoxP.setModel(new DefaultComboBoxModel(HospitalSys.displayHospitalDoctorsId(hospComboBoxP.getSelectedItem().toString())));
			
			if (!(doctorComboBoxP.getSelectedItem().toString().equalsIgnoreCase("No doctors!")))
				patientComboBox.setModel(new DefaultComboBoxModel(HospitalSys.displayDoctorPatientsSsn(hospComboBoxP.getSelectedItem().toString(), Integer.valueOf(doctorComboBoxP.getSelectedItem().toString()))));
			
		} catch (Exception e) {
			textArea.setText("There is problem with data in the System.");
		}
	}
	
	public void emptyAllComboBoxes() {
		
		hospComboBoxH.setModel(new DefaultComboBoxModel(new String[] {""}));
		hospComboBoxD.setModel(new DefaultComboBoxModel(new String[] {""}));
		hospComboBoxP.setModel(new DefaultComboBoxModel(new String[] {""}));
	
		doctorComboBoxD.setModel(new DefaultComboBoxModel(new String[] {""}));
		doctorComboBoxP.setModel(new DefaultComboBoxModel(new String[] {""}));
	
		patientComboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
	}
}
