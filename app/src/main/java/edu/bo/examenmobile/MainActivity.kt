package edu.bo.examenmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.toolbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)

            repository.insert(Book("Prueba","00000", "prueba","prueba","prueba","https://imgur.com/gallery/kgcFOoO"))

            val lista = repository.getListBooks()

            recyclerView.adapter = BookListAdapter(lista as ArrayList<Book>, applicationContext)

            var linearLayoutManager = LinearLayoutManager(applicationContext)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = linearLayoutManager
        }*/
        val list = arrayListOf<Book>()
        list.add(Book("Luna de pluton", "269", "2222", "Angel David", "libro de Horror", "https://images.cdn2.buscalibre.com/fit-in/360x360/09/19/091924b1c743e38679fbb327d9355174.jpg"))
        list.add(Book("La muerte quiere morir", "300", "JV", "Gutierrez", "Fantasia", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1540154270l/42409474._SX318_.jpg"))
        list.add(Book("Sibelle para Benjami", "200", "JV", "Gutierrez", "Fantasia", "https://1.bp.blogspot.com/-zN1k6tQjypw/UBXL5lDZvPI/AAAAAAAAAcQ/90hj34_LCs4/s1600/Sibelle+para+Benjam%C3%ADn.jpg"))
        list.add(Book("Neuromancer", "2001", "JV", "Gutierrez", "Fantasia", "https://images-na.ssl-images-amazon.com/images/I/91yXdjXLTjL.jpg"))

        val bookListAdapter = BookListAdapter(list, applicationContext)
        recyclerView.adapter = bookListAdapter
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        supportActionBar.let {
            it?.setDisplayHomeAsUpEnabled(true)
            it?.setDisplayShowHomeEnabled(true)
            setSupportActionBar(toolbar)
        }

        val addFloatingButon: View = findViewById(R.id.floatingActionButton)
        addFloatingButon.setOnClickListener {
            startActivity(Intent(this, addBookActivity::class.java))
        }

    }
}