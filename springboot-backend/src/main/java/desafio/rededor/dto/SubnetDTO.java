package desafio.rededor.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import desafio.rededor.model.Subnet;

public class SubnetDTO implements Serializable {

	
	private static final long serialVersionUID = -8496864310629648199L;

	private Long id;
	
	private String name;
	
	private String subnet;
	
	private String masterSubnet;
	
	private String description;
	
	private LocalDate createdAt;

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
	
	public SubnetDTO transformarEmDTO(Subnet sn) {
		
		SubnetDTO dto = new SubnetDTO();
		
		dto.setId(sn.getId());
		dto.setName(sn.getName());
		dto.setDescription(sn.getDescription());
		dto.setSubnet(sn.getSubnet());
		dto.setMasterSubnet(sn.getMasterSubnet());
		dto.setCreatedAt(sn.getCreatedAt());
		
		return dto;
	}
	
	public List<SubnetDTO> transformarEmDTO(List<Subnet> listSn) {
		
		List<SubnetDTO> listDto = new ArrayList<SubnetDTO>();
		
		listSn.stream().forEach(sn -> {
			listDto.add(transformarEmDTO(sn));
		});
		
		return listDto;
	}
	
}
