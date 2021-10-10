package net.maromo.prova1poo;
import java.time.LocalDate;

public class Funcionario {

    // ATRIBUTOS
    private int idFunc;
    private String nomeFunc;
    private String departamento;
    private LocalDate dataContratacao;
    private Double salario;
    private String documento;
    private Boolean estaAtivo;
    private int idEmpresa;

    // GETTERS AND SETTERS
    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Boolean getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(Boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public Funcionario setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
        return null;
    }

    // MÉTODOS
    public void atualizarSalario(double valor){
        salario += valor;
    }

    public void demitirFuncionario(boolean estaAtivo){
        if (getEstaAtivo() == false){
            System.out.println("Empregado demitido!");
        }
    }

    public void imprimir(){
        System.out.println("ID: " + idFunc);
        System.out.println("Nome: " + nomeFunc);
        System.out.println("Departamento: " + departamento);
        System.out.println("Data de Contratação: " + dataContratacao);
        System.out.println("Salário: " + salario);
        System.out.println("Documento: " + documento);
        if (estaAtivo==false){
            System.out.println("Status: Desempregado");
        }
        if (estaAtivo==true){
            System.out.println("Status: Empregado");
            System.out.println("Empresa: " + idEmpresa);
        }
    }
}