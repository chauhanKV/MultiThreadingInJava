package thread.poc.demo.MMTDemo;

public class FlightData {

    private String source;
    private String destination;
    private Double cost;

    public FlightData(String source, String destination, Double cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                '}';
    }
}
