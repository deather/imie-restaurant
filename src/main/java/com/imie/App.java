package com.imie;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.imie.core.Bar;
import com.imie.core.Cuisine;
import com.imie.core.Salle;
import com.imie.daos.*;
import com.imie.model.*;

public class App {

	private Restaurant restaurant;
	ExecutorService executorService = Executors.newFixedThreadPool(1);
	private static Random random = new Random();

	private TableDAO tableDAO = new TableDAO();
	private ClientDAO clientDAO = new ClientDAO();
	private CommandeDAO commandeDAO = new CommandeDAO();
	private AlimentDAO alimentDAO = new AlimentDAO();
	private BoissonDAO boissonDAO = new BoissonDAO();

	public static void main(String[] args) {
		App app = new App();

		app.run();
	}

	public void init() {
		restaurant = new Restaurant();

		Table table = this.tableDAO.create(new Table());
		Table table2 = this.tableDAO.create(new Table());
		Table table3 = this.tableDAO.create(new Table());

		restaurant.add(table);
		restaurant.add(table2);
		restaurant.add(table3);

		Waiter waiter = new Waiter();
		restaurant.add(waiter);

		List<Article> articles = Arrays.asList(
				this.boissonDAO.create(
						new Boisson("Saké", 8.00, 0.20, 1)
				),
				this.boissonDAO.create(
						new Boisson("Kirin Ichiban", 3.5, 0.05, 1)
				),
				this.alimentDAO.create(
						new Aliment("Ramen", 8.00, new HashSet<>(Arrays.asList(Allergen.OEUF, Allergen.SOJA)), 10)
				),
				this.alimentDAO.create(
						new Aliment("Sushi", 10.00, Collections.singleton(Allergen.POISSON), 10)
				)
		);

		restaurant.setMenu(new Menu(articles));
		restaurant.setBar(new Bar());
		restaurant.setCuisine(new Cuisine());
		restaurant.setSalle(new Salle());
		restaurant.getSalle().setCuisine(restaurant.getCuisine());
		restaurant.getSalle().setBar(restaurant.getBar());
		restaurant.getBar().setSalle(restaurant.getSalle());
		restaurant.getCuisine().setSalle(restaurant.getSalle());

		executorService.submit(() -> {
			try {
				while (true) {
					if (!restaurant.getSalle().getClientsPretApartir().isEmpty()) {
						Client clientRandom = restaurant.getSalle().getClientsPretApartir().remove(random.nextInt(restaurant.getSalle().getClientsPretApartir().size()));

						System.out.println(MessageFormat.format("Le client {0} est parti.", clientRandom.getName()));
						Client clientDb = this.clientDAO.get(clientRandom.getId());

						clientDb.getTable().setClient(null);
						this.tableDAO.update(clientDb.getTable());
						clientDb.setTable(null);
						this.clientDAO.update(clientDb);
					}

					Thread.currentThread().sleep(random.nextInt(5) * 1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
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
				this.tableDAO.update(table);
				this.clientDAO.update(client);

				System.out.println("Veuillez vous installer à la table : " + table.getId());

				// Etape 4
				Commande commande = prendreCommande(table);

				System.out.println("Merci, votre commande est le numéro : " + commande.getId());

				restaurant.getSalle().envoyer(commande);
			} else {
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
		} while (nameRead.isEmpty());

		return this.clientDAO.create(new Client(nameRead));
	}

	public Table chooseTable() {
		Random random = new Random();
		Table table;

		if (this.restaurant.hasTableFree()) {
			do {
				int randomIndex = random.nextInt(this.restaurant.getTables().size());
				table = this.restaurant.getTables().get(randomIndex);
			} while (table.getClient() != null);
		} else {
			table = null;
		}

		return this.tableDAO.get(table.getId());
	}

	public Commande prendreCommande(Table table) {
		String articlesIdInString;
		List<Article> articles;

		do {
			List<Integer> articlesId = new ArrayList<>();

			try {
				do {
					System.out.println("+-----------------------------------+");
					System.out.println("| CARTE                             |");
					System.out.println("|===================================|");

					List<Article> articlesMenu = restaurant.getMenu().getArticles();

					for (Article article : articlesMenu)
						System.out.println(article.toString());

					System.out.println("+-----------------------------------+");
					System.out.println("Que souhaitez-vous commander ?");

					Scanner scanner = new Scanner(System.in);
					articlesIdInString = scanner.nextLine();
				} while (articlesIdInString.isEmpty());

				String[] articlesIdSplitted = articlesIdInString.split(",");

				for (String articleIdInString : articlesIdSplitted)
					articlesId.add(Integer.parseInt(articleIdInString));
			} catch (NumberFormatException e) {
				System.out.println("T'es un peu bête j'attends des chiffres");
			}

			articles = this.restaurant.getMenu().getArticles(articlesId);
		} while (articles.isEmpty());

		return this.commandeDAO.create(
				new Commande(articles, table)
		);
	}
}
