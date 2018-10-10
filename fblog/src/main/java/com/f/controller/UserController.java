package com.f.controller;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthScrollBarUI;

import org.omg.CORBA.NVList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.f.pojo.Blog;
import com.f.pojo.Friend;
import com.f.pojo.User;
import com.f.service.UserService;
import com.mysql.jdbc.Blob;

/**
 * 用户控制器类
 */
@Controller
public class UserController {
	// 依赖注入
	@Autowired
	private UserService userService;

        //前往登录界面
        @RequestMapping(value="/login.do",method=RequestMethod.GET)
        public String toLogin() {
            return "login-form"; 
        }
        //登录逻辑处理  //TODO tel的验证
        @RequestMapping(value="/login.do",method=RequestMethod.POST)
        public String login(String username,String password,Model model,HttpSession session) {
             // 通过账号和密码查询用户
                User user = userService.findUser(username, password);
                if(user != null){               
                        // 将用户对象添加到Session
                        session.setAttribute("USER_SESSION", user);
                        // 跳转到主页面
                        //return "redirect:queryAllFriend.do";
                        return "redirect:index.do";
                }
                model.addAttribute("msg", "账号或密码错误，请重新输入！");
                // 返回到登录页面
                return "login-form";
        }
        
        
        //前往注册页面
        @RequestMapping(value="/register.do",method=RequestMethod.GET)
        public String toRegister() {
            return "register-form"; 
        }
        //注册逻辑处理
        @RequestMapping(value="/register.do",method=RequestMethod.POST)
        public String register(User u,Model mv) {
            String username = u.getUsername();
            String password = u.getPassword();
            //System.out.println(username);
            User user = userService.findUser(username, password);
           // System.out.println(user);
            if(user ==null) {
                int result = userService.addUser(u);
                if(result >0) {
                    return "redirect:login.do";
                }
            }
            mv.addAttribute("msg", "用户名已存在");
            return "register-form"; 
        } 
 
        //首页访问
        @RequestMapping(value = "/index.do")
        public ModelAndView toIndex(HttpServletRequest request) {
            ModelAndView  mv = new ModelAndView();
            int x,y,z;
            //在进入主页时先把数据加载进去
            User u= (User) request.getSession().getAttribute("USER_SESSION");
            System.out.println(u);
            List<Blog> blogs = userService.cqueryAllBlogs();
            List<String> num0= userService.numberFriendByUid(u.getId());
            List<String> num2 = userService.queryBlogId(u.getId());
            List<String> num1 = userService.numberFriendByFid(u.getId());
            System.out.println(num0);
            System.out.println(num2);
            System.out.println(num1);
            int[] num = null;
            if(num0.size() >0){
            	x = num0.size();
            }else {
            	x = 0;
            }
            if(num1.size() >0){
            	y = num1.size();
            }else {
            	y = 0;
            }
            if(num2.size() >0){
            	z = num2.size();
            }else {
            	z = 0;
            }
            num = new int[]{x,y,z};
            u.setNum(num);
            System.out.println(blogs);
            if(blogs != null){
            	int i=0;
            	List<Object[]> names = new ArrayList<Object[]>();
            	for(Blog b:blogs){
                    byteToFile(b.getBimg(), "E:/tomcat/apache-tomcat-9.0.0.M10/webapps/fblog/images", "head"+i+".jpg");
                    Object[] name = {b.getContactus(),userService.queryName(userService.queryUserId(b.getId())),"head"+i,b.getId()};
                    if(name != null){
                        names.add(name);
                    }
                    i++;
            	}
            	u.setNames(names);
                u.setBlogs(blogs);
            }
           // System.out.println(user);
            mv.addObject("user", u);
            mv.setViewName("index");
         return mv;
        }	
        
        public static void byteToFile(byte[] buf, String filePath, String fileName)  
        {  
            BufferedOutputStream bufferOut = null;  
            FileOutputStream fileOut = null;  
            File file = null;  
            try  
            {  
                File resFile = new File(filePath);  
                if (!resFile.exists() && resFile.isDirectory())  
                {  
                    resFile.mkdirs();  
                }  
                file = new File(filePath + File.separator + fileName);  
                System.out.println(file);
                fileOut = new FileOutputStream(file);  
                bufferOut = new BufferedOutputStream(fileOut);  
                bufferOut.write(buf);  
            }  
            catch (Exception e)  
            {  
                e.printStackTrace();  
            }  
            finally  
            {  
                if (bufferOut != null)  
                {  
                    try  
                    {  
                        bufferOut.close();  
                    }  
                    catch (IOException e)  
                    {  
                        e.printStackTrace();  
                    }  
                }  
                if (fileOut != null)  
                {  
                    try  
                    {  
                        fileOut.close();  
                    }  
                    catch (IOException e)  
                    {  
                        e.printStackTrace();  
                    }  
                }  
            }          
            
        } 
	
        //用户界面访问
        @RequestMapping(value = "/User.do")
        public ModelAndView toUser(HttpServletRequest request) {
            ModelAndView  mv = new ModelAndView();
            //在进入主页时先把数据加载进去
            User u= (User) request.getSession().getAttribute("USER_SESSION");
            User user = userService.queryAllFriends(u.getId());
            if(u.getUimg() != null){
            byteToFile(u.getUimg(), "E:/tomcat/apache-tomcat-9.0.0.M10/webapps/fblog/images", u.getUsername()+".jpg");
            u.setImgurl(u.getUsername()+".jpg");
            }
            u.setFriends(user.getFriends());
            // System.out.println(user);
            mv.addObject("user", u);
            mv.setViewName("User");
         return mv;
        }	

        //个人界面访问
        @RequestMapping(value = "/personage.do")
        public ModelAndView toPesonage(HttpServletRequest request) {
            ModelAndView  mv = new ModelAndView();
            //在进入主页时先把数据加载进去
            User u= (User) request.getSession().getAttribute("USER_SESSION");
            List<Blog> blog = userService.cqueryAllBlog(u.getId());
            List<Object[]> names = new ArrayList<Object[]>();
            
            int i=0;
            for(Blog b:blog){
            	byteToFile(b.getBimg(), "E:/tomcat/apache-tomcat-9.0.0.M10/webapps/fblog/images", u.getUsername()+".jpg");
            	Object[] name = {u.getName(),b.getContactus(),u.getUsername()+".jpg",b.getId()};
                if(name != null){
                    names.add(name);
                }
            }
            // System.out.println(user);
            u.setNames(names);
            mv.addObject("user", u);
            mv.setViewName("personage");
         return mv;
        }	
        
        
        //添加好友逻辑处理
        @RequestMapping(value = "/addFriend.do")
        public String addFriend(String fname, HttpServletRequest request) {
            //获取session中的用户,得到用户id
            User u= (User) request.getSession().getAttribute("USER_SESSION");  
            //System.out.println(u);
           // System.out.println(friend);
            Friend friend = userService.findFriendByName(fname);
            //中间表的更新
            int result1 =userService.addUser_f(u.getId(),friend.getId());
            if(result1>0) {
                return "redirect:User.do";//添加好友成功
            }
            return "addFriend-form";
        }
        
            
        //根据fid删除好友 //TODO  删除好友的jsp
        @RequestMapping(value="/deleteFriend.do")
        public String deleteFriend(String fid, HttpServletRequest request)  {
            //System.out.println(fid);
        	Map<String,String> num = new HashMap<String,String>();
        	User u= (User) request.getSession().getAttribute("USER_SESSION");  
        	String uid = String.valueOf(u.getId());
        	System.out.println(fid+"--"+uid);
        	num.put("fid", fid);
        	num.put("uid", uid);
        	System.out.println(num);
            int res1=userService.deleteUser_f(num);
            return "redirect:User.do";
        }
        
        //博客上传，包含内容和图片
        @RequestMapping(value = "/sendBlog.do", method = RequestMethod.POST)
        public String addBlog(HttpServletRequest request,HttpServletResponse response, HttpSession session,
                         Model model,@RequestParam("contactus") String contactus, 
                         @RequestParam("bimg") MultipartFile bimg)  {
                Blog blog = new Blog();
                //获取前台提交图片
                 CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
                 
                 session = request.getSession(true);//从session中取出当前登录用户
                 User user=(User) session.getAttribute("USER_SESSION");
                 System.out.println(user);
                 
                if (multipartResolver.isMultipart(request)) // 判断 request
                  // 是否有文件上传,即多部分请求...
                {
                    MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) (request);
                    Iterator<String> iter = multiRequest.getFileNames();
                    String path = "";// 文件路径
                        while (iter.hasNext()) {
                                MultipartFile file = multiRequest.getFile(iter.next());
                                String fileName = "upload" + file.getOriginalFilename();// 获取文件名称
                                String path1 = request.getSession().getServletContext().getRealPath("/");// 获取服务器的路径
                                path = path1 + "" + fileName;// 拼接文件路径
                                File localFile = new File(path);
                                try {
                                        file.transferTo(localFile);// 图片上传至 服务器
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                }
                        }
                   try {
                       FileInputStream is = new FileInputStream(path);
                       int i = is.available(); // 得到文件大小
                       byte data[] = new byte[i];
                       is.read(data); //读数据
                       is.close();
                       
                       blog.setBimg(data);
                       blog.setContactus(contactus);
                       
                       //System.out.println(blog);
                       int res=userService.addBlog(blog);
                       int res1=userService.addUser_b(user.getId(), blog.getId());
                       //System.out.println(res+"--------"+res1);
                       File file =new File(path);
                       file.delete();//删除上传至服务器的文件
                   }catch (Exception e) {
                }
            }
         return "redirect:User.do";
        } 
        
        //更新用户信息
        @RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
        public String update(User user,HttpServletRequest request,HttpServletResponse response, HttpSession session,
                         Model model,@RequestParam("fimg") MultipartFile fimg)  {
                //获取前台提交图片
                 CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
                 
                 System.out.println(user);
                 
                if (multipartResolver.isMultipart(request)) // 判断 request
                  // 是否有文件上传,即多部分请求...
                {
                    MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) (request);
                    Iterator<String> iter = multiRequest.getFileNames();
                    String path = "";// 文件路径
                        while (iter.hasNext()) {
                                MultipartFile file = multiRequest.getFile(iter.next());
                                String fileName = "upload" + file.getOriginalFilename();// 获取文件名称
                                String path1 = request.getSession().getServletContext().getRealPath("/");// 获取服务器的路径
                                path = path1 + "" + fileName;// 拼接文件路径
                                File localFile = new File(path);
                                try {
                                        file.transferTo(localFile);// 图片上传至 服务器
                                } catch (IllegalStateException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                }
                        }
                   try {
                       FileInputStream is = new FileInputStream(path);
                       int i = is.available(); // 得到文件大小
                       byte data[] = new byte[i];
                       is.read(data); //读数据
                       is.close();
                       
                       user.setUimg(data);
                       
                       //System.out.println(blog);
                       int res = userService.updateUser(user);
                       //System.out.println(res+"--------"+res1);
                       File file =new File(path);
                       file.delete();//删除上传至服务器的文件
                   }catch (Exception e) {
                }
            }
           return "redirect:User.do";
        } 
        
        //查询当前用户所有博客
        @RequestMapping("/blogshow.do")
        public ModelAndView  userImage(HttpServletRequest request,HttpServletResponse response, HttpSession session) {
                ModelAndView mv = new ModelAndView();
                session = request.getSession(true);
                User user=(User) session.getAttribute("USER_SESSION");
                response.setContentType("image/*"); // 设置返回的文件类型
                
               
                ByteArrayInputStream in=null;
                User user1 =null;
                try {
                    OutputStream toClient = response.getOutputStream();
                    
                    user1 =userService.queryAllBlogs(user.getId());
                    
                    System.out.println(user);
                    System.out.println(user1.getId());
                    
                    List<Blog> blogs = user1.getBlogs(); //
                    
                    //System.out.println(user1.getBlogs());
                    
                    for(Blog blog:blogs) {
                       in = new ByteArrayInputStream(blog.getBimg());
                       int len;
                       byte[] buf = new byte[1024];
                       while((len = in.read(buf)) != -1) {
                           toClient.write(buf,0,len);
                       }
                       
                    }
                    toClient.flush();
                 //   toClient.write(user1.getUserimage());
                    toClient.close();
                }catch (Exception e) {
                   e.printStackTrace();
                } 
               mv.addObject("user1", user1);
               mv.addObject("in",in);
               mv.setViewName("user-info");
               return mv;
        }

        // 关注添加好友       
        @RequestMapping(value = "/attention.do")
        public String attention(Friend friend, HttpServletRequest request) {
            //获取session中的用户,得到用户id
            User u= (User) request.getSession().getAttribute("USER_SESSION");  
            //System.out.println(u);
            System.out.println(friend);
            //好友表的更新
            Friend f = userService.findFriendByName(friend.getFname());
            //中间表的更新
            int result1 = userService.addUser_f(u.getId(),f.getId());
            System.out.println(f.getId());
            if(result1>0) {
                return "redirect:index.do";//添加好友成功
            }
            return "addFriend-form";
        }
        
        // 删除博客     
        @RequestMapping(value = "/delblog.do")
        public String delBlog(String bid) {
        	System.out.println(bid);
            int result = userService.delBlog(bid);
            int result1 = userService.delUserBlog(bid);
            if(result>0 && result1>0) {
                return "redirect:index.do";//删除博客成功
            }
            return " ";
        }

        
        
        
        
        //退出登录
        @RequestMapping(value = "/logout.do")
        public String logout(HttpSession session) {
            // 清除Session
            session.invalidate();
            // 重定向到登录页面
            return "redirect:login.do";
        }
     
        
/*	
	
                //查询所有好友
        @RequestMapping(value="/queryAllFriend.do")
        public ModelAndView querryAllFriend(HttpServletRequest request) {
            ModelAndView  mv = new ModelAndView();
             User u= (User) request.getSession().getAttribute("USER_SESSION");
             System.out.println(u);
            User user = userService.queryAllFriends(u.getId());
            System.out.println(user);
            mv.addObject("user", user);
            mv.setViewName("index");
            return mv;
        }
       
	*/
        /*      //前往添加好友页面
        @RequestMapping(value = "/addFriend.do",method=RequestMethod.GET)
        public String toAddFriend() {
            return "addFriend-form";
        }*/
        
        
        /**
	 * 模拟其他类中跳转到客户管理页面的方法
	 *//*
	@RequestMapping(value = "/toCustomer.action")
	public String toCustomer() {
	    return "customer";
	}
	
	*//**
	 * 退出登录
	 *//*
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
	    // 清除Session
	    session.invalidate();
	    // 重定向到登录页面
	    return "redirect:login.action";
	}
	*/


}
