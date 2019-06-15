package org.dao;

import java.util.List;

import org.module.Record;

public interface Dao<T> {

	T get(int id);

	int add(T ac);

	int update(T ac);

	int del(int id);

	

}