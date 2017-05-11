
public class Juego {

	public static void main(String[] args) {
			Thread animacionThread = new Thread(new Jugando());
			animacionThread.start();//Llama metodo run
		
	}

}
