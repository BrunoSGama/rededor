package desafio.rededor.service;

import java.util.List;

import javax.ejb.Local;

import desafio.rededor.dto.SubnetDTO;

@Local
public interface SubnetServiceLocal {
	
	public List<SubnetDTO> listarSubnets();
	
	public List<SubnetDTO> listarSubnetsPorSubnet(String subnet);
	
	public SubnetDTO salvarSubnet(SubnetDTO subnet);
	
	public SubnetDTO obterSubnetPorId(Long id);
	
	public SubnetDTO atualizarSubnet(SubnetDTO sn);
	
	public void apagarSubnet(Long id);

}
