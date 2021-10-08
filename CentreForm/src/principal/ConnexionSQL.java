package principal;
import javax.swing.*;
import java.sql.*;
public class ConnexionSQL {
	
	
		 
		Connection cnx = null;
		
		public static Connection ConnexionDB() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncentre","root","");
				return cnx;
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
			
		}

	
}
