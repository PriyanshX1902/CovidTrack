package softablitz;


public class Notifications {
    public Boolean success;
    public LatestData data;

    public static class LatestData {
        public NotificationsData[] notifications;

        public static class NotificationsData {
            public String title;
            public String link;

            public NotificationsData(String title, String link) {
                this.title = title;
                this.link = link;
            }

            public String getTitle() {
                return title;
            }

            public String getLink() {
                return link;
            }

        }
    }
}


