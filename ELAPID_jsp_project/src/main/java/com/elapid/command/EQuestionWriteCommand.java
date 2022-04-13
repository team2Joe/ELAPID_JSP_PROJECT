package com.elapid.command;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elapid.dao.QnaDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class EQuestionWriteCommand implements ECommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

		
		String qc_name =request.getParameter("qc_name");
		
		System.out.println(qc_name + "****************");
		String pq_title = request.getParameter("pq_title");
		String pq_content= request.getParameter("pq_content");
		String uid = (String) session.getAttribute("uid");
		//이미지파일 업로드 
		
		String uploadPath=request.getRealPath("upload");;
		   
		   int size = 10*1024*1024;
		   String filename1="";
		   
		   try{
		      MultipartRequest multi=new MultipartRequest(request,
		                     uploadPath,
		                     size, 
		                     "utf-8",
		            new DefaultFileRenamePolicy());

		      
		      Enumeration files=multi.getFileNames();
		      
		      String file1 =(String)files.nextElement();
		      filename1=multi.getFilesystemName(file1);
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		   
		// 업로드 끝
		  
		QnaDao dao = new QnaDao();
		dao.write( qc_name, pq_title, pq_content, uid);
		
		
	}
}