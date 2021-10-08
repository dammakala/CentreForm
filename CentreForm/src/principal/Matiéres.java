package principal;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.sql.*;

import java.awt.event.ActionEvent;
public class Matiéres  extends JFrame  {
	

	



		JTable table;
		Connection cnx = null;
		PreparedStatement prepared = null;
		ResultSet resultat = null;
		
		public Matiéres(){
			super("Gestion Des Matières");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(1000, 600);
			this.setLocationRelativeTo(null);
			JPanel contentPane = (JPanel) this.getContentPane();
			getContentPane().setLayout(null);
			
			cnx = ConnexionSQL.ConnexionDB();
			
			JLabel NomMat = new JLabel("Nom matière : ");
			NomMat.setBounds(58, 95, 114, 27);
			contentPane.add(NomMat);
			
			JLabel salle = new JLabel("Salle : ");
			salle.setBounds(58, 158, 114, 27);
			contentPane.add(salle);
			
			JLabel date = new JLabel("Date : ");
			date.setBounds(58, 216, 130, 32);
			contentPane.add(date);
			
			JLabel horaire = new JLabel("Horaire : ");
			horaire.setBounds(58, 273, 130, 22);
			contentPane.add(horaire);
			
			JTextField NomTextField = new JTextField();
			NomTextField.setBounds(238, 94, 161, 28);
			contentPane.add(NomTextField);
			
			String Tab[]= {"salle1","salle2"};
			JComboBox <String> salleComboBox = new JComboBox<String>(Tab);
			salleComboBox.setBounds(238, 157, 161, 28);
			contentPane.add(salleComboBox);
			
			String Tab1[]= {"Lundi","Mardi","Mercredi","Jeudi","Vendredi", "Samedi"};
			JComboBox<String> dateComboBox = new JComboBox<String>(Tab1);
			dateComboBox.setBounds(238, 220, 154, 28);
			contentPane.add(dateComboBox);
			
			String Tab2[]= {"8h à 12h","13h à 16h"};
			JComboBox<String> HoraireComboBox = new JComboBox<String>(Tab2);
			HoraireComboBox.setBounds(238, 270, 162, 28);
			contentPane.add(HoraireComboBox);
			
			JButton btnRetour = new JButton("");
			btnRetour.setIcon(new ImageIcon("boutons\\retourPNG.PNG"));
			btnRetour.setBounds(22, 0, 55, 55);
			contentPane.add(btnRetour);
			
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fenetre obj =new Fenetre();
		             obj.setVisible(true);
		             dispose();
				}});

			JButton btnSuppMat = new JButton("");
			btnSuppMat.setIcon(new ImageIcon("boutons\\suppmat.png"));
			btnSuppMat.setBounds(253, 339, 130, 132);
			getContentPane().add(btnSuppMat);
			
			
			btnSuppMat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nom = NomTextField.getText().toString();
					String sql ="delete from matieres where NomMatiere= ?";
					try {
						if (!nom.equals("")) {
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, nom);
						prepared.execute();
						
						JOptionPane.showMessageDialog(null,"Matière supprimée"); 
						
						NomTextField.setText("");
						dateComboBox.setSelectedIndex(0);
						salleComboBox.setSelectedIndex(0);
						HoraireComboBox.setSelectedIndex(0);
						
						
				    }}
						
						
					 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
					
			
			});


			
			JButton btnAjoutMat = new JButton("");
			btnAjoutMat.setIcon(new ImageIcon("boutons\\ajoutermat.png"));
			btnAjoutMat.setBounds(103, 339, 138, 133);
			getContentPane().add(btnAjoutMat);
			btnAjoutMat.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					String nom = NomTextField.getText().toString();
					String salle = salleComboBox.getSelectedItem().toString();
					String horaire = HoraireComboBox.getSelectedItem().toString();
					String date = dateComboBox.getSelectedItem().toString();
					String sql ="insert into matieres(NomMatiere,salle,date,horaire)  values (?,?,?,?)";
					try {
						if (!nom.equals("") && !salle.equals("") && !horaire.equals("") && !date.equals("") ) {
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, nom);
						prepared.setString(2, salle);
						prepared.setString(3, date );
						prepared.setString(4, horaire );
						
						prepared.execute();
						
						JOptionPane.showMessageDialog(null,"Matière ajoutée"); 
						
						NomTextField.setText("");
					
						
			
						}else 
						{
							JOptionPane.showMessageDialog(null,"il faut remplir tous les champs!");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			});
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(517, 74, 404, 441);
			getContentPane().add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					int ligne = table.getSelectedRow();
					String id = table.getModel().getValueAt(ligne, 0).toString();
					String sql ="select * from matieres where NomMatiere='"+id+"'";
					try {
						prepared=cnx.prepareStatement(sql);
						resultat=prepared.executeQuery();
						
						if(resultat.next()) {
							NomTextField.setText(resultat.getString("NomMatiere"));
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
			});
			scrollPane.setViewportView(table);
			

			JButton btnActualiser = new JButton("Actualiser");
			btnActualiser.setIcon(new ImageIcon("boutons\\actualiser.PNG"));
			btnActualiser.setBounds(538, 6, 71, 64);
			getContentPane().add(btnActualiser);
			btnActualiser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UpdateTable();
				}
			});
			
			JLabel lblFond = new JLabel("New label");
			lblFond.setIcon(new ImageIcon("boutons\\body.png"));
			lblFond.setBounds(0, 0, 1000, 600);
			contentPane.add(lblFond);
			}
		
		public void UpdateTable() {
			String sql= "select * from matieres ";
			try {
				prepared=cnx.prepareStatement(sql);
				resultat=prepared.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(resultat));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}


		public static void main(String[] args) throws Exception {
				// apply a look and feel
				UIManager.setLookAndFeel(new NimbusLookAndFeel());
				
				
				
				//start my window
				Matiéres myWindow= new Matiéres();
				myWindow.setVisible(true);

			}
	
}
