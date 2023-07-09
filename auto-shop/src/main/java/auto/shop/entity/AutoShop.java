package auto.shop.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class AutoShop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer autoShopId;
	private String autoShopName;
	private String autoShopAddress;
	private String autoShopCity;
	private String autoShopState;
	private String autoShopZip;
	private String autoShopPhone;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "auto_shop_part",
			joinColumns = @JoinColumn(name = "auto_shop_id"),
			inverseJoinColumns = @JoinColumn(name = "part_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Part> parts = new HashSet<>();
	
	@OneToMany(mappedBy = "autoShop", cascade = CascadeType.ALL, orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Buyer> buyers = new HashSet<>();
}
