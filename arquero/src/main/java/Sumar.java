import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Sumar {

	public int sumarDosNumeros(int n1, int n2) {
		return n1 + n2;
	}

	public int mockito(HttpsURLConnection http, int n1, int n2) {
		if (http.getAllowUserInteraction()) {
			return n1 + n2;
		} else {
			throw new RuntimeException();
		}
	}

	public void listar(List list) {
		list.isEmpty();
	}

}
