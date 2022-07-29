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
public class Medico extends Pessoa {
    private String especialidade;
    private ArrayList <String> listaConvenios = new ArrayList();
    private ArrayList <RegistroConsulta> listaRegistroConsultas = new ArrayList();
    private ArrayList <ConsultasAgendadas> listaConsultasAgendadas = new ArrayList();
    private Agenda agenda;
    private ArrayList <Doenca> listaDoencas = new ArrayList();

    public Medico(String especialidade, String nome, String cpf, int idade, String rg, String telefone, String email, Agenda agenda) {
        super(nome, cpf, idade, rg, telefone, email);
        this.especialidade = especialidade;
        this.agenda = agenda;
    }
    
    public Agenda getAgenda() {
        return agenda;
    }

    public ArrayList<Doenca> getListaDoencas() {
        return listaDoencas;
    }

    public void setListaDoencas(ArrayList<Doenca> listaDoencas) {
        this.listaDoencas = listaDoencas;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public void setListaRegistroConsultas(ArrayList<RegistroConsulta> listaRegistroConsultas) {
        this.listaRegistroConsultas = listaRegistroConsultas;
    }
    
    @Override
    public String toString() {
        return super.toString()+ " Medico{" + "especialidade=" + especialidade + ", listaConvenios=" + listaConvenios + '}';
    }
    
//    CONVENIO

    public ArrayList<String> getListaConvenios() {
        return listaConvenios;
    }

    public void addConvenio(String novoConvenio) {
        this.listaConvenios.add(novoConvenio);
    }
    
    public void removeConvenio(String nomeConvenio){
        for(String nome: this.listaConvenios){
            if(nome.equalsIgnoreCase(nomeConvenio)){
                this.listaConvenios.remove(nome);
                System.out.println("\n Convenio removido com sucesso");
            }
        }
        System.out.println("\n Convenio nao encontrado");
    }
    
//    DOENCA
    
    public void addDoenca(Doenca a){
        this.listaDoencas.add(a);
    }
    
    public boolean incrementaDoenca(Doenca a){
        for(Doenca doenca: this.listaDoencas){
            if(a.equals(doenca)){
                doenca.incrementaOcorrencia();
                return true;
            }
        }
        
        return false; //dai cria uma nova doenca no array de doencas do medico
    }
    
//    REGISTRO CONSULTAS

    public ArrayList<RegistroConsulta> getListaRegistroConsultas() {
        return listaRegistroConsultas;
    }
    
    public ArrayList<RegistroConsulta> getFaixaRegistros(LocalDateTime dataInicio, LocalDateTime dataFim){
        ArrayList<RegistroConsulta> listaConsultas = new ArrayList();
        
        for(RegistroConsulta registro: listaRegistroConsultas){
            if(registro.getDataConsulta().isAfter(dataInicio) && registro.getDataConsulta().isBefore(dataFim)){
                listaConsultas.add(registro);
            }
        }
        
        return listaConsultas;
    }
    
    public void mostrarDataConsultasRealizadas(){
        for(RegistroConsulta registro: listaRegistroConsultas){
            System.out.println(registro.getDataConsulta().toLocalDate() + " : " + registro.getDataConsulta().toLocalTime());
        }
    }
    
    public void registrarConsultaRealizada(Paciente pac, LocalDateTime data, String bpm, String pressao, String temperatura, String diagnostico, ArrayList<Medicamento> listaMedicamentos){
        RegistroConsulta consultaRealizada = new RegistroConsulta(pac.getNome(), super.getNome(), this.especialidade, data, bpm, pressao,temperatura, diagnostico, listaMedicamentos);
        for(Medicamento medicamento: listaMedicamentos){
            medicamento.decrementaQuantidade();
            medicamento.incrementaUso();
        }
        this.listaRegistroConsultas.add(consultaRealizada);
    }
    
//    CONSULTAS AGENDADAS
    
    public ArrayList<ConsultasAgendadas> getListaConsultasAgendadas() {
        return listaConsultasAgendadas;
    }

//    CONSULTAS REALIZADAS POR PACIENTE
    
    public ArrayList<RegistroConsulta> getHistoricoConsultasPorPaciente(Paciente pac, LocalDateTime dataInicio, LocalDateTime dataFim){
        ArrayList<RegistroConsulta> listaConsultas = new ArrayList();
        
        for(RegistroConsulta registro: listaRegistroConsultas){
            if(registro.getNomePaciente().equals(pac.getNome()) && registro.getDataConsulta().isAfter(dataInicio) && registro.getDataConsulta().isBefore(dataFim)){
                listaConsultas.add(registro);
            }
        }
        return listaConsultas;
    }
    
}
