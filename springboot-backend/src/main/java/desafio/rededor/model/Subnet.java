package desafio.rededor.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import desafio.rededor.dto.SubnetDTO;

@Entity
@Table(name = "subnet")
public class Subnet implements Serializable {

	private static final long serialVersionUID = 7235454741184914681L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "subnet")
	private String subnet;
	
	@Column(name = "master_subnet")
	private String masterSubnet;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_at")
	private LocalDate createdAt = LocalDate.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getMasterSubnet() {
		return masterSubnet;
	}

	public void setMasterSubnet(String masterSubnet) {
		this.masterSubnet = masterSubnet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	public Subnet transformarEmEntidade(SubnetDTO dto) {
		
		Subnet sn = new Subnet();
		
		sn.setId(dto.getId());
		sn.setName(dto.getName());
		sn.setDescription(dto.getDescription());
		sn.setSubnet(dto.getSubnet());
		sn.setMasterSubnet(dto.getMasterSubnet());
		sn.setCreatedAt(dto.getCreatedAt());
		
		return sn;
	}
	
	public List<Subnet> transformarEmEntidade(List<SubnetDTO> listDto) {
		
		List<Subnet> listSn = new ArrayList<Subnet>();
		
		listDto.stream().forEach(sn -> {
			listSn.add(transformarEmEntidade(sn));
		});
		
		return listSn;
	}

	@Override
	public String toString() {
		return "Subnet [id=" + id + ", name=" + name + ", subnet=" + subnet + ", masterSubnet=" + masterSubnet
				+ ", description=" + description + ", createdAt=" + createdAt + "]";
	}
	
}
