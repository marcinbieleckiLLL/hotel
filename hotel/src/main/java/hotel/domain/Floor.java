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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity(name="Floor")
@NamedQuery(name = "Floor.getFloorByName", query = "SELECT f FROM Floor f WHERE f.name = :name" )
public class Floor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name="Floor_Id")
	private Long id;
	@Column(name="Name")
	private String name;
	@Column(name="Rooms")
	@OneToMany(mappedBy="floor")
	private Set<Room> rooms = new HashSet<Room>(0);
	@Column(name="If_There_Is_A_Terrace")
	private String ifThereIsATerrace; 
	@Column(name="If_There_Is_A_Bowling")
	private String ifThereIsABowling; 
	@Column(name="If_There_Is_A_Pool")
	private String ifThereIsAPool; 
	@Column(name="If_There_Is_A_Roasting_Room")
	private String ifThereIsARoastingRoom;
	

	
	public Floor() {
		super();
	}


	public Floor(String name,String ifThereIsATerrace, String ifThereIsABowling, String ifThereIsAPool,
			String ifThereIsARoastingRoom) {
		super();
		this.name = name;
		this.ifThereIsATerrace = ifThereIsATerrace;
		this.ifThereIsABowling = ifThereIsABowling;
		this.ifThereIsAPool = ifThereIsAPool;
		this.ifThereIsARoastingRoom = ifThereIsARoastingRoom;
	}

	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Room> getRooms() {
		return rooms;
	}


	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}


	public String getIfThereIsATerrace() {
		return ifThereIsATerrace;
	}


	public void setIfThereIsATerrace(String ifThereIsATerrace) {
		this.ifThereIsATerrace = ifThereIsATerrace;
	}


	public String getIfThereIsABowling() {
		return ifThereIsABowling;
	}


	public void setIfThereIsABowling(String ifThereIsABowling) {
		this.ifThereIsABowling = ifThereIsABowling;
	}


	public String getIfThereIsAPool() {
		return ifThereIsAPool;
	}


	public void setIfThereIsAPool(String ifThereIsAPool) {
		this.ifThereIsAPool = ifThereIsAPool;
	}


	public String getIfThereIsARoastingRoom() {
		return ifThereIsARoastingRoom;
	}


	public void setIfThereIsARoastingRoom(String ifThereIsARoastingRoom) {
		this.ifThereIsARoastingRoom = ifThereIsARoastingRoom;
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
		Floor other = (Floor) obj;
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
