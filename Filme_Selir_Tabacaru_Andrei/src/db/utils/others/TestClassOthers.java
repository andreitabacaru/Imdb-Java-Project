package db.utils.others;

public class TestClassOthers {

	public static void main(String[] args) {

		LoginWeb lw = new LoginWeb("andrei9980", "parola");

		
		if( lw.isCorrect() ) {
			System.out.println("Da");
		} else {
			System.out.println("Nu");
		}
	
		
		ProductionWeb pw = new ProductionWeb();
		
		System.out.println(pw.getProductionFromId(4));
		
	}

}
