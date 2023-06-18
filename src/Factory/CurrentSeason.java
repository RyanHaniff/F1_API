package Factory;

import Connect.Connect;
import Connect.CurrentSeasonConnect;

public class CurrentSeason implements Season {

    public void run() {
        Connect currentSeasonConnect = new CurrentSeasonConnect();
    }

}
