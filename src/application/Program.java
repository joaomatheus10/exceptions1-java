package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) { // (! se n�o for) verifica se data checkout � depois de data checkin.
			System.out.println("Erro in reservation: Check-out date must be after check-in date.");
		} else {
			Reservation reservation= new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY: ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)){
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			} else {if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: check-out date must be after check-in date");
			} else {
			
			
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}
		

			}
		
		sc.close();
	}


}
}