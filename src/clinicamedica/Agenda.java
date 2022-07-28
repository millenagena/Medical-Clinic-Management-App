/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author lucas
 */
public class Agenda {
    private ArrayList <String> listaDatasDisponiveis = new ArrayList();
    private ArrayList <String> listaDatasIndisponiveis = new ArrayList();
    private Calendar data;

    public Agenda(ArrayList <String> datasDisponiveis) {
        this.listaDatasDisponiveis = datasDisponiveis; //22-05-2023 - 16:30
    }
    
    public void adicionarDataDisponivel(String data){
        //tratar data quando chamar este metodo
        this.listaDatasDisponiveis.add(data);
        System.out.println("\nData adicionada");
    }
    
    public int realizarAgendamento(String dataDesejada){
        //tratar data desejada
        for(String data: this.listaDatasDisponiveis){
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

    public ArrayList<String> getListaDatasDisponiveis() {
        return listaDatasDisponiveis;
    }

    public ArrayList<String> getListaDatasIndisponiveis() {
        return listaDatasIndisponiveis;
    }
    
    @Override
    public String toString() {
        return "Agenda{" + "listaDatasDisponiveis=" + listaDatasDisponiveis + ", listaDatasIndisponiveis=" + listaDatasIndisponiveis + '}';
    }    
}
