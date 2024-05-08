import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Obrigada por utilizar nosso sistema");
                System.exit(0);
                break;

            default:
                System.out.println("Opção invalida");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        ContaTerminal pessoa = new ContaTerminal(nome, cpf, email);
        Conta conta = new Conta(0, pessoa, null);

        contasBancarias.add(conta);

        System.out.println("Conta criada!!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta)
                    ;
                conta = c;
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Digite o numero da conta: ");
        int numConta = input.nextInt();

        Conta conta = encontrarConta(numConta);

        if (conta != null) {
            System.out.println("Digite o valor de depósito: ");
            Double valorDeposito = input.nextDouble();
            conta.deposito(valorDeposito);
            System.out.println("Depósito realizado com sucesso");

        } else {
            System.out.println("Conta não encontrada no sistema");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Digite o numero da conta: ");
        int numConta = input.nextInt();

        Conta conta = encontrarConta(numConta);

        if (conta != null) {
            System.out.println("Digite o valor de saque: ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);

        } else {
            System.out.println("Conta não encontrada no sistema");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Digite o numero da conta do remetente: ");
        int numContaRem = input.nextInt();

        Conta contaRemetente = encontrarConta(numContaRem);

        if (contaRemetente != null) {
            System.out.println("Numero da conta do destinatario: ");
            int numContaDest = input.nextInt();

            Conta contaDest = encontrarConta(numContaDest);

            if (contaDest != null) {
                System.out.println("Qual o valor de transferencia: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDest, valor);
            } else {
                System.out.println("Não encontramos uma conta para deposito com esses dados");
            }
        } else {
            System.out.println("Conta para transferencia não encontrada");
        }

        operacoes();
    }

    public static void listar() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não encontramos nenhuma conta cadastradas");
        }
    }
}
