package com.mitocode.service.Impl;

import com.mitocode.model.Venta;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IVentaRepo;
import com.mitocode.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {

    @Autowired
    private IVentaRepo repo;

    @Override
    protected IGenericRepo<Venta, Integer> getRepo() {
        return repo;
    }
}
