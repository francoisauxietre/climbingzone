package repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "escalade.db.recreate", havingValue = "true")
public class dataBase implements CommandLineRunner {
    private ParkingRepository parkingRepository;
    private PlaceRepository placeRepository;
    private RouteRepository routeRepository;
    private ClimberRepository climberRepository;

    public dataBase(ParkingRepository parkingRepository, PlaceRepository placeRepository, RouteRepository routeRepository, ClimberRepository climberRepository) {
        this.parkingRepository = parkingRepository;
        this.placeRepository = placeRepository;
        this.routeRepository = routeRepository;
        this.climberRepository = climberRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.parkingRepository.deleteAll();
        this.placeRepository.deleteAll();
        this.routeRepository.deleteAll();
        this.climberRepository.deleteAll();
    }
}
