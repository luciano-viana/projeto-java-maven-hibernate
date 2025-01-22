package projetojavamavenhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Class será resposável por ler o arquivo "persistence.xml" e deixar instânciado a conexão com o banco de dados
public class HibernateUtil {
	
	//Fábrica de conexão do Hibernat
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	//Método que irá ler o arquivo "persistence.xml"
	private static void init() {
		
		try {
			
			if(factory == null) {
				factory = Persistence.createEntityManagerFactory("projeto-java-maven-hibernate");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Retornar a o gerenciador de entidade para poder fazer as operações no banco de dados
	public static EntityManager geEntityManager() {
		return factory.createEntityManager();//Prove a parte de persistência
	}

}
