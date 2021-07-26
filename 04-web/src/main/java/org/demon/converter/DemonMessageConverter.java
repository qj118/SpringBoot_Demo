package org.demon.converter;

import org.demon.entity.Book;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author Demon
 * create on 2021/7/26-13:31
 */
public class DemonMessageConverter implements HttpMessageConverter<Book> {

    /**
     * 可读方法，即 controller 参数中包含某个 @RequestBody 类型，该 converter 是否可读
     * @param clazz
     * @param mediaType
     * @return
     */
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    /**
     * 可写方法，即 controller 返回值类型为 clazz 时，可以写出
     * @param clazz
     * @param mediaType
     * @return
     */
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Book.class);
    }

    /**
     * 返回请求头中支持的 mediaType
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/xxx-demon");
    }

    /**
     * 将读入信息转换为 Book
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    public Book read(Class<? extends Book> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /**
     * 将 Book 转换为输出流
     * @param book
     * @param contentType
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    public void write(Book book, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String data = book.getBookName() + "-" + book.getBookAuthor();

        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes(Charset.forName("UTF-8")));
    }
}
