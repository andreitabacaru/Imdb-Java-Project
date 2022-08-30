package db.utils.actor;
import java.util.Calendar;
import java.util.Date;

public class Actor implements Comparable<Actor>{
	
	int idActor;
	String nume;
	String prenume;
	Calendar dataNasterii = Calendar.getInstance();
	Date dataNasteriiDate = new Date(0);
	String sex;
	
	@SuppressWarnings("deprecation")
	public Actor( int id, String n, String p, Calendar c, String s ) {
		
		this.dataNasterii = c;
		this.idActor = id;
		this.nume = n;
		this.prenume = p;
		this.sex = s;
		
		dataNasteriiDate.setYear(dataNasterii.get(1) + 1900);
		dataNasteriiDate.setMonth(dataNasterii.get(2) + 1);
		dataNasteriiDate.setDate(dataNasterii.get(3));

		
	}
	
	@SuppressWarnings("deprecation")
	public Actor( int id, String n, String p, Date d, String s ) {
		
		this.dataNasteriiDate = new Date(d.getTime());
		this.dataNasteriiDate.setYear(d.getYear());
		this.dataNasteriiDate.setMonth(d.getMonth());
		this.idActor = id;
		this.nume = n;
		this.prenume = p;
		this.sex = s;
		
	}
	
	public String getNume() {
		return nume;
	}
	
	public int getIdActor() {
		return idActor;
	}
	
	public String getPrenume() {
		return prenume;
	}
	
	public Calendar getDataNasterii() {
		return dataNasterii;
	}
	
	public Date getDataNasteriiDate() {
		return dataNasteriiDate;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String toString() {
		return "Id: " + idActor + "\nNume: " + nume + "\nPrenume: " + prenume + "\nSex: " + sex + "\nData Nasterii: "
				+ dataNasteriiDate.getYear() + "/" + dataNasteriiDate.getMonth() + "/" + dataNasteriiDate.getDate() + "\n";
	}
	@Override
	public int compareTo(Actor a) {
		
		return this.nume.compareTo(a.nume); 
		
	}
	
}
