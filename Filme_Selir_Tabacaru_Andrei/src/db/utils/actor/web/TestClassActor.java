package db.utils.actor.web;

public class TestClassActor {

	public static void main(String[] args) {
		
		SelectActorWeb saw = new SelectActorWeb("", "", "");
		System.out.println(saw.getSelectedActors());
	}

}
