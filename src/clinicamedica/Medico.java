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
    private ArrayList <ConsultaAgendada> listaConsultasAgendadas = new ArrayList();
    private Agenda agenda;
    private GerenciadorDoenca gDoenca = new GerenciadorDoenca();
    
    
    public Medico(String especialidade, String nome, String cpf, int idade, String rg, String telefone, String email, Agenda agenda, ArrayList<Doenca> historicoDoencas) {
        super(nome, cpf, idade, rg, telefone, email);
        this.especialidade = especialidade;
        this.agenda = agenda;
        gDoenca.setHistoricoDoencas(historicoDoencas);
    }
    
    public Medico(String especialidade, String nome, String cpf, int idade, String rg, String telefone, String email, ArrayList<Doenca> historicoDoencas) {
        super(nome, cpf, idade, rg, telefone, email);
        this.especialidade = especialidade;
        gDoenca.setHistoricoDoencas(historicoDoencas);
    }
    
    public GerenciadorDoenca getgDoenca() {
        return gDoenca;
    }

    public void setgDoenca(GerenciadorDoenca gDoenca) {
        this.gDoenca = gDoenca;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Agenda getAgenda() {
        return agenda;
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
        return super.toString()+ "\n Medico{" + "\nespecialidade: " + especialidade + "\nlistaConvenios: " + listaConvenios + "\nlistaDoencas: " + this.getgDoenca().getHistoricoDoencas() + '}';
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
    
    public void registrarConsultaRealizada(Paciente pac, String bpm, String pressao, String temperatura, String diagnostico, ArrayList<Medicamento> listaMedicamentos) throws ConsultaException {
        LocalDateTime data = null;
        for(ConsultaAgendada c: this.listaConsultasAgendadas){
            if(c.getPac().getNome().equals(pac.getNome())){
                data = c.getData();
                c.setIsRealizada(true);
            }
        }
        if(data == null){
            throw new ConsultaException("\n Consulta nao encontrada, talvez nao haja consultas agendadas");
        }else{
            RegistroConsulta consultaRealizada = new RegistroConsulta(pac.getNome(), super.getNome(), this.especialidade, data, bpm, pressao,temperatura, diagnostico, listaMedicamentos);
            for(Medicamento medicamento: listaMedicamentos){
                medicamento.decrementaQuantidade();
                medicamento.incrementaUso();
            }
            this.listaRegistroConsultas.add(consultaRealizada);
        }
    }
    
    public void registrarConsultaRealizada(Paciente pac, String bpm, String pressao, String temperatura, String diagnostico) throws ConsultaException {
        LocalDateTime data = null;
        for(ConsultaAgendada c: this.listaConsultasAgendadas){
            if(c.getPac().getNome().equals(pac.getNome())){
                data = c.getData();
                c.setIsRealizada(true);
            }
        }
        if(data == null){
            throw new ConsultaException("\n Consulta nao encontrada, talvez nao haja consultas agendadas");
        }else{
            RegistroConsulta consultaRealizada = new RegistroConsulta(pac.getNome(), super.getNome(), this.especialidade, data, bpm, pressao,temperatura, diagnostico);
            this.listaRegistroConsultas.add(consultaRealizada);
        }
    }
    
//    CONSULTAS AGENDADAS
    
    public ArrayList<ConsultaAgendada> getListaConsultasAgendadas() {
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
