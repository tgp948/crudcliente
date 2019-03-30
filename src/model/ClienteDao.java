package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.FabricaDeConexoes;

public class ClienteDao {
	
	public void inserir(Cliente cliente) throws Exception{
		if (cliente != null && cliente.getId() == 0) {
			
			Connection con = null;
			
			try {
				
				con = FabricaDeConexoes.conectar();
				String sql = "INSERT INTO cliente (nome, email, datnasc, sexo, estcivil, ativo, cpf) VALUES (?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getEmail());
				ps.setString(3, cliente.getDatnasc().toString());
				ps.setString(4, cliente.getSexo());
				ps.setString(5, cliente.getEstcivil());
				ps.setInt(6, cliente.getAtivo());
				ps.setString(7, cliente.getCpf());
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Inconsistencia nos dados.", e);
				
			} finally {
				FabricaDeConexoes.desconectar(con);
				
			}
		}
	}
		
		
		public List<Cliente> listar(){
			
			List<Cliente> retorno = new ArrayList<Cliente>();
			Connection con = null;
			
			try {
				
				con = FabricaDeConexoes.conectar();
				Statement stmt = con.createStatement();
				String sql = "SELECT * FROM cliente ORDER BY nome;";
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					
					/*Cliente cliente = new Cliente();
					cliente.setId(rs.getInt("idcliente"));
					cliente.setNome(rs.getString("nome"));
					cliente.setEmail(rs.getString("email"));
					cliente.setDatnasc(rs.getDate("datnasc"));
					cliente.setSexo(rs.getString("sexo"));
					cliente.setEstcivil(rs.getString("estcivil"));
					cliente.setAtivo(rs.getInt("ativo"));
					cliente.setCpf(rs.getString("cpf"));
					retorno.add(cliente);*/
					
					retorno.add(this.preencheCliente(rs));
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				FabricaDeConexoes.desconectar(con);
				
			}
			
			return retorno;
			
		}
	
		
	public Cliente obter(int id) {
		
		Cliente retorno = null;
		
		if(id > 0 ) {
			Connection con = null;
			try {
				con = FabricaDeConexoes.conectar();
				String sql = "SELECT * FROM cliente WHERE idcliente=?;";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					
					retorno = this.preencheCliente(rs);
					
				} 
			}catch(Exception e) {
				e.printStackTrace();
			
			}finally {
				FabricaDeConexoes.desconectar(con);
				
			}
			
			
		}
		return retorno;
	}
	
	
	private Cliente preencheCliente(ResultSet rs) throws Exception{
		Cliente cliente = new Cliente();
		try {
		cliente.setId(rs.getInt("idcliente"));
		cliente.setNome(rs.getString("nome"));
		cliente.setEmail(rs.getString("email"));
		cliente.setDatnasc(rs.getDate("datnasc"));
		cliente.setSexo(rs.getString("sexo"));
		cliente.setEstcivil(rs.getString("estcivil"));
		cliente.setAtivo(rs.getInt("ativo"));
		cliente.setCpf(rs.getString("cpf"));
		
		}finally{
		}
		
		return cliente;
		
	}
	
	
	public void excluir(int id) {
		
		if(id > 0) {
			Connection con = null;
			try {
				con = FabricaDeConexoes.conectar();
				String sql = "DELETE FROM cliente WHERE id=?;";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				FabricaDeConexoes.desconectar(con);
				
			}
		}
	}

	
	public List<Cliente> listarPorCPF(String cpf){
		
		List<Cliente> retorno = new ArrayList<Cliente>();
		Connection con = null;
		
		try {
			
			con = FabricaDeConexoes.conectar();
			String sql = "SELECT * FROM cliente WHERE cpf=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				retorno.add(this.preencheCliente(rs));
				
			} 
		}catch(Exception e) {
			
		e.printStackTrace();
		
	}finally {
		FabricaDeConexoes.desconectar(con);
		
	}
	
	return retorno;
	}
	
	
	
	public List<Cliente> listarPorNome(String nome){
			
			List<Cliente> retorno = new ArrayList<Cliente>();
			Connection con = null;
			
			try {
				
				con = FabricaDeConexoes.conectar();
				String sql = "SELECT * FROM cliente WHERE nome=?;";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, nome);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					
					retorno.add(this.preencheCliente(rs));
					
				} 
			}catch(Exception e) {
				
			e.printStackTrace();
			
		}finally {
			FabricaDeConexoes.desconectar(con);
			
		}
		
		return retorno;
	}
	
	
	public List<Cliente> listarPorNomeCPF(String nome, String cpf) {
		
		List<Cliente> retorno = new ArrayList<Cliente>();
		Connection con = null;
		
		try {
			
			con = FabricaDeConexoes.conectar();
			String sql = "SELECT * FROM cliente WHERE nome=? AND cpf=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				retorno.add(this.preencheCliente(rs));
				
			} 
		}catch(Exception e) {
			
		e.printStackTrace();
		
	}finally {
		FabricaDeConexoes.desconectar(con);
		
	}
	
	return retorno;
}
	
	
	
	
	
	
}
