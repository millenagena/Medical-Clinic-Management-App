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
    private GerenciadorDoenca gDoenca = new GerenciadorDoenca();

    public Paciente(ArrayList<Doenca> historicoDoencas, String nome, String cpf, int idade, String rg, String telefone, String email) {
        super(nome, cpf, idade, rg, telefone, email);
        gDoenca.setHistoricoDoencas(historicoDoencas);
    }

    public GerenciadorDoenca getgDoenca() {
        return gDoenca;
    }

    public void setgDoenca(GerenciadorDoenca gDoenca) {
        this.gDoenca = gDoenca;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n Paciente{" + "\nhistoricoDoencas: " + this.getgDoenca().getHistoricoDoencas() + '}';
    }
    
}
