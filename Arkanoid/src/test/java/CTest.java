import java.awt.Button;
import java.awt.TextArea;
import java.net.HttpRetryException;
import java.net.URLConnection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

//importante no olvidar
@RunWith(MockitoJUnitRunner.class)
public class CTest {

	C obj = new C();

	@Mock
	URLConnection urlConnection;
	@Mock
	HttpRetryException exception;

	private TextArea textArea = new TextArea();

	@Mock
	private Button button;

	@Test
	public void mayorDetresnumerosWhenNumberFormatErrorTest() {
		try {
			obj.mayorDetresnumeros("adasdasd", 2, 3);
			Assert.fail("no debe llegar");
		} catch (NumberFormatException e) {
		}

		try {
			obj.mayorDetresnumeros("4", null, 3);
			Assert.fail("no debe llegar");
		} catch (RuntimeException e) {
		}
	}

	@Test
	public void mayorDetresnumeros() {
		Assert.assertEquals(Integer.valueOf(10), obj.mayorDetresnumeros("10", 2, 3));
		Assert.assertEquals(Integer.valueOf(210), obj.mayorDetresnumeros("2", 210, 3));
		Assert.assertEquals(Integer.valueOf(210), obj.mayorDetresnumeros("2", 5, 210));
	}

	@Test
	public void mockitoTest() {
		Mockito.when(exception.getMessage()).thenReturn("esto es mi error de codigo");
		Mockito.when(urlConnection.getConnectTimeout()).thenReturn(11);
		obj.mockito(exception, urlConnection);

	}

	@Test
	public void mockito2Test() {
		// textArea.setText("hola mundo");
		Mockito.when(button.getActionCommand()).thenReturn("onclick");
		obj.mockito2(textArea, button);
		// Assert.assertEquals("", textArea.getText());
	}
}
