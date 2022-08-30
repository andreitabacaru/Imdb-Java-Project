package db.utils.actor.web;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import db.utils.actor.Actor;
import db.utils.actor.ActorDbHelper;
import db.utils.actor.ImdbExceptions;

public class UpdateActorWeb {
	
	int ok = 0;
	
	public UpdateActorWeb(String id, String nume, String prenume, String dataNasteriiString, String sex) {
		
		ActorDbHelper adh = new ActorDbHelper();
		List<Actor> actors = null;
		int actorId = -1;
		
		try {
			actors = adh.selectActors();
		} catch (ImdbExceptions e) {
			e.printStackTrace();
		}
		
		java.util.Date actorDataNasteriiDate = new Date(0);
		Date actorDataNasterii = new Date(0);
		
		if( dataNasteriiString != "" ) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
			try {
				actorDataNasteriiDate = sdf.parse(dataNasteriiString);
				actorDataNasterii = new Date(actorDataNasteriiDate.getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			actorId = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for( Actor a : actors ) 
			if( a.getIdActor() == actorId ) {
				
				if( nume.equals("") )
					nume = a.getNume();
				
				if( prenume.equals("") )
					prenume = a.getPrenume();
				
				if( sex.equals("") )
					sex = a.getSex();
				
				if( dataNasteriiString.equals("") ) {
					actorDataNasteriiDate = a.getDataNasteriiDate();
					actorDataNasterii = new Date(actorDataNasteriiDate.getTime());
				}
				
				adh.updateActor(actorId, nume, prenume, actorDataNasterii, sex);
				ok = 1;
				
				break;
			}
		
	}
	
	public String getStatusMessage() {
		
		if( ok == 0 )
			return "Invalid id.";
		else
			return "Successfully updated!";
		
	}
	
	public int getStatus() {
		
		return ok;
		
	}
	
}
