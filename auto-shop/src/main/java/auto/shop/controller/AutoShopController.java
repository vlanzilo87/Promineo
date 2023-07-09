package auto.shop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import auto.shop.controller.model.AutoShopPart;
import auto.shop.controller.model.AutoShopData;
import auto.shop.controller.model.AutoShopBuyer;
import auto.shop.service.AutoShopService;

@RestController
@RequestMapping("/auto_shop")
@Slf4j
public class AutoShopController {
	@Autowired
	private AutoShopService autoShopService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AutoShopData insertPetStore(@RequestBody AutoShopData autoShopData) {
		log.info("Creating auto shop {}", autoShopData);
		return autoShopService.saveAutoShop(autoShopData);
	}
	
	@PutMapping("/{autoShopId}")
	public AutoShopData updateAutoShop(@PathVariable Integer autoShopId, @RequestBody AutoShopData autoShopData) {
		autoShopData.setAutoShopId(autoShopId);
		log.info("Updating auto shop {}", autoShopData);
		return autoShopService.saveAutoShop(autoShopData);
	}
	
	@PostMapping("/{autoShopId}/buyer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AutoShopBuyer addBuyerToAutoShop(@PathVariable Integer autoShopId, @RequestBody AutoShopBuyer autoShopBuyer) {
		log.info("Adding buyer {} to auto shop with ID={}", autoShopBuyer, autoShopId);
		
		return autoShopService.saveBuyer(autoShopId, autoShopBuyer);
	}
	
	@PostMapping("/{autoShopId}/part")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AutoShopPart addPartToAutoShop(@PathVariable Integer autoShopId, @RequestBody AutoShopPart autoShopPart) {
		log.info("Adding part {} to auto shop with ID={}", autoShopPart, autoShopId);
		
		return autoShopService.savePart(autoShopId, autoShopPart);
	}
	
	@GetMapping
	public List<AutoShopData> retrieveAllAutoShops() {
		log.info("Retrieveing all auto shops");
		return autoShopService.retrieveAllAutoShops();
	}
	
	@GetMapping("/{autoShopId}")
	public AutoShopData retrieveAutoShopById(@PathVariable Integer autoShopId) {
		log.info("Retrieving auto shop with ID={}", autoShopId);
		return autoShopService.retrieveAutoShopById(autoShopId);
	}
	
	@DeleteMapping("/{autoShopId}")
	public Map<String, String> deleteAutoShopById(@PathVariable Integer autoShopId) {
		log.info("Deleting auto shop with ID={}", autoShopId);
		autoShopService.deleteAutoShopById(autoShopId);
		return Map.of("message", "Auto shop with ID=" + autoShopId + " deleted.");
	}
	
}
