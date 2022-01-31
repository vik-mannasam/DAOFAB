package com.daofab.dao;

import com.daofab.domain.Child;
import com.daofab.dto.ChildParentDTO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.List;

@Repository
public interface ChildRepository extends PagingAndSortingRepository<Child, Integer> {

    List<Child> findByParentid(Integer parentid) throws Exception;

    Integer findPaidAmount(Integer parentid) throws Exception;
}
