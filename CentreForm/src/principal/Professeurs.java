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

import java.awt.event.ActionEvent;
public class Professeurs extends JFrame {
	

	    JComboBox<String> MatiereComboBox;
		
		JTable table;
		Connection cnx = null;
		PreparedStatement prepared = null;
		ResultSet resultat = null;
		
		public Professeurs(){
			super("Gestion Des Professeurs");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(1000, 600);
			this.setLocationRelativeTo(null);
			JPanel contentPane = (JPanel) this.getContentPane();
			getContentPane().setLayout(null);
			
			cnx = ConnexionSQL.ConnexionDB();
			
			JLabel NomProf = new JLabel("Nom : ");
			NomProf.setBounds(58, 95, 114, 27);
			contentPane.add(NomProf);
			
			JLabel PrenomProf = new JLabel("Prénom : ");
			PrenomProf.setBounds(58, 158, 114, 27);
			contentPane.add(PrenomProf);
			
			JLabel SalaireProf = new JLabel("Salaire : ");
			SalaireProf.setBounds(58, 216, 130, 32);
			contentPane.add(SalaireProf);
			
			JLabel MatProf = new JLabel("Matière : ");
			MatProf.setBounds(58, 273, 130, 22);
			contentPane.add(MatProf);
			
			JTextField NomTextField = new JTextField();
			NomTextField.setBounds(238, 94, 161, 28);
			contentPane.add(NomTextField);
			
			JTextField PrenomTextField = new JTextField();
			PrenomTextField.setBounds(238, 157, 161, 28);
			contentPane.add(PrenomTextField);
			
			JTextField salaireTextField = new JTextField();
			salaireTextField.setBounds(238, 220, 154, 28);
			contentPane.add(salaireTextField);
			
			MatiereComboBox = new JComboBox<String>();
			MatiereComboBox.setBounds(238, 270, 162, 28);
			contentPane.add(MatiereComboBox);
			remplirMatiere();
			
			//precedent
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

			JButton btnSuppProf = new JButton("");
			btnSuppProf.setIcon(new ImageIcon("boutons\\supprimerprof.png"));
			btnSuppProf.setBounds(253, 339, 130, 132);
			getContentPane().add(btnSuppProf);
			
			btnSuppProf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nom = NomTextField.getText().toString();
					String prenom = PrenomTextField.getText().toString();
					String salaire = salaireTextField.getText().toString();
					String sql ="delete from professeurs where NomProf= ? and PrenomProf=? ";
					try {
						if (!nom.equals("") && !prenom.equals("") && !salaire.equals("")) {
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, nom);
						prepared.setString(2, prenom);
						
						prepared.execute();
						
						JOptionPane.showMessageDialog(null,"Professeur supprimé"); 
						
						NomTextField.setText("");
						PrenomTextField.setText("");
						salaireTextField.setText("");}}
						
						
					 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
					
			
			});
			
			JButton btnAjoutProf = new JButton("");
			btnAjoutProf.setIcon(new ImageIcon("boutons\\ajouterprof.png"));
			btnAjoutProf.setBounds(103, 339, 138, 133);
			getContentPane().add(btnAjoutProf);
			btnAjoutProf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nom = NomTextField.getText().toString();
					String prenom = PrenomTextField.getText().toString();
					String salaire =  salaireTextField.getText().toString();
					String sql ="insert into professeurs (NomProf,PrenomProf,Salaire,NomMatiere) values (?,?,?,?)";
					try {
						if (!nom.equals("") && !prenom.equals("") && !salaire.equals("")) {
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, nom);
						prepared.setString(2, prenom);
						prepared.setString(3, salaire);
						prepared.setString(4, MatiereComboBox.getSelectedItem().toString());
						prepared.execute();
						JOptionPane.showMessageDialog(null,"Professeur ajoutée"); 
						
						NomTextField.setText("");
						PrenomTextField.setText("");
						salaireTextField.setText("");
						MatiereComboBox.setSelectedIndex(0);
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
					String sql ="select * from professeurs where idProf='"+id+"'";
					try {
						prepared=cnx.prepareStatement(sql);
						resultat=prepared.executeQuery();
						
						if(resultat.next()) {
							NomTextField.setText(resultat.getString("NomProf"));
							PrenomTextField.setText(resultat.getString("PrenomProf"));
							salaireTextField.setText(resultat.getString("Salaire"));
							
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
			btnActualiser.setBounds(537, 6, 68, 64);
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
			String sql= "select * from professeurs ";
			try {
				prepared=cnx.prepareStatement(sql);
				resultat=prepared.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(resultat));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		public void remplirMatiere() {
			String sql = "select * from matieres";
			
			try {
				prepared= cnx.prepareStatement(sql);
				resultat= prepared.executeQuery();
				
				while (resultat.next()) {
					String nom = resultat.getString("NomMatiere").toString();
					MatiereComboBox.addItem(nom);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


		public static void main(String[] args) throws Exception {
				// apply a look and feel
				UIManager.setLookAndFeel(new NimbusLookAndFeel());
				
				
				
				//start my window
				Professeurs myWindow= new Professeurs();
				myWindow.setVisible(true);

			}
	
}
