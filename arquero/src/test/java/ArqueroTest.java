import java.awt.Image;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArqueroTest {

	@Mock
	Image imgs;

	private Arquero arquero;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testAspectRatioIsCorrect() {
		int posx = 12;
		int posy = 14;
		int anchura = 300;
		int altura = 900;
		arquero = new Arquero(imgs, posx, posy, anchura, altura);
		Assert.assertEquals(3, arquero.getAspectRatio());
	}

	@Test
	public void testDivideByZero() {
		int posx = 12;
		int posy = 13;
		int anchura = 0;
		int altura = 34;
		Image imgs = null;

		try {
			arquero = new Arquero(imgs, posx, posy, anchura, altura);
			Assert.fail("debe saltar la excepcion");
		} catch (Exception e) {
		}

	}

	class ArqueroSettings {

		private int altura, anchura, posx, posy;

	}

}
