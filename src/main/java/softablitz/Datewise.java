package softablitz;
public class Datewise{
    public boolean success;
    public Data[] data;
    public String lastRefreshed;
    public String lastOriginUpdate;
    public class Data{
        public String day;
        public Summary summary;
        public Regionals[] regionals;

        public String getDay() {
            return day;
        }

        public Summary getSummary() {
            return summary;
        }

        public Regionals[] getRegionals() {
            return regionals;
        }

        public class Summary{
            int total;
            int confirmedCasesIndian;
            int confirmedCasesForeign;
            int discharged;
            int deaths;
            int confirmedButLocationUnidentified;

            public int getTotal() {
                return total;
            }

            public int getConfirmedCasesIndian() {
                return confirmedCasesIndian;
            }

            public int getConfirmedCasesForeign() {
                return confirmedCasesForeign;
            }

            public int getDischarged() {
                return discharged;
            }

            public int getDeaths() {
                return deaths;
            }

            public int getConfirmedButLocationUnidentified() {
                return confirmedButLocationUnidentified;
            }
        }
        public class Regionals{
            String loc;
            int confirmedCasesIndian;
            int confirmedCasesForeign;
            int discharged;
            int deaths;
            int totalConfirmed;
        }
    }
}