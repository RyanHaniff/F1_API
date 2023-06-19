package Factory;

import Connect.*;

public class SeasonFactory {

    public void createConnection(String channel) {

        if (channel.isEmpty()) {
            Season currentSeason = new CurrentSeason();
            currentSeason.run();
        } else {
            Season pastSeason = new PastSeason(Integer.parseInt(channel));
            pastSeason.run();
        }
    }
}
