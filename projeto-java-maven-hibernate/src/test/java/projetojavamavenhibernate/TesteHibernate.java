package projetojavamavenhibernate;

import java.util.List;

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
		pessoa.setNome("Luciano 1");
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
			
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L, UsuarioPessoa.class);
		
		daoGeneric.deletarPorID(pessoa);
			
		System.out.println(pessoa);
	}

   //-------------------------------------------------------------------------------------
   //Método de Consultar
   @Test
   public void testeConsultar() {
	    DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
			
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
		
		for(UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("----------------------------------------------");

		}
	}
   
   //-------------------------------------------------------------------------------------
   //Método para consultar com condições sem precisar criar métodos no DaoGeneric
   @Test
   public void testeQueryList() {
	   DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>(); 
	   List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery
			   ("from UsuarioPessoa where id = 20").getResultList();
	   
	   for (UsuarioPessoa usuarioPessoa : list) {
		System.out.println(usuarioPessoa);
	}
	   
   }
   
   //-------------------------------------------------------------------------------------
   // Método para consultar com ordenação dos dados e com limite máximo de resultados
   @Test
   public void testeQueryListMaxResult() {
	   DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>(); 
	   List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery
			   ("from UsuarioPessoa order by nome")
			   .setMaxResults(4)
			   .getResultList();
	   
	   for (UsuarioPessoa usuarioPessoa : list) {
		System.out.println(usuarioPessoa);
	}
	   
   }
   
   //-------------------------------------------------------------------------------------
   // Método para consultar com parâmetros e queryes condicionais
   @Test
   public void testeQueryListParameter() {
	   DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	   List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery
			   ("from UsuarioPessoa where nome = : nome or sobrenome = : sobrenome order by nome")
			   .setParameter("nome", "Luciano 3")
			   .setParameter("sobrenome", "Vianadd")
			   .getResultList();
	   
	   for (UsuarioPessoa usuarioPessoa : list) {
		System.out.println(usuarioPessoa);
	}
	   
   }
   
  //-------------------------------------------------------------------------------------
  // Método de consulta com operações matemáticas
  @Test
  public void testeQuerySoma() {
	  DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	  
	  Long somaIdade = (Long) daoGeneric.getEntityManager().
			  createQuery("select sum(u.idade) from UsuarioPessoa u").getSingleResult();
	  
	  System.out.println("Soma de todas as idades é --> " + somaIdade);
  }
  
  //-------------------------------------------------------------------------------------
  // Método de consulta todos os dados utilizando NamedQuerey na classe UsuarioPessoa
  @Test
  public void testeNameQuery1() {
	  DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	  List<UsuarioPessoa> list = daoGeneric.getEntityManager().
			  createNamedQuery("UsuarioPessoa.todos").getResultList();
	  
	  for (UsuarioPessoa usuarioPessoa : list) {
		System.out.println(usuarioPessoa);
	}
  }
  
  //-------------------------------------------------------------------------------------
  // Método de consulta dos dados com filtro nome utilizando NamedQuerey na classe UsuarioPessoa
  @Test
  public void testeNameQuery2() {
	  DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	  
	  List<UsuarioPessoa> list = daoGeneric.getEntityManager().
			  createNamedQuery("UsuarioPessoa.buscaPorNome")
			  .setParameter("nome", "Luciano 5")
			  .getResultList();
	  
	  for (UsuarioPessoa usuarioPessoa : list) {
		System.out.println(usuarioPessoa);
	}
			  
  }
   
}


















