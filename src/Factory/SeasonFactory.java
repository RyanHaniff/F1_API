package Factory;

import Connect.*;

public class SeasonFactory {

    public Season createConnection(String channel) {

        return new CurrentSeason();

        // if (channel.isEmpty()) {
        //     return new CurrentSeason();
        // } else {
        //     return new PastSeason(Integer.parseInt(channel));
        // }
    }
}
