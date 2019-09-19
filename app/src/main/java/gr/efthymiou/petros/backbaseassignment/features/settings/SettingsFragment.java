package gr.efthymiou.petros.backbaseassignment.features.settings;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.application.BaseFragment;
import gr.efthymiou.petros.backbaseassignment.application.PreferenceDao;


public class SettingsFragment extends BaseFragment implements SettingsView {

    private SettingsPresenter presenter;
    private Switch mImperialSwitch;


    public SettingsFragment() {
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new SettingsPresenterImpl(this);
        prepareViews(view);
    }

    private void prepareViews(@NonNull View view) {
        ViewGroup mOptionDeleteAllBookmarks = view.findViewById(R.id.delete_bookmarks_ll);

        DialogInterface.OnClickListener deleteAllBookmarksButton = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.deleteAllBookmarks(getContext());
            }
        };

        DialogInterface.OnClickListener dismissButton = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        mOptionDeleteAllBookmarks.setOnClickListener(v -> {
            AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
            alertDialog.setMessage(getString(R.string.settings_delete_bookmarks_dialog_message));
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.delete), deleteAllBookmarksButton);
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.no), dismissButton);
            alertDialog.setTitle(getString(R.string.settings_delete_bookmarks));
            alertDialog.setCancelable(false);
            alertDialog.show();
        });

        mImperialSwitch = view.findViewById(R.id.imperial_switch);
        if (getContext() != null) {
            mImperialSwitch.setChecked((Boolean) PreferenceDao.USER_IMPERIAL_SYSTEM.getValue(getContext()));
        }

        mImperialSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (getContext() != null) {
                if (isChecked)
                    PreferenceDao.USER_IMPERIAL_SYSTEM.setValue(true, getContext());
                else
                    PreferenceDao.USER_IMPERIAL_SYSTEM.setValue(false, getContext());
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    public void bookmarksDeleted() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(() -> {
                displaySnackbar(getString(R.string.all_bookmarks_deleted));
            });
        }
    }

    @Override
    public void displayError(int errorMessageId) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(() -> {
                displaySnackbar(getString(errorMessageId));
            });
        }
    }
}
