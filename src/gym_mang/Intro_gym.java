package gym_mang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JProgressBar;

public class Intro_gym extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel_3 = new JLabel("0%");
	private JProgressBar progressBar = new JProgressBar();

	public Intro_gym() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(900, 500));
		contentPane.setSize(new Dimension(900, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(0, 0, 450, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Intro_gym.class.getResource("/images/8201938-gym-logo-fitness-vector-logo-design-template-design-for-gym-and-fitness-vector-vectoriel__1___1___1_-removebg-preview.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 450, 199);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BIENVENUE À GYM CENTER ");
		lblNewLabel_1.setFont(new Font("Cooper Black", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 167, 450, 55);
		panel.add(lblNewLabel_1);
		
		
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setBorder(null);
		progressBar.setBounds(0, 291, 450, 9);
		panel.add(progressBar);
		
		JLabel lblNewLabel_2 = new JLabel("LOADING...");
		lblNewLabel_2.setFont(new Font("Source Serif Pro Semibold", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(6, 276, 84, 14);
		panel.add(lblNewLabel_2);
		
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(404, 276, 46, 14);
		panel.add(lblNewLabel_3);
	}
	public static void main(String[] args) {
		Intro_gym frame = new Intro_gym();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		try {
			for(int i=0;i<=100;i++) {
				 
				Thread.sleep(50);
			
				frame.lblNewLabel_3.setText(i+"%");
				frame.progressBar.setValue(i);
			
			    
			}
			frame.setVisible(false);
			Log_gym l = new Log_gym();
			l.setVisible(true);
			l.setLocationRelativeTo(null);
			
				} catch (InterruptedException e) {
					JOptionPane.showMessageDialog(null, e);
					e.printStackTrace();
				}
			}
}
