package auto.shop.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Part {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer partId;
	private String partName;
	private String partPrice;
	private String partDescription;
	
	@ManyToMany(mappedBy = "parts", cascade = CascadeType.PERSIST)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<AutoShop> autoShops = new HashSet<>();
}
