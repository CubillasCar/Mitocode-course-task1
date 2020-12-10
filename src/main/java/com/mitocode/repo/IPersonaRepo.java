package com.mitocode.repo;

import com.mitocode.model.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepo extends IGenericRepo<Persona, Integer>{
}
