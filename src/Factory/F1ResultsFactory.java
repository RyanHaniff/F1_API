package Factory;

import Connect.*;

public class F1ResultsFactory {

    public Connect createConnection(String channel) {

        if (channel.isEmpty()) {
            return new CurrentSeasonConnect();
        } else {
            return new PastSeasonConnect(Integer.parseInt(channel));
        }
    }
}
