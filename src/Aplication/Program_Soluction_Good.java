package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program_Soluction_Good {
//Comando muito ruim, porque delega a logica de validação toda no programa principal
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			//Comando que irão ler os dados digitados pelo usuario
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date ckeckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date ckeckOut = sdf.parse(sc.next());
			
			//Instanciando os dados para a classe Reservation e imprimindo na tela
			Reservation res = new Reservation(number, ckeckIn, ckeckOut);
			System.out.println("Reservation: " + res);
			
			System.out.println("-----------");
			System.out.print("Deseja alterar, as datas de checkIn e CheckOut? (y/n): ");
			char ch = sc.next().charAt(0);
			System.out.println();
			if(ch == 'y') {
			System.out.println("Enter data to update th reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			ckeckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			ckeckOut = sdf.parse(sc.next());
			//Comando para verificar se as datas são inferiores ao dia de "hoje"...
			//Se forem, o sistema nao irá aceitar e mostrar uma mensagem de erro
		
			//Comando criado para atualizar as datas
			res.updateDates(ckeckIn, ckeckOut);
			System.out.println("Reservation update: " + res + ". Boa viagem!!!");
			}
			else {
				System.out.println("Não houve alteração das datas. Boa Viagem!");
				 }
		}catch(ParseException e){
			System.out.println("Invalid date format ");
		}catch(DomainException c) {
			System.out.println("Error in reservation: " + c.getMessage());
		}catch (RuntimeException d) {
			//para não permitir que o sistema quebre
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}
}
