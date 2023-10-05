package zenite;

import java.util.Scanner;

public class zenite {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		
		String[] diasDaSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sabado", "Domingo"};
		String[][] agenda = new String[7][3];
		
		System.out.println("Bem-vindo a Zênite Odontologia!");
		
		int opcao;
		
		do {
			System.out.println("\nMenu");
			System.out.println("1. Agendar consulta");
			System.out.println("2. Ver agenda");
			System.out.println("3. Sair");
			System.out.println("Escolha uma opção: ");
			opcao = scanner.nextInt();
			
			switch (opcao) {
			  case 1:
				  System.out.println("Dias disponiveis para consulta:");
				  for (int i = 0; i < diasDaSemana.length; i++) {
					  System.out.println((i + 1) + ". " + diasDaSemana[i]);
				  }
				  System.out.println("Escolha o dia (1 a 7): ");
				  int diaConsulta = scanner.nextInt();
				  scanner.nextLine();
				  if (diaConsulta < 1 || diaConsulta > 7) {
					  System.out.println("Dia invalido. Tente novamente.");
					  continue;
				  }
				  int diaIndex = diaConsulta - 1;
				  if (agenda[diaIndex][2] != null) {
					  System.out.println("Não há horários disponiveis para este dia.");
					  continue;
				  }
				  
				  System.out.println("Digite o horário da consulta(por exemplo, 09:00)");
				  String horarioConsulta = scanner.nextLine();
				  
				  boolean horarioDisponivel = true;
				  for (int i = 0; i < 3; i++) {
					  if (agenda[diaIndex][i] != null && agenda[diaIndex][i].startsWith(horarioConsulta)) {
						  horarioDisponivel = false;
						  System.out.println("Horário já agendado. Escolha outro horário. ");
						  break;
					  }
				  }
				  
				  if (!horarioDisponivel) {
					  continue;
				  }
				  
				  for (int i = 0; i < 3; i++) {
					  if(agenda[diaIndex][i] == null) {
						 agenda[diaIndex][i] = horarioConsulta;
						 System.out.println("Digite o nome do paciente:");
						 String nomePaciente = scanner.nextLine();
						 agenda[diaIndex][i] += " - " + nomePaciente;
						 System.out.println("Consulta agendada com sucesso!");
						 break;
					  }
				  }
				  break;
				 
				  
			  case 2:
				  System.out.println("\nAgenda de Consultas:");
				  for (int i = 0; i < diasDaSemana.length; i++) {
					  System.out.println(diasDaSemana[i] + ":");
					  for (int j = 0; j < 3 ; j++) {
						  String consulta = agenda[i][j];
						  if (consulta != null) {
							  System.out.println("- " + consulta);
						  }
					  }
				  }
				  break;
				  
			  case 3 :
				  System.out.println("Obrigado por usar nosso sistema. Até logo!");
				  break;
				  
			default:
				System.out.println("Opção inválida. Por favor, escolha novamente.");
			}
		} while (opcao != 3);
		
		scanner.close();
	}

}
