package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import projetojavamavenhibernate.HibernateUtil;

public class DaoGeneric<E> {
	
	//Instânciar EntityManager
	private EntityManager entityManager = HibernateUtil.geEntityManager();
	
	//-------------------------------------------------------------------------------------
	//Método de Salvar
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();//Salvar no banco de dados
		
	}
	
	//-------------------------------------------------------------------------------------
	//Método de Consulta Tipo1
	public E pesquisar(E entidade) {
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		E e = (E) entityManager.find(entidade.getClass(), id);
		
		return e;
	}
	
	//Método de Consulta Tipo2
	public E pesquisar(Long id, Class<E> entidade) {//Receber ID direto
			
		E e = (E) entityManager.find(entidade, id);
			
		return e;
	}
		
	//-------------------------------------------------------------------------------------
	//Método de Update "Atualizar"
	public E updateMerge(E entidade) {//salva ou atualiza
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			E entidadeSalva = entityManager.merge(entidade);
			transaction.commit();//Salvar no banco de dados
			
			return entidadeSalva;
	
   }

   //-------------------------------------------------------------------------------------
   //Método de Delete "Excluir"
   public void deletarPorID(E entidade) {
	   
	   Object id = HibernateUtil.getPrimaryKey(entidade);
	   
	   EntityTransaction transaction = entityManager.getTransaction();
	   transaction.begin();
	   
	   entityManager.createNativeQuery(
			   "delete from " + entidade.getClass().getSimpleName().toLowerCase() + 
			   " where id = " + id).executeUpdate(); // faz delete
	   transaction.commit();// grava alteração no banco
	   
   }
	
   //-------------------------------------------------------------------------------------
   //Método de Consultar
   public List<E> listar(Class<E> entidade){
	   EntityTransaction transaction = entityManager.getTransaction();
	   transaction.begin();
	   
	   List<E> lista = entityManager.createQuery("from "+ entidade.getName()).getResultList();
	   
	   transaction.commit();
	   
	   return lista;
   }
   
   //-------------------------------------------------------------------------------------
   //Entity Manager dentro do Dao para acessar em outras partes do projeto
   public EntityManager getEntityManager() {
	return entityManager;
   }
   
}