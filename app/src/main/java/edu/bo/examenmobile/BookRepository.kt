package edu.bo.examenmobile

class BookRepository(private val bookDao: IBookDao) {

    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }

    /*suspend fun deleteBooks() {
        bookDao.deleteAll()
    }*/

    fun getListBooks(): List<Book> {
        return bookDao.getList()
    }
}
