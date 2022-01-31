package com.daofab.service;

import com.daofab.dao.ChildRepository;
import com.daofab.dao.ParentRepository;
import com.daofab.domain.Child;
import com.daofab.domain.Parent;
import com.daofab.dto.ChildParentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    public Page<Parent> getAllParents(Pageable pageable) throws Exception {
        return parentRepository.findAll(pageable);
    }

    public List<ChildParentDTO> getChildOfParent(Integer parentId) throws Exception {
        List<Child> children = this.childRepository.findByParentid(parentId);
        Optional<Parent> parent = this.parentRepository.findById(parentId);
        if (!parent.isPresent()){
            throw new Exception("No parent found");
        }
        List<ChildParentDTO> list = new ArrayList<>();
        children.forEach(child -> {
            ChildParentDTO dto = new ChildParentDTO();
            dto.setId(child.getId());
            dto.setPaidAmount(child.getPaidAmount());
            dto.setSender(parent.get().getSender());
            dto.setReceiver(parent.get().getReceiver());
            dto.setTotalAmount(parent.get().getTotalAmount());
            list.add(dto);
        });
        return list;
    }
}
