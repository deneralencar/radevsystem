package notUnitaryTest;

import com.radev.foundation.controller.ClienteController;
import com.radev.foundation.controller.impl.ClienteControllerImpl;
import com.radev.foundation.entity.Cliente;

public class TestCliente {
	
	public static void main(String args[]) {
		
		Cliente cliente = new Cliente();
		cliente.setCpf("1745634932");
		cliente.setEmail("deneralencar@gmail.com");
		cliente.setNome("Dener Alencar");
		cliente.setRg("61647600");
		
		ClienteController clienteController = new ClienteControllerImpl();
		
		try {
			clienteController.persist(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}				
		
	}

}
