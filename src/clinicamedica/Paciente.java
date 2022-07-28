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
    public ArrayList<Doenca> historicoDoencas;

    public Paciente(ArrayList<Doenca> historicoDoencas, String nome, String cpf, int idade, String rg, String nomeMae, int telefone, String email, String endereco) {
        //super(nome, cpf, idade, rg, nomeMae, telefone, email, endereco);
        this.historicoDoencas = historicoDoencas;
    }
    
    public ArrayList<Doenca> getHistoricoDoencas() {
        return historicoDoencas;
    }

    @Override
    public String toString() {
        return "Paciente{" + "historicoDoencas=" + historicoDoencas + '}';
    }
}
