/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

/**
 *
 * @author lucas
 */
public class MedicamentoInjetavel extends Medicamento {

    public MedicamentoInjetavel(String nome, String Faixa, int quantidadeEstoque, int quantidadeUso, String tipo, String indicacao) {
        super(nome, Faixa, quantidadeEstoque, quantidadeUso, tipo, indicacao);
    }

    @Override
    public String preescricao(){
        return "Este medicamento deve ser administrado por injecao";
    };
    
    @Override
    public String toString() {
        return "Medicamento{" + "\nnome: " + nome + "\nFaixa: " + Faixa  + "\ntipo: " + tipo + "\nindicacao: " + indicacao + "\nMedicamento injetavel: " + this.preescricao() + '}';
    }
    
}
