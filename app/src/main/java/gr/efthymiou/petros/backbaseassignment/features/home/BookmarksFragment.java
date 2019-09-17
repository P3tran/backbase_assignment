package gr.efthymiou.petros.backbaseassignment.features.home;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.base.BaseFragment;


public class BookmarksFragment extends BaseFragment implements BookmarksView {

    private RecyclerView mBookmarksRv;
    private BookmarksPresenter presenter;

    public BookmarksFragment() { }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bookmarks;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBookmarksRv = view.findViewById(R.id.bookmarks_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mBookmarksRv.setLayoutManager(layoutManager);
        presenter = new BookmarksPresenterImpl(this);
        presenter.getBookmarks(getContext());
    }

    @Override
    public void displayBookmarks(List<Bookmark> bookmarks) {

        BookmarksRecyclerAdapter adapter = new BookmarksRecyclerAdapter(bookmarks, new BookmarkClickListener() {
            @Override
            public void onBookmarkClicked(Bookmark bookmark) {
                //TODO
            }
        });

        mBookmarksRv.setAdapter(adapter);

    }

    @Override
    public void displayEmptyState() {

    }

    @Override
    public void displayError(int errorMessageId) {
        //TODO
    }
}
