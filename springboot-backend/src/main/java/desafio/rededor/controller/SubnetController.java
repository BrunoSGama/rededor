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

import desafio.rededor.dto.SubnetDTO;
import desafio.rededor.service.SubnetService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/rededor/")
public class SubnetController {

	@Autowired
	private SubnetService subnetService;

	// listar subnet's
	@GetMapping("/listarSubnets")
	public List<SubnetDTO> listarSubnets() {

		return subnetService.listarSubnets();
	}

	// listar subnet's por subnet
	@GetMapping("/listarSubnets/{subnet}")
	public List<SubnetDTO> listarSubnetsPorSubnet(@PathVariable String subnet) {

		return subnetService.listarSubnetsPorSubnet(subnet);
	}

	// salvar subnet
	@PostMapping("/salvarSubnet")
	public SubnetDTO salvarSubnet(@RequestBody SubnetDTO subnet) {

		return subnetService.salvarSubnet(subnet);
	}

	// obter subnet por id
	@GetMapping("/subnet/{id}")
	public ResponseEntity<SubnetDTO> obterSubnetPorId(@PathVariable Long id) {

		return ResponseEntity.ok(subnetService.obterSubnetPorId(id));
	}

	// atualizar subnet
	@PutMapping("/subnet/{id}")
	public ResponseEntity<SubnetDTO> atualizarSubnet(@RequestBody SubnetDTO sn) {

		SubnetDTO dto = subnetService.atualizarSubnet(sn);
		return ResponseEntity.ok(dto);
	}

	// apagar subnet
	@DeleteMapping("/subnet/{id}")
	public ResponseEntity<Map<String, Boolean>> apagarSubnet(@PathVariable Long id) {

		subnetService.apagarSubnet(id);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
