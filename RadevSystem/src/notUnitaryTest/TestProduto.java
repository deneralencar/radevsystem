package notUnitaryTest;

import com.radev.foundation.controller.ProdutoController;
import com.radev.foundation.controller.impl.ProdutoControllerImpl;
import com.radev.foundation.entity.Produto;

public class TestProduto {

	public static void main(String[] args) {
		
		Produto produto = new Produto();
		produto.setDescricao("Refrigerador");
		produto.setValor(999.00f);
		
		ProdutoController produtoController = new ProdutoControllerImpl();
		
		try {
			produtoController.persist(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
