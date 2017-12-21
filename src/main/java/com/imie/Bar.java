package com.imie;

import com.imie.model.Boisson;
import com.imie.model.Commande;

public class Bar extends Preparator<Boisson, Bar.BarNotifierParam> {
	public class BarNotifierParam implements NotifierParam {

	}

	public void preparer(Boisson article) {

	}

	@Override
	public void estNotifie(Commande param) {

	}
}
