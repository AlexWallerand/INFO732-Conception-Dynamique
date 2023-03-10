import java.util.ArrayList;

public class Systeme {

	private AnnonceFactory annonceFactory = new AnnonceFactory();
	private final ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<>();
	private final ArrayList<Annonce> listeAnnonces = new ArrayList<>();

	public void addUtilisateur(Utilisateur utilisateur){
		listeUtilisateurs.add(utilisateur);
	}

	public void addAnnonce(Annonce annonce){
		listeAnnonces.add(annonce);
	}

	public Utilisateur creerUtilisateur(String nom, String email, String mdp) {
		Utilisateur utilisateur = new Utilisateur(nom, email, mdp);
		addUtilisateur(utilisateur);
		return utilisateur;
	}

	public Annonce creerAnnonce(Utilisateur utilisateur, String typeAnnonce, String typePrestation, String description, String nom){
		TypeAnnonce typeA = null;
		switch (typeAnnonce) {
			case "demande" -> typeA = TypeAnnonce.demande;
			case "proposition" -> typeA = TypeAnnonce.proposition;
		}
		Annonce annonce = annonceFactory.creerAnnonce(typeA, typePrestation, description, nom);
		addAnnonce(annonce);
		utilisateur.addAnnonce(annonce);
        return annonce;
    }

	public void getFilAnnonces(TypeAnnonce typeAnnonce, String typePrestation) {
		ArrayList<Annonce> annonces = new ArrayList<>();
		for(Annonce a : listeAnnonces)
			if ((a.getTypeAnnonce() == typeAnnonce)&&(a.getClass().getName().equals(typePrestation))){
				annonces.add(a);
			}
		for(Annonce annonce : annonces)
			System.out.println(annonce);
	}

	public void getFilAnnonces(TypeAnnonce typeAnnonce) {
		ArrayList<Annonce> annonces = new ArrayList<>();
		for(Annonce a : listeAnnonces)
			if (a.getTypeAnnonce() == typeAnnonce){
				annonces.add(a);
			}
		for(Annonce annonce : annonces)
			System.out.println(annonce);
	}

	public void getFilAnnonces(String typePrestation) {
		ArrayList<Annonce> annonces = new ArrayList<>();
		for(Annonce a : listeAnnonces)
			if (a.getClass().getName().equals(typePrestation)){
				annonces.add(a);
			}
		for(Annonce annonce : annonces)
			System.out.println(annonce);
	}

	public void getFilAnnonces() {
		for(Annonce annonce : listeAnnonces)
			System.out.println(annonce);
	}
	

}