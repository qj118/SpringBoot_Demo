package org.demon.repository;

import org.demon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // 继承 JpaRepository 类并且指定泛型为 <实体类名，实体类主键类型>
}
