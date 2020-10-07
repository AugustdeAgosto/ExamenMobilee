package edu.bo.examenmobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_row.view.*

class BookListAdapter(val items: ArrayList<Book>, val context: Context): RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_row, parent, false)
        return BookListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        val book = items.get(position)
        holder.itemView.tvId.text = book.id.toString()
        holder.itemView.tvTitle.text = book.title
        holder.itemView.tvPages.text = book.pages
        holder.itemView.tvEditorial.text = book.editorial
        holder.itemView.tvAuthor.text = book.author
        holder.itemView.tvDescription.text = book.description

        holder.itemView.tvPhotoUrl.text = book.photoURL
        val picasso = Picasso.get()
        picasso.load(book.photoURL).into(holder.itemView.ImageViewBook)
    }

    class BookListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}
