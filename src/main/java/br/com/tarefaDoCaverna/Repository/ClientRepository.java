package br.com.tarefaDoCaverna.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tarefaDoCaverna.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	public Optional<Client> findByCpf (String cpf);
	
}
