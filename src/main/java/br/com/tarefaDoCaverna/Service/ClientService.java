package br.com.tarefaDoCaverna.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefaDoCaverna.Exception.ClientAlreadyExistsException;
import br.com.tarefaDoCaverna.Exception.ClientDontExistsException;
import br.com.tarefaDoCaverna.Repository.ClientRepository;
import br.com.tarefaDoCaverna.models.Client;

@Service
public class ClientService {
	
	private static final Logger log = LoggerFactory.getILoggerFactory().getLogger(ClientService.class.getName());
	
	@Autowired
	private ClientRepository clienteRepository;

	
	public Client findOneClientById(Long id) {
		Optional<Client> findById = clienteRepository.findById(id);
		
		if(findById.isPresent()) {
			return findById.get();
		}else {
			return null;
		}
	}

	public List<Client> findAllClient() {
		return clienteRepository.findAll();
	}

	public Client findOneClientByCpf(String cpf) {
		Optional<Client> findByCpf = clienteRepository.findByCpf(cpf);
		
		if (findByCpf.isPresent()) {
			return findByCpf.get();
		} else {
			return null;
		}
	}
	
	public void saveClient(Client newCliente) {
		Client findOneClientByCpf = findOneClientByCpf(newCliente.getCpf());
		
		if (findOneClientByCpf != null) {
			log.warn("saveClient(Client newCliente) - warning - Client already exists with cpf: {}", newCliente.getCpf());
			throw new ClientAlreadyExistsException();
		}
		clienteRepository.save(newCliente);
	}	
	
	public void updateClient(Long id, Client newClientInfo) {
		Client savedClient = findOneClientById(id);

		if(savedClient != null) {
			BeanUtils.copyProperties(newClientInfo, savedClient, "id");
			clienteRepository.save(savedClient);			
		}else {
			throw new ClientDontExistsException("Cliente inexistente ou Id incorreta!");
		}
	}

	public void deleteClient(Long id) {
		Client savedClient = findOneClientById(id);
		
		if(savedClient != null) {
			clienteRepository.deleteById(id);			
		}else {
			throw new ClientDontExistsException("Cliente inexistente ou Id incorreta!");
		}
	}

}
