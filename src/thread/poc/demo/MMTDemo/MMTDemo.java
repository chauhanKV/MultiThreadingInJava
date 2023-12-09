package thread.poc.demo.MMTDemo;

import java.util.List;

public class MMTDemo {
    public static void main(String[] args) {
        MMTFlightSearchService service = new MMTFlightSearchService();
        System.out.println(service.getAllFlightsBySourceAndDestination("Delhi", "Norway"));
    }
}
