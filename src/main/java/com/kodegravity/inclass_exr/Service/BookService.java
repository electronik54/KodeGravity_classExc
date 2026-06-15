package com.kodegravity.inclass_exr.Service;

import com.kodegravity.inclass_exr.entity.Book;
import com.kodegravity.inclass_exr.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class BookService {

    @Autowired
//    BookDAO bookDAO;
    BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Object[] getBooksById(int bookId) {
        Optional<Book> byId = bookRepo.findById(bookId);
        if (byId.isEmpty()) {
            return new Object[]{null};
        } else {
            return new Object[]{byId.get()};
        }
    }

    public Book addNewBook(Book bk) {
        return bookRepo.save(bk);
    }

    public List<Book> addNewBook(List<Book> bks) {
        return bookRepo.saveAll(bks);
    }

    public boolean removeBookById(int bId) {
        bookRepo.delete(new Book.bookBuilder().setId(bId).build());
        return true;
    }

    public boolean removeBookById(Integer[] bId) {
        bookRepo.deleteAllById(new ArrayList<>(Arrays.asList(bId)));
        return true;
    }

    public boolean updateById(Map<String, String> bookDetails) {

        try {
            Object retVal = getBooksById(Integer.parseInt(bookDetails.get("bookId")))[0];
            if (retVal instanceof Book bookToUpdate) {

                if (bookDetails.containsKey("name") && !bookDetails.get("name").equals(bookToUpdate.getName()))
                    bookToUpdate.setName(bookDetails.get("name"));

                if (bookDetails.containsKey("author") && !bookDetails.get("author").equals(bookToUpdate.getAuthor()))
                    bookToUpdate.setAuthor(bookDetails.get("author"));

                if (bookDetails.containsKey("stock")) {
                    int stock = Integer.parseInt(bookDetails.get("stock"));
                    if (stock != bookToUpdate.getStock())
                        bookToUpdate.setStock(stock);
                }

                if (bookDetails.containsKey("isbn") && !bookDetails.get("isbn").equals(bookToUpdate.getIsbn()))
                    bookToUpdate.setIsbn(bookDetails.get("isbn"));

                if(bookDetails.containsKey("isAvailable")) {
                    boolean isAvailable = Boolean.parseBoolean(bookDetails.get("isAvailable"));
                    if (isAvailable != bookToUpdate.isAvailable())
                        bookToUpdate.setAvailable(isAvailable);
                }

                if(bookDetails.containsKey("price")) {
                    BigDecimal price = new BigDecimal(bookDetails.get("price"));
                    if (price != bookToUpdate.getPrice())
                        bookToUpdate.setPrice(price);
                }

                bookRepo.save(bookToUpdate);
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return false;
    }

    @Transactional(readOnly = true)
    public Page<Book> getBookByPriceAndAvailability(BigDecimal minP, BigDecimal maxP, boolean ava, int page, int pgSize) {
        PageRequest pageable = PageRequest.of(page, pgSize);
        Page<Book> byPriceRangeAndAvailability = bookRepo.findByPriceRangeAndAvailability(minP, maxP, ava, pageable);
        return byPriceRangeAndAvailability;
    }

    public List<Book> getByAuthorAndStockGraterThan(String author, int stock) {
        return bookRepo.findAllByAuthorAndStockEquals(author, stock);
    }
    public List<Book> getByAuthor(String author) {
        return bookRepo.findAllByAuthor(author);
    }
    public List<Book> atlByLangByNativeQuery(String author) {
        return bookRepo.allByLangByNativeQuery(author);
    }

}