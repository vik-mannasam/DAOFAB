package com.daofab.dao;

import com.daofab.domain.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ChildRepositoryImpl implements ChildRepository{

    @Autowired
    private DataSource dataSource;


    @Override
    public List<Child> findByParentid(Integer parentid){
        List<Child> children = dataSource.childDTO.getData().stream().filter(item -> item.getParentId().equals(parentid)).collect(Collectors.toList());
        return children;
    }

    @Override
    public Integer findPaidAmount(Integer parentid){
        Integer sum =  dataSource.childDTO.getData().stream().filter(item -> item.getParentId().equals(parentid)).mapToInt(Child::getPaidAmount).sum();
        return sum;
    }

    @Override
    public Iterable<Child> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Child> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Child> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Child> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Child> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Child> findAll() {
        return null;
    }

    @Override
    public Iterable<Child> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Child entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Child> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
