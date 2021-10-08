package principal;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Salle1 extends JFrame{
	
	public Salle1() {
		super ("Salle 1");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel contentPane = (JPanel) getContentPane();
		getContentPane().setLayout(null);
		
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
		
		JButton btnSeance1 = new JButton("seance 1");
		btnSeance1.setBounds(191, 158, 111, 62);
		contentPane.add(btnSeance1);
		
		JButton btnSeance2 = new JButton("seance 2");
		btnSeance2.setBounds(191, 373, 111, 62);
		contentPane.add(btnSeance2);
		
		JButton btnSeance3 = new JButton("seance 3");
		btnSeance3.setBounds(334, 158, 111, 62);
		contentPane.add(btnSeance3);
		
		JButton btnSeance4 = new JButton("seance 4");
		btnSeance4.setBounds(334, 373, 111, 62);
		contentPane.add(btnSeance4);
		
		JButton btnSeance5 = new JButton("seance 5");
		btnSeance5.setBounds(471, 158, 111, 62);
		contentPane.add(btnSeance5);
		
		JButton btnSeance6 = new JButton("seance 6");
		btnSeance6.setBounds(471, 373, 111, 62);
		contentPane.add(btnSeance6);
		
		JButton btnSeance7 = new JButton("seance 7");
		btnSeance7.setBounds(610, 158, 111, 62);
		contentPane.add(btnSeance7);
		
		JButton btnSeance8 = new JButton("seance 8");
		btnSeance8.setBounds(610, 373, 111, 62);
		contentPane.add(btnSeance8);
		
		JButton btnSeance9 = new JButton("seance 9");
		btnSeance9.setBounds(754, 158, 111, 62);
		contentPane.add(btnSeance9);
		
		JButton btnSeance10 = new JButton("seance 10");
		btnSeance10.setBounds(754, 373, 111, 62);
		contentPane.add(btnSeance10);
		
		JButton btnSeance11 = new JButton("seance 11");
		btnSeance11.setBounds(887, 158, 97, 62);
		contentPane.add(btnSeance11);
		
		JButton btnSeance12 = new JButton("seance 12");
		btnSeance12.setBounds(887, 373, 97, 62);
		contentPane.add(btnSeance12);
		
		JLabel lblfond = new JLabel("New label");
		lblfond.setIcon(new ImageIcon("boutons\\emploi.png"));
		lblfond.setBounds(0, 0, 1000, 600);
		contentPane.add(lblfond);
		
		btnSeance1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance1_s1 obj1= new salle1.Seance1_s1();
				obj1.setVisible(true);
			}});
		
		btnSeance2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance2_s1 obj2= new salle1.Seance2_s1();
				obj2.setVisible(true);
			}});
		
		btnSeance3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance3_s1 obj3= new salle1.Seance3_s1();
				obj3.setVisible(true);
			}});
		
		btnSeance4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance4_s1 obj4= new salle1.Seance4_s1();
				obj4.setVisible(true);
			}});
		
		btnSeance5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance5_s1 obj5= new salle1.Seance5_s1();
				obj5.setVisible(true);
			}});
		
		btnSeance6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance6_s1 obj6= new salle1.Seance6_s1();
				obj6.setVisible(true);
			}});
		
		btnSeance7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance7_s1 obj7= new salle1.Seance7_s1();
				obj7.setVisible(true);
			}});
		
		btnSeance8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance8_s1 obj8= new salle1.Seance8_s1();
				obj8.setVisible(true);
			}});
		
		btnSeance9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance9_s1 obj9= new salle1.Seance9_s1();
				obj9.setVisible(true);
			}});
		
		btnSeance10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance10_s1 obj10= new salle1.Seance10_s1();
				obj10.setVisible(true);
			}});
		
		btnSeance11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance11_s1 obj11= new salle1.Seance11_s1();
				obj11.setVisible(true);
			}});
		
		btnSeance12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salle1.Seance12_s1 obj12= new salle1.Seance12_s1();
				obj12.setVisible(true);
			}});
	}
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		Salle1 window = new Salle1();
		window.setVisible(true);

	}
}



