package com.imie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.imie.model.*;

public class App {

	private Restaurant restaurant;

	public static void main(String[] args) {
		App app = new App();

		app.run();
	}

	public void init() {
		restaurant = new Restaurant();
		Table table = new Table(1);
		Table table2 = new Table(2);
		Table table3 = new Table(3);
		Waiter waiter = new Waiter();

		restaurant.add(table);
		restaurant.add(table2);
		restaurant.add(table3);
		restaurant.add(waiter);

		List<Article> articles = new ArrayList<>();

		Article article = new Article(1, "Saké");
		Article article2 = new Article(2, "Kirin Ichiban");
		Article article3 = new Article(3, "Ramen");
		Article article4 = new Article(4, "Sushi");

		articles.add(article);
		articles.add(article2);
		articles.add(article3);
		articles.add(article4);

		restaurant.setMenu(new Menu(articles));
	}

	public void run() {
		this.init();

		while (true) {
			// Etape 1
			System.out.println("Bienvenue dans notre restaurant !");

			// Etape 2
			Client client = demanderClient();

			// Etape 3
			Table table = chooseTable();

			if (table != null) {
				table.setClient(client);
				client.setTable(table);

				System.out.println("Veuillez vous installer à la table : " + table.getId());

				// Etape 4
				Commande commande = prendreCommande(table);

				System.out.println("Merci, votre commande est le numéro : " + commande.getId());
			}
			else {
				System.out.println("Désolé nous n'avons plus de place.");
			}
		}
	}

	public Client demanderClient() {
		String nameRead;

		do {
			System.out.println("Puis-je connaître votre nom ?");
			Scanner sc = new Scanner(System.in);
			nameRead = sc.nextLine();

			if (nameRead.isEmpty())
				System.out.println("Je n'ai pas compris votre nom.");
		} while(nameRead.isEmpty());

		return new Client(nameRead);
	}

	public Table chooseTable() {
		Random random = new Random();
		Table table;

		if (this.restaurant.hasTableFree()) {
			do {
				int randomIndex = random.nextInt(this.restaurant.getTables().size());
				table = this.restaurant.getTables().get(randomIndex);
			} while (table.getClient() != null);
		}
		else {
			table = null;
		}

		return table;
	}

	public Commande prendreCommande(Table table) {
		String articlesIdInString;
		List<Article> articles;

		do {
			List<Integer> articlesId = new ArrayList<>();

			try {
				do {
					System.out.println("// TODO afficher menu");
					System.out.println("Que souhaitez-vous commander ?");

					Scanner scanner = new Scanner(System.in);
					articlesIdInString = scanner.nextLine();
				} while (articlesIdInString.isEmpty());

				String[] articlesIdSplitted = articlesIdInString.split(",");

				for (String articleIdInString : articlesIdSplitted)
					articlesId.add(Integer.parseInt(articleIdInString));
			} catch(NumberFormatException e) {
				System.out.println("T'es un peu bête j'attends des chiffres");
			}

			articles = this.restaurant.getMenu().getArticles(articlesId);
		} while(articles.isEmpty());

		return new Commande(this.restaurant.getCommandeCounter(), articles, table);
	}
}
