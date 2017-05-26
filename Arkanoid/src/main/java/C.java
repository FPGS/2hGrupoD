import java.awt.Button;
import java.awt.TextArea;
import java.net.HttpRetryException;
import java.net.URLConnection;

public class C {

	public void mockito(HttpRetryException exception, URLConnection url) {
		if (exception.getMessage().contains("error")) {
			if (url.getConnectTimeout() > 10) {
				return;
			}
			throw new RuntimeException();
		} else
			throw new RuntimeException();
	}

	public void mockito2(TextArea textArea, Button button) {
		if (button.getActionCommand() == "onclick") {
			textArea.setText("");
		} else
			throw new RuntimeException();
	}

	public Integer mayorDetresnumeros(String n1, Integer n2, Integer n3) {

		Integer num1 = Integer.parseInt(n1);

		if (n1 == null || n2 == null || n3 == null) {
			throw new RuntimeException("algo malo ocurrio");
		}

		Integer mayor;
		if (num1 > n2) {
			mayor = num1;
		}else {
			mayor = n2;
		}
		if (num1 > n3) {
			mayor = num1;
		}else{
			mayor = n3;
		}
		return mayor;
		
	}


}
