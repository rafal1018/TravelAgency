package TravelAgency;

import java.util.List;

public class TripOffer {
    private float pricePerNight;
    private int hotelNights;
    private Continent destination;
    private boolean dogsAllowed;

    public TripOffer(float pricePerNight, int hotelNights, Continent destination, boolean dogsAllowed) {
        this.pricePerNight = pricePerNight;
        this.hotelNights = hotelNights;
        this.destination = destination;
        this.dogsAllowed = dogsAllowed;
    }

    public boolean meetsCriteria(float maxPricePerNight, int minHotelNoghts, List<Continent> continents, boolean dogTravelling){
        if (dogTravelling && !dogsAllowed)
            return false;

        if (pricePerNight > maxPricePerNight)
            return false;

        if (hotelNights < minHotelNoghts)
            return false;

        for (Continent c : continents){
            if (c == destination)
                return false;
        }

        return false;
    }

    @Override
    public String toString() {
        return "TripOffer{" +
                "pricePerNight=" + pricePerNight +
                ", hotelNights=" + hotelNights +
                ", destination=" + destination +
                ", dogsAllowed=" + dogsAllowed +
                '}';
    }
}
