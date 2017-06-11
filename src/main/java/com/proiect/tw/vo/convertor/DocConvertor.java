package com.proiect.tw.vo.convertor;

import com.proiect.tw.model.Doc;
import com.proiect.tw.vo.DocVO;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/11/2017.
 */
@Service
public class DocConvertor {

    public DocVO toVO(Doc doc){
        DocVO docVO = new DocVO();

        docVO.setId(doc.getId());
        docVO.setCourse_id(doc.getCourse_id());
        docVO.setTitle(doc.getTitle());
        docVO.setLink(doc.getLink());

        return docVO;
    }

    public Doc fromVO(DocVO docVO){
        Doc doc = new Doc();

        doc.setId(docVO.getId());
        doc.setCourse_id(docVO.getCourse_id());
        doc.setTitle(docVO.getTitle());
        doc.setLink(docVO.getLink());

        return doc;
    }
}
