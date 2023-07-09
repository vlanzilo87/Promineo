package auto.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import auto.shop.entity.Part;

public interface PartDao extends JpaRepository<Part, Integer> {

}
