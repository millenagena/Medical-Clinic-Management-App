/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Medico extends Pessoa {
    private String especialidade;
    private ArrayList <String> listaConvenios = new ArrayList();
    private ArrayList <RegistroConsulta> listaRegistroConsultas = new ArrayList();
    private Agenda agenda;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public ArrayList<String> getListaConvenios() {
        return listaConvenios;
    }

    public void addConvenio(String novoConvenio) {
        this.listaConvenios.add(novoConvenio);
    }
    
    public int removeConvenio(String nomeConvenio){
        for(String nome: this.listaConvenios){
            if(nome.equalsIgnoreCase(nomeConvenio)){
                this.listaConvenios.remove(nome);
                System.out.println("\n Convenio removido com sucesso");
                return 1;
            }
        }
        System.out.println("\n Convenio nao encontrado");
        return 0;
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
    
    public void getHistoricoPaciente(String dataInicial, String dataFinal, String nomePaciente){
        for(RegistroConsulta consulta: this.listaRegistroConsultas){
            if(consulta.getNomePaciente().equalsIgnoreCase(nomePaciente)){
                //consulta.getDataConsulta() -> verificar se essa dataConsulta esta dentro do intervalo de datas informado
            }
        }
        
    }
    
}
