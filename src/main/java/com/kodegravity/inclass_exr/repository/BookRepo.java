package com.kodegravity.inclass_exr.repository;

import com.kodegravity.inclass_exr.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

    //Native SQL Query: this won't be processed by Hibernate
    @Query(nativeQuery = true, value = "select * from BOOK where LANG =:lang")
    List<Book> allByLangByNativeQuery(String tang);

    //HBL-Hibernate Query Language (or JPQL-Jakarta Persistent Query Language)
    @Query("""
        SELECT b FROM Book b
        WHERE (b.price >= :minPrice)
          AND (b.price <= :maxPrice)
          AND (b.isAvailable = :available)
    """)
    Page<Book> findByPriceRangeAndAvailability(
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("available") Boolean available,
            Pageable pageable
    );

    // region Hibernate Generate queries
    List<Book> findAllByAuthorAndStockEquals(String author, int stock);
    List<Book> findAllByAuthor(String author);
    // endregion
}
