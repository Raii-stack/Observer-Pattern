public class NewsSubscriber implements Subscriber {
    private final String name;
    private String lastReceivedNews;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        this.lastReceivedNews = news;
        System.out.println("  -> [" + name + "] received breaking news alert: " + news);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getLastReceivedNews() {
        return lastReceivedNews;
    }
}
