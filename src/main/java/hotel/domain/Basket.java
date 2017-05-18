package hotel.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@NamedQuery(name = "Basket.deleteBasket", query = "DELETE FROM Basket b WHERE b.user.id = :id")
@Table(name="Basket")
public class Basket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="Basket_id")
	private Long id;
	@Cascade({CascadeType.SAVE_UPDATE})
	@OneToOne()
	private User user;
	@Column(name="Price")
	private int price;
	@Column(name="BasketItems")
	@OneToMany(mappedBy="basket", fetch = FetchType.EAGER)
	private Set<BasketItem> basketItems = new HashSet<BasketItem>(0);
	
	public Basket(){}
	
	public Basket(User user) {
		super();
		this.user = user;
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Basket other = (Basket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
