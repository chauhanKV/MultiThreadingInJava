package thread.poc.demo.MMTDemo;

import java.util.ArrayList;
import java.util.List;

public class GoFlightSearchService implements FlightSearchInterface{
    @Override
    public List<FlightData> getFlightSearchData(String source, String destination) {

        List<FlightData> data = new ArrayList<>();
        data.add(new FlightData("Delhi", "New York", 345665.00));
        data.add(new FlightData("Bengaluru", "Switzerland", 34663.00));
        data.add(new FlightData("Delhi", "Copenhagen", 235325.00));
        data.add(new FlightData("Delhi", "Mexico", 235325.00));
        return data;
    }
}
