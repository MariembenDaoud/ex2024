package ex2024;

public class main {

    public static void main(String[] args) {

        StreamingPlatform platform = new StreamingPlatform(20, 10);
        platform.addContent(
                new Movie("Inception",
                        "Sci-Fi",
                        false,
                        148));

        platform.addContent(
                new Serie("Stranger Things",
                        "Thriller",
                        false,
                        25,
                        50));

        platform.addContent(
                new Movie("Charlie Chaplin",
                        "Comedy",
                        true,
                        75));

        platform.addContent(
                new Serie("Friends",
                        "Comedy",
                        true,
                        236,
                        22));

        // Création des utilisateurs
        User user1 = new User("Imene", false);
        User user2 = new User("Jihene", true);

        platform.addUser(user1);
        platform.addUser(user2);

        try {

            System.out.println("=== Imene ===");
            platform.playContent(user1, "Inception");
            platform.playContent(user1, "Charlie Chaplin");

        } catch (ContentNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {

            System.out.println("\n=== Jihene ===");
            platform.playContent(user2, "Stranger Things");
            platform.playContent(user2, "Friends");

        } catch (ContentNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== Recommandations pour Jihene ===");

        Content[] rec = platform.getRecommendations(user2);

        for (int i = 0; i < rec.length; i++) {
            System.out.println(rec[i].getTitle()
                    + " (" + rec[i].getGenre() + ")");
        }
    }
}