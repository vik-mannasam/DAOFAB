package com.daofab.dao;

import com.daofab.domain.Child;
import com.daofab.domain.Parent;
import com.daofab.dto.ParentDTO;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

@Repository
public class ParentRepositoryImpl implements ParentRepository{

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ChildRepository childRepository;

    @Override
    public Iterable<Parent> findAll(Sort sort) {
        return null;
    }

    @SneakyThrows
    @Override
    public Page<Parent> findAll(Pageable pageable) {
        if(pageable.getPageSize() <= 0 || pageable.getPageNumber() <= 0) {
            throw new Exception("invalid page size : "+pageable.getPageSize()+" or page number: " +pageable.getPageNumber());
        }
        List<Parent> sublist = dataSource.parentDTO.getData().subList((pageable.getPageNumber()-1)* pageable.getPageSize(), Math.min((pageable.getPageNumber()-1)* pageable.getPageSize() + pageable.getPageSize(), dataSource.parentDTO.getData().size()));
        for(Parent parent : sublist){
            parent.setPaidAmount(this.childRepository.findPaidAmount(parent.getId()));
        }
        return new PageImpl<>(sublist, pageable, dataSource.parentDTO.getData().size());
    }

    @Override
    public List<Parent> findAll() {
        return dataSource.parentDTO.getData();
    }

    @Override
    public <S extends Parent> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Parent> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Parent> findById(Integer integer) {
        return dataSource.parentDTO.getData().stream().filter(item -> item.getId().equals(integer)).findFirst();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Parent> findAllById(Iterable<Integer> integers) {
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
    public void delete(Parent entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Parent> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
