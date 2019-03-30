package model;

import java.util.ArrayList;
import java.util.List;

public class ClienteDlo {
	
	public boolean cadastrar(Cliente cliente) {
		boolean retorno = false;
		
		if(cliente.getId() == 0) {
			retorno = true;
			ClienteDao clienteDao = new ClienteDao();
			try {
				clienteDao.inserir(cliente);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}				
		
		return retorno;
	}
	
	public boolean editar(Cliente cliente) {
		boolean retorno = false;
		if(cliente != null) {
		if(cliente.getId() > 0 && cliente.getNome() != null && cliente.getNome() != "" && cliente.getCpf() != null && cliente.getCpf() != "" && cliente.getDatnasc() != null && cliente.getEmail() != null && cliente.getEstcivil() != null && cliente.getSexo() != null) {
			ClienteDao clienteDao = new ClienteDao();
			clienteDao.alterar(cliente);
			retorno = true;
		}
		}
		
		return retorno;
		
	}
	
	
	public boolean deletar(int id) {
		boolean retorno = false;
		if(id > 0) {
			ClienteDao clienteDao = new ClienteDao();
			clienteDao.excluir(id);
			retorno = true;
		}
		
		
		return retorno;
	}
	
	public List<Cliente> listarTudo(){
		List<Cliente> retorno = new ArrayList<Cliente>();
		ClienteDao clienteDao = new ClienteDao();
		retorno = clienteDao.listar();
		
		return retorno;
	}
	
	
	public Cliente clienteUnico(int id) {
		Cliente retorno = null;
		if(id > 0) {
			ClienteDao clienteDao = new ClienteDao();
			retorno = clienteDao.obter(id);
		}
		
		return retorno;
	}
	
	
	public List<Cliente> filtrar(String nome, String cpf){
		List<Cliente> retorno = new ArrayList<Cliente>();
		ClienteDao clienteDao = new ClienteDao();
		if(nome != "" && nome != null && cpf != "" && cpf != null) {
			retorno = clienteDao.listarPorNomeCPF(nome, cpf);
			
		} else if(nome != "" && nome != null && (cpf == "" || cpf == null)) {
			retorno = clienteDao.listarPorNome(nome);
		}else if((nome == "" || nome == null) && cpf != "" && cpf != null) {
			retorno = clienteDao.listarPorCPF(cpf);
		}
		
		return retorno;
	}
	
	public boolean deletarLote(int[] listaId) {
		boolean retorno = false;
		int contador = 0;
		for(int a = 0; a < listaId.length; a++) {
			if(listaId[a] > 0) {
				this.deletar(listaId[a]);
			}
		}
		if(contador > 0) {
			
		}
		
		return retorno;
	}

}
