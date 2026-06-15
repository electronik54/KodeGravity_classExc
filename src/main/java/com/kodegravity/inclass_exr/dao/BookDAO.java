package com.kodegravity.inclass_exr.dao;

import com.kodegravity.inclass_exr.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class BookDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks() {
        RowMapper<Book> bookRowMapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book.bookBuilder()
                        .setId(rs.getInt("BOOK_ID"))
                        .setName(rs.getString("NAME"))
                        .setStock(rs.getInt("STOCK"))
                        .setIsAvailable(rs.getBoolean("IS_AVAILABLE"))
                        .setIsbn(rs.getString("ISBN"))
                        .setAuthor(rs.getString("AUTHOR"))
                        .build();
            }
        };

        return jdbcTemplate.query("SELECT * FROM BOOK", bookRowMapper);
    }

    public int updateBookById(int bookId, Map<String, Object> fieldsToUpdate) {
        try {

            StringBuilder sql = new StringBuilder("UPDATE BOOK SET ");
            List<Object> params = new ArrayList<>();
            for (Map.Entry<String, Object> entry : fieldsToUpdate.entrySet()) {
                if (!params.isEmpty()) {
                    sql.append(", ");
                }

                sql.append(entry.getKey()).append(" = ?");
                params.add(entry.getValue());
            }
            sql.append(" WHERE BOOK_ID = ?");
            params.add(bookId);

            return jdbcTemplate.update(sql.toString(), params.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int addNewBook() {
        try {
            String sql = "INSERT INTO BOOK (BOOK_ID, NAME, STOCK, IS_AVAILABLE, ISBN, AUTHOR) VALUES (5, 'NEW BOOK', 44, TRUE, '122312-KD321', 'NOT ME!')";
            return jdbcTemplate.update(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}