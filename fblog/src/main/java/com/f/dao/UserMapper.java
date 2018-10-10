package com.f.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.f.pojo.Blog;
import com.f.pojo.Friend;
import com.f.pojo.User;

public interface UserMapper {

   // 通过账号和密码查询用户
    public User findUser(@Param("username")String username, @Param("password")String password);
    
    //添加用户
    public int addUser(User user);
    
    //更新用户信息
    public int updateUser(User user);
    
    // 添加好友
    public int addFriend(Friend friend);

    //中间表信息的插入
    public int addUser_f(@Param("uid")int uid, @Param("fid")int fid);
    
    //查询该用户所有好友
    public User queryAllFriends(@Param("uid")int uid);
    
    //删除好友
    public int deleteUser_f(Map user);
    
    //发表说说
    public int addBlog(Blog blog);
    public int addUser_b(@Param("uid")int uid, @Param("bid")int bid);
    
    //查询该用户所有博客
    public User queryAllBlogs(@Param("uid")int uid);
    
    //查询该用户所有博客2
    public List<String> queryBlogId(@Param("uid")int uid);
    public String queryUserId(int bid);
    public String queryName(String id);
    public List<Blog> cqueryAllBlog(int bid);
    public List cqueryAllBlogs();
    
    //根据名字查询好友
    public Friend findFriendByName(String fname);

    //删除博客
    public int delBlog(String bid);
    public int delUserBlog(String bid);
    
    //查询好友数
    public List<String> numberFriendByFid(int fid);
    public List<String> numberFriendByUid(int uid);

}
