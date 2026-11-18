package ex2024;

public abstract class Content implements Streamable{
	private String title;
	private String genre;
	private boolean isFree;
	
	public Content(String title ,String genre ,boolean isFree) {
		this.title = title;
		this.genre = genre;
		this.isFree = isFree;
	}
	
	
	public String getTitle() {
		return title;
	}



	public String getGenre() {
		return genre;
	}


	public boolean isFree() {
		return isFree;
	}


	


	public abstract void afficheDetails() ;
	
	public void play() {
		System.out.println("Lecture de:["+genre+"]");
		afficheDetails();
	}
	

}
