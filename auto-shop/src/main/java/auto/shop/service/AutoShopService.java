package auto.shop.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import auto.shop.controller.model.AutoShopPart;
import auto.shop.controller.model.AutoShopData;
import auto.shop.controller.model.AutoShopBuyer;
import auto.shop.dao.AutoShopDao;
import auto.shop.dao.PartDao;
import auto.shop.dao.BuyerDao;
import auto.shop.entity.Part;
import auto.shop.entity.Buyer;
import auto.shop.entity.AutoShop;

@Service
public class AutoShopService {
	@Autowired
	private AutoShopDao autoShopDao;
	@Autowired
	private BuyerDao buyerDao;
	@Autowired
	private PartDao partDao;
	
	@Transactional(readOnly = false)
	public AutoShopData saveAutoShop(AutoShopData autoShopData) {
		Integer autoShopId = autoShopData.getAutoShopId();
		AutoShop autoShop = findOrCreateAutoShop(autoShopId);
		copyAutoShopFields(autoShop, autoShopData);
		
		return new AutoShopData(autoShopDao.save(autoShop));
	}

	private void copyAutoShopFields(AutoShop autoShop, AutoShopData autoShopData) {
		autoShop.setAutoShopAddress(autoShopData.getAutoShopAddress());
		autoShop.setAutoShopCity(autoShopData.getAutoShopCity());
		autoShop.setAutoShopId(autoShopData.getAutoShopId());
		autoShop.setAutoShopName(autoShopData.getAutoShopName());
		autoShop.setAutoShopPhone(autoShopData.getAutoShopPhone());
		autoShop.setAutoShopState(autoShopData.getAutoShopState());
		autoShop.setAutoShopZip(autoShopData.getAutoShopZip());
	}

	private AutoShop findOrCreateAutoShop(Integer autoShopId) {
		if(Objects.isNull(autoShopId)) {
			return new AutoShop();
		} else {
			return findAutoShopById(autoShopId);
		}
	}

	private AutoShop findAutoShopById(Integer autoShopId) {
		return autoShopDao.findById(autoShopId).orElseThrow(() -> new NoSuchElementException("Auto shop with ID=" + autoShopId + " was not found."));
	}
	
	//Buyer
	@Transactional(readOnly = false)
	public AutoShopBuyer saveBuyer(Integer autoShopId, AutoShopBuyer autoShopBuyer) {
		AutoShop autoShop = findAutoShopById(autoShopId);
		Integer buyerId = autoShopBuyer.getBuyerId();
		Buyer buyer = findOrCreateBuyer(autoShopId, buyerId);
		copyBuyerFields(buyer, autoShopBuyer);
		
		buyer.setAutoShop(autoShop);
		autoShop.getBuyers().add(buyer);
		Buyer dbBuyer = buyerDao.save(buyer);
		
		return new AutoShopBuyer(dbBuyer);
	}
		
	private void copyBuyerFields(Buyer buyer, AutoShopBuyer autoShopBuyer) {
		buyer.setBuyerId(autoShopBuyer.getBuyerId());
		buyer.setBuyerFirstName(autoShopBuyer.getBuyerFirstName());
		buyer.setBuyerLastName(autoShopBuyer.getBuyerLastName());
		buyer.setBuyerPhone(autoShopBuyer.getBuyerPhone());
		buyer.setBuyerCompany(autoShopBuyer.getBuyerCompany());
	}
	
	private Buyer findOrCreateBuyer(Integer autoShopId, Integer buyerId) {
		if(Objects.isNull(buyerId)) {
			return new Buyer();
		}

		return findBuyerById(autoShopId, buyerId);
	}
	
	private Buyer findBuyerById(Integer autoShopId, Integer buyerId) {
		Buyer buyer = buyerDao.findById(buyerId).orElseThrow(() -> new NoSuchElementException("Buyer with ID=" + buyerId + " was not found."));
		
		if(buyer.getAutoShop().getAutoShopId() != autoShopId) {
			throw new IllegalArgumentException("The buyer with ID=" + buyerId + " is not registered with the auto shop with ID=" + autoShopId + ".");
		}
		
		return buyer;
	}
	
	//Part
	@Transactional
	public AutoShopPart savePart(Integer autoShopId, AutoShopPart autoShopPart) {
		AutoShop autoShop = findAutoShopById(autoShopId);
		Integer partId = autoShopPart.getPartId();
		Part part = findOrCreatePart(autoShopId, partId);
		copyPartFields(part, autoShopPart);
		
		part.getAutoShops().add(autoShop);
		autoShop.getParts().add(part);
		Part dbPart = partDao.save(part);
		
		return new AutoShopPart(dbPart);
	}
	
	private void copyPartFields(Part part, AutoShopPart autoShopPart) {
		part.setPartId(autoShopPart.getPartId());
		part.setPartName(autoShopPart.getPartName());
		part.setPartPrice(autoShopPart.getPartPrice());
		part.setPartDescription(autoShopPart.getPartDescription());
	}
	
	private Part findOrCreatePart(Integer autoShopId, Integer partId) {
		if(Objects.isNull(partId)) {
			return new Part();
		}

		return findPartById(autoShopId, partId);
	}

	private Part findPartById(Integer autoShopId, Integer partId) {
		Part part = partDao.findById(partId).orElseThrow(() -> new NoSuchElementException("Part with ID=" + partId + " was not found."));
			
		boolean found = false;
			
		for(AutoShop autoShop : part.getAutoShops()) {
			if(autoShop.getAutoShopId() == autoShopId) {
				found = true;
				break;
			}
		}
			
		if(!found) {
			throw new IllegalArgumentException("The part with ID=" + partId + " is not currently in the inventory of the auto shop with ID=" + autoShopId + ".");
		}
			
		return part;
	}
	
	@Transactional(readOnly = true)
	public List<AutoShopData> retrieveAllAutoShops() {
		List<AutoShop> autoShops = autoShopDao.findAll();
		List<AutoShopData> result = new LinkedList<>();
		
		for(AutoShop autoShop : autoShops) {
			AutoShopData asd = new AutoShopData(autoShop);
			asd.getParts().clear();
			asd.getBuyers().clear();
			
			result.add(asd);
		}
		
		return result;
	}
	
	@Transactional(readOnly = true)
	public AutoShopData retrieveAutoShopById(Integer autoShopId) {
		return new AutoShopData(findAutoShopById(autoShopId));
	}
	
	@Transactional(readOnly = false)
	public void deleteAutoShopById(Integer autoShopId) {
		AutoShop autoShop = findAutoShopById(autoShopId);
		autoShopDao.delete(autoShop);
	}
}
