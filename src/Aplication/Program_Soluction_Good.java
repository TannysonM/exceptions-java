package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program_Soluction_Good {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Comando que irão ler os dados digitados pelo usuario
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date ckeckIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date ckeckOut = sdf.parse(sc.next());
		
		//Comando para testar uma data posterior a outra
		if (!ckeckOut.after(ckeckIn)) {
			System.out.println("Error in reservation: " + "Check-out date must be after ckeck-in date.");
		}
		else {
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
			Date now = new Date();
			if (ckeckIn.before(now) || ckeckOut.before(now)) {
				System.out.println("Error in Reservation: Reservation dates for update must be future dates");
			}
			else if (!ckeckOut.after(ckeckIn)) {
				System.out.println("Error in reservation: Check-out date must be after ckeck-in date.");
			}else { 
			//Comando criado para atualizar as datas
			res.updateDates(ckeckIn, ckeckOut);
			System.out.println("Reservation update: " + res + ". Boa viagem!!!");
			}}
			else {
				System.out.println("Não houve alteração das datas. Boa Viagem!");
		
		}
				
		}
		sc.close();
	}

}
