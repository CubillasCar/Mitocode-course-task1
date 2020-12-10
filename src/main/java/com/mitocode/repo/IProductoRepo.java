package com.mitocode.repo;

import com.mitocode.model.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepo extends IGenericRepo<Producto, Integer>{
}
