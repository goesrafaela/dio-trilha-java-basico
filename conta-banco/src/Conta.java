public class Conta {

    private static int contadorContas = 1;

    private int numeroConta;
    private ContaTerminal pessoa; 
    private Double saldo = 0.0;
    
    public Conta(int numeroConta, ContaTerminal pessoa, Double saldo) {
        this.numeroConta = contadorContas;
        this.pessoa = pessoa;
        contadorContas += 1;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public int getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public ContaTerminal getPessoa() {
        return pessoa;
    }
    public void setPessoa(ContaTerminal pessoa) {
        this.pessoa = pessoa;
    }   

    public String toString() {

        return "\nNumero da conta: " + this.getNumeroConta() +
        "\nNome: " + this.pessoa.getNome() +
        "\nCPF: " + this.pessoa.getCPF() +
        "\nEmail: " + this.pessoa.getEmail() +
        "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
        "\n";
    }    

    public void deposito(Double valor) {
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Valor depositado com sucesso!");
        }
        else{
            System.out.println("Não foi posivel fazer o depósito");
        }
    }
    public void sacar (Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
            
        }else{
            System.out.println("Não foi posivel fazer o saque");

        }
        
    }

    public void transferir(Conta contaDeposito, Double valor){
        if(valor > 0 && this.getSaldo()>= valor){
            setSaldo(getSaldo() - valor );

            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("transferencia realizada com sucesso!");

        }else{
            System.out.println("Não foi possivel realizar a transferencia!");

        }
    }

}
