/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clinicamedica;

import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author lucas
 */
public class ClinicaMedica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LocalDateTime diaMesAnoHoraMin = LocalDateTime.now();
        System.out.println(diaMesAnoHoraMin);
        
        LocalDateTime teste = LocalDateTime.of(2023, 04, 22, 16, 30);
        System.out.println(teste.toLocalDate() + " : " + teste.toLocalTime());
        //String.format("foo %s:%s", param1, param2)
        System.out.println(teste.isAfter(diaMesAnoHoraMin));
        
    }
    
}
