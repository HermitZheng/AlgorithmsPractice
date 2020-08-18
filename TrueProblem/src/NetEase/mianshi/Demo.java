package NetEase.mianshi;

import java.util.*;

/**
 * 请实现按书籍类型分类功能,注意：在同一个分类下书籍名称不可重复,如有重复请过滤,留下发版时间最新的书籍
 */
public class Demo {

    static class Book {

        /**
         * 书籍类型
         */
        private Integer bookType;

        /**
         * 书籍名称
         */
        private String bookName;

        /**
         * 发版时间
         */
        private Date publishDate;

        public Integer getBookType() {
            return bookType;
        }

        public String getBookName() {
            return bookName;
        }

        public Date getPublishDate() {
            return publishDate;
        }
    }
    
    public static Map<Integer, Set<Book>> classify(List<Book> bookList) {

        return null;
    }

}