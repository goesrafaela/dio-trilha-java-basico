
public class ContaTerminal {
    private static int counter = 1;

    private String nome;
    private String cpf;
    private String email;

    public ContaTerminal(String nome, String CPF, String email) {
        this.nome = nome;
        this.cpf = CPF;
        this.email = email;
        counter += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String toString() {
        return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCPF() +
                "\nEmail: " + this.getEmail();
    }
}