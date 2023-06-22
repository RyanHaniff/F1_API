package Factory;

import java.time.Year;

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

        int year;

        // check to see if the channel is a year
        if (isNumeric(channel)) {
            year = Integer.parseInt(channel);
            // check to see if the year is between 1950 and current year
            if ((year >= 1950) & (year <= Year.now().getValue())) {
                return new PastSeasonRequest(year);
            } else {
                return null;
            }
            // if the channel is empty, call the current year season list
        } else if (channel.isEmpty()) {
            return new CurrentSeasonRequest();
            // called when you want a list of all docuemnted seasons in F1
        } else if (channel == "season") {
            return new SeasonListRequest();
            // called to show the latest race results
        } else if (channel == "latest race results") {
            return new RaceResultsRequest();
            // called to show the latest qualifying results
        } else if (channel == "latest qualifying results") {
            return new QualifyingResultsRequest();
        } // As more classes get created we can add them here because its a factory method
        return null;
    }

    public boolean isNumeric(String channel) {
        try {
            Integer.parseInt(channel);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
