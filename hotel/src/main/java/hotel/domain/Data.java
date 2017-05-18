package hotel.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@GeneratedValue
	@Column(name="Quantity_Of_Breakfast")
	private int quantityOfBreakfast;
	@GeneratedValue
	@Column(name="Quantity_Of_Days")
	private int quantityOfDays;
	@OneToMany(mappedBy="data")
	private Set<BasketItem> basketItems = new HashSet<BasketItem>(0);
	
	
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


	public Set<BasketItem> getBasketItems() {
		return basketItems;
	}


	public void setBasketItems(Set<BasketItem> basketItems) {
		this.basketItems = basketItems;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantityOfBreakfast != other.quantityOfBreakfast)
			return false;
		if (quantityOfDays != other.quantityOfDays)
			return false;
		return true;
	}
	
	
}
