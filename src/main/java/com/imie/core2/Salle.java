package com.imie.core2;

import java.util.ArrayList;
import java.util.List;

import com.imie.model.Commande;

public class Salle extends Notifieur<Salle.SalleNotifierParam> implements Notifiable<Preparator.PreparatorNotifierParam> {
	public static class SalleNotifierParam implements NotifierParam {
		private Commande commande;

		public SalleNotifierParam(Commande commande) {
			this.commande = commande;
		}
	}

	private List<Commande> commandes = new ArrayList<>();

	@Override
	public void notifier(SalleNotifierParam param) {
		this.commandes.add(param.commande);
		super.notifier(param);
	}

	@Override
	public void estNotifie(Preparator.PreparatorNotifierParam articleReady) {
//		if () {
//
//		}

//		clientsPretApartir.add(commande.getClient());
	}
}
