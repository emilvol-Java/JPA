package world.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Country {
	
	@Id
	private String code;
	private String name;
	private String continent;
	private String region;
	private long population;
	
	
	protected Country(String code, String name, String continent, String region, long population) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.population = population;
	}
	
	
	protected Country() {
		super();
	}



	//Getters and setters:
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContinent() {
		return continent;
	}


	public void setContinent(String continent) {
		this.continent = continent;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public long getPopulation() {
		return population;
	}


	public void setPopulation(long population) {
		this.population = population;
	}


	@Override
	public String toString() {
		return name + " in " + continent + ", population " + population;
	}
	
	
	
	
	
}
