package gr.efthymiou.petros.backbaseassignment.features.bookmarks;

import android.os.Parcel;
import android.os.Parcelable;

public class Bookmark implements Parcelable {

    private int id;
    private String name;
    private Coord coord;

    public Bookmark(String name, Coord coord) {
        this.name = name;
        this.coord = coord;
    }

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

    protected Bookmark(Parcel in) {
        id = in.readInt();
        name = in.readString();
        coord = (Coord) in.readValue(Coord.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeValue(coord);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Bookmark> CREATOR = new Parcelable.Creator<Bookmark>() {
        @Override
        public Bookmark createFromParcel(Parcel in) {
            return new Bookmark(in);
        }

        @Override
        public Bookmark[] newArray(int size) {
            return new Bookmark[size];
        }
    };
}