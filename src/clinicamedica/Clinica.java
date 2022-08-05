/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Clinica implements GerenciadorMedicamento, GerenciadorMedico, GerenciadorPaciente, GerenciadorClinica {
    private String nome;
    private static ArrayList <Medico> listaMedicos = new ArrayList();
    private static ArrayList <Paciente> listaPacientes = new ArrayList();
    private static ArrayList <Medicamento> listaMedicamentos = new ArrayList();

    public Clinica() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public ArrayList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }
    
    @Override
    public String toString() {
        return "Clinica{" + "nome=" + nome + '}';
    }
    
//    GERENCIA MEDICAMENTOS
    
    public void mostrarListaMedicamentos(){
        for(Medicamento medicamento: listaMedicamentos){
            System.out.println("\n"+medicamento.toString()+"\n");
        }
    }
    
    public void cadastraMedicamento(Medicamento a){
        listaMedicamentos.add(a);
    }
    
    public Medicamento buscaMedicamentoPeloNome(String nome){
        for(Medicamento medicamento: listaMedicamentos){
            if(nome.equals(medicamento.getNome())){
                return medicamento;
            }
        }
        return null;
    }
    
    public void setarEstoqueMedicamento(int quantidade, String nome){
        Medicamento medicamento = buscaMedicamentoPeloNome(nome);
        medicamento.setQuantidadeEstoque(quantidade);
    }
    
    public void getUtilizacaoMedicamentos(){
        for(Medicamento medicamento: listaMedicamentos){
            System.out.println("\nNome: "+ medicamento.getNome() + "Quantidade: " + medicamento.getQuantidadeEstoque() + "Vezes usados: "+ medicamento.getQuantidadeUso());
        }
    }
    
//    GERENCIA MEDICO
    
    public Medico buscaMedicoPeloNome(String nome){
        for(Medico med: listaMedicos){
            if(nome.equals(med.getNome())){
                return med;
            }
        }
        return null;
    }
    
    public void cadastrarMedico(Medico a){
        listaMedicos.add(a);
    }
    
//    GERENCIA PACIENTE
    
    public Paciente buscaPacientePeloNome(String nome){
        for(Paciente pac: listaPacientes){
            if(nome.equals(pac.getNome())){
                return pac;
            }
        }
        return null;
    }
    
    public void cadastrarPaciente(Paciente a){
        this.listaPacientes.add(a);
    }
    
    public void atualizaHistoricoDoencaPaciente(Paciente pac, Doenca doen){
        pac.adicionaDoenca(doen);
    }
    
    public ArrayList<RegistroConsulta> getRelatorioPaciente(Paciente pac, LocalDateTime dataInicio, LocalDateTime dataFim){
        ArrayList<RegistroConsulta> totalListaConsultas = new ArrayList();
        
        for(Medico medico: listaMedicos){
           ArrayList<RegistroConsulta> listaPorMedico;
           listaPorMedico = medico.getHistoricoConsultasPorPaciente(pac, dataInicio, dataFim);
           for(RegistroConsulta reg: listaPorMedico){
               totalListaConsultas.add(reg);
           }
        }
        return totalListaConsultas;
    }
    
//    CLINICA
    
    public void agendarConsulta(Medico med, Paciente pac, LocalDateTime data){
        boolean isDataDisponivel = med.getAgenda().marcarAgenda(data);
        if(isDataDisponivel == true){
            ConsultasAgendadas novaConsulta = new ConsultasAgendadas(med, pac, data);
            med.getListaConsultasAgendadas().add(novaConsulta);
        }else{
            System.out.println("\n Data desejada nao existe ou nao esta disponivel \n");
        } 
    }
    
    
    
    
    
    
    
    
    
    
    
}
