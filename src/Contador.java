import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);

    String mensagemInput1 = "Digite o primeiro parâmetro (número):";
    String mensagemInput2 = "Digite o segundo parâmetro (número):";
    String mensagemError = "O parâmetro deve ser um número inteiro";

		int parametroUm = lerNumeroDeEntrada(mensagemInput1, mensagemError, terminal);
		int parametroDois = lerNumeroDeEntrada(mensagemInput2, mensagemError, terminal);
		
		try {
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);
		
		}catch (ParametrosInvalidosException exception) {
			//imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
      System.err.println(exception.getMessage());
		} finally {
      terminal.close();
    }
	}

  public static int lerNumeroDeEntrada (String menssagemDeInstrucao, String MessagemErro, Scanner scanner) {
    boolean inputInvalido;
    int numero = 0;
    
    do {
      try {
        System.out.println(menssagemDeInstrucao);
        numero = Integer.parseInt(scanner.nextLine());
        inputInvalido = false;
      } catch (RuntimeException e) {
        inputInvalido = true;
        System.err.println("Error: " + MessagemErro + ". Caso queira sair digite \"ctrl+C\"");
      }
    } while (inputInvalido);
    
    return numero;
  }

	public static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		if (parametroUm > parametroDois) {
      throw new ParametrosInvalidosException();
    }

		int contagem = parametroDois - parametroUm;

    for (int i = 1; i <= contagem; i++) {
      System.out.printf("Imprimindo o número %d\n", i);
    }
	}
}