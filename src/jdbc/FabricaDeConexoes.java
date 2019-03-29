package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class FabricaDeConexoes {
	
	private FabricaDeConexoes() {
		//Para não criar objetos e nem ser extenção de outras classes. 
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
            		" versão: " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver: " + dbmd.getDriverName() + 
            		" versão: " + dbmd.getDriverVersion());
            
            
		} catch(ClassNotFoundException ex) {
			System.out.println("ERRO: o driver não pôde ser carregado.");
			
		} catch (SQLException ex) {
			System.out.println("ERRO: não foi possível conectar-se ao banco");
		}
		return retorno;
	}
	
	
	public static void desconectar(Connection con) {
		try{
			if(con != null && !con.isClosed()) {
				con.close();
			}
			
		} catch(Exception e) {
			System.out.println("ERRO: o banco não pode ser desconectado.");
		}
	}

}
