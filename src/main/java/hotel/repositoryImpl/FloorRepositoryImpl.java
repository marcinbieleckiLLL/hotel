package hotel.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hotel.domain.Floor;
import hotel.repository.FloorRepository;


@Repository
@Transactional
public class FloorRepositoryImpl implements FloorRepository {

	@PersistenceContext
	private EntityManager emManager;
	
	private Floor currentFloor;
	
	
	
	public Floor getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(Floor currentFloor) {
		this.currentFloor = currentFloor;
	}

	public List<Floor> getAll() {
		return emManager.createQuery("SELECT f FROM Floor f", Floor.class).getResultList();
	}

	public void save(Floor floorToSave) {
		List<Floor> listOfFloors = getAll();
		boolean save = true;
		
		for(Floor floor: listOfFloors){
			if(floor.getName().equals(floorToSave.getName())){
				save = false;
			}
		}
		
		if(save)
			emManager.persist(floorToSave);
		
	}

	public void update(Floor floor) {
		emManager.merge(floor);
	}

	public Floor getFlorByName(String floorName) {
		TypedQuery<Floor> query = emManager.createNamedQuery("Floor.getFloorByName", Floor.class);
		query.setParameter("name", floorName);
		return query.getSingleResult();
	}

}
