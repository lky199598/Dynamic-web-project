package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import JavaBean.Message;
import db.DBAccess;

public class MessageDao_1 {

	public List<Message> selectMessageInformationByPage(Map<String, Object> parameter) {

		// System.out.println(command+"\t"+description);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			sqlSession = dbAccess.getSqlSession();
			
			//接口式编程的规范
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.selectMessageInformationByPage(parameter);
			
			return  messageList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return null;
	}

	
	public List<Message> selectMessageInformation(Map<String, Object> parameter) {

		// System.out.println(command+"\t"+description);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			sqlSession = dbAccess.getSqlSession();
			
			//接口式编程的规范
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.selectMessageInformation(parameter);
			 System.out.println("messageList: "+messageList.size());
			return  messageList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return null;
	}

	
	public int messageCount(Message message) {

		// System.out.println(command+"\t"+description);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int count=0;
		try {
			sqlSession = dbAccess.getSqlSession();
			//接口式编程的规范
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			count = imessage.messageCount(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return count;
	}
		
	
	public boolean Delete_One_Message(int id) {

		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();

			sqlSession.delete("Delete_One_Message", id);
			sqlSession.commit();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return false;
	}
	
	public boolean Delete_Batch_Message(List<Integer> ids) {

		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();

			sqlSession.delete("Delete_Batch_Message", ids);
			sqlSession.commit();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		MessageDao_1 m = new MessageDao_1();
	
	}
}
