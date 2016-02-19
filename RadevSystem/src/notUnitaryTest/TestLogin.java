package notUnitaryTest;

import com.radev.foundation.controller.UsuarioController;
import com.radev.foundation.controller.impl.UsuarioControllerImpl;
import com.radev.foundation.entity.Usuario;

public class TestLogin {

	public static void main(String[] args) {
		
    	UsuarioController usuarioController = new UsuarioControllerImpl();
    	Usuario usuario = usuarioController.findByLogin("Dener");

	}

}
