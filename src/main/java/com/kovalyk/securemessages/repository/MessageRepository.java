package com.kovalyk.securemessages.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.model.Message;

public interface MessageRepository extends
		PagingAndSortingRepository<Message, Long> {
	public final static String FIND_BY_CUSTOM_QUERY = "SELECT DISTINCT m FROM Message m "
			+ "WHERE m.from = :from and m.to = :to "
			+ "or m.from = :to and m.to = :from order by m.date ASC";
	
	List<Message> findByTo(Account to);
	
	@Query(FIND_BY_CUSTOM_QUERY)
	List<Message> findByToAndFromOrderByDateAsc(@Param("to") Account to, @Param("from") Account from);
	
	Page<Message> findByToAndRead(Account to, boolean read, Pageable pageable);
	
	List<Message> findByToAndRead(Account to, boolean read);
	
	List<Message> findByFrom(Account from);
	
	Long countByToAndRead(Account to, boolean read);
}
