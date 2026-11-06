import java.time.LocalDate;

public class Conta {
    
    // Atributos da Conta //
    private int numeroConta;
    private float saldo;   
    private boolean ativa;
    private LocalDate dataCriacao;
    protected String tipoConta;

    // Criação de Métodos //
    public void abrirConta() {
        this.setAtiva(true);
        System.out.println("Conta " + this.tipoConta + " aberta com sucesso!");
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Você ainda possui saldo na conta.");
        } else {
            if (this.getSaldo() < 0) {
                System.out.println("Você ainda possui saldo devedor.");
            } else {
                this.ativa = false;
                System.out.println("Conta encerrada.");
            }
        } 
    }

    public void depositar(float valor) {
        if (this.getAtiva()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito realizado! Saldo atual: R$" + this.getSaldo());
        } else {
            System.out.println("Conta indisponível. Verifique os Dados inserido!");
        }
    }

    public void sacar(float valor) {
        if (this.getAtiva()) {
            if (getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque de R$" + valor + " efetuado! Saldo atual: R$" + this.getSaldo());
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Conta indisponível. Verifique os Dados inserido!");
        }
    }

    public void verSaldo() {
        if (this.getAtiva()){
            System.out.println("Seu saldo atual é R$" + this.getSaldo());
        } else {
            System.out.println("Conta indisponível. Verifique os Dados inserido!");
        }
    }

    // Criação do Método Construtor //
    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0;
        this.ativa = false;
        this.dataCriacao = LocalDate.now();
    }

    // Craiação dos Métodos Especiais Getters e Setters //
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}