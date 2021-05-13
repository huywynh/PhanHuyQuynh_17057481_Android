package com.example.lab_05_recycleview_horizontalvertical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {


    private Context context;
    private List<Book> books;

    public BookAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.book_layout, parent, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        Book book = books.get(position);

        holder.ivBookImage.setImageResource(book.getImage());
        holder.tvBookName.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivBookImage;
        private TextView tvBookName;


        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            ivBookImage = itemView.findViewById(R.id.ivBookImage);
            tvBookName= itemView.findViewById(R.id.tvBookName);

        }
    }
}
