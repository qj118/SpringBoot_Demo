package org.demon.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_book")
public class Book {

    // 以下两个字段不在数据库内
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

    private int id;
    private String bookName;
    private String bookAuthor;
}
