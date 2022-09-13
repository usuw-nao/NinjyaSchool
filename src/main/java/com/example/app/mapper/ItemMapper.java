package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.app.domain.Item;

@Mapper
public interface ItemMapper {
	// Itemテーブルから全データゲット
	List<Item> selectAll() throws Exception;

	Item selectById(Integer id) throws Exception;

	// Itemテーブルにデータを追加
	void insert(Item item) throws Exception;

	void update(Item item) throws Exception;

	// itemテーブルのIDをもとに削除する
	void deleteById(Integer id) throws Exception;

}
