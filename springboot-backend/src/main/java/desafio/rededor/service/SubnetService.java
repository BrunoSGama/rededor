package desafio.rededor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.rededor.dto.SubnetDTO;
import desafio.rededor.exception.RequisicaoInvalidaException;
import desafio.rededor.exception.ResourceNotFoundException;
import desafio.rededor.model.Subnet;
import desafio.rededor.repository.SubnetRepository;

@Service
public class SubnetService implements SubnetServiceLocal {

	private SubnetRepository subnetRepository;
	private SubnetDTO dto = new SubnetDTO();
	private Subnet entidade = new Subnet();

	@Autowired
	public SubnetService(SubnetRepository repositorio) {
		this.subnetRepository = repositorio;
	}

	public List<SubnetDTO> listarSubnets() {
		return dto.transformarEmDTO(subnetRepository.findAll());
	}

	public List<SubnetDTO> listarSubnetsPorSubnet(String subnet) {
		return dto.transformarEmDTO(subnetRepository.findAll().stream().filter(s -> s.getSubnet().contains(subnet))
				.collect(Collectors.toList()));
	}

	public SubnetDTO salvarSubnet(SubnetDTO subnet) {
		validarSubnet(subnet);
		return dto.transformarEmDTO(subnetRepository.save(entidade.transformarEmEntidade(subnet)));
	}

	public SubnetDTO obterSubnetPorId(Long id) {
		Subnet subnet = subnetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("nao existe subnet com o ID: " + id));

		return dto.transformarEmDTO(subnet);
	}

	public SubnetDTO atualizarSubnet(SubnetDTO sn) {
		validarSubnet(sn);
		Subnet subnet = subnetRepository.findById(sn.getId())
				.orElseThrow(() -> new ResourceNotFoundException("nao existe subnet com o ID: " + sn.getId()));

		subnet.setDescription(sn.getDescription());
		subnet.setMasterSubnet(sn.getMasterSubnet());
		subnet.setName(sn.getName());
		subnet.setSubnet(sn.getSubnet());

		return dto.transformarEmDTO(subnetRepository.save(subnet));
	}

	public void apagarSubnet(Long id) {
		Subnet subnet = subnetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("nao existe subnet com o ID: " + id));

		subnetRepository.delete(subnet);
	}

	private SubnetDTO validarSubnet(SubnetDTO obj) {
		try {
			if (obj.getName() == null || obj.getName().isEmpty()) {
				throw new RequisicaoInvalidaException("Campo nome não pode estar vazio.");
			}
			if (obj.getSubnet() == null || obj.getSubnet().equals(null)) {
				throw new RequisicaoInvalidaException("Campo subnet não pode estar vazio.");
			}
			if (obj.getMasterSubnet() == null || obj.getMasterSubnet().equals(null)) {
				throw new RequisicaoInvalidaException("Campo master subnet não pode estar vazio.");
			}
			if (obj.getDescription() == null || obj.getDescription().equals(null)) {
				throw new RequisicaoInvalidaException("Campo descricao não pode estar vazio.");
			}

		} catch (Exception e) {
			throw new RequisicaoInvalidaException("ERROR: Subnet Invalido!");
		}
		return obj;

	}

}
