package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.TbUsuario;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.print("===JPACRUD===");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_clase01x");
		EntityManager em = fabrica.createEntityManager();
		/*
		List<TbUsuario> lstUsuario = em.createQuery("Select a From TbUsuario a",TbUsuario.class).getResultList();
		System.out.print("El Número de Usuarios es :"+ lstUsuario.size());
		*/
		
		Query query = em.createNativeQuery("{call usp_validaAcceso(?,?)}",TbUsuario.class);
		query.setParameter(1, "U001@gmail.com");
		query.setParameter(2, "10001");
		TbUsuario u = (TbUsuario) query.getSingleResult();
		if (u == null) {
		System.out.println("Usuario no existe");
		}else{
			System.out.println("Usuario  existe");
		}
		System.out.println("Bienvenido " + u.getNomUsua());
		System.out.println("Tus datos son : " +u);
		List<TbUsuario> lstUsuarios= query.getResultList();
		
		
	}

}
