package auto.shop.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import auto.shop.entity.Part;

@Data
@NoArgsConstructor
public class AutoShopPart {
	private Integer partId;
	private String partName;
	private String partPrice;
	private String partDescription;

	public AutoShopPart(Part part) {
		partId = part.getPartId();
		partName = part.getPartName();
		partPrice = part.getPartPrice();
		partDescription = part.getPartDescription();
	}
}

