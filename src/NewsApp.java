public class NewsApp {
    public static void main(String[] args) {
        System.out.println("=== Real-time News Subscription Service (Observer Pattern) ===\n");

        NewsAgency agency = new NewsAgency();

        NewsSubscriber alice = new NewsSubscriber("Alice");
        NewsSubscriber bob = new NewsSubscriber("Bob");
        NewsSubscriber charlie = new NewsSubscriber("Charlie");

        // 1. Initial Subscriptions
        System.out.println("--- Subscribing Initial Users ---");
        agency.subscribe(alice);
        agency.subscribe(bob);

        // 2. Publish first breaking news
        agency.publishNews("Global Tech Summit kicks off with breakthrough quantum announcements!");

        // 3. Dynamic Subscription Updates (Charlie subscribes, Bob unsubscribes)
        System.out.println("\n--- Dynamic Subscription Updates ---");
        agency.subscribe(charlie);
        agency.unsubscribe(bob);

        // 4. Publish second breaking news
        agency.publishNews("Mars rover discovers definitive signs of ancient underground aquifers!");

        // 5. Verification / Self-check
        System.out.println("\n--- Verification ---");
        assert "Mars rover discovers definitive signs of ancient underground aquifers!".equals(alice.getLastReceivedNews()) : "Alice did not receive latest news";
        assert "Global Tech Summit kicks off with breakthrough quantum announcements!".equals(bob.getLastReceivedNews()) : "Bob received news after unsubscribing";
        assert "Mars rover discovers definitive signs of ancient underground aquifers!".equals(charlie.getLastReceivedNews()) : "Charlie did not receive latest news";
        assert agency.getSubscriberCount() == 2 : "Subscriber count mismatch";

        System.out.println("[Verification] Dynamic subscription updates and decoupled notifications verified successfully.");
    }
}
