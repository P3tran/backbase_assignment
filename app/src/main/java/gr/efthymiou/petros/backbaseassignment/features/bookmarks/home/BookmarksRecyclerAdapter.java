package gr.efthymiou.petros.backbaseassignment.features.bookmarks.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;

public class BookmarksRecyclerAdapter extends RecyclerView.Adapter<BookmarksRecyclerAdapter.ViewHolder> {

    private List<Bookmark> bookmarks;
    private BookmarkClickListener listener;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewGroup background;
        TextView name;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.bookmark_name);
            background = view.findViewById(R.id.bookmark_item_background);
        }
    }

    @Override
    public BookmarksRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bookmark_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText(bookmarks.get(position).getName());
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onBookmarkClicked(bookmarks.get(position));
            }
        });
    }

    public BookmarksRecyclerAdapter(List<Bookmark> bookmarks, BookmarkClickListener listener) {
        this.bookmarks = bookmarks;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
