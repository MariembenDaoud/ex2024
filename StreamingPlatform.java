package ex2024;

public class StreamingPlatform {
	private Content[] contents;
    private User[] users;
    private int nbContents;
    private int nbUsers;
    
    
    
    public StreamingPlatform(int maxContents , int nbUsers) {
        contents = new Content[100];
        users = new User[100];
        nbContents = 0;
        nbUsers = 0;
    }
    public void addContent(Content content) {
        if (nbContents < contents.length) {
            contents[nbContents++] = content;
           
        }
    }
    
    public void addUser(User user) {
        if (nbUsers < users.length) {
            users[nbUsers++] = user;
        }
    }
    
    public Content findContent(String title)
            throws ContentNotFoundException {

        for (int i = 0; i < nbContents; i++) {
            if (contents[i].getTitle().equals(title))
                return contents[i];
        }

        throw new ContentNotFoundException(
                "Contenu introuvable : " + title);
    }
    
    
    public void playContent(User user, String title)
            throws ContentNotFoundException,
                   AccessDeniedException {

        Content c = findContent(title);

        if (!user.canPlay(c))
            throw new AccessDeniedException(
                    "Accès refusé à : " + title);

        c.play();
        user.addWatchedContent(c);
    }

    public Content[] getRecommendations(User user) {
        Content[] rec = new Content[10];
        int nbRec = 0;
        String[] genres = user.getWatchedGenres();
        for (int i = 0; i < nbContents && nbRec < 10; i++) {
            Content c = contents[i];
            boolean memeGenre = false;
            for (int j = 0; j < genres.length; j++) {

                if (c.getGenre().equalsIgnoreCase(genres[j])) {
                    memeGenre = true;
                    break;
                }
            }
            boolean Regarde = false;
            for (int j = 0; j < user.getNbWatched(); j++) {
                if (user.getWatchedContent()[j] == c) {
                    Regarde = true;
                    break;
                }
            }
            if (memeGenre && !Regarde) {
                rec[nbRec++] = c;
            }
        }
        Content[] result = new Content[nbRec];
        for (int i = 0; i < nbRec; i++)
            result[i] = rec[i];
        return result;
    }
}
    
    
    



