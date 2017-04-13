package world.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A City in a country.
 * @author Emil
 *
 */

@Entity
public class City {
	@Id
	private Integer id;
	private String name;
	private String district;
	private int population;
	
		
	
	// Getters and setters:
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", district=" + district + ", population=" + population + "]";
	}
	
	
}
