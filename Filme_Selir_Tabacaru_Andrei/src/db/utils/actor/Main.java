package db.utils.actor;

public class Main {
	
	public static void main(String[] args) {
	
		ActorDbHelper adh = new ActorDbHelper();

		try {
			System.out.println(adh.selectActors());
		} catch (ImdbExceptions e) {
			e.printStackTrace();
		}
		
	}

}
