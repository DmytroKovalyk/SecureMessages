package com.kovalyk.securemessages.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.kovalyk.securemessages.model.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
	public final static String FIND_BY_CUSTOM_QUERY = "SELECT DISTINCT a FROM Account a "
			+ "WHERE UPPER(a.firstName) LIKE :info or UPPER(a.secondName) LIKE :info "
			+ "or UPPER(a.nickName) LIKE :info or UPPER(a.email) LIKE :info";
	
	Account findAccountByEmail(String email);

	@Query(FIND_BY_CUSTOM_QUERY)
	List<Account> findAccountByInfo(
			@Param("info") String info);

}
