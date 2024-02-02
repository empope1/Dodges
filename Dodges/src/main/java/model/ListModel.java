package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author emilylester empope1
 * CIS 175 Spring 2024
 * Jan 31, 2024
 */

@Entity
@Table(name="models")
public class ListModel {
	@Id
	@GeneratedValue
	@Column(name="YEAR")
	private int year;
	@Column(name="COLOR")
	private String color;
	@Column(name="MODEL")
	private String model;
	
	
	public ListModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ListModel(String color, String model) {
		super();
		this.color = color;
		this.model = model;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}
	
	public String returnModelDetails() {
		return this.color + ": " + this.model;
	}

}
