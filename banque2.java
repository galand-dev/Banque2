// INFORMATIONS SUR L'ETUDIANT
/*
 * NOM: NDZOMO NOAH
 * PRENOM: FRANCOIS GALAND
 * FILIERE: GENIE INFORMATIQUE
 * NIVEAU : 2
 * GROUPE: FI1-B
 * CONTROLE CONTINUE 2
 * PROGRAMMATION ORIENTE OBJET
 * 09/11/2024
 */





// Classe representant un client
class Client {
  private String nom;
  private String ville;
  private Compte comptePrive;
  private Compte compteEpargne;

  public Client(String nom, String ville, double soldePrive, double soldeEpargne, double tauxPrive, double tauxEpargne) {
      this.nom = nom;
      this.ville = ville;
      this.comptePrive = new Compte(soldePrive, tauxPrive);
      this.compteEpargne = new Compte(soldeEpargne, tauxEpargne);
  }

  public void afficherInformations() {
      System.out.println("Client: " + nom + " de " + ville);
      System.out.println("Compte privé: " + comptePrive.retournerSolde() + " francs");
      System.out.println("Compte d'épargne: " + compteEpargne.retournerSolde() + " francs");
  }

  public void bouclerComptes() {
      comptePrive.ajouterInterets();
      compteEpargne.ajouterInterets();
  }
}

// Classe representant un compte bancaire
class Compte {
  private double solde;
  private double tauxInteret;

  public Compte(double solde, double tauxInteret) {
      this.solde = solde;
      this.tauxInteret = tauxInteret;
  }

  public double retournerSolde() {
      return solde;
  }

  public void ajouterInterets() {
      solde += solde * tauxInteret;
  }
}

// Classe principale pour gerer le programme bancaire
public class Banque2 {
  public static void main(String[] args) {
      double tauxPrive = 0.01;
      double tauxEpargne = 0.02;

      // Creation des clients
      Client client1 = new Client("Pedro", "Genève", 1000.0, 2000.0, tauxPrive, tauxEpargne);
      Client client2 = new Client("Alexandra", "Lausanne", 3000.0, 2000.0, tauxPrive, tauxEpargne);

      // Afficher les donnees des clients
      client1.afficherInformations();
      client2.afficherInformations();

      // Bouclage des comptes
      client1.bouclerComptes();
      client2.bouclerComptes();

      // Afficher les donnees après le bouclage des comptes
      client1.afficherInformations();
      client2.afficherInformations();
  }
}
