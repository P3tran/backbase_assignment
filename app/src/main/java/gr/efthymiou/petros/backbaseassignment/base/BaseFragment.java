package gr.efthymiou.petros.backbaseassignment.base;

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
}
