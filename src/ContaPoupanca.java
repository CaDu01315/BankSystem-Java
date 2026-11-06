public class ContaPoupanca extends Conta {
    
    // Atributos da Conta Poupança //
    private float cofrinho;
    private float investimentos;

    public void guardaCofrinho(float valor) {
        if (this.getAtiva()) {
            if (this.getSaldo() > valor) {
                this.setSaldo(this.getSaldo() - valor);
                this.cofrinho += valor;
                System.out.println("R$" + valor + " Guardado no cofrinho");
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("Conta indisponível. Verifique os Dados inserido!");
        }    
    }

    // Criação do Método Construtor //
    public ContaPoupanca(int numeroConta) {
        super(numeroConta);
        this.cofrinho = 0;
        this.investimentos = 0;
        this.tipoConta = "Poupança";
    }

    // Craiação dos Métodos Especiais Getters e Setters //
    public float getCofrinho() {
        return cofrinho;
    }

    public void setCofrinho(float cofrinho) {
        this.cofrinho = cofrinho;
    }

    public float getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(float investimentos) {
        this.investimentos = investimentos;
    }

    @Override
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Você ainda possui saldo na conta.");
        } else {
            if (this.getSaldo() < 0) {
                System.out.println("Você ainda possui saldo devedor.");
            } else {
                this.setAtiva(false);
                System.out.println("Conta encerrada.");
            }
        } if (this.cofrinho > 0) {
            System.out.println("Você possui saldo no cofrinho.");
        } else {
            if (this.investimentos > 0) {
                System.out.println("Você possui investimentos ativos na conta.");
            } else {
                this.setAtiva(false);
                System.out.println("Conta encerrada.");
            }
        }
    }
}