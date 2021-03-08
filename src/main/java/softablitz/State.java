package softablitz;

import java.lang.*;

public class State {
    int srNo;
    String stateUT, confirmed, recovered, deaths;

    public State() {
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getStateUT() {
        return stateUT;
    }

    public void setStateUT(String stateUT) {
        this.stateUT = stateUT;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}

