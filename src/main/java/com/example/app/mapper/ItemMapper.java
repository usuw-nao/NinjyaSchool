package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.app.domain.Item;

@Mapper
public interface ItemMapper {
	//Itemテーブルから全データゲット
	List<Item> selectItems();
	//Itemテーブルにデータを追加
	void addItem(Item item);
	//itemテーブルのIDをもとに削除する
	void deleteById(int id);

}
