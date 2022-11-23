package br.com.erudio.bookservice.repository;

import br.com.erudio.bookservice.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
