package gr.efthymiou.petros.backbaseassignment.features.help;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.application.BaseFragment;


public class HelpFragment extends BaseFragment {

    WebView mHelpWebview;

    public static HelpFragment newInstance() {
        HelpFragment fragment = new HelpFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHelpWebview = view.findViewById(R.id.help_webview);
        mHelpWebview.loadUrl("file:///android_asset/help.html");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_help;
    }

}
