package thread.poc.demo.MMTDemo;

import java.util.ArrayList;
import java.util.List;

public class MMTDemo {
    public static void main(String[] args) {
        List<FlightSearchInterface> flightSearchImplementationList = new ArrayList<>();
        flightSearchImplementationList.add(new GoFlightSearchService());
        flightSearchImplementationList.add(new IndigoFlightSearchService());
        MMTFlightSearchService service = new MMTFlightSearchService(flightSearchImplementationList);
        System.out.println(service.getAllFlightsBySourceAndDestination("Delhi", "Norway"));
    }
}
