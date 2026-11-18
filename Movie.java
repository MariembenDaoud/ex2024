package ex2024;

public class Movie extends Content{
	private int duration;
	
	
	public Movie(String title,String genre,boolean isFree,int duration) {
		super(title,genre,isFree);
		this.duration = duration;
		
	}
	
	public int getDuration() {
		return duration ;
	}
	
	public void afficheDetails() {
		System.out.println("Titre : " + getTitle());
        System.out.println("Genre : " + getGenre());
        if(isFree()) {
        	System.out.println("Gratuit  ");
        }
        else {
        	System.out.println("n'est pas Gratuit " );
        }
        
        System.out.println("Durée : " + duration + " minutes");
    
	}
}
