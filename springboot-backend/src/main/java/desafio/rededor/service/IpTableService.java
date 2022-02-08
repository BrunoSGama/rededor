package desafio.rededor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.rededor.dto.IpTableDTO;
import desafio.rededor.exception.RequisicaoInvalidaException;
import desafio.rededor.exception.ResourceNotFoundException;
import desafio.rededor.model.IpTable;
import desafio.rededor.repository.IpTableRepository;

@Service
public class IpTableService implements IpTableServiceLocal {
	
	private IpTableRepository ipTableRepository;
	private IpTableDTO dto = new IpTableDTO();
	private IpTable entidade = new IpTable();
	
	@Autowired
	public IpTableService(IpTableRepository repositorio) {
		this.ipTableRepository = repositorio;
	}
	
	public IpTableDTO salvarIp(IpTableDTO ip) {
		validarIpTable(ip);
		return dto.transformarEmDTO(ipTableRepository.save(entidade.transformarEmEntidade(ip)));
	}
	
	public List<IpTableDTO> listarIps() {
		return dto.transformarEmDTO(ipTableRepository.findAll());
	}
	
	public List<IpTableDTO> listarIpsPorIp(String ip) {
		return dto.transformarEmDTO(ipTableRepository.findAll().stream().filter(i -> i.getIp().contains(ip)).collect(Collectors.toList()));
	}
	
	public IpTableDTO obterIpPorId(Long id) {
		IpTable ip = ipTableRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("nao existe IP com o ID: " + id));
		
		return dto.transformarEmDTO(ip);
	}
	
	public IpTableDTO atualizarIp(IpTableDTO ip) {
		
		validarIpTable(ip);
		
		IpTable ipTable = ipTableRepository.findById(ip.getId())
				.orElseThrow(() -> new ResourceNotFoundException("nao existe IP com o ID: " + ip.getId()));
		
		ipTable.setIp(ip.getIp());
		ipTable.setDevice(ip.getDevice());
		ipTable.setSubnet(ip.getSubnet());
		
		return dto.transformarEmDTO(ipTableRepository.save(ipTable));
	}
	
	public void apagarIp(Long id) {
		IpTable ipTable = ipTableRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("nao existe IP com o ID: " + id));
		
		ipTableRepository.delete(ipTable);
	}
	
	private IpTableDTO validarIpTable(IpTableDTO obj) {
		try {
			if (obj.getIp() == null || obj.getIp().isEmpty()) {
				throw new RequisicaoInvalidaException("Campo ip não pode estar vazio.");
			}
			if (obj.getDevice() == null || obj.getDevice().equals(null)) {
				throw new RequisicaoInvalidaException("Campo device não pode estar vazio.");
			}
			if (obj.getSubnet() == null) {
				throw new RequisicaoInvalidaException("Campo subnet não pode estar vazio.");
			}
		
		} catch (Exception e) {
			throw new RequisicaoInvalidaException("ERROR: IpTable Invalido!");
		}
		return obj;

	}

}
