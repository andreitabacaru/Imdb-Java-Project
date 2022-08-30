package db.utils.actor.web;

import db.utils.actor.Actor;
import java.util.Date;
import db.utils.actor.ActorDbHelper;
import java.text.SimpleDateFormat;

public class InsertActorWeb {
	
	public InsertActorWeb(String nume, String prenume, String dataNasteriiString, String sex) {
		
		ActorDbHelper adh = new ActorDbHelper();
		Date actorDataNasterii = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			actorDataNasterii = sdf.parse(dataNasteriiString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Actor adrian = new Actor(1, nume, prenume, actorDataNasterii, sex);
		
		try {
			adh.insertActor(adrian);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
