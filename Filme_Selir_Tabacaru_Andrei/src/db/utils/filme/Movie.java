package db.utils.filme;

public class Movie {

	private int idProduction;
	private String title;
	private int runTime;
	private int releaseYear;
	private String productionName;
	
	public Movie( String movieTitle, int runTimeMins, int releaseYear, int idProduction ) {
		
		this.setIdProduction(idProduction);
		this.setTitle(movieTitle);
		this.setRunTime(runTimeMins);
		this.setReleaseYear(releaseYear);
		
	}

	public int getIdProduction() {
		return idProduction;
	}

	public void setIdProduction(int idProduction) {
		this.idProduction = idProduction;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String movieTitle) {
		this.title = movieTitle;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getProductionName() {
		return productionName;
	}

	public void setProductionName(String productionName) {
		this.productionName = productionName;
	}
	
	
	
}
