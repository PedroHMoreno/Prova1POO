package net.maromo.prova1poo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarFuncionario {
    public List<Funcionario> listaFuncionarios = new ArrayList<>();
    public List<Empresa> listaEmpresas = new ArrayList<>();

    public static void main(String[] args) {

        GerenciarFuncionario gf = new GerenciarFuncionario();
        Scanner input = new Scanner(System.in);

        int opc = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("================");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Cadastrar Empresa");
            System.out.println("3. Atualizar Salário");
            System.out.println("4. Demitir Funcionário");
            System.out.println("5. Listar Todos os Funcionarios Cadastrados");
            System.out.println("6. Listar Todas as Empresas Cadastradas");
            System.out.println("7. Listar Funcionários de UMA Empresa");
            System.out.println("8. Listar Funcionários de TODAS as Empresas");
            System.out.println("9. Adicionar Funcionário ao Quadro da Empresa");
            System.out.println("10. Verificar Existência de Funcionário na Empresa");
            System.out.println("11. SAIR");
            System.out.println("Escolha sua opção: \n");
            opc = Integer.parseInt(input.nextLine());

            switch(opc){
                case 1:
                    gf.cadastrarFuncionario();
                    break;
                case 2:
                    gf.cadastrarEmpresa();
                    break;
                case 3:
                    gf.atualizarSalario();
                    break;
                case 4:
                    gf.demitirFuncionario();
                    break;
                case 5:
                    gf.listarFuncCadastrados();
                    break;
                case 6:
                    gf.listarEmpresasCadastradas();
                    break;
                case 7:
                    gf.listarFuncUmaEmpresa();
                    break;
                case 8:
                    gf.listarFuncTodasEmpresas();
                    break;
                case 9:
                    gf.adicionarFuncionario();
                    break;
                case 10:
                    gf.verificarFuncionario();
                    break;
                case 11:
                    System.out.println("====================");
                    System.out.println("PROGRAMA FINALIZADO");
                    System.out.println("====================");
                    break;
                default:
                    System.out.println("===============");
                    System.out.println("OPÇÃO INVÁLIDA");
                    System.out.println("===============");
            }
        }while(opc !=11);
    }

    // MÉTODOS
    public void cadastrarFuncionario(){
        Scanner input = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        System.out.println("Digite o ID do Funcionario: ");
        funcionario.setIdFunc(Integer.parseInt(input.nextLine()));
        System.out.println("Digite o Nome do Funcionario: ");
        funcionario.setNomeFunc(input.nextLine());
        System.out.println("Digite o Departamento do Funcionario: ");
        funcionario.setDepartamento(input.nextLine());
        System.out.println("Digite a Data de Contratação (YYYY-MM-DD): ");
        funcionario.setDataContratacao(LocalDate.parse(input.nextLine()));
        System.out.println("Digite o Salário do funcionario: ");
        funcionario.setSalario(Double.parseDouble(input.nextLine()));
        System.out.println("Digite o Documento do funcionario: ");
        funcionario.setDocumento(input.nextLine());
        //Desempregado = Não foi indicado a uma empresa
        funcionario.setEstaAtivo(false);
        listaFuncionarios.add(funcionario);
    }

    public void cadastrarEmpresa(){
        Scanner input = new Scanner(System.in);
        Empresa empresa = new Empresa();
        System.out.println("Digite o ID da Empresa: ");
        empresa.setIdEmpresa(Integer.parseInt((input.nextLine())));
        System.out.println("Digite a Razão Social da Empresa: ");
        empresa.setRazaoSocial(input.nextLine());
        System.out.println("Digite o CNPJ da Empresa: ");
        empresa.setCnpj(input.nextLine());
        listaEmpresas.add(empresa);
    }

    public void atualizarSalario() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do Funcionario que se deseja atualizar o salario: ");
        int codigo = Integer.parseInt(input.nextLine());

        System.out.println("-------------------------------");
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getIdFunc() == codigo) {
                System.out.println("FUNCIONARIO ENCONTRADO!");
                System.out.println("Indique o aumento que o funcionario recebera: ");

                //chamar metodo para adicionar valor ao salario atual
                double valor = Double.parseDouble(input.nextLine());
                funcionario.atualizarSalario(valor);

                System.out.println("SALARIO ATUALIZADO!");
                System.out.println("-------------------------------");
                System.out.println("ID Funcionario: " + funcionario.getIdFunc());
                System.out.println("Nome do Funcionario: " + funcionario.getNomeFunc());
                System.out.println("Salario Atual: " + funcionario.getSalario());
                System.out.println("-------------------------------");
                //mostrar novo salario
                return;
            }
        }
    }

    public void demitirFuncionario(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do funcionario que sera demitido: ");
        int codigo = Integer.parseInt(input.nextLine());
        System.out.println("-------------------------------");
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getIdFunc() == codigo && funcionario.getEstaAtivo() == true){
                funcionario.setEstaAtivo(false);
                boolean estaAtivo = false;
                funcionario.demitirFuncionario(estaAtivo);
                return;
            }
            if (funcionario.getIdFunc() != codigo && funcionario.getEstaAtivo() == true){
                System.out.println("ERRO - ID INVALIDO!");
                System.out.println("FUNCIONARIO NAO ENCONTRADO!");
            }
        }
        return;
    }

    public void listarFuncCadastrados(){
        System.out.println("\nFuncionarios Cadastrados");
        System.out.println("------------------------------------------------");
        for (Funcionario funcionario : listaFuncionarios){
            funcionario.imprimir();
            System.out.println("------------------------------------------------");
        }
        return;
    }

    public void listarEmpresasCadastradas(){
        System.out.println("\nEmpresas Cadastradas");
        System.out.println("------------------------------------------------");
        for (Empresa empresa : listaEmpresas){
            empresa.imprimir();
        }
        return;
    }

    public void listarFuncUmaEmpresa(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID da Empresa para mostrar os funcionarios: ");
        int codigo = Integer.parseInt(input.nextLine());
        System.out.println("-------------------------------");
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getIdEmpresa() == codigo) {
                System.out.println("EMPRESA ENCONTRADA!");
                empresa.mostrarEmpregados();
                for (Funcionario funcionario : listaFuncionarios){
                    if (empresa.getIdEmpresa() == funcionario.getIdEmpresa() && funcionario.getEstaAtivo()==true){
                        System.out.println("\nDados do Funcionário");
                        System.out.println("------------------------------------------------");
                        funcionario.imprimir();
                        System.out.println("------------------------------------------------");
                    }
                    if (empresa.getIdEmpresa() != funcionario.getIdEmpresa() && funcionario.getEstaAtivo()==true){
                        System.out.println("Nenhum funcionario cadastrado nessa empresa.");
                    }
                }
                return;
            }
        }
    }

    public void listarFuncTodasEmpresas(){
        for (Empresa empresa : listaEmpresas){
            for (Funcionario funcionario : listaFuncionarios) {
                if (funcionario.getEstaAtivo() == true) {
                    funcionario.imprimir();
                    empresa.mostrarFuncionariosAtivos();
                }
            }
            return;
        }
        return;
    }

    public void adicionarFuncionario() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID da Empresa em que o funcionario sera contratado: ");
        int codigo = Integer.parseInt(input.nextLine());
        System.out.println("-------------------------------");
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getIdEmpresa() == codigo) {
                System.out.println("EMPRESA ENCONTRADA!");
                System.out.println("-------------------------------");
                System.out.println("Digite o ID do Funcionario que se deseja contratar: ");
                int codigo2 = Integer.parseInt(input.nextLine());
                System.out.println("-------------------------------");
                for (Funcionario funcionario : listaFuncionarios) {
                    if (funcionario.getIdFunc() == codigo2 && funcionario.getEstaAtivo() == false) {
                        funcionario.setEstaAtivo(true);
                        funcionario.setIdEmpresa(codigo);
                        empresa.adicionarEmpregados();
                    }
                }
            }
        }
        return;
    }

    public void verificarFuncionario() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID da Empresa que o funcionario trabalha: ");
        int codigo = Integer.parseInt(input.nextLine());
        System.out.println("-------------------------------");
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getIdEmpresa() == codigo) {
                System.out.println("EMPRESA ENCONTRADA!");
                System.out.println("-------------------");
                System.out.println("Digite o ID do funcionario desejado: ");
                int codigo2 = Integer.parseInt(input.nextLine());
                for (Funcionario funcionario : listaFuncionarios) {
                    if (funcionario.getIdFunc() == codigo2 && funcionario.getEstaAtivo() == true) {
                        boolean achei = true;
                        empresa.contemFuncionario(achei);
                        System.out.println("\nDados do Funcionário");
                        System.out.println("------------------------------------------------");
                        funcionario.imprimir();
                        empresa.mostrarFuncionariosAtivos();
                    }
                    if (funcionario.getIdFunc() != codigo2 && funcionario.getEstaAtivo() == true) {
                        boolean achei = false;
                        empresa.contemFuncionario(achei);
                    }
                }

            } if (empresa.getIdEmpresa() != codigo) {
                System.out.println("ERRO - ID INVALIDO!");
                System.out.println("EMPRESA NAO ENCONTRADA!");
                return;
            }
        }
        return;
    }
}