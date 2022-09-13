package com.example.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Item;
import com.example.app.mapper.ItemMapper;
import com.example.app.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService service;

	
	@GetMapping
	public String list(Model model)throws Exception {
		model.addAttribute("items",service.getItemList());
		return "items/list";
	}
	
	//道具追加フォームの表示
	@GetMapping("add")
	public String add(Model model)throws Exception {
		Item item = new Item();
		model.addAttribute("item",item);
		return "addItem";
	}
	
	//道具追加
	@PostMapping("add")
	public String add(@Valid Item item, Errors errors)throws Exception{
		if(errors.hasErrors()) {
			return "addItem";
		}
		service.addItem(item);
		return "redirect:/";
	}
	
	

	@GetMapping("/addDone")
	public String addDone(HttpSession session, Model model) {
		String name = (String) session.getAttribute("itemName");
		Integer number = (Integer) session.getAttribute("itemNumber");
		Integer no = (Integer) session.getAttribute("itemNo");
		Integer yes = (Integer) session.getAttribute("itemYes");
		Integer destroy = (Integer) session.getAttribute("itemDestroy");
		String text = (String) session.getAttribute("itemText");

		session.invalidate();

		model.addAttribute("name", name);
		model.addAttribute("number", number);
		model.addAttribute("no", no);
		model.addAttribute("yes", yes);
		model.addAttribute("destroy", destroy);
		model.addAttribute("text", text);

		return "item/addDone";
	}

	@GetMapping("/show/{id}")
	public String show(@PathVariable Integer id, Model model) {
		if (id.equals(1)) {
			model.addAttribute("info", "とてもいい手裏剣です");
		} else if (id.equals(2)) {
			model.addAttribute("info", "とてもいい兵糧丸です");
		} else {
			return "redirect:/item";
		}
		return "item/show";

	}

}
