package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class FabricaDeConexoes {
	
	private FabricaDeConexoes() {
		//Para n�o criar objetos e nem ser exten��o de outras classes. 
	}
	
	public static Connection conectar() {
		Connection retorno = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
            String usr = "root";
            String pwd = "root";
            
            retorno = DriverManager.getConnection(url, usr, pwd);
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
            System.out.println(df.format(new Date()));
            
            DatabaseMetaData dbmd = retorno.getMetaData();
            System.out.println("BD: " + dbmd.getDatabaseProductName() + 
            		" vers�o: " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver: " + dbmd.getDriverName() + 
            		" vers�o: " + dbmd.getDriverVersion());
            
            
		} catch(ClassNotFoundException ex) {
			System.out.println("ERRO: o driver n�o p�de ser carregado.");
			
		} catch (SQLException ex) {
			System.out.println("ERRO: n�o foi poss�vel conectar-se ao banco");
		}
		return retorno;
	}
	
	
	public static void desconectar(Connection con) {
		try{
			if(con != null && !con.isClosed()) {
				con.close();
			}
			
		} catch(Exception e) {
			System.out.println("ERRO: o banco n�o pode ser desconectado.");
		}
	}

}
