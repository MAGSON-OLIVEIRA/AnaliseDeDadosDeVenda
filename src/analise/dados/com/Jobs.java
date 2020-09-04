package analise.dados.com;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimerTask;

import analise.dados.com.dominio.Retorno;
import analise.dados.com.io.Arquivo;

public class Jobs extends TimerTask {
	
	Arquivo arquivo = new Arquivo();
	
	@Override
	public void run() {
		Retorno retorno = new Retorno();
		
		try {
			Set<String[]> leitura = arquivo.leitura();
			if(!leitura.isEmpty()) {
				Iterator<String[]> interator = leitura.iterator();
				int contCliente = 0;
				int contVendedores = 0;
				while (interator.hasNext()) {
					String[] it = interator.next();
					if(it[0].equals("001")) {
						contCliente ++;
					}if(it[0].equals("002")) {
						contVendedores++;
					}else if (it[0].equals("003")) {
						retorno.setIdVendaCara(it[1]);
						retorno.setPiorVendedor(it[3]);
					}
				}
				retorno.setQtdCliente(String.valueOf(contCliente));
				retorno.setQtdVendedores(String.valueOf(contVendedores));
				arquivo.gravar(retorno);
				leitura = new HashSet<String[]>();
			}else {
				System.out.println("[Lista vazia]: OK");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
