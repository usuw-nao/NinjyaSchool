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
