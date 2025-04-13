package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.HibernateUtil;

public class DaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void Salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	public void Excluir(E entidade) {
		
		Object id = HibernateUtil.getPrimaryKey(entidade);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.createNativeQuery("DELETE FROM usuario WHERE id = " + id).executeUpdate();

		transaction.commit();  
	}
	
	@SuppressWarnings("unchecked")
	public E buscar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
	 
		E e = (E)entityManager.find(entidade.getClass(), id);
		
		return e;
	}
	
	public E updateMerge(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		
		return entidadeSalva;
	}
	
	public List<E> listUser(Class<E> entidade){
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		@SuppressWarnings("unchecked")
		List<E> lista = entityManager.createQuery("FROM "+entidade.getName()).getResultList();
		
		transaction.commit();
		
		return lista;
		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
}
