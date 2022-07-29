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
public class Agenda {
    private ArrayList <LocalDateTime> listaDatasDisponiveis = new ArrayList();
    private ArrayList <LocalDateTime> listaDatasIndisponiveis = new ArrayList();
    
    public Agenda(ArrayList <LocalDateTime> datasDisponiveis) {
        this.listaDatasDisponiveis = datasDisponiveis;
    }
    
    public void adicionarDataDisponivel(LocalDateTime data){
        //tratar data quando chamar este metodo
        this.listaDatasDisponiveis.add(data);
        System.out.println("\nData adicionada");
    }
    
    public boolean marcarAgenda(LocalDateTime dataDesejada){
        //tratar data desejada
        for(LocalDateTime data: this.listaDatasDisponiveis){
            if(data.isEqual(dataDesejada)){
                this.listaDatasIndisponiveis.add(data);
                this.listaDatasDisponiveis.remove(data);
                System.out.println("\n Data agendada com sucesso para o dia: "+ dataDesejada);
                return true;
            }
        }
        return false; 
    }

    public ArrayList<LocalDateTime> getListaDatasDisponiveis() {
        return listaDatasDisponiveis;
    }
    
    public void mostrarDatasDisponiveis(){
        for(LocalDateTime data: this.listaDatasDisponiveis){
            System.out.println(data.toLocalDate() + " : " + data.toLocalTime());
        }
    }

    public ArrayList<LocalDateTime> getListaDatasIndisponiveis() {
        return listaDatasIndisponiveis;
    }
    
    @Override
    public String toString() {
        return "Agenda{" + "listaDatasDisponiveis=" + listaDatasDisponiveis + ", listaDatasIndisponiveis=" + listaDatasIndisponiveis + '}';
    }    
}
