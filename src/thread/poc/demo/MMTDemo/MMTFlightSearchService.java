package thread.poc.demo.MMTDemo;

import javax.security.auth.callback.Callback;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MMTFlightSearchService {

    List<FlightSearchInterface> flightSearchImplementation;

    public MMTFlightSearchService(List<FlightSearchInterface> flightSearchImplementation) {
        this.flightSearchImplementation = flightSearchImplementation;
    }
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public List<FlightData> getAllFlightsBySourceAndDestination(String source, String destination) {
        List<FlightData> response = new ArrayList<>();

//        GoFlightSearchService go = new GoFlightSearchService();
//        IndigoFlightSearchService indigo = new IndigoFlightSearchService();
//
////        response.addAll(go.getFlightSearchData(source, destination));
////        response.addAll(indigo.getFlightSearchData(source, destination));
//
//        Callable<List<FlightData>> indigoCallable = () -> indigo.getFlightSearchData(source, destination);
//        Callable<List<FlightData>> goCallable = () -> go.getFlightSearchData(source, destination);
//
//        Future<List<FlightData>> indigoFuture = executorService.submit(indigoCallable);
//        Future<List<FlightData>> goFuture = executorService.submit(goCallable);
//
//
//        try {
//            List<FlightData> indigoResponse = indigoFuture.get();
//            List<FlightData> goResponse = goFuture.get();
//
//            response.addAll(indigoResponse);
//            response.addAll(goResponse);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }

        // Code Refactoring

        List<Callable<List<FlightData>>> callableList = new ArrayList<>();

        for(FlightSearchInterface searchInterface : flightSearchImplementation)
        {
            Callable<List<FlightData>> callable = () -> searchInterface.getFlightSearchData(source,destination);
            callableList.add((callable));
        }

        try {
            List<Future<List<FlightData>>> futureList = executorService.invokeAll(callableList);
            for(Future<List<FlightData>> future : futureList)
            {
                try {
                    response.addAll(future.get());
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        return response;
    }
}
