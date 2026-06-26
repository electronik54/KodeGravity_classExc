package com.kodegravity.inclass_exr.api;

import com.kodegravity.inclass_exr.Service.BookService;
import com.kodegravity.inclass_exr.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value="/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping(value="/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getBooksById(@RequestParam int bId) {
        return bookService.getBooksById(bId)[0];
//        return booksById;
    }

//    @PatchMapping(value="/setTwistedgamesToGamesTwisted", produces = MediaType.APPLICATION_JSON_VALUE)
//    public int updateBookById() {
//        return bookService.updateBooksById(3, m);
//    }

    @PostMapping(value="/addNew", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book addNewBook(@RequestBody Book bk) {
         bookService.addNewBook(bk);
         bookService.addNewBook(bk);
         bookService.addNewBook(bk);
         bookService.addNewBook(bk);
         bookService.addNewBook(bk);
         bookService.addNewBook(bk);
         bookService.addNewBook(bk);
         bookService.addNewBook(bk);
        return bookService.addNewBook(bk);
    }




    @PostMapping(value="/addList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> addNewBook(@RequestBody List<Book> bk) {
        return bookService.addNewBook(bk);
    }

    @DeleteMapping(value="/removeById", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addNewBook(@RequestParam int bId) {
        return bookService.removeBookById(bId);
    }
    @DeleteMapping(value="/removeByIds", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addNewBook(@RequestParam Integer[] bId) {
        return bookService.removeBookById(bId);
    }

    @PatchMapping(value="/updateById", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateBookById(@RequestBody Map<String, String> bookDetails) {
        return bookService.updateById(bookDetails);
    }

    @GetMapping(value="/getByPriceAndAvailability", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Book> getByPriceAndAvailability(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice, @RequestParam boolean avail, @RequestParam int page, @RequestParam int pgSize) {
        return bookService.getBookByPriceAndAvailability(minPrice, maxPrice, avail, page, pgSize);
//        return booksById;
    }
    @GetMapping(value="/getByAuthorAndInStock", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getByAuthorAndStockGraterThan(@RequestParam String author, @RequestParam int stock) {
        return bookService.getByAuthorAndStockGraterThan(author, stock);
    }
    @GetMapping(value="/getByAuthor", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getByAuthorAndInStock(@RequestParam String author) {
        return bookService.getByAuthor(author);
    }
    @GetMapping(value="/getByAuthorNative", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getByAuthorNative(@RequestParam String author) {
        return bookService.atlByLangByNativeQuery(author);
    }
}