package auto.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import auto.shop.entity.Buyer;

public interface BuyerDao extends JpaRepository<Buyer, Integer> {

}
