package com.model;

public class Word {
	String name;
	String expl;
	String type;
	int val;
	String webname;
	String webaddr;
	public String getWebname() {
		return webname;
	}
	public void setWebname(String webname) {
		this.webname = webname;
	}
	public String getWebaddr() {
		return webaddr;
	}
	public void setWebaddr(String webaddr) {
		this.webaddr = webaddr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpl() {
		return expl;
	}
	public void setExpl(String expl) {
		this.expl = expl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public void setAll(String name,String expl,String type,int val) {
		this.name = name;
		this.expl = expl;
		this.type = type;
		this.val = val;
	}
}
