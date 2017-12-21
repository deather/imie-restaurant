package com.imie;

import java.util.ArrayList;
import java.util.List;

public abstract class Notifieur<T extends NotifierParam> {
	private List<Notifiable> notifies = new ArrayList<>();

	public void ajouter(Notifiable notifiable) {
		this.notifies.add(notifiable);
	}

	public void retirer(Notifiable notifiable) {
		this.notifies.remove(notifiable);
	}

	public void notifier(T param) {
		for (Notifiable notifiable : this.notifies)
			notifiable.estNotifie(param);
	}
}
