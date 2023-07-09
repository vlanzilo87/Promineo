package auto.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import auto.shop.entity.AutoShop;

public interface AutoShopDao extends JpaRepository<AutoShop, Integer> {

}
