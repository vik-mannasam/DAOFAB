package com.daofab.dao;

import com.daofab.domain.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends PagingAndSortingRepository<Parent, Integer> {

    Page<Parent> findAll(Pageable pageable);

    List<Parent> findAll();
}
