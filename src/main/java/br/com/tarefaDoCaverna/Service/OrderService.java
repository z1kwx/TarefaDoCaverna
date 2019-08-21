package br.com.tarefaDoCaverna.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefaDoCaverna.Exception.SaldoInsuficienteException;
import br.com.tarefaDoCaverna.dto.ClmResponse;
import br.com.tarefaDoCaverna.feign.MyFeignClient;
import br.com.tarefaDoCaverna.models.Order;


@Service
public class OrderService {

	@Autowired
	private MyFeignClient myFeignClient;
	
	public String validatePurchase(Order newOrder) {		
		ClmResponse response = myFeignClient.getCustomerPoints(newOrder.getCpf());		
		if(response.getPoints() >= newOrder.getTotalValue()) {
			return "Saldo Suficiente para realizar a compra";
		}else {
			throw new SaldoInsuficienteException("Saldo Insuficiente!");
		}
	}
	
}
