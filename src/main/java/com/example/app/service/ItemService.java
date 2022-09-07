package com.example.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Item;

@Service
public class ItemService {

	private List<Item> itemList;

	public ItemService() {
		itemList.add(new Item("手裏剣", 10, 0, 0, 0, "良い", getDate("2020/08/25")));
		itemList.add(new Item("兵糧丸", 10, 0, 0, 0, "良い", getDate("2020/08/26")));
		itemList.add(new Item("苦無", 10, 0, 0, 0, "良い", getDate("2020/08/30")));
		itemList.add(new Item("まきびし", 10, 0, 0, 0, "良い", getDate("2020/09/25")));
		itemList.add(new Item("火薬", 10, 0, 0, 0, "良い", getDate("2020/10/25")));
		itemList.add(new Item("巻物", 10, 0, 0, 0, "良い", getDate("2020/11/02")));

	}

	public List<Item> getItemList() {
		return itemList;
	}

	public Item getItemById(int id) {
		return itemList.get(id);
	}

	private Date getDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return new Date();
		}
	}
}
