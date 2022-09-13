package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.ItemType;

public interface ItemTypeMapper {
	
	List<ItemType>selectAll()throws Exception;

}
