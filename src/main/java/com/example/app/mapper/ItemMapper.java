package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.app.domain.Item;

@Mapper
public interface ItemMapper {

	@Select("SELECT * FROM items")
	List<Item> findAll();

}
