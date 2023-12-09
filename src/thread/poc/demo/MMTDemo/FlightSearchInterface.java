package thread.poc.demo.MMTDemo;

import java.util.List;

public interface FlightSearchInterface {
    List<FlightData> getFlightSearchData(String source, String destination);
}
