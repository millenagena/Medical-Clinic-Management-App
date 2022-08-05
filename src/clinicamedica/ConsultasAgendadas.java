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
    private Medico med;
    private Paciente pac;
    private LocalDateTime data;

    public ConsultasAgendadas(Medico med, Paciente pac, LocalDateTime data) {
        this.med = med;
        this.pac = pac;
        this.data = data;
    }

    public Medico getMed() {
        return med;
    }

    public void setMed(Medico med) {
        this.med = med;
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
        return "\nConsultasAgendadas{" + "med=" + med.getNome() + ", pac=" + pac.getNome() + ", data=" + data.toLocalDate() + " : " + data.toLocalTime() + '}';
    }
    
}
