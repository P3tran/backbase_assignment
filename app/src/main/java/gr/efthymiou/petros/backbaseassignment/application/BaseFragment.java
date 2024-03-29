package gr.efthymiou.petros.backbaseassignment.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        if (getActivity() != null)
            ((MainActivity) getActivity()).updateNavigation(this.getClass().getSimpleName());
        return inflater.inflate(getLayoutId(), container, false);
    }

    protected abstract int getLayoutId();

    protected void flipOpenFragment(BaseFragment fragment) {
        if (getActivity() != null)
            ((MainActivity) getActivity()).flipOpenFragment(fragment);
    }

    protected void displaySnackbar(String message) {
        if (getActivity() != null)
            ((MainActivity) getActivity()).displaySnackbar(message);
    }
}
