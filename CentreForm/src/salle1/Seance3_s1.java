package salle1;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import principal.ConnexionSQL;



public class Seance3_s1 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JLabel lblMatiere= new JLabel("Matière :");
	private JLabel lblProf= new JLabel("Professeur :");
	private JList<String> list;

		public Seance3_s1() {
			super ("Mardi de 8h à 12h");
			this.setSize(420,290);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			cnx =  ConnexionSQL.ConnexionDB();
			
	        JPanel contentPane = (JPanel) getContentPane();
	        
	        JScrollPane projectScrollPane = new JScrollPane(createLeftPanel());
	        projectScrollPane.setPreferredSize( new Dimension( 150, 0 ) );
	        
	       
	        
	        JScrollPane editorScrollPane = new JScrollPane( createRightPanel() );
	        
	        
	        JSplitPane mainSplitPane = new JSplitPane(
	                JSplitPane.HORIZONTAL_SPLIT, projectScrollPane, editorScrollPane );
	        contentPane.add( mainSplitPane /*, BorderLayout.CENTER */ );    

		
		
		}
		private JPanel createRightPanel() {
			
			JPanel panel= new JPanel();
			panel.setLayout(null);
			lblMatiere.setBounds(0, 0, 500, 100);
			panel.add(lblMatiere);
			lblProf.setBounds(0, 100, 566, 140);
			panel.add(lblProf);
			
			JLabel lblNewLabel = new JLabel(nomMatiere());
			lblNewLabel.setBounds(139, 0, 500, 100);
			panel.add(lblNewLabel);
			
			
			JLabel lblNewLabel_1 = new JLabel(nomProf());
			lblNewLabel_1.setBounds(139, 165, 80, 10);
			panel.add(lblNewLabel_1);
			
	
			
			return panel;
		}
		
		private JPanel createLeftPanel() {
			JPanel panel = new JPanel();
			//panel.setLayout(null);
			list= new JList<String>();
			panel.add(list);
			listeEtudiants();
			
			return panel;
		}
	
		
		public String nomMatiere() {
			String sql = "select NomMatiere from matieres where salle='salle1' and date='Mardi' and horaire='8h à 12h'";
			
			try {
				prepared= cnx.prepareStatement(sql);
				resultat= prepared.executeQuery();
				
				while (resultat.next()) {
					String nom = resultat.getString("NomMatiere").toString();
					return nom;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
		}
		
		public String nomProf() {
			String sql = "select NomProf, PrenomProf from professeurs where NomMatiere in (select NomMatiere from matieres where salle='salle1' and date='Mardi' and horaire='8h à 12h')";
			
			try {
				prepared= cnx.prepareStatement(sql);
				resultat= prepared.executeQuery();
				
				while (resultat.next()) {
					String nom = resultat.getString("NomProf").toString();
					String prenom = resultat.getString("PrenomProf").toString();
					String prof= nom.concat( " "+prenom);
					return prof;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
		}
		
		public void listeEtudiants() {
			DefaultListModel<String> dlm= new DefaultListModel<String>();
			String sql = "select NomEtud, PrenomEtud from etudiants where NomMatiere in (select NomMatiere from matieres where salle='salle1' and date='Mardi' and horaire='8h à 12h')";
			
			try {
				prepared= cnx.prepareStatement(sql);
				resultat= prepared.executeQuery();
				
				while (resultat.next()) {
					String nom = resultat.getString("NomEtud").toString();
					String prenom = resultat.getString("PrenomEtud").toString();
					String etud= nom.concat( " "+prenom);
					
					dlm.addElement(etud);
					list.setModel(dlm);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
		public static void main(String[] args) throws Exception {
			  UIManager.setLookAndFeel( new NimbusLookAndFeel() );
			  Seance3_s1 frame = new Seance3_s1();
		        frame.setVisible(true);

		}
}