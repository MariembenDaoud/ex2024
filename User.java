package ex2024;

public class User {
	private String name;
	private boolean isSubscribed;
	private Content[] watchedContent;
    private int nbWatched;
    public static final int MAX_WATCHED = 100;
	
    public User(String name, boolean isSubscribed) {
		this.name = name;
		this.isSubscribed = isSubscribed;
		this.watchedContent = new Content[MAX_WATCHED];
		this.nbWatched=0;
	}
    public int getNbWatched() {
        return nbWatched;
    }

    public Content[] getWatchedContent() {
        return watchedContent;
    }
    
    public boolean canPlay(Content content) {

        if (content == null) {
            return false;
        }

        return isSubscribed || content.isFree();
    }
    
    public void addWatchedContent(Content content) {

        if (content != null && nbWatched < MAX_WATCHED) {
            watchedContent[nbWatched] = content;
            nbWatched++;
        }
    }
    
    public String[] getWatchedGenres() {

        String[] genres = new String[nbWatched];
        int nbGenres = 0;

        for (int i = 0; i < nbWatched; i++) {

            String genre = watchedContent[i].getGenre();
            boolean existe = false;

            for (int j = 0; j < nbGenres; j++) {
                if (genres[j].equals(genre)) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                genres[nbGenres] = genre;
                nbGenres++;
            }
        }

        return genres;
    }
}
    


