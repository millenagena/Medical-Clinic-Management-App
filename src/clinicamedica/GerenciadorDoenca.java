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
public class GerenciadorDoenca {
    private ArrayList<Doenca> historicoDoencas;

    public ArrayList<Doenca> getHistoricoDoencas() {
        return historicoDoencas;
    }

    public void setHistoricoDoencas(ArrayList<Doenca> historicoDoencas) {
        this.historicoDoencas = historicoDoencas;
    }
    
    public void adicionaDoenca(Doenca a){
        this.historicoDoencas.add(a);
    }
    
    public void incrementaDoenca(Doenca a){
        for(Doenca doenca: this.historicoDoencas){
            if(a.getNomeDoenca().equals(doenca.getNomeDoenca())){
                doenca.incrementaOcorrencia();
            }
        }
    }
    
    public boolean doencaExiste(String a){
        for(Doenca doenca: this.historicoDoencas){
            if(a.equals(doenca.getNomeDoenca())){
                return true;
            }
        }
        return false;
    }
    
    public Doenca buscaDoencaPeloNome(String a){
        for(Doenca doenca: this.historicoDoencas){
            if(a.equals(doenca.getNomeDoenca())){
                return doenca;
            }
        }
        return null;
    }
}
