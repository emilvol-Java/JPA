package world.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Country {
	
	@Id
	private String code;
	private String name;	
	private String continent;
	private String region;
	private long population;
	
		
	//Capital is a reference to a City object
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "capital")
	private City capital;
	
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private Set<City> cities;		
	
	public Set<City> getCities() {
		return cities;
	}



	public void setCities(List<City> cities) {
		for(City city: cities){
			this.cities.add(city);
		}
	}

	public Country(String name, String continent, long population){
		this.name = name;
		this.continent = continent;
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


	public City getCapital() {
		return capital;
	}


	public void setCapital(City capital) {
		this.capital = capital;
	}


	@Override
	public String toString() {
		return name + " in " + continent + ", population " + String.format("%,d",population);
	}
	
	
	
	
	
}
