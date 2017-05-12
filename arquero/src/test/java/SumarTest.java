
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SumarTest {

	Sumar sum = new Sumar();

	@Mock
	HttpsURLConnection http;

	@Mock
	List lista;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSumar() {
		Assert.assertEquals(4, sum.sumarDosNumeros(2, 2));
	}

	@Test
	public void testMockito() {
		Mockito.when(http.getAllowUserInteraction()).thenReturn(true);
		Assert.assertEquals(7, sum.mockito(http, 3, 4));
	}

	@Test
	public void testMockitoException() {
		Mockito.when(http.getAllowUserInteraction()).thenReturn(false);
		try {
			Assert.assertEquals(7, sum.mockito(http, 3, 4));
			Assert.fail("no debe llegar aquí");
		} catch (RuntimeException e) {
		}
	}

	@Test
	public void testList() {
		sum.listar(lista);
	}


}
