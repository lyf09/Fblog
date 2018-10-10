package com.f.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f.dao.UserMapper;
import com.f.pojo.Blog;
import com.f.pojo.Friend;
import com.f.pojo.User;


@SuppressWarnings("unused")
@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    // ͨ���˺ź������ѯ�û�
    public User findUser(String username, String password) {
	 return userMapper.findUser(username, password);
    }
    
    //����û�
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
    
    //�����û���Ϣ
    public int updateUser(User user){
    	return userMapper.updateUser(user);
    }
    
    //��ѯ��ǰ�û����к���
    public User queryAllFriends(int uid) {
       return userMapper.queryAllFriends(uid); 
    }

    //��Ӻ���
    public int addFriend(Friend friend) {
        return  userMapper.addFriend(friend);
      }
    //�м�����һ����Ϣ
    public int addUser_f(int uid,int fid) {
        return userMapper.addUser_f(uid,fid);
    }

    //ɾ���м�������Ϣ
    public int deleteUser_f(Map user) {
        return userMapper.deleteUser_f(user);     
    }

    //����
    public  int addBlog(Blog blog) {
        return userMapper.addBlog(blog);
    }
    public int addUser_b(int uid, int bid) {
        return userMapper.addUser_b(uid,bid);
        
    }
    
    //��ѯ��ǰ�û����в���
    public User queryAllBlogs(int uid) {
       return userMapper.queryAllBlogs(uid); 
    } 
    
    //��ѯ���û����в���2
    public List<String> queryBlogId(int uid){
    	return userMapper.queryBlogId(uid);
    }
    public String queryUserId(int bid){
    	return userMapper.queryUserId(bid);
    }
    public String queryName(String id){
    	return userMapper.queryName(id);
    }
    public List<Blog> cqueryAllBlog(int bid){
    	return userMapper.cqueryAllBlog(bid);
    }
    public List cqueryAllBlogs(){
    	return userMapper.cqueryAllBlogs();
    }
    
  //�������ֲ�ѯ����
    public Friend findFriendByName(String fname){
    	return userMapper.findFriendByName(fname);
    }
    
    //ɾ������
    public int delBlog(String bid){
    	return userMapper.delBlog(bid);
    }
    
    public int delUserBlog(String bid){
    	return userMapper.delUserBlog(bid);
    }
    
    //��ѯ������
    public List<String> numberFriendByFid(int fid){
    	return userMapper.numberFriendByFid(fid);
    }
    public List<String> numberFriendByUid(int uid){
    	return userMapper.numberFriendByUid(uid);
    }

}
