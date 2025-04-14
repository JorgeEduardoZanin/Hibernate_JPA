package pos_java_maven_hibernate.pos_java_maven_hibernate;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import entities.Telefone;
import entities.Usuario;



public class testeHibernate<E> {
	
	private DaoGeneric<Usuario> daoUser = new DaoGeneric<Usuario>();
	private DaoGeneric<Telefone> daoTel = new DaoGeneric<Telefone>();
	
	@Test
	public void testeHibernateUtil() {
		//HibernateUtil.getEntityManager();	
		
		Usuario user = new Usuario("Milena", "Victoria", "teste@gmail.com", "mariache", "12345678",13);
		
		daoUser.Salvar(user);
		
	}
	
	@Test
	public void testeBuscarUpdate() {
		
		Usuario user = new Usuario();
		
		user.setId(1L); 
		Usuario userBuscado = daoUser.buscar(user);
		
		System.out.println(userBuscado);
		userBuscado.setEmail("jorge.santista10@hotmail.com");
		
		daoUser.updateMerge(userBuscado);
		
		System.out.println(userBuscado);
	}
	
	@Test
	public void testeDeletar() {
		
		Usuario user = new Usuario();
		
		user.setId(202L);
		Usuario userBuscado = daoUser.buscar(user);
		
		
		
		daoUser.Excluir(userBuscado);
		
	}
	
	@Test
	public void testeListaUser() {
		List<Usuario> listaDeUser = daoUser.listUser(Usuario.class);
		
		for(Usuario lista: listaDeUser) {
			System.out.println(lista);
		}
	}
	
	@Test 
	public void testeQueryList() {
		List<Usuario> list = daoUser.getEntityManager().createQuery("FROM Usuario WHERE id="+1).getResultList();
		
		for(Usuario usuario: list) {
			System.out.println(usuario);
		}
	}
	
	@Test 
	public void testeQueryListPrimeiros3() {
		List<Usuario> list = daoUser.getEntityManager().createQuery("FROM Usuario ORDER BY name").setMaxResults(3).getResultList();
		
		for(Usuario usuario: list) {
			System.out.println(usuario);
		}
	}
	
	@Test 
	public void testeQueryListParameter() {
		List<Usuario> list = daoUser.getEntityManager().createQuery("FROM Usuario WHERE name = :name ORDER BY name").setParameter("name", "Milena").getResultList();
		
		for(Usuario usuario: list) {
			System.out.println(usuario);
		}
	}
	
	@Test 
	public void somaIdade() {

		Long somaIdade = (Long) daoUser.getEntityManager().createQuery("SELECT sum(u.idade) FROM Usuario u").getSingleResult();
		
		System.out.println(somaIdade);
	}
	
	@Test
	public void namedQueryUser() {
		
		List<Usuario> listaUser = daoUser.getEntityManager().createNamedQuery("usuario.findAll").getResultList();
		
		for(Usuario usuario : listaUser) {
			
			System.out.println(usuario);
		}
	}
	
	@Test
	public void relacionamentoHibernate() {
		
		Usuario user = new Usuario("Milena", "Victoria", "teste@gmail.com", "mariache", "12345678",13);
		
		user.setId(1L); 
		Usuario userBuscado = daoUser.buscar(user);
		
	
		

			Telefone tel = new Telefone("Celular", "(42) 9 9883-5513", userBuscado);
	
	
		
			daoTel.Salvar(tel);
		
	}
	

}
