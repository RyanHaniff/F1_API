package Factory;

import Connect.*;

public class F1ResultsFactory {

    public void createConnection(String channel) {

        if (channel.isEmpty()) {
            Connect currentSeason = new CurrentSeasonConnect();

        } else {
            Connect pastSeason = new PastSeasonConnect(Integer.parseInt(channel));
        }
    }
}
