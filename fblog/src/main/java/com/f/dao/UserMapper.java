package com.f.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.f.pojo.Blog;
import com.f.pojo.Friend;
import com.f.pojo.User;

public interface UserMapper {

   // ͨ���˺ź������ѯ�û�
    public User findUser(@Param("username")String username, @Param("password")String password);
    
    //����û�
    public int addUser(User user);
    
    //�����û���Ϣ
    public int updateUser(User user);
    
    // ��Ӻ���
    public int addFriend(Friend friend);

    //�м����Ϣ�Ĳ���
    public int addUser_f(@Param("uid")int uid, @Param("fid")int fid);
    
    //��ѯ���û����к���
    public User queryAllFriends(@Param("uid")int uid);
    
    //ɾ������
    public int deleteUser_f(Map user);
    
    //����˵˵
    public int addBlog(Blog blog);
    public int addUser_b(@Param("uid")int uid, @Param("bid")int bid);
    
    //��ѯ���û����в���
    public User queryAllBlogs(@Param("uid")int uid);
    
    //��ѯ���û����в���2
    public List<String> queryBlogId(@Param("uid")int uid);
    public String queryUserId(int bid);
    public String queryName(String id);
    public List<Blog> cqueryAllBlog(int bid);
    public List cqueryAllBlogs();
    
    //�������ֲ�ѯ����
    public Friend findFriendByName(String fname);

    //ɾ������
    public int delBlog(String bid);
    public int delUserBlog(String bid);
    
    //��ѯ������
    public List<String> numberFriendByFid(int fid);
    public List<String> numberFriendByUid(int uid);

}
