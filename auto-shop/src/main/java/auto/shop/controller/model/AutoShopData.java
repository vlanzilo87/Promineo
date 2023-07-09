package auto.shop.controller.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import auto.shop.entity.Part;
import auto.shop.entity.Buyer;
import auto.shop.entity.AutoShop;
import auto.shop.controller.model.AutoShopBuyer;

@Data
@NoArgsConstructor
public class AutoShopData {
	private Integer autoShopId;
	private String autoShopName;
	private String autoShopAddress;
	private String autoShopCity;
	private String autoShopState;
	private String autoShopZip;
	private String autoShopPhone;
	
	private Set<AutoShopPart> parts = new HashSet<>();
	private Set<AutoShopBuyer> buyers = new HashSet<>();
	
	public AutoShopData(AutoShop autoShop) {
		autoShopId = autoShop.getAutoShopId();
		autoShopName = autoShop.getAutoShopName();
		autoShopAddress = autoShop.getAutoShopAddress();
		autoShopCity = autoShop.getAutoShopCity();
		autoShopState = autoShop.getAutoShopState();
		autoShopZip = autoShop.getAutoShopZip();
		autoShopPhone = autoShop.getAutoShopPhone();
		
		for(Part part : autoShop.getParts()) {
			parts.add(new AutoShopPart(part));
		}
		
		for(Buyer buyer : autoShop.getBuyers()) {
			buyers.add(new AutoShopBuyer(buyer));
		}
	}
}
