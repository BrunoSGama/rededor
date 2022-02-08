package desafio.rededor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.rededor.dto.IpTableDTO;
import desafio.rededor.service.IpTableService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/rededor/")
public class IpController {

	@Autowired
	private IpTableService ipTableService;

	// listar ip's
	@GetMapping("/listarIps")
	public List<IpTableDTO> listarIps() {

		return ipTableService.listarIps();
	}

	// listar ip's por ip
	@GetMapping("/listarIps/{ip}")
	public List<IpTableDTO> listarIpsPorIp(@PathVariable String ip) {

		return ipTableService.listarIpsPorIp(ip);
	}

	// salvar ip
	@PostMapping("/salvarIp")
	public IpTableDTO salvarIp(@RequestBody IpTableDTO ip) {

		return ipTableService.salvarIp(ip);
	}

	// obter ip por id
	@GetMapping("/ip/{id}")
	public ResponseEntity<IpTableDTO> obterIpPorId(@PathVariable Long id) {

		IpTableDTO ip = ipTableService.obterIpPorId(id);
		return ResponseEntity.ok(ip);
	}

	// atualizar ip
	@PutMapping("/ip/{id}")
	public ResponseEntity<IpTableDTO> atualizarIp(@PathVariable Long id, @RequestBody IpTableDTO ip) {

		IpTableDTO dto = ipTableService.atualizarIp(ip);
		return ResponseEntity.ok(dto);
	}

	// apagar ip
	@DeleteMapping("/ip/{id}")
	public ResponseEntity<Map<String, Boolean>> apagarIp(@PathVariable Long id) {

		ipTableService.apagarIp(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
