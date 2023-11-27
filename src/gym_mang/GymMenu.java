package gym_mang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JMonthChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GymMenu extends JFrame {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GymMenu frame = new GymMenu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
boolean pressed = true;
private DefaultTableModel model,mod;
private ArrayList<Membre> membre;
private ArrayList<Coach> coach;
private ArrayList<Payement> pay;


private JPanel panel_1;

private JPanel panel_membre;
private JPanel panel_intro;
private JPanel panel_3;
private JPanel panel_menu;
private JPanel panel_coaches;
private JPanel panel_payement_1;

private JTextField textField_cin;
private JTextField textField_prénom;
private JTextField textField_téléphone;
private JTextField textField_nom;
private JRadioButton btnFemme;
private JRadioButton btnHomme;
private JMonthChooser monthChooser;
private final ButtonGroup buttonGroup = new ButtonGroup();
private JTable table_membre;
private JTextField textField_cin_1;
private JTextField textField_nomComplet;
private JTextField textField_telephone;
private JTextField textField_age;
private JTable table_coach1;
private JComboBox combox_membre;


String[] memb= {""};
private JTextField textField_montant;
private JTable table_payement;


	public GymMenu() {
		setResizable(false);
		
		model=new DefaultTableModel();
		membre = new ArrayList();
		coach = new ArrayList();
		pay = new ArrayList();
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);
						
			JPanel panel_intro_1 = new JPanel();
			panel_intro_1.setBounds(23, 0, 411, 261);
			panel_intro_1.setVisible(true);
						
			JPanel panel_menu_1 = new JPanel();
			panel_menu_1.setBounds(23, 0, 104, 261);
			panel_menu_1.setVisible(false);
							
			DefaultComboBoxModel<String> combox_model = new DefaultComboBoxModel<>();
			combox_model.addElement("");
			DefaultTableModel mod_1;
			mod_1 = new DefaultTableModel();
			Object[] col2 = {"N°","Nom Complet","Période","Montant"};
			mod_1.setColumnIdentifiers(col2);	
	
			JPanel panel_barre = new JPanel();
			panel_barre.setBounds(0, 0, 25, 261);
			panel_barre.setBackground(new Color(0, 255, 0));
			getContentPane().add(panel_barre);
			panel_barre.setLayout(null);
					
			JButton lblNewLabel = new JButton("");
		    lblNewLabel.setIcon(new ImageIcon(GymMenu.class.getResource("/images/660376 (1).png")));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBackground(new Color(0, 255, 0));
			lblNewLabel.setBounds(0, 0, 22, 32);
			panel_barre.add(lblNewLabel);
					
			lblNewLabel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 255, 0)));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				
		    panel_menu_1.setBackground(new Color(0, 255, 0));
			getContentPane().add(panel_menu_1);
			panel_menu_1.setLayout(null);
							
		    JButton lblMembre = new JButton("Membre");
							
			lblMembre.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblMembre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
			lblMembre.setHorizontalAlignment(SwingConstants.CENTER);
			lblMembre.setBackground(new Color(0, 0, 0));
     		lblMembre.setForeground(new Color(255, 255, 255));
			lblMembre.setOpaque(true);
			lblMembre.setBounds(0, 78, 82, 30);
			panel_menu_1.add(lblMembre);
					
			JButton lblCoaches = new JButton("Coaches");
							
			lblCoaches.setOpaque(true);
			lblCoaches.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblCoaches.setHorizontalAlignment(SwingConstants.CENTER);
			lblCoaches.setForeground(Color.WHITE);
			lblCoaches.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
			lblCoaches.setBackground(Color.BLACK);
			lblCoaches.setBounds(0, 119, 82, 30);
			panel_menu_1.add(lblCoaches);
							
			JButton lblLogout = new JButton("Log out");
			lblLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
			});
	     	lblLogout.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogout.setForeground(Color.WHITE);
		    lblLogout.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
			lblLogout.setBackground(Color.BLACK);
			lblLogout.setBounds(0, 201, 82, 30);
			panel_menu_1.add(lblLogout);
							
			JButton lblPayement = new JButton("Payement");
							
			lblPayement.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblPayement.setHorizontalAlignment(SwingConstants.CENTER);
			lblPayement.setForeground(Color.WHITE);
			lblPayement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
	     	lblPayement.setBackground(Color.BLACK);
		    lblPayement.setBounds(0, 160, 82, 30);
		    panel_menu_1.add(lblPayement);
							
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(10, 11, 76, 56);
			panel_menu_1.add(lblNewLabel_2);
			lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel_2.setBackground(new Color(0, 255, 0));
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setIcon(new ImageIcon(GymMenu.class.getResource("/images/téléchargement__1_-removebg-preview.png")));
							
							
						
						
			getContentPane().add(panel_intro_1);
			panel_intro_1.setLayout(null);
						
			JLabel lblNewLabel_10 = new JLabel("SYSTEM");
			lblNewLabel_10.setForeground(new Color(0, 255, 0));
			lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
			lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_10.setBounds(244, 179, 157, 40);
			panel_intro_1.add(lblNewLabel_10);
						
			JLabel lblNewLabel_6 = new JLabel("MANAGEMENT");
			lblNewLabel_6.setBounds(103, 103, 286, 40);
			lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
			lblNewLabel_6.setForeground(new Color(0, 255, 0));
		    lblNewLabel_6.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
			panel_intro_1.add(lblNewLabel_6);
						
			JLabel lblNewLabel_5 = new JLabel("GYM CENTER");
			lblNewLabel_5.setBounds(20, 30, 391, 40);
			lblNewLabel_5.setForeground(new Color(0, 255, 0));
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
			lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
			panel_intro_1.add(lblNewLabel_5);
						
			JLabel lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setBounds(0, 0, 340, 261);
			lblNewLabel_3.setIcon(new ImageIcon(GymMenu.class.getResource("/images/213274208-gym-background-in-low-key-ai.jpg")));
			panel_intro_1.add(lblNewLabel_3);
						
			JLabel lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setBounds(309, 0, 102, 261);
			lblNewLabel_4.setIcon(new ImageIcon(GymMenu.class.getResource("/images/213274208-gym-background-in-low-key-ai.jpg")));
		    panel_intro_1.add(lblNewLabel_4);
			mod = new DefaultTableModel();
			Object[] col1 = {"CIN","Nom Complet","Äge","Tele"};
			mod.setColumnIdentifiers(col1);
		
	
			Object[] column = {"CIN","Nom","Prénom","Téléphone","Mois payé","Sexe"};
			
			model.setColumnIdentifiers(column);
			
			ButtonGroup group = new ButtonGroup();
			
			panel_membre = new JPanel();
			panel_membre.setBounds(23, 0, 411, 261);
			panel_membre.setVisible(false);
			
			getContentPane().add(panel_membre);
			panel_membre.setLayout(null);
			
			JMonthChooser monthChooser_1 = new JMonthChooser();
			monthChooser_1.setBounds(84, 89, 111, 20);
			monthChooser_1.setMonth(-1);
			panel_membre.add(monthChooser_1);
			
			JButton btn_chercher = new JButton("Chercher");
			btn_chercher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					if(  textField_cin.getText().equals("")  ) {
						JOptionPane.showMessageDialog(null, "Entrez le CIN du membre à chercher !");
					}
					else {
						for(int i=0;i<table_membre.getRowCount();i++) {
							String cellule = table_membre.getValueAt(i, 0).toString();
							if(textField_cin.getText().equals(cellule)) {
								table_membre.setRowSelectionInterval(i,i);
								Rectangle rc = table_membre.getCellRect(table_membre.getSelectedRow(), 0, false);
								table_membre.scrollRectToVisible(rc);
								return;
							}
							
						}
								JOptionPane.showMessageDialog(null, "Auncune correspondance trouvée por le membre séléctionné !");
						
							}
					}
			});
			btn_chercher.setBorder(null);
			btn_chercher.setBackground(new Color(37, 173, 57));
			btn_chercher.setBounds(210, 118, 89, 23);
			panel_membre.add(btn_chercher);
			btn_chercher.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btn_chercher.setBackground(new Color(0,255,0));
				
				}
				public void mouseExited(MouseEvent e) {
					btn_chercher.setBackground(new Color(37, 173, 57));
				}
			});
			
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(17, 153, 379, 97);
			panel_membre.add(scrollPane_2);
			
		
			table_membre = new JTable();
			table_membre.setBackground(new Color(216, 216, 216));
			table_membre.setModel(model);
			scrollPane_2.setViewportView(table_membre);
			
			JRadioButton btnFemme_1 = new JRadioButton("Femme");
			btnFemme_1.setHorizontalAlignment(SwingConstants.CENTER);
			btnFemme_1.setForeground(Color.WHITE);
			btnFemme_1.setBackground(Color.BLACK);
			btnFemme_1.setBounds(340, 39, 74, 23);
			panel_membre.add(btnFemme_1);
			
			JRadioButton btnHomme_1 = new JRadioButton("Homme ");
			btnHomme_1.setHorizontalAlignment(SwingConstants.CENTER);
			btnHomme_1.setBackground(new Color(0, 0, 0));
			btnHomme_1.setForeground(new Color(255, 255, 255));
			btnHomme_1.setBounds(264, 38, 74, 23);
			panel_membre.add(btnHomme_1);
			group.add(btnHomme_1);
			group.add(btnFemme_1);
			
			JLabel titre_panelMembre = new JLabel("GESTION DES MEMBRES");
			titre_panelMembre.setHorizontalAlignment(SwingConstants.CENTER);
			titre_panelMembre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
			titre_panelMembre.setForeground(new Color(0, 255, 0));
			titre_panelMembre.setBounds(0, 0, 411, 25);
			panel_membre.add(titre_panelMembre);
			
			JButton btn_supprimer = new JButton("Supprimer");
			btn_supprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			     	int indice = table_membre.getSelectedRow();
			     	if(indice!=-1) {
			    
			     		membre.remove(indice);
			     		model.removeRow(indice);
			     		combox_model.removeElementAt(indice+1);
			     		textField_cin.setText("");
			    		textField_prénom.setText("");
			    		textField_téléphone.setText("");
			    		textField_nom.setText("");
			    		group.clearSelection();
			    		monthChooser_1.setMonth(-1);
			    		
			    		
			    		JOptionPane.showMessageDialog(null, "Ce membre a été bien supprimer");
			    		
			     	}
			     
			     	else {
			     		JOptionPane.showMessageDialog(null,"Séléctionnez un membre SVP!!","Aucun membre séléctionné",JOptionPane.OK_OPTION);
			     	}
			    
				}
			});
			btn_supprimer.setBounds(307, 118, 89, 23);
			panel_membre.add(btn_supprimer);
			btn_supprimer.setBackground(new Color(37, 173, 57));
			btn_supprimer.setBorder(null);
			btn_supprimer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btn_supprimer.setBackground(new Color(0,255,0));
				
				}
				public void mouseExited(MouseEvent e) {
					btn_supprimer.setBackground(new Color(37, 173, 57));
				}
			});
			
			JButton btn_modifier = new JButton("Modifier");
			btn_modifier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indice = table_membre.getSelectedRow();
					int moiSelectionne = monthChooser_1.getMonth();
					if( textField_nom.getText().equals("") && textField_prénom.getText().equals("")  && textField_cin.getText().equals("") && textField_téléphone.getText().equals("") && group.getSelection()==null  ) {
					
							JOptionPane.showMessageDialog(null, "Séléctionnez un membre à modifier ");
						
						
					}
					
					else {
					    	if(indice!=-1) {
					    		if( textField_nom.getText().equals("") || textField_prénom.getText().equals("")  || textField_cin.getText().equals("") || textField_téléphone.getText().equals("") || group.getSelection()==null || moiSelectionne==-1 ) {
					    			JOptionPane.showMessageDialog(null, "Remplissez tous les champs ");
					    		}
					    		else {
								table_membre.setValueAt(textField_cin.getText(), indice, 0);
								table_membre.setValueAt(textField_nom.getText(), indice, 1);
								table_membre.setValueAt(textField_prénom.getText(), indice, 2);
								table_membre.setValueAt(textField_téléphone.getText(), indice, 3);
								table_membre.setValueAt(monthChooser_1.getMonth()+1, indice, 4);
							
						     	if(btnHomme_1.isSelected()) {
						     		table_membre.setValueAt("Homme", indice, 5);
									}
							    else {
							    	table_membre.setValueAt("Femme", indice, 5);
									}
						     	Membre m_1= new Membre(textField_cin.getText(),textField_nom.getText(),textField_prénom.getText(),textField_téléphone.getText(),moiSelectionne,table_membre.getValueAt(indice, 5).toString());
						     	membre.set(indice, m_1);
						     	combox_model.removeElementAt(indice+1);
						     	combox_model.insertElementAt(textField_nom.getText()+" "+textField_prénom.getText(),indice+1);
							
						     	textField_nom.setText("");
						     	textField_prénom.setText("");
								textField_téléphone.setText("");
								textField_cin.setText("");
								monthChooser_1.setMonth(-1);
								group.clearSelection();
				
								JOptionPane.showMessageDialog(null, "Ce membre a été bien modifié ");
					    		}
					    	}
					}
					    	
					 
					
				}
					
					
					
				
	});
			
			btn_modifier.setBounds(115, 118, 89, 23);
			panel_membre.add(btn_modifier);
			btn_modifier.setBackground(new Color(37, 173, 57));
			btn_modifier.setBorder(null);
			btn_modifier.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btn_modifier.setBackground(new Color(0,255,0));
				
				}
				public void mouseExited(MouseEvent e) {
					btn_modifier.setBackground(new Color(37, 173, 57));
				}
			});
			
			JLabel lblNewLabel_7 = new JLabel("CIN");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblNewLabel_7.setForeground(new Color(255, 255, 255));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setBounds(0, 41, 74, 14);
			panel_membre.add(lblNewLabel_7);
			
			textField_cin = new JTextField();
			textField_cin.setBounds(86, 39, 101, 20);
			panel_membre.add(textField_cin);
			textField_cin.setColumns(10);
			
			JLabel lbl_sexe = new JLabel("Sexe");
			lbl_sexe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lbl_sexe.setForeground(new Color(255, 255, 255));
			lbl_sexe.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_sexe.setBounds(197, 42, 83, 14);
			panel_membre.add(lbl_sexe);
			
			JLabel lbl_nom = new JLabel("Nom");
			lbl_nom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lbl_nom.setForeground(new Color(255, 255, 255));
			lbl_nom.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_nom.setBounds(0, 67, 74, 14);
			panel_membre.add(lbl_nom);
			
			JLabel lbl_prenom = new JLabel("Prénom");
			lbl_prenom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lbl_prenom.setForeground(new Color(255, 255, 255));
			lbl_prenom.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_prenom.setBounds(197, 67, 83, 14);
			panel_membre.add(lbl_prenom);
			
			JLabel lbl_paye = new JLabel("Payé ");
			lbl_paye.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lbl_paye.setForeground(new Color(255, 255, 255));
			lbl_paye.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_paye.setBounds(0, 87, 74, 25);
			panel_membre.add(lbl_paye);
			
			JLabel lblNewLabel_telephone = new JLabel("Téléphone");
			lblNewLabel_telephone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblNewLabel_telephone.setForeground(new Color(255, 255, 255));
			lblNewLabel_telephone.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_telephone.setBounds(197, 92, 83, 14);
			panel_membre.add(lblNewLabel_telephone);
			
			textField_prénom = new JTextField();
			textField_prénom.setColumns(10);
			textField_prénom.setBounds(290, 65, 101, 20);
			panel_membre.add(textField_prénom);
			
			textField_téléphone = new JTextField();
			textField_téléphone.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!Character.isDigit(c) || c==KeyEvent.CHAR_UNDEFINED) {
						e.consume();
					}
				}
			});
			textField_téléphone.setColumns(10);
			textField_téléphone.setBounds(290, 92, 101, 20);
			panel_membre.add(textField_téléphone);
			
			textField_nom = new JTextField();
			textField_nom.setColumns(10);
			textField_nom.setBounds(86, 65, 101, 19);
			panel_membre.add(textField_nom);
			
			JButton btn_ajouter = new JButton("Ajouter");
			
			btn_ajouter.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btn_ajouter.setBackground(new Color(0,255,0));
				
				}
				public void mouseExited(MouseEvent e) {
					btn_ajouter.setBackground(new Color(37, 173, 57));
				}
			});
			btn_ajouter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int moiSelectionne = monthChooser_1.getMonth();
					if( textField_nom.getText().equals("") || textField_prénom.getText().equals("")  || textField_cin.getText().equals("") || textField_téléphone.getText().equals("") || group.getSelection()==null || moiSelectionne==-1 ) {
						JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
					}
					else {
			
						
						boolean membreExiste = false;
						for(int j=0;j<membre.size();j++) {
							Membre m_1 = membre.get(j);
							if(textField_cin.getText().equals(m_1.getCIN())) {
								
								membreExiste=true;
							}
					
						}
						if(membreExiste) {
							JOptionPane.showMessageDialog(null, "Cette personne est déjà un membre ","Information",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
					
							 					
							 String cin = textField_cin.getText();
							 String nom = textField_nom.getText();
							 String prenom = textField_prénom.getText();
							 String telephone = textField_téléphone.getText();
							 String sexe = "Homme";
						
							if(!btnHomme_1.isSelected()) {
									sexe="Femme";
							}

							model.insertRow(model.getRowCount(), new Object[] {
										cin,
										nom,
										prenom,
										telephone,
										moiSelectionne,
										sexe
								});
								
						    Membre m =new Membre(cin,nom,prenom,telephone,moiSelectionne,sexe);
							membre.add(m);
							combox_model.addElement(nom+" "+prenom);
									
								
						    textField_cin.setText("");
							textField_nom.setText("");
							textField_prénom.setText("");
							textField_téléphone.setText("");
							monthChooser_1.setMonth(-1);
							group.clearSelection();
					
							 JOptionPane.showMessageDialog(null, "Membre ajouté avec succès");
			
					}
				 }	
				}
				});
			
					
				
			btn_ajouter.setBackground(new Color(37, 173, 57));
			btn_ajouter.setBorder(null);
			btn_ajouter.setBounds(19, 117, 89, 23);
			panel_membre.add(btn_ajouter);
			
			JLabel lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setForeground(new Color(255, 255, 255));
			lblNewLabel_8.setIcon(new ImageIcon(GymMenu.class.getResource("/images/images (1).jpeg")));
			lblNewLabel_8.setBounds(0, 0, 411, 261);
			panel_membre.add(lblNewLabel_8);
             
             JPanel panel_payement_1_1 = new JPanel();
             panel_payement_1_1.setBounds(23, 0, 411, 261);
             getContentPane().add(panel_payement_1_1);
             panel_payement_1_1.setVisible(false);
             panel_payement_1_1.setLayout(null);
             
             
             JPanel panel_coaches_1 = new JPanel();
				panel_coaches_1.setBackground(new Color(0, 255, 0));
				panel_coaches_1.setBounds(23, 0, 411, 261);
				panel_coaches_1.setVisible(false);	
				getContentPane().add(panel_coaches_1);
				panel_coaches_1.setLayout(null);

             
             lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if(pressed) {
							panel_menu_1.setVisible(true);
							panel_membre.setVisible(false);
						    panel_coaches_1.setVisible(false);
						    panel_payement_1_1.setVisible(false);
							lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
							lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
							lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
							pressed=false;
						}
						else {
							panel_menu_1.setVisible(false);
							panel_intro_1.setVisible(true);
							panel_membre.setVisible(false);
						    panel_coaches_1.setVisible(false);
						    panel_payement_1_1.setVisible(false);
							lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
							lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
							lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);	
							pressed=true;
						}
					}
				});
             
             JLabel lblNewLabel_titre = new JLabel("GESTION DES PAYEMENTS");
             lblNewLabel_titre.setBounds(10, 4, 391, 31);
             lblNewLabel_titre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
             lblNewLabel_titre.setForeground(Color.green);
             lblNewLabel_titre.setHorizontalAlignment(SwingConstants.CENTER);
             panel_payement_1_1.add(lblNewLabel_titre);
             
             JLabel lbl_periode = new JLabel("Période");
             lbl_periode.setForeground(new Color(255, 255, 255));
             lbl_periode.setBounds(11, 48, 76, 18);
             lbl_periode.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
             panel_payement_1_1.add(lbl_periode);
             
             JLabel lbl_memb = new JLabel("Membre");
             lbl_memb.setForeground(new Color(255, 255, 255));
             lbl_memb.setBounds(11, 85, 76, 18);
             lbl_memb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
             panel_payement_1_1.add(lbl_memb);
             
             JLabel lbl_montant = new JLabel("Montant");
             lbl_montant.setForeground(new Color(255, 255, 255));
             lbl_montant.setBounds(213, 49, 76, 18);
             lbl_montant.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
             panel_payement_1_1.add(lbl_montant);
             
             
             
             textField_montant = new JTextField();
             textField_montant.setBounds(286, 49, 114, 18);
             textField_montant.addKeyListener(new KeyAdapter() {
             	@Override
             	public void keyTyped(KeyEvent e) {
             		char k = e.getKeyChar();
             		if(!Character.isDigit(k) || k==KeyEvent.CHAR_UNDEFINED) {
             			e.consume();
             		}
             	}
             });
             panel_payement_1_1.add(textField_montant);
             textField_montant.setColumns(10);
             
             JDateChooser dateChooser = new JDateChooser();
             dateChooser.setBounds(82, 48, 112, 20);
             dateChooser.setDateFormatString("yyyy-MM-dd");
             panel_payement_1_1.add(dateChooser);
             JComboBox<String> combox_membre_1 = new JComboBox<>(combox_model);
             combox_membre_1.setBounds(81, 84, 114, 18);
             panel_payement_1_1.add(combox_membre_1);
             
             JButton chercher = new JButton("Chercher");
             chercher.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int selectedIndex = combox_membre_1.getSelectedIndex();
                     String selectedMembre = combox_membre_1.getItemAt(selectedIndex);
                  if(selectedIndex!=0) {   	
                     for(int i=0;i<table_payement.getRowCount();i++) {
             			String cellule = table_payement.getValueAt(i, 1).toString();
             			if(selectedMembre.equals(cellule)) {
             				table_payement.setRowSelectionInterval(i,i);
             				Rectangle rc = table_payement.getCellRect(table_payement.getSelectedRow(), 0, false);
             				table_payement.scrollRectToVisible(rc);
             				return;
             	           }
             			
                     }
             				JOptionPane.showMessageDialog(null, "Aucune correspondance trouvée pour le membre séléctionné !");
             			}
                     
                  
                     else {
             			JOptionPane.showMessageDialog(null, "Séléctionnez un membre à chercher, SVP!!");
             		}
                 }
             });

				chercher.setBackground(new Color(0,128,0));
				chercher.setForeground(new Color(255,255,255));
				chercher.setBorder(null);
				chercher.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						chercher.setBackground(Color.red);
					}
					public void mouseExited(MouseEvent e) {
						chercher.setBackground(new Color(0,128,0));
					}
				});
				chercher.setBounds(312, 82, 89, 23);
				chercher.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				panel_payement_1_1.add(chercher);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(12, 119, 389, 132);
				panel_payement_1_1.add(scrollPane_1);
				
				table_payement = new JTable();
				table_payement.setModel(mod_1);
				scrollPane_1.setViewportView(table_payement);
				
				JButton payer = new JButton("Payer");
				payer.setBorder(null);
				payer.setBackground(new Color(0,128,0));
				payer.setForeground(Color.white);
				payer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						payer.setBackground(Color.green);
						
					}
					public void mouseExited(MouseEvent e) {
						payer.setBackground(new Color(0,128,0));
					}
				});
				payer.setBounds(205, 82, 89, 23);
				payer.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				        if (dateChooser.getDate() == null || combox_membre_1.getSelectedItem().equals("") || textField_montant.getText().equals("")) {
				            JOptionPane.showMessageDialog(null, "Remplissez les champs, SVP!!");
				        } else {
				            Date selectedDate = dateChooser.getDate();
				            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				            String periode = dateFormat.format(selectedDate);

				            String memb = combox_membre_1.getSelectedItem().toString();
				            String montant = textField_montant.getText();
				            boolean existe = false;
				            boolean paye = false;
				            int s = -1;

				            for (int j = 0; j < table_payement.getRowCount(); j++) {
				                
				                if (memb.equals(table_payement.getValueAt(j, 1))) {
				                    existe = true;
				                    s = j; // Update the index when member is found
				                }
				                if (periode.equals(table_payement.getValueAt(j, 2)) ){
				                    paye = true;
				                    s=j;
				                }
				            }

				            if (existe && paye) {
				                JOptionPane.showMessageDialog(null, "Ce membre a déjà payé cette période !");
				            } else if (existe && !paye) {
				                int option = JOptionPane.showConfirmDialog(null, "Période n'est pas payée! voulez-vous la payer ?", "Confirmer le payement ", JOptionPane.YES_NO_OPTION);
				                if (option == JOptionPane.YES_OPTION) {
				               
				                    table_payement.setValueAt(periode, s, 2);
				                    table_payement.setValueAt(montant, s, 3);
				                    dateChooser.setDate(null);
				                    combox_membre_1.setSelectedItem("");
				                    textField_montant.setText("");
				                    JOptionPane.showMessageDialog(null, "Payement de cette période :" + periode + " a été bien effectué");
				                } else {
				                    JOptionPane.showMessageDialog(null, "Payement refusé");
				                }
				            } else {
				                int index = table_payement.getSelectedRow();

				                mod_1.insertRow(mod_1.getRowCount(), new Object[]{
				                        mod_1.getRowCount(),
				                        memb,
				                        periode,
				                        montant
				                });
				                Payement p_1 = new Payement(periode, memb, montant);
				                pay.add(p_1);

				                dateChooser.setDate(null);
				                combox_membre_1.setSelectedIndex(0);
				                textField_montant.setText("");
				            }
				        }
				    }
				});

				payer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
				panel_payement_1_1.add(payer);
				
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon(GymMenu.class.getResource("/images/Untitled design.png")));
				lblNewLabel_1.setBounds(0, 0, 411, 261);
				panel_payement_1_1.add(lblNewLabel_1);
				
				JLabel lblNewLabel_9 = new JLabel("New label");
				lblNewLabel_9.setIcon(new ImageIcon(GymMenu.class.getResource("/images/Untitled design.png")));
				lblNewLabel_9.setBounds(335, 0, 76, 261);
				panel_payement_1_1.add(lblNewLabel_9);
				
				JLabel lbl_nomComplet = new JLabel("Nom complet");
				lbl_nomComplet.setForeground(new Color(255, 255, 255));
				lbl_nomComplet.setBounds(7, 73, 92, 24);
				lbl_nomComplet.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
				panel_coaches_1.add(lbl_nomComplet);
				
				JLabel lbl_telephone = new JLabel("Téléphone");
				lbl_telephone.setForeground(new Color(255, 255, 255));
				lbl_telephone.setBounds(10, 104, 82, 24);
				lbl_telephone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
				panel_coaches_1.add(lbl_telephone);
				
				JLabel lbl_age = new JLabel("Âge ");
				lbl_age.setForeground(new Color(255, 255, 255));
				lbl_age.setBounds(10, 134, 82, 24);
				lbl_age.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
				panel_coaches_1.add(lbl_age);
				
				JLabel lbl_cin = new JLabel("CIN");
				lbl_cin.setForeground(new Color(255, 255, 255));
				lbl_cin.setBounds(10, 43, 82, 20);
				lbl_cin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
				panel_coaches_1.add(lbl_cin);
				
				JButton btnModifier = new JButton("Modifier");
				btnModifier.setBounds(7, 197, 221, 23);
				btnModifier.setBackground(Color.white);
				btnModifier.setBorder(null);
				
				btnModifier.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnModifier.setBackground(new Color(79,79,79));
						btnModifier.setForeground(Color.white);
					}
					public void mouseExited( MouseEvent e) {
						btnModifier.setBackground(Color.white);
						btnModifier.setForeground(Color.black);
					}
				});
				
				panel_coaches_1.add(btnModifier);
				
				JButton btnSupprimer = new JButton("Supprimer");
				btnSupprimer.setBounds(7, 226, 221, 23);
				btnSupprimer.setBorder(null);
				btnSupprimer.setBackground(Color.white);
				btnSupprimer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnSupprimer.setBackground(new Color(128,128,128));
						btnSupprimer.setForeground(Color.white);
					}
					public void mouseExited(MouseEvent e) {
						btnSupprimer.setBackground(Color.white);
						btnSupprimer.setForeground(Color.black);
					}
				});
				panel_coaches_1.add(btnSupprimer);
				
				textField_cin_1 = new JTextField();
				textField_cin_1.setBounds(102, 43, 126, 20);
				panel_coaches_1.add(textField_cin_1);
				textField_cin_1.setColumns(10);
				
				textField_nomComplet = new JTextField();
				textField_nomComplet.setBounds(103, 76, 125, 20);
				textField_nomComplet.setColumns(10);
				panel_coaches_1.add(textField_nomComplet);
				
				textField_telephone = new JTextField();
				textField_telephone.setBounds(101, 108, 127, 20);
				textField_telephone.setColumns(10);
				textField_telephone.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(!Character.isDigit(c) || c==KeyEvent.CHAR_UNDEFINED ) {
							e.consume();
						}
					}
				});
				panel_coaches_1.add(textField_telephone);
				
				textField_age = new JTextField();
				textField_age.setBounds(102, 136, 126, 20);
				textField_age.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char k = e.getKeyChar();
						if(!Character.isDigit(k) || k==KeyEvent.CHAR_UNDEFINED) {
							e.consume();
						}
					}
				});
				textField_age.setColumns(10);
				panel_coaches_1.add(textField_age);
             							
             JScrollPane scrollPane = new JScrollPane();
             scrollPane.setBounds(238, 43, 163, 206);
             panel_coaches_1.add(scrollPane);
             
             JTable table_coach1_1 = new JTable();
             table_coach1_1.setModel(mod);
             scrollPane.setViewportView(table_coach1_1);
             
             
             
             table_coach1_1.addMouseListener(new MouseAdapter() {
             	@Override
             	public void mouseClicked(MouseEvent e) {
             		int i = table_coach1_1.getSelectedRow();
             		
             		textField_cin_1.setText(mod.getValueAt(i, 0).toString());
             		textField_nomComplet.setText(mod.getValueAt(i, 1).toString());
             		textField_telephone.setText(mod.getValueAt(i, 2).toString());
             		textField_age.setText(mod.getValueAt(i, 3).toString());
             		
             		if(e.getButton() ==MouseEvent.BUTTON3 ) {
             			textField_cin_1.setText("");
             			textField_nomComplet.setText("");
             			textField_telephone.setText("");
             			textField_age.setText("");
             		}
             	}
             });
             
             btnModifier.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		int i = table_coach1_1.getSelectedRow();
             	
             		if(textField_cin_1.getText().equals("") && textField_nomComplet.getText().equals("") && textField_telephone.getText().equals("") && textField_age.getText().equals("")) {
             			JOptionPane.showMessageDialog(null, "Séléctionnez un coache à modifier ");
             		}
             		
             		else {
             			if(i!=-1) {
             				if(textField_cin_1.getText().equals("") || textField_nomComplet.getText().equals("") || textField_telephone.getText().equals("") || textField_age.getText().equals(""))
             				{
             					JOptionPane.showMessageDialog(null, "Remplissez tous les champs , SVP!");
             				
             				}
             				else {
             			
             					table_coach1_1.setValueAt(textField_cin_1.getText(), i, 0);
             					table_coach1_1.setValueAt(textField_nomComplet.getText(), i, 1);
             					table_coach1_1.setValueAt(textField_telephone.getText(), i, 2);
             					table_coach1_1.setValueAt(textField_age.getText(), i, 3);
             			
             					Coach c = new Coach(textField_cin_1.getText(),textField_nomComplet.getText(),Integer.valueOf(textField_telephone.getText()),Integer.valueOf(textField_age.getText()));
             					coach.set(i, c);
             			
             					textField_cin_1.setText("");
             					textField_nomComplet.setText("");
             					textField_telephone.setText("");
             					textField_age.setText("");
             			
             					JOptionPane.showMessageDialog(null, "les information de ce coache ont été bien modidifiées " );
             		}
             	}
             			
             			
             	
             	}
             	}
             	});
             
             btnSupprimer.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		int i = table_coach1_1.getSelectedRow();
             		if(i!=-1) {
             			mod.removeRow(i);
             			coach.remove(i);
             			JOptionPane.showMessageDialog(null,"Ce coache a été bien supprimé de la liste");
             			textField_cin_1.setText("");
                 		textField_nomComplet.setText("");
                 		textField_telephone.setText("");
                 		textField_age.setText("");
             		}
             		else {
             			JOptionPane.showMessageDialog(null, "Selectionnez un coache à supprimer ,SVP!","Empty",JOptionPane.OK_OPTION);
             			}
             	}
             });
             
             
             JButton btnAjouter = new JButton("Ajouter");
             btnAjouter.setBounds(7, 169, 221, 23);
             btnAjouter.setBorder(null);
             btnAjouter.setBackground(Color.white);
             btnAjouter.addMouseListener(new MouseAdapter() {
             	@Override
             	public void mouseEntered(MouseEvent e) {
             		btnAjouter.setBackground(Color.black);
             		btnAjouter.setForeground(Color.white);
             	}
             	public void mouseExited(MouseEvent e) {
             		btnAjouter.setBackground(Color.white);
             		btnAjouter.setForeground(Color.black);
             	}
             });
             btnAjouter.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		
             		if(textField_cin_1.getText().equals("") || textField_nomComplet.getText().equals("") || textField_age.getText().equals("") || textField_telephone.getText().equals("")) {
             			JOptionPane.showMessageDialog(null, "Remplissez tous les champs , SVP!","Manque d'infos",JOptionPane.OK_OPTION);
             		}
             		else {
             			String CIN ,nom_complet;
             			int age,tele;
             			CIN = textField_cin_1.getText();
             			nom_complet = textField_nomComplet.getText();
             			age=Integer.valueOf(textField_telephone.getText());
             			tele=Integer.valueOf(textField_age.getText());
             			
             			boolean ex = false;
             			for(int i=0;i<coach.size();i++) {
             				Coach c = coach.get(i);
             				if(CIN.equals(c.getCIN())) {
             				ex =true;
             			}
             			}
             			if(ex) {
             				JOptionPane.showMessageDialog(null,"Coach déjà inscrit");
             			}
             			else {	
             			
             		Coach c = new Coach(CIN,nom_complet,age,tele);
             		coach.add(c);
             		mod.insertRow(mod.getRowCount(), new Object[] {
             				CIN,nom_complet,age,tele
             		});
             		
             		textField_cin_1.setText("");
             		textField_nomComplet.setText("");
             		textField_telephone.setText("");
             		textField_age.setText("");
             	}
             	}
             	}
             });
             panel_coaches_1.add(btnAjouter);
             
             JLabel lbl_gestion_coach = new JLabel("GESTION DES COACHES");
             lbl_gestion_coach.setForeground(new Color(0, 255, 0));
             lbl_gestion_coach.setBounds(7, 11, 394, 21);
             lbl_gestion_coach.setHorizontalAlignment(SwingConstants.CENTER);
             lbl_gestion_coach.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
             panel_coaches_1.add(lbl_gestion_coach);
             
             JLabel lblNewLabel_11 = new JLabel("");
             lblNewLabel_11.setIcon(new ImageIcon(GymMenu.class.getResource("/images/depositphotos_5669973-Dark-brushed-steel-texture (1).jpg")));
             lblNewLabel_11.setBounds(0, 0, 411, 261);
             panel_coaches_1.add(lblNewLabel_11);
			
			
			lblCoaches.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_coaches_1.setVisible(true);
					panel_membre.setVisible(false);
					panel_intro_1.setVisible(false);
					panel_menu_1.setVisible(false);
					panel_payement_1_1.setVisible(false);
					
				}
			});
			
			lblMembre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_menu_1.setVisible(false);
					panel_membre.setVisible(true);
					panel_intro_1.setVisible(false);
					panel_payement_1_1.setVisible(false);
					panel_coaches_1.setVisible(false);
				}
			});
			
			lblPayement.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_payement_1_1.setVisible(true);
					panel_intro_1.setVisible(false);
					panel_menu_1.setVisible(false);
					panel_membre.setVisible(false);
					panel_coaches_1.setVisible(false);
					
					
				}
			});
			
			
			table_membre.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = table_membre.getSelectedRow();
					textField_cin.setText(model.getValueAt(i, 0).toString());
					textField_nom.setText(model.getValueAt(i, 1).toString());
					textField_prénom.setText(model.getValueAt(i, 2).toString());
					textField_téléphone.setText(model.getValueAt(i, 3).toString());
					for(int j=0;j<12;j++) {
						if(Integer.valueOf(model.getValueAt(i, 4).toString())==j) {
						
							monthChooser_1.setMonth(j-1);
					}
					if(model.getValueAt(i, 5).toString()=="Homme") {
						btnHomme_1.setSelected(true);
						
					}
					else {
						btnFemme_1.setSelected(true);
					}
				}
					if(e.getButton() ==MouseEvent.BUTTON3 ) {
						textField_cin.setText("");
						textField_nom.setText("");
						textField_prénom.setText("");
						textField_téléphone.setText("");
						monthChooser_1.setMonth(-1);
						group.clearSelection();
						table_membre.clearSelection();
					}
			}});
		
			}
	}



