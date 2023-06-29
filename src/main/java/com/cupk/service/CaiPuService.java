package com.cupk.service;

import com.cupk.pojo.CaiPu;

import java.util.List;

public interface CaiPuService {
    List<CaiPu> findCaiPuById(int id);
    List<CaiPu> findAll(int page,int size);
    int countPages(int size);
}
