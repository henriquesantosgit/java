package br.edu.fatecpg.associacao.model;

public class Empresa {
    private Cliente[] clientes = new Cliente[5];
    private Funcionario[] funcionarios = new Funcionario[10];
    private int totalClientes = 0;
    private int totalFuncionarios = 0;

    /**
     * Método para adicionar um cliente.
     * Verifica se há espaço na lista de clientes antes de adicionar.
     */
    public void adicionarCliente(String nome, String email) {
        if (totalClientes < clientes.length) {
            clientes[totalClientes++] = new Cliente(nome, email);
        } else {
            System.out.println("Limite de clientes atingido.");
        }
    }

    /**
     * Método para exibir todos os clientes cadastrados na empresa.
     */
    public void exibirClientes() {
        System.out.println("Lista de Clientes:");
        for (int i = 0; i < totalClientes; i++) {
            System.out.println("Cliente: " + clientes[i].getNome() + ", Email: " + clientes[i].getEmail());
        }
    }

    /**
     * Método para adicionar um funcionário.
     * Verifica se há espaço na lista de funcionários antes de adicionar.
     */
    public void adicionarFuncionario(String nome, String cargo, double salario) {
        if (totalFuncionarios < funcionarios.length) {
            funcionarios[totalFuncionarios++] = new Funcionario(nome, cargo, salario);
        } else {
            System.out.println("Limite de funcionários atingido.");
        }
    }

    /**
     * Método para exibir todos os funcionários cadastrados na empresa.
     */
    public void exibirFuncionarios() {
        System.out.println("Lista de Funcionários:");
        for (int i = 0; i < totalFuncionarios; i++) {
            System.out.println("Funcionário: " + funcionarios[i].getNome() + ", Cargo: " + funcionarios[i].getCargo() + ", Salário: " + funcionarios[i].getSalario());
        }
    }

    /**
     * Método para calcular a folha salarial total da empresa.
     * Retorna o valor total gasto em salários.
     */
    public double calcularFolhaSalarial() {
        double total = 0;
        for (int i = 0; i < totalFuncionarios; i++) {
            total += funcionarios[i].getSalario();
        }
        System.out.println("Folha salarial total: " + total);
        return total;
    }

    /**
     * Método para calcular a média salarial dos funcionários usando a classe Calculadora.
     * A Calculadora é usada temporariamente dentro do método, sem ser armazenada.
     */
    public double calcularMediaSalarial() {
        if (totalFuncionarios == 0) return 0;
        Calculadora calculadora = new Calculadora();
        double somaSalarios = 0;

        for (int i = 0; i < totalFuncionarios; i++) {
            somaSalarios = calculadora.somar(somaSalarios, funcionarios[i].getSalario());
        }

        return calculadora.multiplicar(somaSalarios, 1.0 / totalFuncionarios);
    }

    /**
     * Método para exibir a média salarial dos funcionários.
     */
    public void exibirMediaSalarial() {
        System.out.println("Média salarial: " + calcularMediaSalarial());
    }
}
