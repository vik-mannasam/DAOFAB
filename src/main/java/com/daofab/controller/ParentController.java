package com.daofab.controller;

import com.daofab.domain.Parent;
import com.daofab.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping(path = "/all")
    public String getAllParents(Model model, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) throws Exception {
        int pageNum = page == null ? 1:page;
        int pageSize = size == null ? 2:size;
        Page<Parent> parents = parentService.getAllParents(PageRequest.of(pageNum, pageSize));
        model.addAttribute("parents", parents);
        int totalPages = parents.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "allTransactions";
    }

    @GetMapping(path = "/child/{parentid}")
    public String getAllChildren(Model model, @PathVariable Integer parentid) throws Exception {
        model.addAttribute("children", this.parentService.getChildOfParent(parentid));
        model.addAttribute("parentid", parentid);
        return "childTransactions";
    }
}
