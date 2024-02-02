package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListModel;

/**
 * @author emilylester empope1
 * CIS 175 Spring 2024
 * Jan 31, 2024
 */
public class ListModelHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Dodges");
	
	public void insertModel(ListModel li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);;
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListModel>showAllModels(){
		EntityManager em = emfactory.createEntityManager();
		List<ListModel>allModels = em.createQuery("SELECT i FROM ListModel i").getResultList();
		return allModels;
	}

	/**
	 * @param toDelete
	 */
	public void deleteModel(ListModel toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListModel>typedQuery=em.createQuery("select li from ListModel li where li.color = :selectedColor and li.model = :selectedModel",ListModel.class);
	
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedColor", toDelete.getColor());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		ListModel result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param yearToEdit
	 * @return
	 */
	public ListModel searchForModelByYear(int yearToEdit) {
		// TODO Auto-generated method stub
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		ListModel found = em.find(ListModel.class, yearToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateModel(ListModel toEdit) {
		// TODO Auto-generated method stub
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param colorName
	 * @return
	 */
	public List<ListModel> searchForModelByColor(String colorName) {
		// TODO Auto-generated method stub
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListModel>typedQuery=em.createQuery("select li from ListModel li where li.color = :selectedColor",ListModel.class);
		typedQuery.setParameter("selectedColor", colorName);
		
		List<ListModel>foundModels=typedQuery.getResultList();
		em.close();
		return foundModels;
	}

	/**
	 * @param modelName
	 * @return
	 */
	public List<ListModel> searchForModelByModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListModel>typedQuery=em.createQuery("select li from ListModel li where li.model = :selectedModel",ListModel.class);
		typedQuery.setParameter("selectedModel", modelName);
		
		List<ListModel>foundModels=typedQuery.getResultList();
		em.close();
		return foundModels;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
