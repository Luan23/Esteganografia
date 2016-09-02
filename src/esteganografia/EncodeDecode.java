// Matematica Discreta - 2016.1 - UFCG - Curso de Ciencia da Computacao - Departamento de Sistemas e Computacao - CEEI
// Grupo: Artur Hermogenes, Lucas Arcoverde, Lucas Duarte, Luan Rocha, Mariana Araujo 
// Professor: Eanes Torres

package esteganografia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EncodeDecode {

	public static void encode(String mensagem, String filePath) throws Exception {
		ArrayList texto = new ArrayList();
		ArrayList parts = new ArrayList();
		String binary = stringBinaria(mensagem);
		ArrayList bits = divideMensagem(binary, parts, 3);
		String mensagemSecreta = transformaEmEspacos(bits, "bytesSpaces");
		InputOutput.write(filePath, InputOutput.read(filePath, texto), mensagemSecreta);
		
		System.out.println("\nCodificacao completa com sucesso!");
	}
	
	private static String stringBinaria(String mensagem) {
		String[] partes = mensagem.split("");
		String stringBinario = "";
		final String ZEROS = "00000000";
		for (String string : partes) {
			if (string.equals(" ")) {
				stringBinario += "00100000";
			} else {
				String bits = (Integer.toString(Integer.parseInt(Integer.toString((int) string.charAt(0)), 10), 2).toString());
				String intComoString = bits.length() <= 8 ? ZEROS.substring(bits.length()) + bits : bits;
				stringBinario += intComoString;
			}
		}

		return stringBinario;
	}
	
	private static ArrayList<Integer> divideMensagem(String mensagemBinaria, ArrayList pedacos, int tamanho) {
		while (true) {
			if (mensagemBinaria.length() % tamanho == 0) {
				int contador = 0;
				int inicio = 0;
				int fim = tamanho;
				while(contador < (mensagemBinaria.length()/tamanho)) {
					String pedaco = mensagemBinaria.substring(inicio,fim);
					pedacos.add(pedaco);
					inicio += tamanho;
					fim += tamanho;
					contador += 1;
				}
				break;
			} else {
				mensagemBinaria += "0";
			}
		}
		return pedacos;
	}
	
	private static String transformaEmEspacos(ArrayList pedacos, String operacao) {
		final String ZERO = "000";
		final String UM = "001";
		final String DOIS = "010";
		final String TRES = "011";
		final String QUATRO = "100";
		final String CINCO = "101";
		final String SEIS = "110";
		final String SETE = "111";
		String mensagemSecreta = "";
		String espaco = "";

		for (Object object : pedacos) {
			if (operacao.equals("bytesSpaces")) {
				if (object.equals(ZERO)) {
					espaco = " ";
				} else if (object.equals(UM)) {
					espaco = "  ";
				} else if (object.equals(DOIS)) {
					espaco = "   ";
				} else if (object.equals(TRES)) {
					espaco = "    ";
				} else if (object.equals(QUATRO)) {
					espaco = "     ";
				} else if (object.equals(CINCO)) {
					espaco = "      ";
				} else if (object.equals(SEIS)) {
					espaco = "       ";
				} else if (object.equals(SETE)) {
					espaco = "        ";
				}
				mensagemSecreta += "\t";
				mensagemSecreta += espaco;
			} else {
				if (object.equals(" ")) {
					espaco = ZERO;
				} else if (object.equals("  ")) {
					espaco = UM;
				} else if (object.equals("   ")) {
					espaco = DOIS;
				} else if (object.equals("    ")) {
					espaco = TRES;
				} else if (object.equals("     ")) {
					espaco = QUATRO;
				} else if (object.equals("      ")) {
					espaco = CINCO;
				} else if (object.equals("       ")) {
					espaco = SEIS;
				} else if (object.equals("        ")) {
					espaco = SETE;
				}				
				mensagemSecreta += espaco;
			}
		}
		return mensagemSecreta;
	}
	
	public static void decode(String filePath) throws Exception {
		ArrayList texto = new ArrayList();
		ArrayList elementos = new ArrayList();
		ArrayList strings = new ArrayList();
		String mensagemRevelada = "";
		ArrayList mensagem = InputOutput.read(filePath, texto);
		String linhaSecreta = mensagem.get(mensagem.size()-1).toString();
		String segredo = linhaSecreta.substring(linhaSecreta.indexOf("\t")+1, linhaSecreta.length());
		String[] separaEspacos = segredo.split("\t");
		
		for (String string : separaEspacos) {
			elementos.add(string);
		}
		String bits = transformaEmEspacos(elementos, "spacesBits");
		if (bits.endsWith("00")) {
			bits = bits.substring(0, bits.lastIndexOf("00"));
		} else if (bits.length() % 3 != 0){
			bits = bits.substring(0, bits.length()-1);
		}
		ArrayList pedacos = divideMensagem(bits, strings, 8);
		for (Object object : pedacos) {
			if (object.equals("00000000")) {
				break;
			}
			String str = new Character((char)Integer.parseInt(object.toString(), 2)).toString();
			mensagemRevelada += str;
		}
		System.out.println("\nDecodificao concluida com sucesso!");
		System.out.println("A mensagem secreta eh: " + mensagemRevelada);
	}
}
