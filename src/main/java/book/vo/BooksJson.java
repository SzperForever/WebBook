package book.vo;

import lombok.Data;

import java.util.List;

@Data
public class BooksJson {
    private List<BookJson> books;

}
