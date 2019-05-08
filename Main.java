package TravelAgency;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TravelAgency agency = new TravelAgency();
        agency.getOffers().add(new TripOffer(219.99f, 7, Continent.EUROPE, false));
        agency.getOffers().add(new TripOffer(349.99f, 10, Continent.SOUTH_AMERICA, true));
        agency.getOffers().add(new TripOffer(290.99f, 14, Continent.ASIA, false));
        agency.getOffers().add(new TripOffer(199.99f, 8, Continent.AFRICA, true));

        agency.displayOffers();
        System.out.println();

        float maxPrice = 200;
        int minNights = 6;
        List<Continent> continents = new ArrayList<>();
        continents.add(Continent.EUROPE);
        continents.add(Continent.ASIA);
        continents.add(Continent.AFRICA);
        boolean dogs = false;
        boolean result;

        result = agency.bookOffer(maxPrice, minNights, continents, dogs);
        System.out.println(String.format("Result for (%.2f * %d, %s, %b) is: %b", maxPrice, minNights,
                parseConts(continents), dogs, result));

        agency.displayOffers();
        System.out.println();
        maxPrice = 300;
        minNights = 10;
        dogs = true;

        result = agency.bookOffer(maxPrice, minNights, continents, dogs);
        System.out.println(String.format("Result for (%.2f * %d, %s, %b) is: %b", maxPrice, minNights,
                parseConts(continents), dogs, result));

        agency.displayOffers();
        System.out.println();
        maxPrice = 500;
        minNights = 10;
        dogs = true;
        continents.remove(0);
        continents.remove(0);
        continents.add(Continent.SOUTH_AMERICA);

        result = agency.bookOffer(maxPrice, minNights, continents, dogs);
        System.out.println(String.format("Result for (%.2f * %d, %s, %b) is: %b", maxPrice, minNights,
                parseConts(continents), dogs, result));
        agency.displayOffers();

    }

    private static String parseConts(List<Continent> continents) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < continents.size(); i++) {
            sb.append(continents.get(i).getAbbreviation());
            if (i < continents.size() - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
