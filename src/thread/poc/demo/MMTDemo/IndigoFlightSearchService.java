package thread.poc.demo.MMTDemo;

import java.util.ArrayList;
import java.util.List;

public class IndigoFlightSearchService implements FlightSearchInterface{


    @Override
    public List<FlightData> getFlightSearchData(String source, String destination) {
        List<FlightData> data = new ArrayList<>();
        data.add(new FlightData("Mumbai", "Norway", 345436.00));
        data.add(new FlightData("Mumbai", "Delhi", 34663.00));
        data.add(new FlightData("Mumbai", "Paris", 235325.00));
        data.add(new FlightData("Mumbai", "Turkey", 235325.00));

        return data;
    }
}
