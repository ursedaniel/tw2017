package com.proiect.tw.service.impl;

import com.proiect.tw.exception.BusinessException;
import com.proiect.tw.model.Doc;
import com.proiect.tw.repository.DocRepository;
import com.proiect.tw.repository.specification.DocSpecification;
import com.proiect.tw.service.DocService;
import com.proiect.tw.vo.DocVO;
import com.proiect.tw.vo.convertor.DocConvertor;
import com.proiect.tw.vo.search.DocSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/11/2017.
 */
@Service
public class DocServiceImpl implements DocService {

    @Autowired
    private DocRepository docRepository;

    @Autowired
    private DocConvertor docConvertor;

    private Page<DocVO> convertToVO(Page<Doc> page) {

        return page.map(docConvertor::toVO);
    }

    @Override
    public Page<DocVO> getDocs(Pageable pageable) {

        return convertToVO(docRepository.findAll(pageable));
    }

    @Override
    public Page<DocVO> getDocs(DocSearchVO searchVO, Pageable pageable) {

        return convertToVO(docRepository.findAll(DocSpecification.searchByVO(searchVO), pageable));
    }

    @Override
    public DocVO getDoc(Integer id) {

        Doc doc = docRepository.findOne(id);

        if (doc == null) {
            throw new BusinessException( "Documentul cu id-ul " + id + " nu exista in baza de date! ");
        }

        return docConvertor.toVO(doc);
    }

    @Override
    public void createDoc(DocVO docVO) {

        docRepository.save(docConvertor.fromVO(docVO));
    }

    @Override
    public void updateDoc(Integer id, DocVO docVO) {

        if (docRepository.findOne(id) == null) {
            throw new BusinessException(" Documentul cu id-ul " + id + " nu exista in baza de date! ");
        }
        else {
            docRepository.save(docConvertor.fromVO(docVO));
        }
    }

    @Override
    public void deleteDoc(Integer id) {

        docRepository.delete(id);
    }
}
