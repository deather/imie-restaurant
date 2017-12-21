package com.imie;

import java.util.List;

import com.imie.model.Article;
import com.imie.model.Commande;

public class Salle extends Notifieur<Salle.SalleNotifierParam> implements Notifiable<Article> {
	public class SalleNotifierParam implements NotifierParam {

	}
	@Override
	public void estNotifie(Article param) {
//		clientsPretApartir.add(commande.getClient());
	}
}
