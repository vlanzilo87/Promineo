package auto.shop.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import auto.shop.entity.Buyer;

@Data
@NoArgsConstructor
public class AutoShopBuyer {
	private Integer buyerId;
	private String buyerFirstName;
	private String buyerLastName;
	private String buyerPhone;
	private String buyerCompany;
	
	public AutoShopBuyer(Buyer buyer) {
		buyerId = buyer.getBuyerId();
		buyerFirstName = buyer.getBuyerFirstName();
		buyerLastName = buyer.getBuyerLastName();
		buyerPhone = buyer.getBuyerPhone();
		buyerCompany = buyer.getBuyerCompany();
	}
}

