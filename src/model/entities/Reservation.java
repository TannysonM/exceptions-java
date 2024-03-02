package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	// Comando para alterar o formato do DATE
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// Variaveis
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public long duration() {
		// Transformando variavel para ler milissegundos
		long diff = checkout.getTime() - checkin.getTime();
		// Converter variavel para de milissegundos para "dia"
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	// Sobreposição particular
	@Override
	public String toString() {
		return "Room: " + roomNumber 
				+ ", check-in: " + sdf.format(checkin) 
				+ ", check-out: " + sdf.format(checkout)
				+ ", " + duration() + " nights";
	}

}