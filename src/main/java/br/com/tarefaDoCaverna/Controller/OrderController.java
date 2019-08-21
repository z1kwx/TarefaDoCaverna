package br.com.tarefaDoCaverna.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefaDoCaverna.Service.OrderService;
import br.com.tarefaDoCaverna.models.Order;

@RestController
public class OrderController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class.getName());
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/validateOrder")
	public ResponseEntity<?> validatePurchase(@RequestBody Order newOrder){
		log.debug("validatePurchase(Order newOrder) - start - param: {}", newOrder);
		orderService.validatePurchase(newOrder);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Compra Efetuada com Sucesso!");
	}
	
}
