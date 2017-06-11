package com.proiect.tw.repository;

import com.proiect.tw.model.Doc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by JACK on 6/11/2017.
 */
public interface DocRepository extends JpaRepository<Doc, Integer>, JpaSpecificationExecutor<Doc> {
}
