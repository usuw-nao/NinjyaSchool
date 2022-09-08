package com.example.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.mapper.ItemMapper;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemMapper mapper;

	@GetMapping
	public String list() {
		return "item/list";
	}

	@GetMapping("/add")
	public String addGet() {
		return "item/add";
	}

	@PostMapping("/add")
	public String addPost(@RequestParam String name, @RequestParam Integer number, @RequestParam Integer no,
			@RequestParam Integer yes, @RequestParam Integer destroy, @RequestParam String text, HttpSession session) {
		if (name.isBlank()) {
			return "item/add";
		}
		session.setAttribute("itemName", name);
		session.setAttribute("itemNumber", number);
		session.setAttribute("itemNo", no);
		session.setAttribute("itemYes", yes);
		session.setAttribute("itemDestroy", destroy);
		session.setAttribute("itemText", text);
		return "redirect:/item/addDone";
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
