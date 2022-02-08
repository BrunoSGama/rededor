package desafio.rededor.service;

import java.util.List;

import javax.ejb.Local;

import desafio.rededor.dto.IpTableDTO;

@Local
public interface IpTableServiceLocal {
	
	public IpTableDTO salvarIp(IpTableDTO ip);
	
	public List<IpTableDTO> listarIps();
	
	public List<IpTableDTO> listarIpsPorIp(String ip);
	
	public IpTableDTO obterIpPorId(Long id);
	
	public IpTableDTO atualizarIp(IpTableDTO ip);
	
	public void apagarIp(Long id);

}
