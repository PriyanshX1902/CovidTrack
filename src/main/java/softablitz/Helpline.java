package softablitz;

public class Helpline {
    public Boolean success;
    public HelplineData data;
    public String lastRefreshed;
    public String lastOriginUpdate;

    public static class HelplineData {
        public Contacts contacts;

        public static class Contacts {
            public Primary primary;
            public Regional[] regional;

            public static class Primary {
                public String number;
                public String number_tollfree;
                public String email;
                public String twitter;
                public String facebook;
                public String[] media;
            }

            public static class Regional {
                public String loc;
                public String number;

                public Regional(String state, String contact) {
                    loc = state;
                    number = contact;
                }

                public String getLoc() {
                    return loc;
                }

                public String getNumber() {
                    return number;
                }
            }
        }
    }
}



