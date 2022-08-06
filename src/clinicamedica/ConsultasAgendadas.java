/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicamedica;

import java.time.LocalDateTime;

/**
 *
 * @author lucas
 */
public class ConsultasAgendadas {
    private Paciente pac;
    private LocalDateTime data;

    public ConsultasAgendadas(Paciente pac, LocalDateTime data) {
        this.pac = pac;
        this.data = data;
    }

    public Paciente getPac() {
        return pac;
    }

    public void setPac(Paciente pac) {
        this.pac = pac;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "\n Consultas Agendadas: \n" + "paciente: " + pac.getNome() + ", data: " + data.toLocalDate() + " : " + data.toLocalTime();
    }
    
}
