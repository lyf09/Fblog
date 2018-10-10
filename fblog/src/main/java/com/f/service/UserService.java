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
    
    // 通过账号和密码查询用户
    public User findUser(String username, String password) {
	 return userMapper.findUser(username, password);
    }
    
    //添加用户
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
    
    //更新用户信息
    public int updateUser(User user){
    	return userMapper.updateUser(user);
    }
    
    //查询当前用户所有好友
    public User queryAllFriends(int uid) {
       return userMapper.queryAllFriends(uid); 
    }

    //添加好友
    public int addFriend(Friend friend) {
        return  userMapper.addFriend(friend);
      }
    //中间表添加一条信息
    public int addUser_f(int uid,int fid) {
        return userMapper.addUser_f(uid,fid);
    }

    //删除中间表好友信息
    public int deleteUser_f(Map user) {
        return userMapper.deleteUser_f(user);     
    }

    //发表
    public  int addBlog(Blog blog) {
        return userMapper.addBlog(blog);
    }
    public int addUser_b(int uid, int bid) {
        return userMapper.addUser_b(uid,bid);
        
    }
    
    //查询当前用户所有博客
    public User queryAllBlogs(int uid) {
       return userMapper.queryAllBlogs(uid); 
    } 
    
    //查询该用户所有博客2
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
    
  //根据名字查询好友
    public Friend findFriendByName(String fname){
    	return userMapper.findFriendByName(fname);
    }
    
    //删除博客
    public int delBlog(String bid){
    	return userMapper.delBlog(bid);
    }
    
    public int delUserBlog(String bid){
    	return userMapper.delUserBlog(bid);
    }
    
    //查询好友数
    public List<String> numberFriendByFid(int fid){
    	return userMapper.numberFriendByFid(fid);
    }
    public List<String> numberFriendByUid(int uid){
    	return userMapper.numberFriendByUid(uid);
    }

}
