public class ContaCorrente extends Conta {

    // Atributos da Conta Corrente //
    private boolean cartao;
    private float pagamento;
    private float emprestimo;

    public void realizarPagamento(float valor) {
        if (this.getAtiva()) {
            if (this.getSaldo() > valor) {
                this.setSaldo(this.getSaldo() - valor);
                this.pagamento += valor;
                System.out.println("Pagamento de R$" + valor + " realizado!");
            }
        } else {
            System.out.println("Conta indisponível. Verifique os Dados inserido!");
        }
    }

    // Criação do Método Construtor //
    public ContaCorrente(int numeroConta) {
        super(numeroConta);
        this.cartao = true;
        this.pagamento = 0;
        this.emprestimo = 0;
        this.tipoConta = "Corrente";
    }

    // Craiação dos Métodos Especiais Getters e Setters //
    public float getPagamento() {
        return pagamento;
    }

    public void setPagamento(float pagamento) {
        this.pagamento = pagamento;
    }

    public boolean getCartao() {
        return cartao;
    }

    public void setCartao(boolean cartao) {
        this.cartao = cartao;
    }

    public float getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(float emprestimo) {
        this.emprestimo = emprestimo;
    }  
}