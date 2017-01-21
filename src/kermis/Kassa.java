package kermis;

import java.util.Scanner;

public class Kassa {
	//Array voor alle onderdelen van de kermis via Chargeable interface
	static final Chargeable kermisArray[] = new Chargeable[10];
	static final int aantalAttracties = 6;
	static final int aantalKramen = 2;
	//Scanner voor invoer en keuzevariabele 
	static Scanner invoer = new Scanner(System.in);
	private String keuze;
	
	//invullen van Array en naar kassa gaan om een keuze te maken
	void gaNaarKassa(){		
		kermisArray[0] = (Botsauto) new Botsauto(); 
		kermisArray[1] = (Hawaii) new Hawaii();
		kermisArray[2] = (Spin) new Spin();
		kermisArray[3] = (Spiegelpaleis) new Spiegelpaleis();
		kermisArray[4] = (Spookhuis) new Spookhuis();
		kermisArray[5] = (Ladderklimmen) new Ladderklimmen();
		kermisArray[6] = (Oliebollenkraam) new Oliebollenkraam();
		kermisArray[7] = (Frietkraam) new Frietkraam();
		kermisArray[8] = (Mueslikraam) new Mueslikraam();
		kermisArray[9] = (Shoarmatent) new Shoarmatent();

		System.out.println("Welkom op de Kermis. Wat wil je doen?\n");
		do {
			printOpties();
			kiezen();
		} while(!keuze.equals("x"));
		System.out.println("Bedankt voor je bezoek. Tot ziens!");
	}

	//Weergave van de opties waaruit gekozen kan worden wanneer de kermis wordt bezocht
	void printOpties(){
		System.out.println("------------------------");
		System.out.println("Attracties");
		System.out.println("------------------------");
		for (int i = 0; i < aantalAttracties; i++) {
			System.out.println((i+1) + "  = " + Kassa.kermisArray[i].getNaam());
		}
		System.out.println("------------------------");
		System.out.println("Voedselkraampjes");
		System.out.println("------------------------");
		
		for (int i = aantalAttracties; i < kermisArray.length; i++) {
			System.out.println((i-aantalAttracties+1)+""+(i-aantalAttracties+1) + "  = " + Kassa.kermisArray[i].getNaam());
		}		
		System.out.println("------------------------");
		System.out.println("p  = prijslijst");
		System.out.println("v  = aantal verkopen");
		System.out.println("o  = omzet");
		System.out.println("x  = park verlaten");
		System.out.println();
	}
	
	//maken van een keuze voor het gebruik van een kermisonderdeel
	void kiezen(){
		keuze = invoer.nextLine().toLowerCase();
		switch(keuze){
		case "1":
			Kassa.kermisArray[0].gaNaarOnderdeel(0);
			break;
		case "2":
			Kassa.kermisArray[1].gaNaarOnderdeel(1);
			break;
		case "3":
			Kassa.kermisArray[2].gaNaarOnderdeel(2);
			break;
		case "4":
			Kassa.kermisArray[3].gaNaarOnderdeel(3);
			break;
		case "5":
			Kassa.kermisArray[4].gaNaarOnderdeel(4);
			break;
		case "6":
			Kassa.kermisArray[5].gaNaarOnderdeel(5);
			break;
		case "11":
			Kassa.kermisArray[6].gaNaarOnderdeel(6);
			break;
		case "22":
			Kassa.kermisArray[7].gaNaarOnderdeel(7);
			break;
		case "33":
			Kassa.kermisArray[8].gaNaarOnderdeel(8);
			break;
		case "44":
			Kassa.kermisArray[9].gaNaarOnderdeel(9);
			break;
		case "v":
			getAantalVerkopen();
			break;
		case "o":
			getTotaalOmzet();
			break;
		case "p":
			getPrijsLijst();
			break;
		case "x":
			break;
		default:
			System.out.println("Oeps! Deze keuze bestaat niet\nProbeer nog eens\n");
			break;
		}
	}
	
	//Weergeven van de actuele tarieven
	void getPrijsLijst(){
		double totaalOmzet = 0;
		System.out.println("-------------------------");
		System.out.println("Attracties");
		System.out.println("-------------------------");
		for (int i = 0; i < aantalAttracties; i++) {
			System.out.print(Kassa.kermisArray[i].getNaam() + "= ");
			System.out.printf("%.2f",Kassa.kermisArray[i].getPrijs());
			System.out.println();
		}
		System.out.println("-------------------------");
		System.out.println("Voedselkraampjes");
		System.out.println("-------------------------");
		for (int i = aantalAttracties; i < kermisArray.length; i++) {
			System.out.print(Kassa.kermisArray[i].getNaam() + "= ");
			System.out.printf("%.2f",Kassa.kermisArray[i].getPrijs());
			System.out.println();
		}
		System.out.println();
		System.out.println("Druk op een toets om verder te gaan...");
		invoer.nextLine();	
	}
	
	//Berekenen en weergeven van afzet van de verschillende kermisonderdelen, maar ook van het totaal
	void getAantalVerkopen(){
		int totaalVerkocht = 0;
		System.out.println("------------------------");
		System.out.println("Attracties");
		System.out.println("------------------------");
		for (int i = 0; i < aantalAttracties ; i++) {
			System.out.println(	Kassa.kermisArray[i].getNaam() +
					"= " +
					Kassa.kermisArray[i].getAantalVerkocht());
			totaalVerkocht += Kassa.kermisArray[i].getAantalVerkocht();
		}
		System.out.println("------------------------");
		System.out.println("Voedselkraampjes");
		System.out.println("------------------------");

		for (int i = aantalAttracties; i < kermisArray.length; i++) {
			System.out.println(	Kassa.kermisArray[i].getNaam() +
					"= " +
					Kassa.kermisArray[i].getAantalVerkocht());
			totaalVerkocht += Kassa.kermisArray[i].getAantalVerkocht();
		}
		System.out.println("------------------------");
		System.out.println("Totaal verkocht  = " + totaalVerkocht + "\n");
		System.out.println("Druk op een toets om verder te gaan...");
		invoer.nextLine();
	}
	
	//Berekenen en weergeven van omzet van de verschillende kermisonderdelen, maar ook van het totaal
	void getTotaalOmzet(){
		double totaalOmzet = 0;
		System.out.println("-------------------------");
		System.out.println("Attracties");
		System.out.println("-------------------------");
		for (int i = 0; i < aantalAttracties; i++) {
			System.out.print(Kassa.kermisArray[i].getNaam() + "= ");
			System.out.printf("%.2f",Kassa.kermisArray[i].getPrijs() * Kassa.kermisArray[i].getAantalVerkocht());
			System.out.println();
			totaalOmzet += Kassa.kermisArray[i].getOmzet(i);
		}
		System.out.println("-------------------------");
		System.out.println("Voedselkraampjes");
		System.out.println("-------------------------");
		for (int i = aantalAttracties; i < kermisArray.length; i++) {
			System.out.print(Kassa.kermisArray[i].getNaam() + "= ");
			System.out.printf("%.2f",Kassa.kermisArray[i].getPrijs() * Kassa.kermisArray[i].getAantalVerkocht());
			System.out.println();
			totaalOmzet += Kassa.kermisArray[i].getOmzet(i);
		}
		System.out.println("-------------------------");
		System.out.print("Totaal verkocht  = ");		
		System.out.printf("%.2f",totaalOmzet);
		System.out.println();
		System.out.println("Druk op een toets om verder te gaan...");
		invoer.nextLine();	
	}
	
}//einde class
	
