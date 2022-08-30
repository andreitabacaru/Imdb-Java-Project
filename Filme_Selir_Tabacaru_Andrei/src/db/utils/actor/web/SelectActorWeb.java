package db.utils.actor.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import db.utils.actor.Actor;
import db.utils.actor.ActorDbHelper;
import db.utils.actor.ImdbExceptions;

public class SelectActorWeb {
	
	private List<Actor> actors = new ArrayList<Actor>();
	private List<Actor> selectedActors = new ArrayList<Actor>();
	
	public SelectActorWeb(String nume, String prenume, String sex) {
		
		ActorDbHelper adh = new ActorDbHelper();
		
		try {
			 actors = adh.selectActors();
		} catch (ImdbExceptions e) {
			e.printStackTrace();
		}
		
		if( nume != "" && prenume != "" && sex != "" )
			for( Actor a : actors ) {
				if( a.getNume().toLowerCase().equals(nume.toLowerCase()) && a.getPrenume().toLowerCase().equals(prenume.toLowerCase()) && a.getSex().toLowerCase().equals(sex.toLowerCase()) )
					selectedActors.add(a);
			}
		else if( nume != "" && prenume != "" )
			for( Actor a : actors ) {
				if( a.getNume().toLowerCase().equals(nume.toLowerCase()) && a.getPrenume().toLowerCase().equals(prenume.toLowerCase()) )
					selectedActors.add(a);
			}
		else if( nume != "" && sex != "" )
			for( Actor a : actors ) {
				if( a.getNume().toLowerCase().equals(nume.toLowerCase()) && a.getSex().toLowerCase().equals(sex.toLowerCase()) )
					selectedActors.add(a);
			}
		else if( prenume != "" && sex != "" )
			for( Actor a : actors ) {
				if( a.getPrenume().toLowerCase().equals(prenume.toLowerCase()) && a.getSex().toLowerCase().equals(sex.toLowerCase()) )
					selectedActors.add(a);
			}
		else if( nume != "" )
			for( Actor a : actors ) {
				if( a.getNume().toLowerCase().equals(nume.toLowerCase()) )
					selectedActors.add(a);
			}
		else if( prenume != "" )
			for( Actor a : actors ) {
				if( a.getPrenume().toLowerCase().equals(prenume.toLowerCase()) )
					selectedActors.add(a);
			}
		else if( sex != "" )
			for( Actor a : actors ) {
				if( a.getSex().toLowerCase().equals(sex.toLowerCase()) )
					selectedActors.add(a);
			}
		else
			for( Actor a : actors )
				selectedActors.add(a);
		
		Collections.sort(selectedActors);
	}
	
	public List<Actor> getSelectedActors() {
		
		return selectedActors;
		
	}
	
}
