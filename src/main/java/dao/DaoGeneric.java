package dao;

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
		
		Object objeto = HibernateUtil.getPrimaryKey(entidade);

		entityManager.getTransaction().begin();
		entityManager.remove(objeto);
		entityManager.getTransaction().commit();
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
	
	
}
