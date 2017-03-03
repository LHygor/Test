package usuario;

import org.junit.Test;

import br.com.virtualtest.model.usuarios.Usuario;
import br.com.virtualtest.view.usuarios.LoginView;
import junit.framework.TestCase;

public class TestLoginView extends TestCase{
	
	Usuario u;

	@Override
	protected void setUp() throws Exception {
		u = new Usuario('a');
		u.setPass("teste");
		u.setUserName("testeA");
		super.setUp();
	}
	
	@Test
	public void testLoginOfAUser() throws Exception {
		
		Usuario test = LoginView.getLoginView(u);
		
		assertEquals(u.getTypeUser(), test.getTypeUser());
		assertEquals(u.getUserName(), test.getUserName());
		assertEquals(u.getPass(), test.getPass());
	}
}
