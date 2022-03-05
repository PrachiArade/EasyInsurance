package perscholas.mycasestudy.service;

import perscholas.mycasestudy.database.entity.Insurance;

import java.util.List;

public interface PropertyServiceInt {

  //  public long add(Insurance property) throws DuplicateRecordException;

    public long add(Insurance property) ;

    public void delete(Insurance property);

    public Insurance findByName(String name);

    public List<Insurance> list();

    public List<Insurance> search(Insurance property);

}
