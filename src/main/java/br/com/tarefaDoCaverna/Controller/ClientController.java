package br.com.tarefaDoCaverna.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefaDoCaverna.Service.ClientService;
import br.com.tarefaDoCaverna.models.Client;

@RestController
public class ClientController {

	private static final Logger log = LoggerFactory.getILoggerFactory().getLogger(ClientController.class.getName());
	
	@Autowired
	private ClientService clientService;

	@GetMapping("/cliente/{Id}")
	public ResponseEntity<Client> findOneClientById(@PathVariable("Id") Long id) {
		log.debug("findOneClientById(Long id) - start - params: {}", id);
		Client cliente = new Client();
		cliente = clientService.findOneClientById(id);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}

	@GetMapping("/cliente")
	public ResponseEntity<List<Client>> findAllClients() {
		log.debug("findAllClients() - start");
		List<Client> listaClientes = clientService.findAllClient();
		return ResponseEntity.ok(listaClientes);
	}

	@GetMapping("/cliente/find/{cpf}")
	public ResponseEntity<Client> findOneClientByCpf(@PathVariable("cpf") String cpf) {
		log.debug("findOneClientByCpf(String cpf) - start - params: {}", cpf);
		Client cliente = new Client(); 
		cliente = clientService.findOneClientByCpf(cpf);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}

	@PostMapping("/cliente")
	public ResponseEntity<String> saveClient(@RequestBody Client cliente) {
		log.debug("saveClient(Client cliente) - start - body: {}",cliente);
		clientService.saveClient(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso!");
	}

	@PutMapping("/cliente/{Id}")
	public ResponseEntity<String> updateClient(@PathVariable("Id") Long id, @RequestBody Client cliente) {
		log.debug("updateClient(Long id, Client cliente) - start - param: {} - body: {}", id, cliente);
		clientService.updateClient(id, cliente);
		return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
	}

	@DeleteMapping("/cliente/{Id}")
	public ResponseEntity<String> deleteClient(@PathVariable("Id") Long id) {
		log.debug("deleteClient(Long id) - start - param: {}", id);
		clientService.deleteClient(id);
		return ResponseEntity.ok("Cliente deletado com sucesso!");
	}
}
