package notUnitaryTest;

import com.radev.purchase.entity.Fornecedor;
import com.radev.purchase.controller.FornecedorController;
import com.radev.purchase.controller.impl.FornecedorControllerImpl;

public class TestFornecedor {

	public static void main(String[] args) {
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCpf("1745634932");
		fornecedor.setEmail("deneralencar@gmail.com");
		fornecedor.setNome("Dener Fornecedor");
		fornecedor.setRg("61647600");
		
		FornecedorController fornecedorController = new FornecedorControllerImpl();
		
		try {
			fornecedorController.persist(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();
		}				
		
	}

}
