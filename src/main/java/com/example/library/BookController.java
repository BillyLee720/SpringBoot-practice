package com.example.library;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable Integer bookId) {
        Book book = bookService.getBookById(bookId);

        if(book != null) {
            return ResponseEntity.status(200).body(book);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {
        Integer bookId = bookService.createBook(bookRequest);
        Book book = bookService.getBookById(bookId);

        return ResponseEntity.status(201).body(book);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @RequestBody BookRequest bookRequest) {
        Book book = bookService.getBookById(bookId);

        if(book == null){
            return ResponseEntity.status(404).build();
        }
        bookService.updateBook(bookId,bookRequest);

        Book updatedBook = bookService.getBookById(bookId);

        return ResponseEntity.status(200).body(updatedBook);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBookById(bookId);

        return ResponseEntity.status(204).build();
    }
}
