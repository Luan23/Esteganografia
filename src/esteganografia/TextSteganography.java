// Matematica Discreta - 2016.1 - UFCG - Curso de Ciencia da Computacao - Departamento de Sistemas e Computacao - CEEI
// Grupo: Artur Hermogenes, Lucas Arcoverde, Lucas Duarte, Luan Rocha, Mariana Araujo 
// Professor: Eanes Torres

package esteganografia;

import java.util.Scanner;

public class TextSteganography {

	
	public static final String ESCONDER = "1";
	public static final String REVELAR = "2";
	public static final String SAIR = "3";
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String opcao;
		String mensagemSecreta;
		String caminhoArquivo;
		
		System.out.println();
		System.out.println("======= Ferramenta de Esteganografia em arquivos Texto =======");
		System.out.println("\nAperte a tecla 1 para esconder uma mensagem secreta");
		System.out.println("Aperte a tecla 2 para revelar um mensagem secreta");
		System.out.println("Aperte a tecla 3 para sair");
	
		
		System.out.print("\nEscolha uma opcao: ");
		opcao = scan.nextLine();
		
		while (!(opcao.equals(SAIR))) {			
		
			if (opcao.equals(ESCONDER)) {
				System.out.println("\n===== Escondendo Mensagem =====");
				System.out.print("\nDigite o caminho do arquivo recipiente: ");
				caminhoArquivo = scan.nextLine();
				System.out.print("Digite a mensagem secreta que deseja esconder: ");
				mensagemSecreta = scan.nextLine();
				EncodeDecode.encode(mensagemSecreta, caminhoArquivo);
			}
			else if (opcao.equals(REVELAR)) {
				System.out.println("\n===== Revelando Mensagem =====");
				System.out.print("\nDigite o caminho do arquivo: ");
				caminhoArquivo = scan.nextLine();
				EncodeDecode.decode(caminhoArquivo);
			}
			else {
				System.out.println("Opcao invalida.");
				System.out.println("\nPor favor, digite uma opcao valida!");
			}
			
			System.out.println();
			System.out.println("======= Ferramenta de Esteganografia em arquivos Texto =======");
			System.out.println("\nAperte a tecla 1 para esconder uma mensagem secreta");
			System.out.println("Aperte a tecla 2 para revelar um mensagem secreta");
			System.out.println("Aperte a tecla 3 para sair");
		
			
			System.out.print("\nEscolha uma opcao: ");
			opcao = scan.nextLine();
		}
	
	}
}
