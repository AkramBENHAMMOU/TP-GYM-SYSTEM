package gym_mang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.SpringLayout;

public class Log_gym extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_gym frame = new Log_gym();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Log_gym() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		 JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("copyright©gymCenter");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(2, 242, 109, 15);
		getContentPane().add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("CENTER");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel_1_1.setBounds(0, 174, 162, 22);
		getContentPane().add(lblNewLabel_1_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("GYM");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 35, 162, 40);
		getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Log_gym.class.getResource("/images/téléchargement__1_-removebg-preview.png")));
		lblNewLabel.setBounds(0, 0, 162, 262);
		getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setBounds(161, 4, 273, 38);
		lblNewLabel_2.setForeground(new Color(0, 255, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 33));
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(214, 83, 162, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(214, 151, 162, 28);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setBounds(237, 204, 117, 31);
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textField.getText()).equals("")){
					
					JOptionPane.showMessageDialog(null, "Entrez ton nom d'utilisateur !","Champs vide",JOptionPane.ERROR_MESSAGE);
				}
				else if((textField_1.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "Entrez ton mot de passe !", "Champs vide",JOptionPane.ERROR_MESSAGE);
				}
				else if((textField.getText()).equals("admin") && (textField_1.getText()).equals("12345")) {
					GymMenu mn = new GymMenu();
					setVisible(false);
					mn.setVisible(true);
				    mn.setLocationRelativeTo(null);
			
				}
				else {
					JOptionPane.showMessageDialog(null, "Username ou mot de passe incorrect !!", "ERROR",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginbtn.setBackground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginbtn.setBackground(new Color(0,255,0));
				
			}
		});
		loginbtn.setBorder(null);
		loginbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		loginbtn.setBackground(new Color(0, 255, 0));
		loginbtn.setForeground(Color.white);
		getContentPane().add(loginbtn);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(214, 59, 162, 21);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(213, 126, 163, 21);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		getContentPane().add(lblNewLabel_3_1);
	}
}
