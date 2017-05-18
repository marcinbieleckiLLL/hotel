package hotel.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="Room")
@NamedQuery(name = "Room.getRoomByName", query = "SELECT r FROM Room r WHERE r.name = :name")
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="Room_Id")
	private Long id;
	@Column(name="Name")
	private String name;
	@Column(name="Size")
	private String size;
	@ManyToOne(targetEntity = Floor.class)
	private Floor floor;
	@Column(name="Availability")
	private String availability;
	@Column(name="Days_To_Be_Empty") 
	private int daysToBeEmpty;
	@Column(name="Price_For_One_Day")
	private int priceForOneDay;
	@Column(name="Direction_Of_Window")
	private String directionOfWindow;
	@OneToMany(mappedBy="room", fetch = FetchType.EAGER)
	private Set<BasketItem> basketItemList = new HashSet<BasketItem>(0);
	@OneToMany(mappedBy="room", fetch = FetchType.EAGER)
	private Set<Data> datas = new HashSet<Data>(0);
	
	
	
	public Room() {
		super();
	}
	
	
	public Room(String name, String size, int priceForOneDay, String directionOfWindow) {
		super();
		this.availability = "wolne";
		this.name = name;
		this.size = size;
		this.priceForOneDay = priceForOneDay;
		this.directionOfWindow = directionOfWindow;
	}

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getDaysToBeEmpty() {
		return daysToBeEmpty;
	}
	public void setDaysToBeEmpty(int daysToBeEmpty) {
		this.daysToBeEmpty = daysToBeEmpty;
	}
	public int getPriceForOneDay() {
		return priceForOneDay;
	}
	public void setPriceForOneDay(int priceForOneDay) {
		this.priceForOneDay = priceForOneDay;
	}
	public String getDirectionOfWindow() {
		return directionOfWindow;
	}
	public void setDirectionOfWindow(String directionOfWindow) {
		this.directionOfWindow = directionOfWindow;
	}
	public Set<BasketItem> getBasketItemList() {
		return basketItemList;
	}
	public void setBasketItemList(Set<BasketItem> basketItemList) {
		this.basketItemList = basketItemList;
	}
	public Set<Data> getDatas() {
		return datas;
	}
	public void setDatas(Set<Data> datas) {
		this.datas = datas;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Room other = (Room) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
