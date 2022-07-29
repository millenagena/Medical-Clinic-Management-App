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
public class Paciente extends Pessoa {
    private ArrayList<Doenca> historicoDoencas;

    public Paciente(ArrayList<Doenca> historicoDoencas, String nome, String cpf, int idade, String rg, String telefone, String email) {
        super(nome, cpf, idade, rg, telefone, email);
        this.historicoDoencas = historicoDoencas;
    }    

    public ArrayList<Doenca> getHistoricoDoencas() {
        return historicoDoencas;
    }

    public void setHistoricoDoencas(ArrayList<Doenca> historicoDoencas) {
        this.historicoDoencas = historicoDoencas;
    }
    
    public void adicionaDoenca(Doenca a){
        this.historicoDoencas.add(a);
    }

    @Override
    public String toString() {
        return super.toString() + " Paciente{" + "historicoDoencas=" + historicoDoencas + '}';
    }
    
}
