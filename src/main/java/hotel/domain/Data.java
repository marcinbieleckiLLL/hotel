package hotel.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Data")
public class Data implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="Data_Id")
	private Long id;
	@Column(name="Quantity_Of_Breakfast")
	private int quantityOfBreakfast;
	@Column(name="Quantity_Of_Days")
	private int quantityOfDays;
	@Column(name="Price_Connected_with_One_Data")
	private int priceConnecetdWithOneData;
	@Column(name="Price_Connected_with_Whole_Basket")
	private int priceConnecetdWithWholeBasket;
	@ManyToOne(targetEntity = Room.class)
	private Room room;
	
	
	public Data() {
		super();
	}


	public int getQuantityOfBreakfast() {
		return quantityOfBreakfast;
	}


	public void setQuantityOfBreakfast(int quantityOfBreakfast) {
		this.quantityOfBreakfast = quantityOfBreakfast;
	}


	public int getQuantityOfDays() {
		return quantityOfDays;
	}


	public void setQuantityOfDays(int quantityOfDays) {
		this.quantityOfDays = quantityOfDays;
	}

	public int getPriceConnecetdWithOneData() {
		return priceConnecetdWithOneData;
	}


	public void setPriceConnecetdWithOneData(int priceConnecetdWithOneData) {
		this.priceConnecetdWithOneData = priceConnecetdWithOneData;
	}

	public int getPriceConnecetdWithWholeBasket() {
		return priceConnecetdWithWholeBasket;
	}


	public void setPriceConnecetdWithWholeBasket(int priceConnecetdWithWholeBasket) {
		this.priceConnecetdWithWholeBasket = priceConnecetdWithWholeBasket;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + priceConnecetdWithOneData;
		result = prime * result + quantityOfBreakfast;
		result = prime * result + quantityOfDays;
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
		Data other = (Data) obj;
		if (priceConnecetdWithOneData != other.priceConnecetdWithOneData)
			return false;
		if (quantityOfBreakfast != other.quantityOfBreakfast)
			return false;
		if (quantityOfDays != other.quantityOfDays)
			return false;
		return true;
	}

}
