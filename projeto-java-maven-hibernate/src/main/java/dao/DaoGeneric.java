package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import projetojavamavenhibernate.HibernateUtil;

public class DaoGeneric<E> {
	
	//Instânciar EntityManager
	private EntityManager entityManager = HibernateUtil.geEntityManager();
	
	//Método de Salvar
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();//Salvar no banco de dados
		
	}
	
	
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
}
