package world;

import java.util.List;
import javax.persistence.*;
import world.domain.*;
import java.util.Scanner;
import java.util.Set;

public class JPADemo {
	
	/**
	 * Find cities in the database by name.
	 *  @param name is the name of city to find.
	 */
	
	private static boolean askCountry = true;
	private static String answer;
	
	public static void findCity(String name){
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("world");
		EntityManager em = factory.createEntityManager();
		Query query = 
				em.createQuery("SELECT c from City c where c.name = :name");
		query.setParameter("name",name);
		List<City> cities = query.getResultList();
		System.out.printf("Found %d matches for %s\n", cities.size(), name);
		for(City c : cities) {
			System.out.print(c);
			System.out.println(" located in " + c.getCountry().getName());
		}
	}
	
	public static List<City> findCitiesByCountryCode(String countryCode){
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("world");
		EntityManager em = factory.createEntityManager();
		Query query = 
				em.createQuery("SELECT c from City c where c.country.code = :countryCode");
		query.setParameter("countryCode", countryCode);
		List<City> cities = query.getResultList();
		
		return cities;
	}
	
	
	public static void findCountry(String countryName){
		
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("world");
		EntityManager em = factory.createEntityManager();
		Query query =
				em.createQuery("SELECT distinct d from Country d where d.name = :name");
		query.setParameter("name", countryName);
		List<Country> countries = query.getResultList();
		
		if (countries.size() != 0) {
			Country country = countries.get(0);
			System.out.println(country);
			System.out.println("The capital city is " + country.getCapital());
			System.out.println("Cities in " + country.getName());
						
			List<City> countryList = findCitiesByCountryCode(country.getCode());
			country.setCities(countryList);		
			
			for (City city : country.getCities()){
				System.out.println(city);
			}
			System.out.println("");
			
		}
		else{
			System.out.println("No matches for " + countryName);
		}
		
		
		
		
	}
	
	
	public static void main(String[] args){
		findCity("Los Angeles");
		
		Scanner sc = new Scanner(System.in);
		
		while (askCountry){
			
			System.out.println("Country to find: ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("quit")){
				askCountry = false;
				System.out.println("Goodbye dear programmer, please return another time!");
				break;
			} else{
				findCountry(answer);
			}
			
				
		}
			
				
			
	}
		
}

