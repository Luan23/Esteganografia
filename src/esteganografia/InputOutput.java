// Matematica Discreta - 2016.1 - UFCG - Curso de Ciencia da Computacao - Departamento de Sistemas e Computacao - CEEI
// Grupo: Artur Hermogenes, Lucas Arcoverde, Lucas Duarte, Luan Rocha, Mariana Araujo 
// Professor: Eanes Torres

package esteganografia;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class InputOutput {
	
	
	public static ArrayList read(String caminhoArquivo, ArrayList texto) throws Exception{
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(caminhoArquivo));

			do {
				String linha = in.readLine();
				texto.add(linha);
			} while (in.ready());
			in.close();
		}catch(Exception e){
			throw new Exception("Erro ao ler o arquivo");
		}
		System.out.println(texto);
		return texto;
	}
	
	public static void write(String caminhoArquivo, ArrayList texto, String mensagemSecreta) throws Exception {
		
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter(caminhoArquivo));
			
			for (int i = 0; i < texto.size(); i++) {
				if (i+1 != texto.size()) {
					out.write(texto.get(i).toString() + System.lineSeparator());
				}else{
					out.write(texto.get(i).toString() + mensagemSecreta);
				}
			}
			
			out.close();
			
		} catch (Exception e) {
			throw new Exception("Erro ao gravar o arquivo");
		}	
	}

}
