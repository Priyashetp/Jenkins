package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currencyinfo")
public class CurrencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String currencyName;
	private double currencyValue;
	public CurrencyEntity() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyName == null) ? 0 : currencyName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(currencyValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyEntity other = (CurrencyEntity) obj;
		if (currencyName == null) {
			if (other.currencyName != null)
				return false;
		} else if (!currencyName.equals(other.currencyName))
			return false;
		if (Double.doubleToLongBits(currencyValue) != Double.doubleToLongBits(other.currencyValue))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public double getCurrencyValue() {
		return currencyValue;
	}
	public void setCurrencyValue(double currencyValue) {
		this.currencyValue = currencyValue;
	}
	public CurrencyEntity(long id, String currencyName, double currencyValue) {
		super();
		this.id = id;
		this.currencyName = currencyName;
		this.currencyValue = currencyValue;
	}
	
}
