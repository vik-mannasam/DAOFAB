package com.daofab.dao;

import com.daofab.dto.ChildDTO;
import com.daofab.dto.ParentDTO;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Data
@Component
public class DataSource {

    Gson gson;
    JsonReader childreader;
    JsonReader parentreader;
    ChildDTO childDTO;
    ParentDTO parentDTO;

    @PostConstruct
    public void init() throws FileNotFoundException {
        gson = new Gson();
        childreader = new JsonReader(new FileReader("src/main/resources/Child.json"));
        parentreader = new JsonReader(new FileReader("src/main/resources/Parent.json"));
        childDTO = gson.fromJson(childreader, ChildDTO.class);
        parentDTO = gson.fromJson(parentreader, ParentDTO.class);
    }
}
