package analise.dados.com.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import analise.dados.com.dominio.Retorno;

public class Arquivo {
	
	private static final String OUT_FILE = "c:/HOMEPATH/data/out/out.txt";
	
	private static final String IN_DIR = "c:/HOMEPATH/data/in/";


	public void gravar(Retorno retorno) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(OUT_FILE)){
			pw.println("QTD CLIENTE: "+retorno.getQtdCliente());
			pw.println("QTD VENDEDORES: "+retorno.getQtdVendedores());
			pw.println("QTD VENDA: "+retorno.getIdVendaCara());
			pw.println("QTD PIOR VENDEDOR: "+retorno.getPiorVendedor());
		}
	}
	
	
	public Set<String[]> leitura() throws IOException {
		Set<String[]> setList = new HashSet<String[]>();
		File fileDirIn =  new File(IN_DIR);
		if(fileDirIn.listFiles().length>0) {
			String texto = "";
			extracted(fileDirIn, texto, setList);
		}
		return setList;
	}


	private void  extracted(File fileDirIn, String texto, Set<String[]> setList) throws IOException {
		for(File file : fileDirIn.listFiles()) {
			try(Scanner scan = new Scanner(new FileReader(file, Charset.forName("UTF-8")))) {
				while(scan.hasNextLine()) {
					String line = scan.nextLine();
					String[] tokens = line.split("ç");
					setList.add(tokens);
				}
				
			}
		 file.delete();
		}
	}


}
