package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Word;

public interface IWordDao {
	public Word search(String name);
	public void add(String name,String expl,String webname,String webaddr);
	public void add(String name,String expl);
	public List<Word> allWords();
	public List<Word> allWords1(String type);
	public ArrayList<Word> selectByCompanyName(String name);
}
