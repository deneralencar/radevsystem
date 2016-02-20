package notUnitaryTest;

import com.radev.purchase.controller.CompradorController;
import com.radev.purchase.controller.impl.CompradorControllerImpl;
import com.radev.purchase.entity.Comprador;

public class TestComprador {

	public static void main(String[] args) {
		
		Comprador comprador = new Comprador();
		comprador.setCpf("01745634932");
		comprador.setEmail("deneralencar@gmail.com");
		comprador.setNome("Dener Cezar");
		comprador.setRg("61647600");
		
		CompradorController compradorController = new CompradorControllerImpl();
		
		try {
			compradorController.persist(comprador);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
