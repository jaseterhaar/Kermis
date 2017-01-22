package kermis;

public interface Chargeable {
	
	double getOmzet(int onderdeelNr);
	
	String getNaam();
	void setNaam(String naam);
	
	String getErvaring();
	void setErvaring(String ervaring);
	
	double getPrijs();
	void setPrijs(double prijs);
	
	public int getAantalVerkocht();
	public void setAantalVerkocht();
	
}//einde interface
