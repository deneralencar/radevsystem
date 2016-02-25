package notUnitaryTest;

import com.radev.foundation.controller.TransportadoraController;
import com.radev.foundation.controller.impl.TransportadoraControllerImpl;
import com.radev.foundation.entity.Transportadora;

public class TestTransportadora {

	public static void main(String[] args) {
		
		Transportadora transportadora = new Transportadora();
		transportadora.setNome("CargoLift");
		
		TransportadoraController transportadoraController = new TransportadoraControllerImpl();		
		
		try {
			transportadoraController.persist(transportadora);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
