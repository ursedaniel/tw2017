package com.proiect.tw.controller;

import com.proiect.tw.service.DocService;
import com.proiect.tw.vo.DocVO;
import com.proiect.tw.vo.search.DocSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 6/11/2017.
 */
@RestController
public class DocController {

    @Autowired
    private DocService docService;

    @RequestMapping("/docs")
    public Page<DocVO> getDocs(Pageable pageable) {

        return docService.getDocs(pageable);
    }

    @RequestMapping(value = "/docs/search")
    public Page<DocVO> searchDocs(@ModelAttribute DocSearchVO searchVO, Pageable page) {

        return docService.getDocs(searchVO, page);
    }

    @RequestMapping("/docs/{id}")
    public DocVO getDoc(@PathVariable("id") Integer id) {

        return docService.getDoc(id);
    }

    @RequestMapping(value = "/docs", method = RequestMethod.POST)
    public void createDoc(@RequestBody DocVO courseVO) {

        docService.createDoc(courseVO);
    }

    @RequestMapping(value = "/docs/{id}", method = RequestMethod.PUT)
    public void updateDoc(@PathVariable("id") Integer id, @RequestBody DocVO docVO) {

        docService.updateDoc(id, docVO);
    }

    @RequestMapping(value = "/docs/{id}", method = RequestMethod.DELETE)
    public void deleteDoc(@PathVariable("id") Integer id) {

        docService.deleteDoc(id);
    }
}

