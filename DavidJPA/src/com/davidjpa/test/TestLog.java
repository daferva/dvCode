/**
 * 
 */
package com.davidjpa.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.davidjpa.model.Log;

/**
 * @author DavidV
 *
 */
public class TestLog {
	
	private static EntityManager entitiManager;
	private static EntityManagerFactory emf;

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
        //System.out.println(getLog().size());
		Log log = new Log();
		log.setTramaIn("Trama in de preuba");
		log.setTramaOut("Trama out de prueba");
		log.setUsuario("dvasco");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		
		log.setFecha(sdf.format(new Date()));
        insertarLog(log);
	}
	
	public static List<Log> getLog(){
		emf = Persistence.createEntityManagerFactory("DavidJPA");
		entitiManager = emf.createEntityManager();
		List<Log> listEmp = entitiManager.createQuery("SELECT e FROM Log e").getResultList();
		return listEmp;
	}
	
	public static void insertarLog(Log log) {
		emf = Persistence.createEntityManagerFactory("DavidJPA");
		entitiManager = emf.createEntityManager();
		EntityTransaction et=entitiManager.getTransaction();
		
		try {
			et.begin();
			entitiManager.persist(log);
			et.commit();
			
		}
		catch(Exception ex){
			et.rollback();
			System.out.println("ERROR Insertando en el log: " + ex.getMessage());
		}
		finally {
			entitiManager.close();
		}
		
	}

}
