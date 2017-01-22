package kermis;

public class Voedselkraam implements Chargeable{
	private String naam;
	private String ervaring;
	private double prijs;
	private int aantalVerkocht;

	//Rekenen van de omzet per kermisonderdeel
	public double getOmzet(int kermisNr){
		double omzet = Kassa.kermisArray[kermisNr].getPrijs() * Kassa.kermisArray[kermisNr].getAantalVerkocht();
		return omzet;
	}
	
	//Naam getter en setter
	public String getNaam(){
		return naam;
	}
	public void setNaam(String naam){
		this.naam = naam;
	}
	
	//Ervaring getter en setter
	public String getErvaring() {
		return ervaring;
	}
	public void setErvaring(String ervaring) {
		this.ervaring = ervaring;
	}
	
	//Prijs getter en setter
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	//aantalVerkocht getter en setter
	public int getAantalVerkocht(){
		return aantalVerkocht;
	}
	public void setAantalVerkocht(){
		aantalVerkocht++;
	}
}//einde class
