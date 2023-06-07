package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Doctor;
import Classes.Hospital;
import Classes.HospitalSys;
import Classes.Patient;

import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	AddFrame addFrame = new AddFrame(this);
	DeleteFrame deleteFrame = new DeleteFrame(this);
	SearchFrame searchFrame = new SearchFrame(this);
	LogInFrame loginFrame = new LogInFrame(this);
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Hospital Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\hms_icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 924, 617);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 24, 282, 423);
		contentPane.add(scrollPane);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 12));
		txtArea.setBackground(new Color(255, 252, 206));
		txtArea.setText("  Press the \"Read Data\" button\r\n\r\n  Data ==\r\n\t  - Ankara Hastanesi \r\n\t  - Doctor with 2 Patients\r\n\t  - Doctor with 1 Patient\r\n  - Istanbul Hastanesi\r\n\t  - Doctor with 1 Patient\r\n\t  - Doctor with 2 Patient\r\n  - Bolu Hastanesi\r\n\t  - Doctor with 1 Patient\r\n\t  - Doctor with 2 Patients\r\n\r\n  Doctor IDs :\r\n  + 1111, 7777, 3333,\r\n      4444, 5555, 9999\r\n\r\n  Patients have SSNs.\r\n\r\n  Unique Fields:\r\n  + Hospital Name\r\n  + Doctor ID\r\n  + Patient SSN");
		scrollPane.setViewportView(txtArea);
		txtArea.setEditable(false);
		
		JButton addFrameBuildButton = new JButton("Add");
		addFrameBuildButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		addFrameBuildButton.setForeground(Color.BLACK);
		addFrameBuildButton.setBackground(new Color(255, 204, 102));
		addFrameBuildButton.setEnabled(false);
		addFrameBuildButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				addFrame.setVisible(true);
			}
		});
		addFrameBuildButton.setBounds(381, 43, 212, 180);
		contentPane.add(addFrameBuildButton);
		
		JButton deleteFrameBuildButton = new JButton("Delete");
		deleteFrameBuildButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		deleteFrameBuildButton.setBackground(new Color(255, 204, 102));
		deleteFrameBuildButton.setEnabled(false);
		deleteFrameBuildButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFrame.setVisible(true);
			}
		});
		deleteFrameBuildButton.setBounds(647, 43, 212, 180);
		contentPane.add(deleteFrameBuildButton);
		
		JButton searchFrameBuildButton = new JButton("Search");
		searchFrameBuildButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		searchFrameBuildButton.setBackground(new Color(255, 204, 102));
		searchFrameBuildButton.setEnabled(false);
		searchFrameBuildButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				searchFrame.setVisible(true);
			}
		});
		searchFrameBuildButton.setBounds(381, 255, 212, 175);
		contentPane.add(searchFrameBuildButton);
		
		JButton logInFrameBuildButton = new JButton("Log In");
		logInFrameBuildButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		logInFrameBuildButton.setBackground(new Color(255, 204, 102));
		logInFrameBuildButton.setEnabled(false);
		logInFrameBuildButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginFrame.setVisible(true);
			}
		});
		logInFrameBuildButton.setBounds(647, 255, 212, 175);
		contentPane.add(logInFrameBuildButton);
		
		JButton readDataButton = new JButton("Read Data");
		readDataButton.setFont(new Font("Monospaced", Font.BOLD, 13));
		readDataButton.setForeground(new Color(25, 25, 112));
		readDataButton.setBackground(new Color(224, 255, 255));
		readDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				moreDataInput();
				
				addFrameBuildButton.setEnabled(true);
				deleteFrameBuildButton.setEnabled(true);
				searchFrameBuildButton.setEnabled(true);
				logInFrameBuildButton.setEnabled(true);
				
				readDataButton.setEnabled(false);
			}
		});
		readDataButton.setBounds(79, 481, 171, 45);
		contentPane.add(readDataButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        Desktop.getDesktop().browse(new URI("http://github.com/mec-cs"));
			    } catch (IOException | URISyntaxException e1) {
			        txtArea.setText("Cannot open GITHUB");
			    }
			}
		});
		lblNewLabel.setIcon(new ImageIcon("src\\images\\github.png"));
		lblNewLabel.setBounds(724, 456, 80, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblGithub = new JLabel("");
		lblGithub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        Desktop.getDesktop().browse(new URI("https://github.com/KadirAygumus"));
			    } catch (IOException | URISyntaxException e1) {
			    	txtArea.setText("Cannot open GITHUB");
			    }
			}
		});
		lblGithub.setIcon(new ImageIcon("src\\images\\github.png"));
		lblGithub.setBounds(553, 456, 80, 70);
		contentPane.add(lblGithub);
		
		JLabel lblGithub_1 = new JLabel("");
		lblGithub_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        Desktop.getDesktop().browse(new URI("https://github.com/berkberaozer"));
			    } catch (IOException | URISyntaxException e1) {
			    	txtArea.setText("Cannot open GITHUB");
			    }
			}
		});
		lblGithub_1.setIcon(new ImageIcon("src\\images\\github.png"));
		lblGithub_1.setBounds(381, 456, 80, 70);
		contentPane.add(lblGithub_1);
		
		JLabel lblNewLabel_1 = new JLabel("Bera Özer");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(381, 539, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kadir Aygümüş");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(540, 539, 105, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enes Çakır");
		lblNewLabel_3.setFont(new Font("Monospaced", Font.ITALIC, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(724, 539, 80, 14);
		contentPane.add(lblNewLabel_3);
	}
	
	public void moreDataInput() {
		
		Doctor d1 = new Doctor("Emir Tuna", "Besli", "Male", 43, 199, 63, 2222, 14500, "EyeDepartment", "emir123");
		Doctor d2 = new Doctor("Ahmet Eren", "Arslanoglu", "Female", 18, 174, 77, 8888, 3000, "Ahmetology", "ahmet123");
		Doctor d3 = new Doctor("Ali Efe", "Ilik", "Female", 19, 137, 47, 6666, 66000, "Radiology", "efe123");
		
		Patient p1 = new Patient("Patient 10", "Noun Surname", "Male", 115, 161, 50, 193512, "Diheria");
		Patient p2 = new Patient("Patient 11", "Dunno Surname", "Female", 99, 114, 30, 953591, "Diheria");
		Patient p3 = new Patient("Patient 12", "Nein Surname", "Female", 78, 105, 20, 555433, "Diheria");
		
		HospitalSys.addDoctor("Ankara Hastanesi", d1);
		HospitalSys.addDoctor("Istanbul Hastanesi", d2);
		HospitalSys.addDoctor("Bolu Hastanesi", d3);;
		
		HospitalSys.addPatient("Ankara Hastanesi", 2222, p1);
		HospitalSys.addPatient("Istanbul Hastanesi", 8888, p2);
		HospitalSys.addPatient("Bolu Hastanesi", 6666, p3);
		
	}
}
