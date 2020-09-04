package analise.dados.com;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Processamento {

	public static void main(String[] args) throws IOException {

	final long time = 3000; 
	Timer timer = new Timer();
	TimerTask task = new Jobs();
	timer.scheduleAtFixedRate(task, time, time);

	}

}
