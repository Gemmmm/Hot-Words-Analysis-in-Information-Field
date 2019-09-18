package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Word;
import com.util.DBUtil;

public class WordDaoImpl implements IWordDao{

	@Override
	public Word search(String name) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		String sql = "select * from words where name = ?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Word word = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				word = new Word();
				word.setAll(name, resultSet.getString("expl"),resultSet.getString("type"),resultSet.getInt("val"));
				word.setWebname(resultSet.getString("webname"));
				word.setWebaddr(resultSet.getString("webaddr"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return word;
	}

	@Override
	public void add(String name, String expl,String webname,String webaddr) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		String sql = "select * from words where name = ?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				if (resultSet.getInt(1) > 0) {
					return;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		sql = "insert into words(name,expl,type,webname,webaddr) values(?,?,?,?,?)";
		int x=(int)(1+Math.random()*5);
		String str=null;
		switch(x) {
		case 1:str="大数据";break;
		case 2:str="人工智能";break;
		case 3:str="云计算";break;
		case 4:str="物联网";break;
		case 5:str="区块链";break;
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, expl);
			preparedStatement.setString(3, str );
			preparedStatement.setString(4, webname );
			preparedStatement.setString(5, webaddr );
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}

	@Override
	public List<Word> allWords() {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		String sql = "select * from words";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Word> words = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Word word = new Word();
				word.setAll(resultSet.getString("name"), resultSet.getString("expl"),
						resultSet.getString("type"),resultSet.getInt("val"));
				words.add(word);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return words;
	}
	
	
	
	@Override
	public List<Word> allWords1(String type) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		String sql = "select * from words where type =?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Word> words = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, type);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Word word = new Word();
				word.setAll(resultSet.getString("name"), resultSet.getString("expl"),
						resultSet.getString("type"),resultSet.getInt("val"));
				words.add(word);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return words;
	}

	@Override
	public void add(String name, String expl) {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		String sql = "select * from words where name = ?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				if (resultSet.getInt(1) > 0) {
					return;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		sql = "insert into words(name,expl,type) values(?,?,?)";
		int x=(int)(1+Math.random()*5);
		String str=null;
		switch(x) {
		case 1:str="大数据";break;
		case 2:str="人工智能";break;
		case 3:str="云计算";break;
		case 4:str="物联网";break;
		case 5:str="区块链";break;
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, expl);
			preparedStatement.setString(3, str );
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}
	@Override
	public ArrayList<Word> selectByCompanyName(String name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Connection connection = DBUtil.getConnection();
				String sql = "select name from words where name like ?";
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				ArrayList<Word> words = new ArrayList<>();
				try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, name);
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						Word word = new Word();
						word.setAll(resultSet.getString("name"), resultSet.getString("expl"),resultSet.getString("type"),resultSet.getInt("val"));
						words.add(word);
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					DBUtil.close(resultSet);
					DBUtil.close(preparedStatement);
					DBUtil.close(connection);
				}
				return words;
	}
	
}
