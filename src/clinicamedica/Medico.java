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

    public Medico(String especialidade, String nome, String cpf, int idade, String rg, String telefone, String email, Agenda agenda) {
        super(nome, cpf, idade, rg, telefone, email);
        this.especialidade = especialidade;
        this.agenda = agenda;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public ArrayList<String> getListaConvenios() {
        return listaConvenios;
    }

    @Override
    public String toString() {
        return super.toString()+ " Medico{" + "especialidade=" + especialidade + ", listaConvenios=" + listaConvenios + '}';
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

    public ArrayList<RegistroConsulta> getListaRegistroConsultas() {
        return listaRegistroConsultas;
    }

    public void setListaRegistroConsultas(ArrayList<RegistroConsulta> listaRegistroConsultas) {
        this.listaRegistroConsultas = listaRegistroConsultas;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public ArrayList<ConsultasAgendadas> getListaConsultasAgendadas() {
        return listaConsultasAgendadas;
    }
    
    public void registrarConsultaRealizada(Paciente pac, LocalDateTime data, String bpm, String pressao, String temperatura, String diagnostico, ArrayList<Medicamento> listaMedicamentos){
        RegistroConsulta consultaRealizada = new RegistroConsulta(pac.getNome(), super.getNome(), this.especialidade, data, bpm, pressao,temperatura, diagnostico, listaMedicamentos);
        for(Medicamento medicamento: listaMedicamentos){
            medicamento.decrementaQuantidade();
            medicamento.incrementaUso();
        }
        this.listaRegistroConsultas.add(consultaRealizada);
    }
    
    public ArrayList<RegistroConsulta> getHistoricoConsultasPorPaciente(Paciente pac){
        ArrayList<RegistroConsulta> listaConsultas = new ArrayList();
        
        for(RegistroConsulta registro: listaRegistroConsultas){
            if(registro.getNomePaciente().equals(pac.getNome())){
                listaConsultas.add(registro);
            }
        }
        return listaConsultas;
    }
    
}
