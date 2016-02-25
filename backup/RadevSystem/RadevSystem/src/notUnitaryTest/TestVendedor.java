package notUnitaryTest;

import com.radev.foundation.controller.VendedorController;
import com.radev.foundation.controller.impl.VendedorControllerImpl;
import com.radev.foundation.entity.Vendedor;

public class TestVendedor {

	public static void main(String[] args) {
		
		Vendedor vendedor = new Vendedor();
		vendedor.setCpf("12345678912");
		vendedor.setEmail("email@gmail.com");
		vendedor.setNome("Dener Vendedor");
		vendedor.setRg("12345678");
		
		VendedorController vendedorController = new VendedorControllerImpl();
		
		try {
			vendedorController.persist(vendedor);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
