package projetojavamavenhibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	//-------------------------------------------------------------------------------------
	//Método Salvar
	@Test
	public void testeHibernateUtil() {
		//HibernateUtil.geEntityManager(); //Utilizado para testar conexão com o BD
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		//Setar os objetos
		pessoa.setIdade(34);
		pessoa.setLogin("admteste");
		pessoa.setSenha("123");
		pessoa.setNome("Luciano 2");
		pessoa.setSobrenome("Viana");
		pessoa.setEmail("lucianoviana12@gmail.com");
		
		daoGeneric.salvar(pessoa);
		
	}
	
	//-------------------------------------------------------------------------------------
	//Método Buscar Tipo1 "Consultar"
	@Test
	public void testeBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
	}
	
	
	//Método Buscar Tipo2 "Consultar"
	@Test
	public void testeBuscar2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
			
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
			
		System.out.println(pessoa);
	}
		
	//-------------------------------------------------------------------------------------
	//Método de Update "Atualizar"
	@Test
	public void testeUpdate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
			
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
		
		pessoa.setIdade(50);
		pessoa.setNome("Nome atualizado Hibernete");
		
		pessoa = daoGeneric.updateMerge(pessoa);
			
		System.out.println(pessoa);
	}
		
	//-------------------------------------------------------------------------------------
   //Método de Delete "Excluir"
   @Test
   public void testeDelete() {
	    DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
			
		UsuarioPessoa pessoa = daoGeneric.pesquisar(15L, UsuarioPessoa.class);
		
		daoGeneric.deletarPorID(pessoa);
			
		System.out.println(pessoa);
	}

}


















