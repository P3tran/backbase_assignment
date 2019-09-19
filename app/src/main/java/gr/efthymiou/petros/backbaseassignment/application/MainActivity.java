package gr.efthymiou.petros.backbaseassignment.application;

public interface MainActivity {

    void flipOpenFragment(BaseFragment fragment);

    void updateNavigation(String fragmentName);

    void displaySnackbar(String message);

}
