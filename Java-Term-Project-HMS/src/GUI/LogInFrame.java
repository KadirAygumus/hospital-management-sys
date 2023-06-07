package GUI;

import Classes.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.HospitalSys;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;

public class LogInFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup logInPersonGroup = new ButtonGroup();
	private JTextField managerIdText;
	private JPasswordField managerPswdText;
	private JTextField doctorIdText;
	private JPasswordField doctorPswdText;

	/**
	 * Create the frame.
	 */
	public LogInFrame(MainFrame mainFrame) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\hms_icon.png"));
		setTitle("System Log In Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 743, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(405, 65, 287, 345);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 204));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JPanel hospitalManagerPanel = new JPanel();
		hospitalManagerPanel.setBackground(new Color(255, 255, 255));
		hospitalManagerPanel.setBounds(32, 97, 327, 235);
		contentPane.add(hospitalManagerPanel);
		hospitalManagerPanel.setLayout(null);
		hospitalManagerPanel.setVisible(true);
		
		JLabel hospitalManIdLbl = new JLabel("Enter Hospital Manager ID :");
		hospitalManIdLbl.setFont(new Font("Dialog", Font.BOLD, 13));
		hospitalManIdLbl.setBounds(30, 50, 256, 24);
		hospitalManagerPanel.add(hospitalManIdLbl);
		
		managerIdText = new JTextField();
		managerIdText.setBounds(30, 86, 256, 26);
		hospitalManagerPanel.add(managerIdText);
		managerIdText.setColumns(10);
		
		JLabel hospitalPswdLbl = new JLabel("Enter Hospital Manager Password :");
		hospitalPswdLbl.setFont(new Font("Dialog", Font.BOLD, 13));
		hospitalPswdLbl.setBounds(30, 143, 256, 24);
		hospitalManagerPanel.add(hospitalPswdLbl);
		
		managerPswdText = new JPasswordField();
		managerPswdText.setBounds(30, 176, 256, 26);
		hospitalManagerPanel.add(managerPswdText);
		
		JPanel doctorPanel = new JPanel();
		doctorPanel.setBackground(new Color(255, 255, 255));
		doctorPanel.setBounds(32, 97, 327, 235);
		contentPane.add(doctorPanel);
		doctorPanel.setLayout(null);
		doctorPanel.setVisible(false);
		
		JLabel doctorIdLbl = new JLabel("Enter Doctor ID :");
		doctorIdLbl.setFont(new Font("Dialog", Font.BOLD, 13));
		doctorIdLbl.setBounds(30, 50, 256, 24);
		doctorPanel.add(doctorIdLbl);
		
		doctorIdText = new JTextField();
		doctorIdText.setColumns(10);
		doctorIdText.setBounds(30, 80, 256, 26);
		doctorPanel.add(doctorIdText);
		
		JLabel doctorPswdLbl = new JLabel("Enter Doctor's Password :");
		doctorPswdLbl.setFont(new Font("Dialog", Font.BOLD, 13));
		doctorPswdLbl.setBounds(30, 139, 256, 24);
		doctorPanel.add(doctorPswdLbl);
		
		doctorPswdText = new JPasswordField();
		doctorPswdText.setBounds(30, 163, 256, 26);
		doctorPanel.add(doctorPswdText);
		
		JCheckBox doctorCheckBox = new JCheckBox("Doctor");
		doctorCheckBox.setBackground(new Color(255, 255, 255));
		doctorCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctorPanel.setVisible(true);
				hospitalManagerPanel.setVisible(false);
			}
		});
		doctorCheckBox.setBounds(239, 45, 76, 25);
		logInPersonGroup.add(doctorCheckBox);
		contentPane.add(doctorCheckBox);
		
		JCheckBox hospitalManagerCheckBox = new JCheckBox("Hospital Manager");
		hospitalManagerCheckBox.setBackground(new Color(255, 255, 255));
		hospitalManagerCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctorPanel.setVisible(false);
				hospitalManagerPanel.setVisible(true);
			}
		});
		hospitalManagerCheckBox.setSelected(true);
		hospitalManagerCheckBox.setBounds(57, 45, 141, 25);
		logInPersonGroup.add(hospitalManagerCheckBox);
		contentPane.add(hospitalManagerCheckBox);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(42, 345, 332, 38);
		contentPane.add(errorLabel);
		
		JButton loginButton = new JButton("LOG IN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String loginOutput = "", error = "", id, pwd;
				
				if (hospitalManagerCheckBox.isSelected()) {
					
					id = managerIdText.getText();
					pwd = new String(managerPswdText.getPassword());
					
					if (id.isEmpty() || pwd.isEmpty())
						error = "Id or Password part cannot be empty!";
					else {
						
						try {
							
							int manId = Integer.parseInt(id);
							
							if (HospitalSys.managerLogin(manId, pwd) != null)
								loginOutput = HospitalSys.managerLogin(manId, pwd);
							else
								error = "Sorry, something get wrong. Please double check password and Id field.";
							
						} catch (NumberFormatException exc) {
							error = "Id must be integer!";
						}
					}
					
				} else if (doctorCheckBox.isSelected()) {
					
					id = doctorIdText.getText();
					pwd = new String(doctorPswdText.getPassword());
					
					if (id.isEmpty() || pwd.isEmpty())
						error = "Id or Password part cannot be empty!";
					else {
					
						try {
							
							int docId = Integer.parseInt(id);
							
							if (HospitalSys.doctorLogin(docId, pwd) != null)
								loginOutput = HospitalSys.doctorLogin(docId, pwd);
							else
								error = "Sorry, something get wrong. Please double check password and Id field.";
								
						} catch (NumberFormatException exc) {
							error = "Id must be integer!"; 
						}
					}
				}
				
				textArea.setText(loginOutput);
				errorLabel.setText(error);
			}
		});
		loginButton.setBounds(57, 400, 112, 38);
		contentPane.add(loginButton);
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(222, 400, 112, 38);
		contentPane.add(btnNewButton);

	}
}
