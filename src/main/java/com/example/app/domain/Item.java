package com.example.app.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
	private String name;
	private Integer number;
	private Integer no;
	private Integer yes;
	private Integer destroy;
	private String text;
	private Date registered;

}
