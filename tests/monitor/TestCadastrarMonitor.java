package monitor;

import org.junit.Test;

import br.com.virtualtest.view.usuarios.CadastrarView;
import junit.framework.TestCase;

public class TestCadastrarMonitor extends TestCase{
	
	CadastrarView c;
	
	@Override
	protected void setUp() throws Exception {
		c = new CadastrarView();
		super.setUp();
	}
	
	@Test
	public void testCadastrarUmMonitor() throws Exception {
		assertEquals(!true, c.cadastrar());
	}
	
}

