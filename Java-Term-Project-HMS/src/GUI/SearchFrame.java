package GUI;

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

import Classes.*;

import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.Color;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField hospitalNameTf;
	private JTextField doctorIdTf;
	private JTextField patientSsnTf;

	/**
	 * Create the frame.
	 */
	public SearchFrame(MainFrame mainFrame) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\hms_icon.png"));
		setTitle("Search Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 960, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 24, 420, 341);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(textArea);
		
		JPanel hospitalPane = new JPanel();
		hospitalPane.setBackground(new Color(255, 255, 255));
		hospitalPane.setBounds(10, 63, 464, 135);
		contentPane.add(hospitalPane);
		hospitalPane.setLayout(null);
		
		JLabel hospitalNameEnterLbl = new JLabel("Enter Hospital Name :");
		hospitalNameEnterLbl.setFont(new Font("Dialog", Font.BOLD, 15));
		hospitalNameEnterLbl.setBounds(26, 47, 260, 23);
		hospitalPane.add(hospitalNameEnterLbl);
		
		hospitalNameTf = new JTextField();
		hospitalNameTf.setBounds(26, 90, 330, 23);
		hospitalPane.add(hospitalNameTf);
		hospitalNameTf.setColumns(10);
		
		JPanel doctorPane = new JPanel();
		doctorPane.setBackground(new Color(255, 255, 255));
		doctorPane.setBounds(10, 63, 464, 135);
		contentPane.add(doctorPane);
		
		JPanel patientPane = new JPanel();
		patientPane.setBackground(new Color(255, 255, 255));
		patientPane.setBounds(10, 63, 464, 135);
		contentPane.add(patientPane);
		doctorPane.setLayout(null);
		
		JLabel doctorIdLbl = new JLabel("Enter Doctor ID :");
		doctorIdLbl.setFont(new Font("Dialog", Font.BOLD, 15));
		doctorIdLbl.setBounds(26, 47, 260, 23);
		doctorPane.add(doctorIdLbl);
		
		doctorIdTf = new JTextField();
		doctorIdTf.setColumns(10);
		doctorIdTf.setBounds(26, 90, 330, 23);
		doctorPane.add(doctorIdTf);
		patientPane.setLayout(null);
		
		JLabel patentSsnLbl = new JLabel("Enter Patient's Social Security Number (SSN) :");
		patentSsnLbl.setFont(new Font("Dialog", Font.BOLD, 15));
		patentSsnLbl.setBounds(26, 47, 379, 23);
		patientPane.add(patentSsnLbl);
		
		patientSsnTf = new JTextField();
		patientSsnTf.setColumns(10);
		patientSsnTf.setBounds(26, 90, 330, 23);
		patientPane.add(patientSsnTf);
		
		JRadioButton hospitalRadioBtn = new JRadioButton("Hospital");
		hospitalRadioBtn.setBackground(new Color(255, 255, 255));
		buttonGroup.add(hospitalRadioBtn);
		hospitalRadioBtn.setSelected(true);
		hospitalRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctorPane.setVisible(false);
				patientPane.setVisible(false);
				hospitalPane.setVisible(true);
			}
		});
		hospitalRadioBtn.setHorizontalAlignment(SwingConstants.LEFT);
		hospitalRadioBtn.setBounds(29, 11, 112, 40);
		contentPane.add(hospitalRadioBtn);
		
		JRadioButton doctorRadioBtn = new JRadioButton("Doctor");
		doctorRadioBtn.setBackground(new Color(255, 255, 255));
		buttonGroup.add(doctorRadioBtn);
		doctorRadioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hospitalPane.setVisible(false);
				doctorPane.setVisible(true);
				patientPane.setVisible(false);
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
				hospitalPane.setVisible(false);
				doctorPane.setVisible(false);
				patientPane.setVisible(true);
			}
		});
		patientRadioBtn.setHorizontalAlignment(SwingConstants.LEFT);
		patientRadioBtn.setBounds(346, 11, 112, 40);
		contentPane.add(patientRadioBtn);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setBackground(new Color(255, 255, 255));
		errorLabel.setBounds(29, 235, 445, 57);
		contentPane.add(errorLabel);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String output = "", error= "";
				
				if (hospitalRadioBtn.isSelected()) {
				
					String hName = hospitalNameTf.getText();
				
					if (hName.isEmpty()) {
						error = "Hospital name text field cannot be empty!";
					} else {
					
						Hospital h = HospitalSys.searchHospital(hName);
						
						if (h != null)
							output = h.toString();
						else
							output = "There is not hospital with the name " + hName;
					}
			
				} else if (doctorRadioBtn.isSelected()) {
					
					String docId = doctorIdTf.getText();
					
					if (docId.isEmpty()) {
						error = "Doctor id text field cannot be empty!";
					} else {
						
						try {
							
							int id = Integer.parseInt(docId);
							
							output = HospitalSys.searchAndDisplayDoctor(id);
							
							if (output == null)
								output = "There is no doctor with the id " + id;
							
						} catch (NumberFormatException exc) {
							error = "Doctor id must be integers!";
						}
					}
					
				} else if (patientRadioBtn.isSelected()) {
				
					String ssnStr = patientSsnTf.getText();
					
					if (ssnStr.isEmpty()) {
						error = "Patient ssn text field cannot be empty!";
					} else {
						
						try {
							
							int ssn = Integer.parseInt(ssnStr);
							
							output = HospitalSys.searchAndDisplayPatient(ssn);
							
							if (output == null)
								output = "There is no patient with the ssn " + ssn;
							
						} catch (NumberFormatException exc) {
							error = "Patient ssn must be integers!";
						}
					}
				}
				
				errorLabel.setText(error);
				textArea.setText(output);
			}
		});
		searchButton.setBounds(29, 323, 112, 42);
		contentPane.add(searchButton);
		
		JButton displayAllButton = new JButton("Display All");
		displayAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String output = "";
				
				output = HospitalSys.displayAllContent();
				
				textArea.setText(output);
			}
		});
		displayAllButton.setBounds(187, 323, 112, 42);
		contentPane.add(displayAllButton);
		
		JButton closeButton = new JButton("CLOSE");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(true);
				dispose();
			}
		});
		closeButton.setBounds(346, 323, 112, 42);
		contentPane.add(closeButton);
	}
}
