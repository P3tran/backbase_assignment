package gr.efthymiou.petros.backbaseassignment.features.bookmarks.map;

import gr.efthymiou.petros.backbaseassignment.application.GenericView;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;

public interface MapView extends GenericView {

    void updateLocation(String location);

    void emptyAddress();

    void moveMapToCurrentUserLocation(Coord coord);

    void showLoader();

    void hideLoader();

    void bookmarkAdded(String bookmarkName);

}
