package pos_java_maven_hibernate.pos_java_maven_hibernate;

import org.junit.Test;

import dao.DaoGeneric;
import entities.User;
import util.HibernateUtil;

public class testeHibernate {
	
	private DaoGeneric<User> daoUser = new DaoGeneric<User>();
	
	@Test
	public void testeHibernateUtil() {
		//HibernateUtil.getEntityManager();	
		
		User user = new User("Jorge", "Eduardo", "jorge@gmail.com", "jorgeUser", "password", 15);
	
		daoUser.Salvar(user);
		
	}
	
	@Test
	public void testeBuscarUpdate() {
		
		User user = new User();
		
		user.setId(1L);
		User userBuscado = daoUser.buscar(user);
		
		System.out.println(userBuscado);
		userBuscado.setEmail("jorge.santista10@hotmail.com");
		
		daoUser.updateMerge(userBuscado);
		
		System.out.println(userBuscado);
	}
	
	@Test
	public void testeDeletar() {
		
		User user = new User();
		user.setId(202L);
		daoUser.Excluir(user);
		
	}
	

}
