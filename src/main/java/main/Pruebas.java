package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TbUsuario;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.print("===JPACRUD===");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_clase01x");
		EntityManager em = fabrica.createEntityManager();
		
		List<TbUsuario> lstUsuario = em.createQuery("Select a From TbUsuario a",TbUsuario.class).getResultList();
		System.out.print("El Número de Usuarios es :"+ lstUsuario.size());
	}

}
