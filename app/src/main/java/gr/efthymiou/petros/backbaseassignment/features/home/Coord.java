package gr.efthymiou.petros.backbaseassignment.features.home;

public class Coord {
    private Long lon;
    private Long lat;

    public Coord(Long lon, Long lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Long getLon() {
        return lon;
    }

    public void setLon(Long lon) {
        this.lon = lon;
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord)) return false;
        Coord coord = (Coord) o;
        return getLon().equals(coord.getLon()) &&
                getLat().equals(coord.getLat());
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
