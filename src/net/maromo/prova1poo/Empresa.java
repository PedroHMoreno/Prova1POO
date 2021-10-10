package net.maromo.prova1poo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

    // ATRIBUTOS
    public int idEmpresa;
    public String razaoSocial;
    public String cnpj;

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // MÉTODOS
    public void adicionarEmpregados(){

        System.out.println("FUNCIONARIO ENCONTRADO!");
        System.out.println("Cadastrando funcionario...");
    }

    public void mostrarEmpregados(){
        System.out.println("\nDados da Empresa");
        System.out.println("------------------------------------------------");
        imprimir();
    }

    public void contemFuncionario(boolean achei){
        if (achei==true){
            System.out.println("Funcionario Encontrado!");
            System.out.println("-----------------------");
        }
        if (achei==false){
            System.out.println("Funcionario Não Encontrado!");
        }
    }

    public void inativarFuncionario(){
        Funcionario funcionario = new Funcionario();
        if (funcionario.getEstaAtivo() == false){
            funcionario.setIdEmpresa(Integer.parseInt(null));
            System.out.println("Funcionario Inativo!");
        }
    }

    public void mostrarFuncionariosAtivos(){

        System.out.println("Nome Empresa: " + razaoSocial);
        System.out.println("------------------------------------------------");
    }

    public void imprimir(){

        System.out.println("ID: " + idEmpresa);
        System.out.println("Razao Social: " + razaoSocial);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("------------------------------------------------");
    }
}