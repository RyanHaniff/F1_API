package Factory;

import RequestData.*;

public class F1ResultsFactory {

    public Request createConnection(String channel) {

        if (channel.isEmpty()) {
            return new CurrentSeasonRequest();
        } else if (channel == "2013") {
            return new PastSeasonRequest(Integer.parseInt(channel));
        } else if (channel == "season") {
            return new SeasonListRequest();
        }
        return null;
    }
}
