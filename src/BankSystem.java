public class BankSystem {
    public static void main(String[] args) throws Exception {
        
        // Array de Contas - capacidade para 6 contas //
        Conta conta[] = new Conta[6];

        // Criando contas correntes e poupanças //
        conta[0] = new ContaCorrente(2074216);
        conta[1] = new ContaCorrente(1300573);
        conta[2] = new ContaCorrente(4820653);
        conta[3] = new ContaPoupanca(4723575);
        conta[4] = new ContaPoupanca(1216734);
        conta[5] = new ContaPoupanca(9852058);

        // Clientes vinculados às contas - usando Composição //
        Cliente cliente1 = new Cliente("Bruce Wayne", "000.000.000-00", conta[0]);
        Cliente cliente2 = new Cliente("Tony Stark", "111.111.111-11", conta[1]);
        Cliente cliente3 = new Cliente("Peter Parker", "222.222.222-22", conta[2]);
        Cliente cliente4 = new Cliente("Natasha Romanoff", "333.333.333-33", conta[3]);
        Cliente cliente5 = new Cliente("Carol Danvers", "444.444.444-44", conta[4]);
        Cliente cliente6 = new Cliente("Felicia Sara", "555.555.555-55", conta[5]);

        // -------- Conta[0] - Testando abertura, fechamento e depósito em conta fechada -------- //
        System.out.println("------------------------------------------");
        System.out.println("---------------- Conta[0] ----------------");
        conta[0].abrirConta();
        System.out.println(cliente1.getConta().getAtiva());
        System.out.println("Nome: " + cliente1.getNome() + "\nCPF: " + cliente1.getCpf());
        System.out.println(conta[0].getTipoConta());
        conta[0].fecharConta(); // fechando a conta com saldo zero
        // Tentativa de depósito em conta fechada - sistema bloqueia //
        conta[0].depositar(1000f);
        System.out.println("Conta ativa: " + cliente1.getConta().getAtiva());
        System.out.println("------------------------------------------");

        // -------- Conta[1] - Testando depósito, saque, pagamento e data de criação -------- //
        System.out.println("---------------- Conta[1] ----------------");
        conta[1].abrirConta();
        System.out.println("Nome: " + cliente2.getNome() + "\nCPF: " + cliente2.getCpf());
        System.out.println("Número da conta: " + conta[1].getNumeroConta());
        System.out.println("Tipo: " + conta[1].getTipoConta());
        conta[1].verSaldo();
        conta[1].depositar(10500.75f);
        conta[1].verSaldo();
        conta[1].sacar(500.75f);
        conta[1].verSaldo();
        // Cast para acessar método específico da ContaCorrente //
        ((ContaCorrente) conta[1]).realizarPagamento(6000f);
        conta[1].verSaldo();
        System.out.println("Data de criação: " + conta[1].getDataCriacao());
        System.out.println("------------------------------------------");

        // -------- Conta[2] - Testando depósito, saque e saldo insuficiente -------- //
        System.out.println("---------------- Conta[2] ----------------");
        conta[2].abrirConta();
        System.out.println("Nome: " + cliente3.getNome() + "\nCPF: " + cliente3.getCpf());
        System.out.println("Número da conta: " + conta[2].getNumeroConta());
        System.out.println("Tipo: " + conta[2].getTipoConta());
        conta[2].depositar(1000f);
        conta[2].verSaldo();
        conta[2].sacar(599.99f);
        conta[2].verSaldo();
        System.out.println("------------------------------------------");
        
        // -------- Conta[3] - Testando depósito e cofrinho -------- //
        System.out.println("---------------- Conta[3] ----------------");
        conta[3].abrirConta();
        System.out.println("Nome: " + cliente4.getNome() + "\nCPF: " + cliente4.getCpf());
        System.out.println("Número da conta: " + conta[3].getNumeroConta());
        System.out.println("Tipo: " + conta[3].getTipoConta());
        conta[3].depositar(5000f);
        conta[3].verSaldo();
        // Cast para acessar método específico da ContaPoupanca //
        ((ContaPoupanca) conta[3]).guardaCofrinho(3000f);
        conta[3].verSaldo();
        System.out.println("------------------------------------------");

        // -------- Conta[4] - Testando fechamento com saldo e sem saldo -------- //
        System.out.println("---------------- Conta[4] ----------------");
        conta[4].abrirConta();
        System.out.println("Nome: " + cliente5.getNome() + "\nCPF: " + cliente5.getCpf());
        System.out.println("Número da conta: " + conta[4].getNumeroConta());
        System.out.println("Tipo: " + conta[4].getTipoConta());
        conta[4].depositar(7000f);
        // Tentativa de fechar conta com saldo - sistema bloqueia //
        conta[4].fecharConta();
        // Zerando o saldo para fechar a conta //
        conta[4].sacar(7000f);
        conta[4].fecharConta();
        System.out.println("------------------------------------------");

        // -------- Conta[5] - Testando cofrinho e fechamento com cofrinho -------- //
        System.out.println("---------------- Conta[5] ----------------");
        conta[5].abrirConta();
        System.out.println("Nome: " + cliente6.getNome() + "\nCPF: " + cliente6.getCpf());
        System.out.println("Número da conta: " + conta[5].getNumeroConta());
        System.out.println("Tipo: " + conta[5].getTipoConta());
        conta[5].depositar(5000f);
        conta[5].verSaldo();
        // Cast para acessar método específico da ContaPoupanca //
        ((ContaPoupanca) conta[5]).guardaCofrinho(1000f);
        System.out.println("Cofrinho: R$" + ((ContaPoupanca) conta[5]).getCofrinho());
        // Tentativa de fechar conta com cofrinho - sistema bloqueia //
        conta[5].fecharConta();
        // Zerando cofrinho e saldo para fechar a conta //
        ((ContaPoupanca) conta[5]).setCofrinho(0f);
        conta[5].sacar(5000f);
        conta[5].fecharConta();
        System.out.println("Conta ativa: " + conta[5].getAtiva());
        System.out.println("------------------------------------------");
    }
}