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
        } else if (channel == "latest race results") {
            return new RaceResultsRequest();
        } else if (channel == "latest qualifying results") {
            return new QualifyingResultsRequest();
        }
        return null;
    }
}
