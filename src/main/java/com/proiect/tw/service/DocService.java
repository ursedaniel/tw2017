package com.proiect.tw.service;

import com.proiect.tw.vo.DocVO;
import com.proiect.tw.vo.search.DocSearchVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 6/11/2017.
 */
public interface DocService {

    Page<DocVO> getDocs(Pageable pageable);
    Page<DocVO> getDocs(DocSearchVO searchVO, Pageable page);
    DocVO getDoc(Integer id);

    void createDoc(DocVO courseVO);
    void updateDoc(Integer id, DocVO docVO);
    void deleteDoc(Integer id);
}
