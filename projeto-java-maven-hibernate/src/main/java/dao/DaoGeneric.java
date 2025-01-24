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
	
}
