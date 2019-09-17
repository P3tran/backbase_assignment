package gr.efthymiou.petros.backbaseassignment.features.home;

public class Bookmark {

    private int id;
    private String name;
    private Coord coord;

    public Bookmark(int id, String name, Coord coord) {
        this.id = id;
        this.name = name;
        this.coord = coord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bookmark)) return false;
        Bookmark bookmark = (Bookmark) o;
        return getId() == bookmark.getId() &&
                getName().equals(bookmark.getName()) &&
                getCoord().equals(bookmark.getCoord());
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                '}';
    }
}
