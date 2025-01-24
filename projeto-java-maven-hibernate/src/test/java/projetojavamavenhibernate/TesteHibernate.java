package projetojavamavenhibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
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

}
