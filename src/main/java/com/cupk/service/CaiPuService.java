package com.cupk.service;

import com.cupk.pojo.CaiPu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CaiPuService {
    CaiPu findCaiPuById(int id);
    List<CaiPu> findAll(int page, int size);
    int countPages(int size);
    int calculateTotalPages(int size);
}

