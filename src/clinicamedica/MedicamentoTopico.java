/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

/**
 *
 * @author lucas
 */
public class MedicamentoTopico extends Medicamento {

    public MedicamentoTopico(String nome, String Faixa, int quantidadeEstoque, int quantidadeUso, String tipo, String indicacao) {
        super(nome, Faixa, quantidadeEstoque, quantidadeUso, tipo, indicacao);
    }

    @Override
    public String preescricao(){
        return "Este medicamento deve ser aplicado diretamente num determinado local do corpo";
    };
    
    @Override
    public String toString() {
        return "Medicamento{" + "\nnome: " + nome + "\nFaixa: " + Faixa  + "\ntipo: " + tipo + "\nindicacao: " + indicacao + "\nMedicamento topico: " + this.preescricao() + '}';
    }
    
}
