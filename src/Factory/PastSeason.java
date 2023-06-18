package Factory;

import Connect.Connect;
import Connect.PastSeasonConnect;

public class PastSeason implements Season {

    private int seasonNumber;

    public PastSeason(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @Override
    public void run() {
        Connect pastSeasonConnect = new PastSeasonConnect(seasonNumber);
    }

}
