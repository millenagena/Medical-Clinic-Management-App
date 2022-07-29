/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clinicamedica;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class ClinicaMedica {
    public static Clinica clinica1 = new Clinica();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        LocalDateTime diaMesAnoHoraMin = LocalDateTime.now();
//        System.out.println(diaMesAnoHoraMin);
//        
//        LocalDateTime teste1 = LocalDateTime.of(2023, 04, 22, 16, 30);
//        LocalDateTime teste2 = LocalDateTime.of(2023, 04, 22, 17, 30);
//        System.out.println(teste1.toLocalDate() + " : " + teste1.toLocalTime());
//        //String.format("foo %s:%s", param1, param2)
//        System.out.println(teste1.isAfter(diaMesAnoHoraMin));        
        
//        ArrayList<ConsultasAgendadas> listaConsultas = med1.getListaConsultasAgendadas();
//        for(ConsultasAgendadas a: listaConsultas){
//            System.out.println(a.toString());
//        }
//                
//        ArrayList<RegistroConsulta> listaRegistros = med1.getListaRegistroConsultas();
//        for(RegistroConsulta b: listaRegistros){
//            System.out.println(b.toString());
//        }
        
        Scanner sc = new Scanner(System.in);
        int op = -1;

        Medicamento testemedica = new Medicamento("nome", "faixa", 4, 0, "tipo", "indicacao");
        clinica1.cadastraMedicamento(testemedica);
        
        while(op != 30){
            System.out.println("=== CLINICA MEDICA ===");
            //System.out.println("1 - Cadastrar Clinica");
            System.out.println("2 - CLINICA - Cadastrar Medico");
            System.out.println("3 - CLINICA - Cadastrar Paciente");
            System.out.println("4 - MEDICO - Adicionar convenio");
            System.out.println("5 - PACIENTE - Agendar consulta");
            System.out.println("6 - MEDICO - Registrar Consulta Realizada");
            System.out.println("7 - CLINICA - Historico de utilizacao dos medicamentos");
            System.out.println("8 - CLINICA - Listar medicos");
            System.out.println("9 - CLINICA - Listar pacientes");
            System.out.println("10 - CLINICA e/ou MEDICO - Ver consultas agendadas por medico");
            System.out.println("11 - CLINICA e/ou MEDICO - Ver consultas registradas por medico / relatorio do medico");
            System.out.println("12 - CLINICA - Cadastrar medicamento");
            System.out.println("13 - MEDICO - Adicionar data disponivel na agenda");
            System.out.println("14 - MEDICO - Ver datas disponiveis");
            System.out.println("15 - CLINICA - Listar medicamentos");
            System.out.println("16 - PACIENTE - Atualizar historico de doencas");
            System.out.println("17 - PACIENTE - Ver historico de consultas / relatorio paciente");
            System.out.println("18 - CLINICA - Ver historico de consultas de todos os medicos / relatorio clinica");
            System.out.println("19 - CLINICA - Ver todas consultas agendadas / relatorio clinica");
            System.out.println("30 - sair");
            
            op = sc.nextInt();
            sc.nextLine();
            
            
            String especialidade;
            String nome;
            String nomeDoenca;
            String cpf;
            String idade;
            String rg; 
            
            String telefone;
            String email;
            Agenda agenda;
            Medico medico;
            
            Paciente paciente;
            
            String dia;
            String mes;
            String ano;
            String hora;
            String minuto;
            String tipo;
            String grau;
            String qtd_vezes;
            LocalDateTime dataInicio;
            LocalDateTime dataFim;
            int cont = 0;
            ArrayList<Medico> listaTodosMedicos;
            
            
            switch (op){
                case 1:
                    clinica1.setNome("Clinica 1");
                    System.out.println(clinica1.toString());
                    break;
                case 2:
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    System.out.println("cpf: ");
                    cpf = sc.nextLine();
                    System.out.println("rg: ");
                    rg = sc.nextLine();
                    System.out.println("especialidade: ");
                    especialidade = sc.nextLine();
                    System.out.println("idade: ");
                    idade = sc.nextLine();
                    System.out.println("telefone: ");
                    telefone = sc.nextLine();
                    System.out.println("email: ");
                    email = sc.nextLine();
                    System.out.println("Quantas datas deseja cadastrar como disponiveis para iniciar os atendimentos? ");
                    String contadorText = sc.nextLine();
                    cont = Integer.parseInt(contadorText);
                    ArrayList <LocalDateTime> datasDisponiveis = new ArrayList();
                    LocalDateTime d;
                    
                    for(int i=0;i<cont;i++){
                        System.out.println("data"+ i +": ");
                        System.out.println("dia: ");
                        dia = sc.nextLine();
                        System.out.println("mes: ");
                        mes = sc.nextLine();
                        System.out.println("ano: ");
                        ano = sc.nextLine();
                        System.out.println("hora: ");
                        hora = sc.nextLine();
                        System.out.println("minuto: ");
                        minuto = sc.nextLine();
                        d = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                        datasDisponiveis.add(d);
                    }
                    
                    agenda = new Agenda(datasDisponiveis);
                    
                    medico = new Medico(especialidade, nome, cpf, Integer.parseInt(idade), rg, telefone, email, agenda);
                    System.out.println(medico.toString());
                    clinica1.cadastrarMedico(medico);
                    
                    break;
                case 3:
                    System.out.println("Nome do paciente: ");
                    nome = sc.nextLine();
                    System.out.println("cpf: ");
                    cpf = sc.nextLine();
                    System.out.println("rg: ");
                    rg = sc.nextLine();
                    System.out.println("idade: ");
                    idade = sc.nextLine();
                    System.out.println("telefone: ");
                    telefone = sc.nextLine();
                    System.out.println("email: ");
                    email = sc.nextLine();
                    
                    
                    
                    System.out.println("Doencas que ja teve");
                    System.out.println("Quantas deseja cadastrar: ");
                    String contadorString = sc.nextLine();
                    
                    cont = Integer.parseInt(contadorString);
                    ArrayList <Doenca> doencas = new ArrayList();
                    Doenca d1;
                    for(int i = 0;i<cont;i++){
                        System.out.println("nome: ");
                        nomeDoenca = sc.nextLine();
                        System.out.println("tipo: ");
                        tipo = sc.nextLine();
                        System.out.println("grau: ");
                        grau = sc.nextLine();
                        System.out.println("quantas vezes: ");
                        qtd_vezes = sc.nextLine();


                        d1 = new Doenca(nomeDoenca, tipo, grau, Integer.parseInt(qtd_vezes));
                        doencas.add(d1);
                    }
               
                    paciente = new Paciente(doencas, nome, cpf, Integer.parseInt(idade), rg, telefone,  email);
                    System.out.println(paciente.toString());
                    clinica1.cadastrarPaciente(paciente);
                    break;
                case 4:
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica1.buscaMedicoPeloNome(nome);
                    
                    System.out.println("Nome do convenio: ");
                    nome = sc.nextLine();
                    
                    medico.addConvenio(nome);
                    System.out.println(medico.toString());

                    break;
                case 5:
                    System.out.println("Nome do paciente: ");
                    nome = sc.nextLine();
                    paciente = clinica1.buscaPacientePeloNome(nome);
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica1.buscaMedicoPeloNome(nome);
                    
                    System.out.println("\nDatas disponiveis: \n");
                    medico.getAgenda().mostrarDatasDisponiveis();
                    
                    LocalDateTime dataDesejada;
                    
                    System.out.println("data desejada: ");
                    System.out.println("dia: ");
                    dia = sc.nextLine();
                    System.out.println("mes: ");
                    mes = sc.nextLine();
                    System.out.println("ano: ");
                    ano = sc.nextLine();
                    System.out.println("hora: ");
                    hora = sc.nextLine();
                    System.out.println("minuto: ");
                    minuto = sc.nextLine();
                    dataDesejada = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    
                    clinica1.agendarConsulta(medico, paciente, dataDesejada);
                    break;
                case 6:
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica1.buscaMedicoPeloNome(nome);
                    System.out.println("Nome do paciente: ");
                    nome = sc.nextLine();
                    paciente = clinica1.buscaPacientePeloNome(nome);
                    
                    System.out.println("Batimentos por minuto: ");
                    String bpm = sc.nextLine();
                    System.out.println("pressao: ");
                    String pressao = sc.nextLine();
                    System.out.println("temperatura: ");
                    String temperatura = sc.nextLine();
                    System.out.println("Diagnostico e observacoes: ");
                    String diagnostico = sc.nextLine();
                    
                    System.out.println("Medicamentos disponiveis: ");
                    clinica1.mostrarListaMedicamentos();
                    System.out.println("\nNome do medicamento: ");
                    nome = sc.nextLine();
                    Medicamento medica1 = clinica1.buscaMedicamentoPeloNome(nome);
                    ArrayList<Medicamento> listaMedicamentosPreescritos = new ArrayList();
                    listaMedicamentosPreescritos.add(medica1);
                    
                    System.out.println("data realizada: ");
                    System.out.println("dia: ");
                    dia = sc.nextLine();
                    System.out.println("mes: ");
                    mes = sc.nextLine();
                    System.out.println("ano: ");
                    ano = sc.nextLine();
                    System.out.println("hora: ");
                    hora = sc.nextLine();
                    System.out.println("minuto: ");
                    minuto = sc.nextLine();
                    LocalDateTime dataRealizada = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    
                    medico.registrarConsultaRealizada(paciente, dataRealizada, bpm, pressao, temperatura, diagnostico, listaMedicamentosPreescritos);
                    break;
                    
                case 7:
                    clinica1.getUtilizacaoMedicamentos();
                    break;
                
                case 8:
                    for(Medico m: clinica1.getListaMedicos()){
                        System.out.println(m.toString());
                    }
                    break;
                    
                case 9:
                    for(Paciente p: clinica1.getListaPacientes()){
                        System.out.println(p.toString());
                    }
                    break;
                    
                case 10:
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica1.buscaMedicoPeloNome(nome);
                    
                    for(ConsultasAgendadas p: medico.getListaConsultasAgendadas()){
                        System.out.println(p.toString());
                    }
                    break;
                    
                case 11:
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica1.buscaMedicoPeloNome(nome);
                    medico.mostrarDataConsultasRealizadas();
                    System.out.println("Informe uma data de inicio: ");
                    System.out.println("dia: ");
                    dia = sc.nextLine();
                    System.out.println("mes: ");
                    mes = sc.nextLine();
                    System.out.println("ano: ");
                    ano = sc.nextLine();
                    System.out.println("hora: ");
                    hora = sc.nextLine();
                    System.out.println("minuto: ");
                    minuto = sc.nextLine();
                    dataInicio = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    System.out.println("Informe uma data de data fim: ");
                    System.out.println("dia: ");
                    dia = sc.nextLine();
                    System.out.println("mes: ");
                    mes = sc.nextLine();
                    System.out.println("ano: ");
                    ano = sc.nextLine();
                    System.out.println("hora: ");
                    hora = sc.nextLine();
                    System.out.println("minuto: ");
                    minuto = sc.nextLine();
                    dataFim = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    for(RegistroConsulta p: medico.getFaixaRegistros(dataInicio, dataFim)){
                        p.mostrarRegistroRealizadoParaMedico();
                    }
                    break;
                    
                case 12:
                    System.out.println("Nome do medicamento: ");
                    nome = sc.nextLine();
                    System.out.println("Faixa do medicamento: ");
                    String faixa = sc.nextLine();
                    System.out.println("Quantidade: ");
                    String qtd = sc.nextLine();
                    System.out.println("Tipo: ");
                    tipo = sc.nextLine();
                    System.out.println("Indicacao: ");
                    String indicacao = sc.nextLine();
                    
                    Medicamento medic1 = new Medicamento(nome, faixa, Integer.parseInt(qtd), 0, tipo, indicacao);
                    clinica1.cadastraMedicamento(medic1);
                    break;
                case 13:
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica1.buscaMedicoPeloNome(nome);
                    System.out.println("data: ");
                    System.out.println("dia: ");
                    dia = sc.nextLine();
                    System.out.println("mes: ");
                    mes = sc.nextLine();
                    System.out.println("ano: ");
                    ano = sc.nextLine();
                    System.out.println("hora: ");
                    hora = sc.nextLine();
                    System.out.println("minuto: ");
                    minuto = sc.nextLine();
                    LocalDateTime dataAdd = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    medico.getAgenda().adicionarDataDisponivel(dataAdd);
                    break;
                case 14:
                    System.out.println("Nome do medico: ");
                    nome = sc.nextLine();
                    medico = clinica1.buscaMedicoPeloNome(nome);
                    medico.getAgenda().mostrarDatasDisponiveis();
                    break;
                    
                case 15:
                    clinica1.mostrarListaMedicamentos();
                    break;
                    
                case 16:
                    System.out.println("Nome do paciente: ");
                    nome = sc.nextLine();
                    paciente = clinica1.buscaPacientePeloNome(nome);
                    
                    System.out.println("nome: ");
                    nomeDoenca = sc.nextLine();
                    System.out.println("tipo: ");
                    tipo = sc.nextLine();
                    System.out.println("grau: ");
                    grau = sc.nextLine();
                    System.out.println("quantas vezes: ");
                    qtd_vezes = sc.nextLine();
                    Doenca doencaPaciente;
                    doencaPaciente = new Doenca(nomeDoenca, tipo, grau, Integer.parseInt(qtd_vezes));
                    
                    boolean doencaJaExiste = paciente.incrementaDoenca(doencaPaciente);
                    if(doencaJaExiste == false){
                        paciente.adicionaDoenca(doencaPaciente);
                    }
                    break;
                    
                case 17:
                    System.out.println("Nome do paciente: ");
                    nome = sc.nextLine();
                    paciente = clinica1.buscaPacientePeloNome(nome);
                    System.out.println("Informe uma data de inicio: ");
                    System.out.println("dia: ");
                    dia = sc.nextLine();
                    System.out.println("mes: ");
                    mes = sc.nextLine();
                    System.out.println("ano: ");
                    ano = sc.nextLine();
                    System.out.println("hora: ");
                    hora = sc.nextLine();
                    System.out.println("minuto: ");
                    minuto = sc.nextLine();
                    dataInicio = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    System.out.println("Informe uma data de data fim: ");
                    System.out.println("dia: ");
                    dia = sc.nextLine();
                    System.out.println("mes: ");
                    mes = sc.nextLine();
                    System.out.println("ano: ");
                    ano = sc.nextLine();
                    System.out.println("hora: ");
                    hora = sc.nextLine();
                    System.out.println("minuto: ");
                    minuto = sc.nextLine();
                    dataFim = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
                    
                    ArrayList<RegistroConsulta> listaRegistrosPaciente;
                    listaRegistrosPaciente = clinica1.getRelatorioPaciente(paciente, dataInicio, dataFim);
                    for(RegistroConsulta registro: listaRegistrosPaciente){
                        System.out.println(registro.toString());
                    }
                    break;
                    
                case 18:
                    
                    listaTodosMedicos = clinica1.getListaMedicos();
                    for(Medico med: listaTodosMedicos){
                        ArrayList<RegistroConsulta> listaConsultasPorMedico = med.getListaRegistroConsultas();
                        for(RegistroConsulta registro: listaConsultasPorMedico){
                            registro.mostrarRegistroRealizadoParaClinia();
                        }
                    }
                    break;
                    
                case 19:
                    listaTodosMedicos = clinica1.getListaMedicos();
                    for(Medico med: listaTodosMedicos){
                        ArrayList<ConsultasAgendadas> listaConsultasPorMedico = med.getListaConsultasAgendadas();
                        for(ConsultasAgendadas consulta: listaConsultasPorMedico){
                            System.out.println(consulta.toString());
                        }
                    }
                    break;
            }
            
        }
        
    }
    
}
