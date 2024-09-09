package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    @Autowired
    private BookDao bookDao;

    public Book getBookById(int bookId){
        return bookDao.getBookById(bookId);
    }

    public Integer createBook(BookRequest bookRequest){
        return bookDao.createBook(bookRequest);
    }

    public void updateBook(Integer bookId,BookRequest bookRequest){
        bookDao.updateBook(bookId,bookRequest);
    }

    public void deleteBookById(int bookId){
        bookDao.deleteBookById(bookId);
    }
}
