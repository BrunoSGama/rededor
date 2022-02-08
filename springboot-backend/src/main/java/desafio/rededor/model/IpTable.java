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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import desafio.rededor.dto.IpTableDTO;

@Entity
@Table(name = "ip_table")
public class IpTable implements Serializable {

	private static final long serialVersionUID = 3184455837812040298L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ip")
	private String ip;

	@ManyToOne
    @JoinColumn(name = "subnet")
	private Subnet subnet;
	
	@Column(name = "device")
	private String device;
	
	@Column(name = "created_at")
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
	
	public IpTable transformarEmEntidade(IpTableDTO dto) {
		
		IpTable ip = new IpTable();
		
		ip.setId(dto.getId());
		ip.setIp(dto.getIp());
		ip.setDevice(dto.getDevice());
		ip.setSubnet(dto.getSubnet());
		ip.setCreatedAt(dto.getCreatedAt());
		
		return ip;
	}
	
	public List<IpTable> transformarEmEntidade(List<IpTableDTO> listDto) {
		
		List<IpTable> listIp = new ArrayList<IpTable>();
		
		listDto.stream().forEach(ip -> {
			listIp.add(transformarEmEntidade(ip));
		});
		
		return listIp;
	}

	@Override
	public String toString() {
		return "IpTable [id=" + id + ", ip=" + ip + ", subnet=" + subnet + ", device=" + device + ", createdAt="
				+ createdAt + "]";
	}
	
}
