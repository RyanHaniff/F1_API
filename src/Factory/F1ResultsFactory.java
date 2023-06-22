package Factory;

import RequestData.*;

/**
 * The Factory where all objects of concrete classes are created and returned to
 * main()
 */
public class F1ResultsFactory {

    /**
     * Function gets called in main after creating a {@link #F1ResultsFactory()}
     * object.
     * 
     * @param channel is the result you want to query. Can be a year, a season, or
     *                the latest race/qualifying results
     * @return the concrete class object
     */
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
