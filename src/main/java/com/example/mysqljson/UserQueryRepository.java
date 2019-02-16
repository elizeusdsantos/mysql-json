package com.example.mysqljson;

import com.example.mysqljson.domain.UserQuery;
import org.springframework.data.repository.CrudRepository;

public interface UserQueryRepository extends CrudRepository<UserQuery, Long> {

}
