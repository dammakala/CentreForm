package principal;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.sql.*;
public class Fenetre extends JFrame {
	

		
		JButton btnEtud = new JButton("");
		JButton btnProf = new JButton("");
		JButton btnMat = new JButton("");
		
		JButton btnSalle1 = new JButton("Salle 1 ");
		JButton btnSalle2 = new JButton("Salle 2"); 


		
		public Fenetre() {
			super ("Fenetre");
			this.setSize(1000, 600);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			// Construction et injection de la barre de menu
	        this.setJMenuBar( this.createMenuBar() );

	        // Construction et injection de la barre d'outils
	        JPanel contentPane = (JPanel) getContentPane();
	        contentPane.add( this.createToolBar(), BorderLayout.NORTH );
	        
	        // The content of the window
	        
	        contentPane.add(createLeftPanel(), BorderLayout.WEST);  
	      
	        
	        JScrollPane basScrollPane = new JScrollPane(createBasPanel());
	 
	        
	        JSplitPane splitPane = new JSplitPane(
	               JSplitPane.VERTICAL_SPLIT, createHautPanel(), basScrollPane );
	        contentPane.add( splitPane  ); 
	        
	        
	        btnEtud.setIcon(new ImageIcon("boutons\\etudiant.png"));
	        btnProf.setIcon(new ImageIcon("boutons\\teacher.png"));
	        btnMat.setIcon(new ImageIcon("boutons\\matiere.png"));
	        
	        btnEtud.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Etudiants obj =new Etudiants();
		             obj.setVisible(true);
		             
				}});
	        
	        btnProf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Professeurs obj1 =new Professeurs();
		             obj1.setVisible(true);
		             
		             
				}});
	        
	        btnMat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Matiéres obj2 =new Matiéres();
		             obj2.setVisible(true);
		             
				}});
	        
	        btnSalle1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Salle1 obj3 =new Salle1();
		             obj3.setVisible(true);
		             
				}});
	        
	        btnSalle2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Salle2 obj4 =new Salle2();
		             obj4.setVisible(true);
		             
				}});
	        

	        this.addWindowListener(new WindowAdapter() {
				@Override
			public void windowClosing(WindowEvent e) {
					int ClikedButton = JOptionPane.showConfirmDialog(Fenetre.this, 
							"Etes-vous sûre de quitter?" , "Confirm exit", JOptionPane.YES_NO_OPTION);
					if (ClikedButton == JOptionPane.YES_OPTION)
						dispose();
				};
			});
		}
		
		private JPanel createLeftPanel() {
			JPanel panel = new JPanel (new GridLayout(3,1));
			panel.add(btnEtud);
			panel.add(btnProf);
			panel.add(btnMat);
			return panel;
		}
		
		private JLabel createHautPanel() {
			
			JLabel fond = new JLabel();
			fond.setIcon(new ImageIcon("boutons\\Fenetre1.gif"));
			fond.setBounds(500, 400, 400, 200);
			return fond;
		}
			
		private JPanel createBasPanel() {
			JPanel panel = new JPanel (new GridLayout(1,2));
			panel.add(btnSalle1);
			panel.add(btnSalle2);
			return panel;
		}
	        
	        /* Methode de construction de la barre de menu */
	        private JMenuBar createMenuBar() {

	            // La barre de menu à proprement parler
	            JMenuBar menuBar = new JMenuBar();

	            // Définition du menu déroulant "Etudiant" et de son contenu
	            JMenu mnuFile = new JMenu( "Fichier" );
	            mnuFile.add( actGestEtud);
	            mnuFile.addSeparator();
	            mnuFile.add(actGestProf);
	            mnuFile.addSeparator();
	            mnuFile.add( actGestMat);
	            menuBar.add(mnuFile);
	            
	            //definiton du menu "Salle1"
	            JMenu salle1 = new JMenu("Salle 1");
	            JMenuItem s1_1 = new JMenuItem("Séance 1");
	            salle1.add(s1_1);
	            salle1.addSeparator();
	            JMenuItem s1_2 = new JMenuItem("Séance 2");
	            salle1.add(s1_2);
	            salle1.addSeparator();
	            JMenuItem s1_3 = new JMenuItem("Séance 3");
	            salle1.add(s1_3);
	            salle1.addSeparator();
	            JMenuItem s1_4 = new JMenuItem("Séance 4");
	            salle1.add(s1_4);
	            salle1.addSeparator();
	            JMenuItem s1_5 = new JMenuItem("Séance 5");
	            salle1.add(s1_5);
	            salle1.addSeparator();
	            JMenuItem s1_6 = new JMenuItem("Séance 6");
	            salle1.add(s1_6);
	            salle1.addSeparator();
	            JMenuItem s1_7 = new JMenuItem("Séance 7");
	            salle1.add(s1_7);
	            salle1.addSeparator();
	            JMenuItem s1_8 = new JMenuItem("Séance 8");
	            salle1.add(s1_8);
	            salle1.addSeparator();
	            JMenuItem s1_9 = new JMenuItem("Séance 9");
	            salle1.add(s1_9);
	            salle1.addSeparator();
	            JMenuItem s1_10 = new JMenuItem("Séance 10");
	            salle1.add(s1_10);
	            salle1.addSeparator();
	            JMenuItem s1_11 = new JMenuItem("Séance 11");
	            salle1.add(s1_11);
	            salle1.addSeparator();
	            JMenuItem s1_12 = new JMenuItem("Séance 12");
	            salle1.add(s1_12);
	           
	            menuBar.add(salle1);
	            
	            //les action de la salle 1
	            s1_1.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance1_s1 obj1_1= new salle1.Seance1_s1();
	    				obj1_1.setVisible(true);
	    			}});
	            
	            s1_2.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance2_s1 obj1_2= new salle1.Seance2_s1();
	    				obj1_2.setVisible(true);
	    			}});
	            
	            s1_3.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance3_s1 obj1_3= new salle1.Seance3_s1();
	    				obj1_3.setVisible(true);
	    			}});
	            
	            s1_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salle1.Seance4_s1 obj1_4= new salle1.Seance4_s1();
					obj1_4.setVisible(true);
				}});
	            s1_5.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance5_s1 obj1_5= new salle1.Seance5_s1();
	    				obj1_5.setVisible(true);
	    			}});
	            s1_6.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance6_s1 obj1_6= new salle1.Seance6_s1();
	    				obj1_6.setVisible(true);
	    			}});
	            s1_7.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance7_s1 obj1_7= new salle1.Seance7_s1();
	    				obj1_7.setVisible(true);
	    			}});
	            s1_8.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance8_s1 obj1_8= new salle1.Seance8_s1();
	    				obj1_8.setVisible(true);
	    			}});
	            s1_9.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance9_s1 obj1_9= new salle1.Seance9_s1();
	    				obj1_9.setVisible(true);
	    			}});
	            s1_10.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance10_s1 obj1_10= new salle1.Seance10_s1();
	    				obj1_10.setVisible(true);
	    			}});
	            s1_11.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance11_s1 obj1_11= new salle1.Seance11_s1();
	    				obj1_11.setVisible(true);
	    			}});
	            s1_12.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance12_s1 obj1_12= new salle1.Seance12_s1();
	    				obj1_12.setVisible(true);
	    			}});
	            
	            
	          //definiton du menu "Salle2"
	            JMenu salle2 = new JMenu("Salle 2");
	            JMenuItem s2_1 = new JMenuItem("Séance 1");
	            salle2.add(s2_1);
	            salle2.addSeparator();
	            JMenuItem s2_2 = new JMenuItem("Séance 2");
	            salle2.add(s2_2);
	            salle2.addSeparator();
	            JMenuItem s2_3 = new JMenuItem("Séance 3");
	            salle2.add(s2_3);
	            salle2.addSeparator();
	            JMenuItem s2_4 = new JMenuItem("Séance 4");
	            salle2.add(s2_4);
	            salle2.addSeparator();
	            JMenuItem s2_5 = new JMenuItem("Séance 5");
	            salle2.add(s2_5);
	            salle2.addSeparator();
	            JMenuItem s2_6 = new JMenuItem("Séance 6");
	            salle2.add(s2_6);
	            salle2.addSeparator();
	            JMenuItem s2_7 = new JMenuItem("Séance 7");
	            salle2.add(s2_7);
	            salle2.addSeparator();
	            JMenuItem s2_8 = new JMenuItem("Séance 8");
	            salle2.add(s2_8);
	            salle2.addSeparator();
	            JMenuItem s2_9 = new JMenuItem("Séance 9");
	            salle2.add(s2_9);
	            salle2.addSeparator();
	            JMenuItem s2_10 = new JMenuItem("Séance 10");
	            salle2.add(s2_10);
	            salle2.addSeparator();
	            JMenuItem s2_11 = new JMenuItem("Séance 11");
	            salle2.add(s2_11);
	            salle2.addSeparator();
	            JMenuItem s2_12 = new JMenuItem("Séance 12");
	            salle2.add(s2_12);
	           
	            menuBar.add(salle2);
	            
	            //les action de la salle 2
	            s2_1.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle2.Seance1_s2 obj2_1= new salle2.Seance1_s2();
	    				obj2_1.setVisible(true);
	    			}});
	            
	            s2_2.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle2.Seance2_s2 obj2_2= new salle2.Seance2_s2();
	    				obj2_2.setVisible(true);
	    			}});
	            
	            s2_3.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle2.Seance3_s2 obj2_3= new salle2.Seance3_s2();
	    				obj2_3.setVisible(true);
	    			}});
	            
	            s2_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salle2.Seance4_s2 obj2_4= new salle2.Seance4_s2();
					obj2_4.setVisible(true);
				}});
	            s2_5.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance5_s1 obj2_5= new salle1.Seance5_s1();
	    				obj2_5.setVisible(true);
	    			}});
	            s2_6.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance6_s1 obj2_6= new salle1.Seance6_s1();
	    				obj2_6.setVisible(true);
	    			}});
	            s2_7.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance7_s1 obj2_7= new salle1.Seance7_s1();
	    				obj2_7.setVisible(true);
	    			}});
	            s2_8.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance8_s1 obj2_8= new salle1.Seance8_s1();
	    				obj2_8.setVisible(true);
	    			}});
	            s2_9.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance9_s1 obj2_9= new salle1.Seance9_s1();
	    				obj2_9.setVisible(true);
	    			}});
	            s2_10.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance10_s1 obj2_10= new salle1.Seance10_s1();
	    				obj2_10.setVisible(true);
	    			}});
	            s2_11.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance11_s1 obj2_11= new salle1.Seance11_s1();
	    				obj2_11.setVisible(true);
	    			}});
	            s2_12.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				salle1.Seance12_s1 obj2_12= new salle1.Seance12_s1();
	    				obj2_12.setVisible(true);
	    			}});
	                
	       
	        
			return menuBar;
	}
	        /* Methode de construction de la barre d'outils */
	        private JToolBar createToolBar() {
	            JToolBar toolBar = new JToolBar();

	            toolBar.add( actGestEtud ).setHideActionText( false );
	            toolBar.addSeparator();
	            toolBar.add( actGestProf ).setHideActionText( false );
	            toolBar.addSeparator();
	            toolBar.add( actGestMat ).setHideActionText( false );
				return toolBar;
	            }
	        
	        /* Nos diverses actions */
	        private AbstractAction actGestEtud = new AbstractAction() {  
				private static final long serialVersionUID = 1L;

				{
	                putValue( Action.NAME, "Gestion des Etudiants" );
	                putValue( Action.SMALL_ICON, new ImageIcon( "boutons\\iconetud.png" ) );
	                putValue( Action.SHORT_DESCRIPTION, "Gestion des Etudiants (CTRL+E)" );
	                putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK ) ); 
	            }
	            
	            @Override public void actionPerformed( ActionEvent e ) {
	    				Etudiants obj =new Etudiants();
	    	             obj.setVisible(true);
	    	             
	            }
	        };
	        
	        private AbstractAction actGestProf = new AbstractAction() {  
				private static final long serialVersionUID = 1L;

				{
	                putValue( Action.NAME, "Gestion des professeurs" );
	                putValue( Action.SMALL_ICON, new ImageIcon( "boutons\\iconprof.png" ) );
	                putValue( Action.SHORT_DESCRIPTION, "Gestion des Professeurs (CTRL+P)" );
	                putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK ) ); 
	            }
	            
	            @Override public void actionPerformed( ActionEvent e ) {
	            	Professeurs obj1 =new Professeurs();
		             obj1.setVisible(true);
		             
	            }
	        };
	        
	        private AbstractAction actGestMat = new AbstractAction() {
				private static final long serialVersionUID = 1L;

				{
	                putValue( Action.NAME, "Gestion des matieres" );
	                putValue( Action.SMALL_ICON,new ImageIcon( "boutons\\iconmatiere.png" ) );
	                putValue( Action.SHORT_DESCRIPTION, "Gestion des Matières (CTRL+M)" );
	                putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK ) ); 
	            }
	            
	            @Override public void actionPerformed( ActionEvent e ) {
	            	Matiéres obj2 =new Matiéres();
		             obj2.setVisible(true);
		             
	            }
	        };
	        
	      
	        
		public static void main(String[] args) throws Exception {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			Fenetre window = new Fenetre();
			window.setVisible(true);

		}
		
	}

