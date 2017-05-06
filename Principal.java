import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {

		Cronometro c = new Cronometro();
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				c.init();
			}
		});
	}
}