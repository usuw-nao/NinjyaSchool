package com.example.app.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data

public class Item {
	
	private Integer id;
	
	@NotBlank(message = "道具名を入力してください")
	@Size(max = 30, message = "30字以内で入力してください")
	private String itemId;
	
	@NotBlank(message = "名前を入力してください")
	@Size(max = 30, message = "30字以内で入力して下さい")
	private String name;
	
	@Min(0)
	@Max(100)
	private Integer number;
	
	@Min(0)
	@Max(100)
	private Integer no;
	
	@Min(0)
	@Max(100)
	private Integer yes;
	
	@Min(0)
	@Max(100)
	private Integer destroy;
	
	@Size(max = 255)
	private String text;
	

}
