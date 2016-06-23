package com.github.pierry.cartolapp.domain.contracts;

import java.util.List;

public interface ICrud<T> {

  List<T> get();

  T getById(long id);

  long create(T item);

  boolean update(T item);

  boolean delete(long id);
}
