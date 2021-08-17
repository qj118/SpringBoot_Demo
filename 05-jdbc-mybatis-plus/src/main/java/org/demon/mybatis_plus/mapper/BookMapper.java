package org.demon.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.demon.mybatis_plus.entity.Book;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
