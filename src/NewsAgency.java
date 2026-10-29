import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private final List<Subscriber> subscribers;
    private String latestNews;

    public NewsAgency() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        if (subscriber != null && !subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            System.out.println(subscriber.getName() + " has subscribed to the news service.");
        }
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        if (subscriber != null && subscribers.remove(subscriber)) {
            System.out.println(subscriber.getName() + " has unsubscribed from the news service.");
        }
    }

    @Override
    public void notifySubscribers() {
        List<Subscriber> currentSubscribers = new ArrayList<>(subscribers);
        for (Subscriber subscriber : currentSubscribers) {
            subscriber.update(latestNews);
        }
    }

    public void publishNews(String news) {
        System.out.println("\n[NewsAgency] Publishing breaking news: \"" + news + "\"");
        this.latestNews = news;
        notifySubscribers();
    }

    public String getLatestNews() {
        return latestNews;
    }

    public int getSubscriberCount() {
        return subscribers.size();
    }
}
