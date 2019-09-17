package gr.efthymiou.petros.backbaseassignment.base;

public interface MainActivity {

    void flipOpenFragment(BaseFragment fragment);

    void updateNavigation(String fragmentName);

    void displayError(String error);
}
