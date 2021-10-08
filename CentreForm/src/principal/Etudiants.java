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

public class Etudiants extends JFrame {
		JComboBox<String> MatiereComboBox;
		
		JTable table;
		Connection cnx = null;
		PreparedStatement prepared = null;
		ResultSet resultat = null;
		
		public Etudiants(){
			super("Gestion Des Etudiants");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(1000, 600);
			this.setLocationRelativeTo(null);
			JPanel contentPane = (JPanel) this.getContentPane();
			getContentPane().setLayout(null);
			
			cnx =  ConnexionSQL.ConnexionDB();
			
			JLabel NomEtud = new JLabel("Nom : ");
			NomEtud.setBounds(58, 95, 114, 27);
			contentPane.add(NomEtud);
			
			JLabel PrenomEtud = new JLabel("Prénom : ");
			PrenomEtud.setBounds(58, 158, 114, 27);
			contentPane.add(PrenomEtud);
			
			JLabel NaissEtud = new JLabel("Date de Naissance : ");
			NaissEtud.setBounds(58, 216, 130, 32);
			contentPane.add(NaissEtud);
			
			JLabel MatEtud = new JLabel("Matière : ");
			MatEtud.setBounds(58, 273, 130, 22);
			contentPane.add(MatEtud);
			
			JTextField NomTextField = new JTextField();
			NomTextField.setBounds(238, 94, 161, 28);
			contentPane.add(NomTextField);
			
			JTextField PrenomTextField = new JTextField();
			PrenomTextField.setBounds(238, 157, 161, 28);
			contentPane.add(PrenomTextField);
			
			JTextField dateNaiss = new JTextField();
			dateNaiss.setBounds(238, 220, 154, 28);
			contentPane.add(dateNaiss);
			
			MatiereComboBox = new JComboBox<String>();
			MatiereComboBox.setBounds(238, 270, 162, 28);
			contentPane.add(MatiereComboBox);
			remplirMatiere();
			
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
				

			JButton btnSuppEtud = new JButton("");
			btnSuppEtud.setIcon(new ImageIcon("boutons\\suppetud.png"));
			btnSuppEtud.setBounds(253, 339, 130, 132);
			getContentPane().add(btnSuppEtud);
			
			btnSuppEtud.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nom = NomTextField.getText().toString();
					String prenom = PrenomTextField.getText().toString();
					String date = dateNaiss.getText().toString();
					String sql ="delete from etudiants where NomEtud= ? and PrenomEtud=? ";
					try {
						if (!nom.equals("") && !prenom.equals("") && !date.equals("")) {
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, nom);
						prepared.setString(2, prenom);
						
						prepared.execute();
						
						JOptionPane.showMessageDialog(null,"Etudiant supprimé"); 
						
						NomTextField.setText("");
						PrenomTextField.setText("");
						dateNaiss.setText("");
						MatiereComboBox.setSelectedIndex(0);}}
						
						
					 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
				
			
			});
			
			
			JButton btnAjoutEtud = new JButton("");
			btnAjoutEtud.setIcon(new ImageIcon("boutons\\ajouteretud.png"));
			btnAjoutEtud.setBounds(103, 339, 138, 133);
			getContentPane().add(btnAjoutEtud);
			btnAjoutEtud.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nom = NomTextField.getText().toString();
					String prenom = PrenomTextField.getText().toString();
					String date =  dateNaiss.getText().toString();
					String sql ="insert into etudiants (NomEtud,PrenomEtud,DateNaissance, NomMatiere) values (?,?,?,?)";
					
					try {
						if (!nom.equals("") && !prenom.equals("") && !date.equals("")) {
						prepared = cnx.prepareStatement(sql);
						prepared.setString(1, nom);
						prepared.setString(2, prenom);
						prepared.setString(3, date);
						prepared.setString(4, MatiereComboBox.getSelectedItem().toString());
						prepared.execute();
						
						JOptionPane.showMessageDialog(null,"Etudiant ajouté"); 
						
						NomTextField.setText("");
						PrenomTextField.setText("");
						dateNaiss.setText("");
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
					String sql ="select * from etudiants where idEtud='"+id+"'";
					try {
						prepared=cnx.prepareStatement(sql);
						resultat=prepared.executeQuery();
						
						if(resultat.next()) {
							NomTextField.setText(resultat.getString("NomEtud"));
							PrenomTextField.setText(resultat.getString("PrenomEtud"));
							dateNaiss.setText(resultat.getString("DateNaissance"));
							
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
			String sql= "select * from etudiants ";
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
				Etudiants myWindow= new Etudiants();
				myWindow.setVisible(true);

			}
	}

