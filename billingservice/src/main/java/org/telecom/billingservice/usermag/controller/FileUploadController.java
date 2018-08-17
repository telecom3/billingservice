package org.telecom.billingservice.usermag.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.usermag.handleservice.IAccountHandleService;
import org.telecom.billingservice.util.AnalysisExcelUtil;

/**
 * 文件上传
 * @author deng
 *
 */
@RequestMapping(value="/templates/account")
@Controller
public class FileUploadController {
	@Resource
	private IAccountHandleService accountHandleServiceImpl;
	/**
	 * springmvc框架的单文件上传
	 * @param file 临时文件对象
	 * @return
	 */
	@RequestMapping(value="/file",produces= {"application/json;charset=utf-8"})
	public @ResponseBody boolean fileUpload(@RequestParam("file")MultipartFile file) {
		String fileName = file.getOriginalFilename();
		FileOutputStream out =null;
		System.out.println(fileName);
		String path = "d:\\files";
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		path = path + File.separator + fileName;
		//将临时文件写入到真实文件中去
		try {
			 out = new FileOutputStream(path);
		     out.write(file.getBytes());
		     //同时解析excle文件
			List<UserInfoBean> list=AnalysisExcelUtil.readExcel(path);
			accountHandleServiceImpl.saveUserInfoBeans(list);
			//解析之后将返回得结果扔给消息服务器
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
		return true;
	}
	
//	/**
//	 * springmvc框架的多文件上传
//	 * @param file 临时文件对象
//	 * @return
//	 */
//	@RequestMapping(value="/multi/upload",method= {RequestMethod.POST})
//	public String fileUpload(@RequestParam("fileName")CommonsMultipartFile[] files) {
//		for (CommonsMultipartFile file : files) {
//			System.out.println(file.getOriginalFilename());
//			
//			
//		}
//		
//		return "index";
//	}
//	
}
