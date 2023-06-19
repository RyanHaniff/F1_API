package Factory;

import Connect.*;

public class F1ResultsFactory {

    public Connect createConnection(String channel) {

        if (channel.isEmpty()) {
            return new CurrentSeasonConnect();
        } else if (channel == "2013") {
            return new PastSeasonConnect(Integer.parseInt(channel));
        } else if (channel == "season") {
            return new SeasonList();
        }
        return null;
    }
}
