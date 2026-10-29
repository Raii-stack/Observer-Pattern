public class NewsApp {
    public static void main(String[] args) {
        System.out.println("=== Real-time News Subscription Service (Observer Pattern) ===\n");

        NewsAgency agency = new NewsAgency();

        NewsSubscriber kathryn = new NewsSubscriber("Kathryn");
        NewsSubscriber alain = new NewsSubscriber("Alain");
        NewsSubscriber ryan = new NewsSubscriber("Ryan");

        // 1. Initial Subscriptions
        System.out.println("--- Subscribing Initial Users ---");
        agency.subscribe(ryan);
        agency.subscribe(kathryn);

        // 2. Publish first breaking news
        agency.publishNews("Global Tech Summit kicks off with breakthrough quantum announcements!");

        // 3. Dynamic Subscription Updates 
        System.out.println("\n--- Dynamic Subscription Updates ---");
        agency.subscribe(alain);
        agency.unsubscribe(kathryn);

        // 4. Publish second breaking news
        agency.publishNews("Mars rover discovers definitive signs of ancient underground aquifers!");

        // 5. Verification
        System.out.println("\n--- Verification ---");
        assert "Mars rover discovers definitive signs of ancient underground aquifers!".equals(kathryn.getLastReceivedNews()) : "Kathryn did not receive latest news";
        assert "Global Tech Summit kicks off with breakthrough quantum announcements!".equals(alain.getLastReceivedNews()) : "Alain received news after unsubscribing";
        assert "Mars rover discovers definitive signs of ancient underground aquifers!".equals(ryan.getLastReceivedNews()) : "Ryan did not receive latest news";
        assert agency.getSubscriberCount() == 2 : "Subscriber count mismatch";

        System.out.println("[Verification] Dynamic subscription updates and decoupled notifications verified successfully.");
    }
}
