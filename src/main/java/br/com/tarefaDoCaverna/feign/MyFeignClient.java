package br.com.tarefaDoCaverna.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tarefaDoCaverna.dto.ClmResponse;

@FeignClient(name = "Clm",url="http://localhost:8075")
public interface MyFeignClient {

	@GetMapping("/acc/{cpf}")
	public ClmResponse getCustomerPoints(@PathVariable(name = "cpf", required = true) String cpf);	
}
