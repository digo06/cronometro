import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cronometro {

	private JLabel contagemTempo;
	private Timer tm;
	private int contador = 0;
	private boolean rodando = false;

	public void init() {

		JFrame janela = new JFrame("Cronometro");
		janela.setSize(300, 200);
		janela.setAlwaysOnTop(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new BorderLayout());

		contagemTempo = new JLabel("00:00:00");
		contagemTempo.setFont(new Font(contagemTempo.getName(), Font.PLAIN, 80));
		janela.add(contagemTempo, BorderLayout.CENTER);

		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(2, 1));

		JButton btIniciar = new JButton("Iniciar");
		btIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!rodando) {
					tm = new Timer();
					rodando = true;
					tm.scheduleAtFixedRate(new TimerTask() {

						@Override
						public void run() {
							contador++;
							int seg = contador % 60;
							int min = contador / 60;
							int hora = min / 60;
							min %= 60;
							contagemTempo.setText(String.format("%02d:%02d:%02d", hora, min, seg));
						}

					}, 1000, 1000);
				}
			}
		});
		JButton btParar = new JButton("Parar");
		btParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rodando) {
					tm.cancel();
					rodando = false;
					contador = 0;
				}
			}
		});
		painel.add(btIniciar);
		painel.add(btParar);
		janela.add(painel, BorderLayout.EAST);
		janela.pack();
		janela.setVisible(true);
	}
}
