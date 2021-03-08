package softablitz;

public class District {
    public StateData[] stateData;

    public class StateData {
        public String id;
        public String state;
        public int active;
        public int confirmed;
        public int recovered;
        public int deaths;
        public int aChanges;
        public int cChanges;
        public int rChanges;
        public int dChanges;
        public DistrictData[] districtData;

        public class DistrictData {
            public String id;
            public String state;
            public String name;
            public int confirmed;
            public int recovered;
            public int deaths;
            public int oldConfirmed;
            public int oldRecovered;
            public int oldDeaths;
            public String zone;
        }
    }
}

//https://api.covidindiatracker.com/state_data.json
//https://api.covidindiatracker.com/total.json
//https://documenter.getpostman.com/view/11238297/SzfDwQdd?version=latest
//https://api.covid19india.org/data.json