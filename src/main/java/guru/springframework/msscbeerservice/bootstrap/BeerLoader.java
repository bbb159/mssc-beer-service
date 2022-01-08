package guru.springframework.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Beer 1")
                    .beerStyle("Beer style")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(123912392193L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Beer 2")
                    .beerStyle("Beer style 2")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(1233333333L)
                    .price(new BigDecimal("20.19"))
                    .build());
        }

        System.out.println("Loaded beers: " + beerRepository.count());
    }
}
