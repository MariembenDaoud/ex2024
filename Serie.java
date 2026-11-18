package ex2024;

public class Serie extends Content {
	private int nbEpisodes;
	private int dureeEpisode;
	
	
	public Serie(String title, String genre, boolean isFree, int nbEpisodes, int dureeEpisode) {
		super(title, genre, isFree);
		this.nbEpisodes = nbEpisodes;
		this.dureeEpisode = dureeEpisode;
	}
	
	
	public int getNbEpisodes() {
		return nbEpisodes;
	}
	public int getDureeEpisode() {
		return dureeEpisode;
	}
	
	public int getDuration() {
		return nbEpisodes*dureeEpisode;
	}
	public void afficheDetails() {
	    System.out.println("=== Série ===");
	    System.out.println("Titre : " + getTitle());
	    System.out.println("Genre : " + getGenre());
	    System.out.println("Gratuit : " + isFree());
	    System.out.println("Nombre d'épisodes : " + nbEpisodes);
	    System.out.println("Durée d'un épisode : " + dureeEpisode + " minutes");
	    System.out.println("Durée totale : " + getDuration() + " minutes");
	   }
	


	

}
