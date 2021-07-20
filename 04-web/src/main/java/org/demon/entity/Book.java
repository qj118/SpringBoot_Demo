package org.demon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Demon
 * create on 2021/7/20-15:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookName;
    private String bookAuthor;
}
