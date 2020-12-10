package com.mitocode.repo;

import com.mitocode.model.Venta;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepo extends IGenericRepo<Venta, Integer> {
}
