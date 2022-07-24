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
public class RegistroConsulta {
    private String nomePaciente;
    private String nomeMedico;
    private String especialidadeMedico;
    private String dataConsulta;
    private String bpm;
    private String pressao;
    private String temperatura;
    private ArrayList <Medicamento> medicamentosIndicados = new ArrayList();
    private String observacao;

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public String getBpm() {
        return bpm;
    }

    public String getPressao() {
        return pressao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public ArrayList<Medicamento> getMedicamentosIndicados() {
        return medicamentosIndicados;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setMedicamentosIndicados(ArrayList<Medicamento> medicamentosIndicados) {
        this.medicamentosIndicados = medicamentosIndicados;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
}
