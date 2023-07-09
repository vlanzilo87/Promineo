package auto.shop.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer buyerId;
	private String buyerFirstName;
	private String buyerLastName;
	private String buyerPhone;
	private String buyerCompany;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "auto_shop_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private AutoShop autoShop;
	
}
