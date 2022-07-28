/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

public class Medicamento {
    public String nome;
    public String Faixa;
    public int quantidade;
    public String tipo;
    public String indicacao;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }
    /*
    - Seria interessante armazenar a informação sobre para quais doenças esse medicamento é
indicado, ajudaria na receita pelo médico durante a consulta.
    */
    public void getIndicacao(){
            System.out.println("Analgesico, Anti-Inflamatorio, Anti-Alérgico ou Anti-Biótico.");
            if ("Analgesico".equals(this.getTipo())){
                this.setIndicacao("Dores");
            }
            else if ("Anti-Inflamatorio".equals(this.getTipo())){
                this.setIndicacao("Inflamações");
            }
            else if ("Anti-Alergico".equals(this.getTipo())){
                this.setIndicacao("Alergias");
            }
            else if ("Anti-Bioticos".equals(this.getTipo())){
                this.setIndicacao("Doencas bacterianas");
            }
            else
                System.out.println("Tipo de medicamento NAO cadastrado.");
    }   
    
    /*
    public void getHistoricoUtilizacao(){
        System.out.println("Medicamentos utilizados: ");
        /*if(registraConsulta.getMedicamentos() !! NULL)
            
        //getMedicamentos();
    }
    */

    @Override
    public String toString() {
        return "Medicamento{" + "nome=" + nome + ", Faixa=" + Faixa + ", quantidade=" + quantidade + ", tipo=" + tipo + ", indicacao=" + indicacao + '}';
    }
}
