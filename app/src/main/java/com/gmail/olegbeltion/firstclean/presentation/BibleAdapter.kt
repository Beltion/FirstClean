package com.gmail.olegbeltion.firstclean.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.olegbeltion.firstclean.R

class BibleAdapter(private val retry: Retry) : RecyclerView.Adapter<BibleAdapter.BibleViewHolder>() {

    private val books = ArrayList<BookUi>()

    fun update(new: List<BookUi>) {
        books.clear()
        books.addAll(new)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = when (books[position]) {
        is BookUi.Base -> 0
        is BookUi.Fail -> 1
        is BookUi.Testament -> 2
        is BookUi.Progress -> 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        0 -> BibleViewHolder.Base(R.layout.book_layout.makeView(parent))
        1 -> BibleViewHolder.Fail(R.layout.fail_fullscreen.makeView(parent), retry)
        2 -> BibleViewHolder.Base(R.layout.testament.makeView(parent))
        else -> BibleViewHolder.FullscreenProgress(R.layout.progress_fullscreen.makeView(parent))
    }


    override fun onBindViewHolder(holder: BibleViewHolder, position: Int) =
        holder.bind(books[position])

    override fun getItemCount() = books.size

    abstract class BibleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        open fun bind(book: BookUi) {
        }

        class FullscreenProgress(v: View) : BibleViewHolder(v)

        class Base(v: View) : BibleViewHolder(v) {
            private val name = itemView.findViewById<TextView>(R.id.textView)
            override fun bind(book: BookUi) {
                book.map(object : BookUi.StringMapper {
                    override fun map(t: String) {
                        name.text = t
                    }

                })
            }
        }

        class Fail(v: View, private val retry: Retry) : BibleViewHolder(v) {
            private val msg = itemView.findViewById<TextView>(R.id.msgTextView)
            private val tryAgainBtn = itemView.findViewById<Button>(R.id.tryAgainBtn)

            override fun bind(book: BookUi) {
                book.map(object : BookUi.StringMapper {
                    override fun map(t: String) {
                        msg.text = t
                    }

                })
                tryAgainBtn.setOnClickListener {
                    retry.tryAgain()
                }
            }

        }
    }
}

interface Retry{
    fun tryAgain()
}

private fun Int.makeView(parent: ViewGroup) =
    LayoutInflater.from(parent.context).inflate(this, parent, false)