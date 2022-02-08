package desafio.rededor.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import desafio.rededor.model.IpTable;
import desafio.rededor.model.Subnet;

public class IpTableDTO implements Serializable {
	
	private static final long serialVersionUID = 3052099908096967555L;

	private Long id;
	
	private String ip;

	private Subnet subnet;
	
	private String device;
	
	private LocalDate createdAt = LocalDate.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Subnet getSubnet() {
		return subnet;
	}

	public void setSubnet(Subnet subnet) {
		this.subnet = subnet;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	public IpTableDTO transformarEmDTO(IpTable ip) {
		
		IpTableDTO dto = new IpTableDTO();
		dto.setId(ip.getId());
		dto.setIp(ip.getIp());
		dto.setDevice(ip.getDevice());
		dto.setSubnet(ip.getSubnet());
		dto.setCreatedAt(ip.getCreatedAt());
		
		return dto;
	}
	
	public List<IpTableDTO> transformarEmDTO(List<IpTable> listIp) {
		
		List<IpTableDTO> listDto = new ArrayList<IpTableDTO>();
		
		listIp.stream().forEach(ip -> {
			listDto.add(transformarEmDTO(ip));
		});
		
		return listDto;
	}

}
