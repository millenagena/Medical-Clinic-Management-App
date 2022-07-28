/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author lucas
 */
public class Agenda {
    private ArrayList <LocalDateTime> listaDatasDisponiveis = new ArrayList();
    private ArrayList <LocalDateTime> listaDatasIndisponiveis = new ArrayList();
    
    public Agenda(ArrayList <LocalDateTime> datasDisponiveis) {
        this.listaDatasDisponiveis = datasDisponiveis; //22-05-2023 - 16:30
    }
    
    public void adicionarDataDisponivel(LocalDateTime data){
        //tratar data quando chamar este metodo
        this.listaDatasDisponiveis.add(data);
        System.out.println("\nData adicionada");
    }
    
    public int realizarAgendamento(LocalDateTime dataDesejada){
        //tratar data desejada
        for(LocalDateTime data: this.listaDatasDisponiveis){
            if(data.equals(dataDesejada)){
                this.listaDatasIndisponiveis.add(data);
                this.listaDatasDisponiveis.remove(data);
                System.out.println("\n Data agendada com sucesso para o dia: "+ dataDesejada);
                return 1; //sucesso
            }
        }
        System.out.println("\n Data desjada nao existe ou nao esta disponivel");
        return 0; //falha 
    }

    public ArrayList<LocalDateTime> getListaDatasDisponiveis() {
        return listaDatasDisponiveis;
    }

    public ArrayList<LocalDateTime> getListaDatasIndisponiveis() {
        return listaDatasIndisponiveis;
    }
    
    @Override
    public String toString() {
        return "Agenda{" + "listaDatasDisponiveis=" + listaDatasDisponiveis + ", listaDatasIndisponiveis=" + listaDatasIndisponiveis + '}';
    }    
}
