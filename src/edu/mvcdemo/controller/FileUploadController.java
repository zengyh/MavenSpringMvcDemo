package edu.mvcdemo.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import edu.mvcdemo.utils.FileComparator;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-16 上午11:05:27
 * @文件描述: 文件上传demo，通过代码控制，限制了只能上传图片
 */
@Controller
@Scope("singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class FileUploadController {
	
	private Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	//从properties配置文件读取file.uploadpath的属性值并给字段赋值，默认值为E:\\360Downloads\\temp
	@Value("${file.uploadpath:E:\\360Downloads\\temp}")
	private String uploadpath;
	//从properties配置文件读取character.encoding的属性值并给字段赋值，默认值为UTF-8
	@Value("${character.encoding:UTF-8}")
	private String characterEncoding;
	
    /**
     * 跳转至多文件上传页面
     * @return
     */
	@RequestMapping(value="/admin/mutilpartfile", method=RequestMethod.GET, params="upload")
	private String showUploadPage(){
		return "mutilpartfile-upload";
	}
	
    /**
     * 跳转至单个文件上传页面
     * @return
     */
	@RequestMapping(value="/admin/onefile", method=RequestMethod.GET, params="upload")
	private String showUploadPage2(HttpServletRequest request){
		return "onefile-upload";
	}
	
	/**
	 * 单文件上传处理
	 * @param files
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/onefile/upload", method=RequestMethod.POST)
	private String uploadOneFile(@RequestParam("file1") MultipartFile file) throws Exception {
		
		String fileName = file.getOriginalFilename();
		File targetDir = new File(uploadpath);
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}

		if (!fileName.toLowerCase().endsWith(".jpg")
				&& !fileName.toLowerCase().endsWith(".png")
				&& !fileName.toLowerCase().endsWith(".bmp")
				&& !fileName.toLowerCase().endsWith(".gif")) {
			throw new Exception("不是支持的文件类型！只支持图片上传！");
		}

		File targetFile = new File(uploadpath + File.separator + UUID.randomUUID() + "_" + fileName);
		logger.info("上传图片：{}", targetFile.getPath());
		file.transferTo(targetFile);
			
		return "redirect:/uploaded-files/preview";
	}
	

	/**
	 * 多文件上传处理
	 * @param files
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/mutilpartfile/upload", method=RequestMethod.POST)
	private String uploadMutilpartFile(@RequestParam("file1") MultipartFile files[]) throws Exception {
		for(MultipartFile file : files){
			String fileName = file.getOriginalFilename();
			File targetDir = new File(uploadpath);
			if(!targetDir.exists()){
				targetDir.mkdirs();
			}
			
			if(!fileName.toLowerCase().endsWith(".jpg") 
			    && !fileName.toLowerCase().endsWith(".png")
			    && !fileName.toLowerCase().endsWith(".bmp")
			    && !fileName.toLowerCase().endsWith(".gif")
			){
				throw new Exception("不是支持的文件类型！只支持图片上传！");
			}
			
			File targetFile = new File(uploadpath + File.separator + UUID.randomUUID() + "_" + fileName);
			logger.info("上传图片：{}", targetFile.getPath());
			file.transferTo(targetFile);
			
		}
		return "redirect:/uploaded-files/preview";
	}
	
	
	/**
	 * 返回服务器上要预览的某张图片
	 * @param fileName
	 * @param fileType
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/uploaded-files/preview/{fileType}/{fileName}", method=RequestMethod.GET)
	private void previewImg(@PathVariable("fileName") String fileName, @PathVariable("fileType") String fileType,
			HttpServletResponse response) throws Exception{
	    fileName = new String(fileName.getBytes("ISO-8859-1"), characterEncoding);  //解决get方式中文乱码
		logger.info("预览图片：{}{}{}.{}", uploadpath, File.separator, fileName, fileType);
		BufferedImage image = ImageIO.read(new File(uploadpath + File.separator + fileName + "." + fileType));
		
		switch(fileType.toLowerCase()){
		       case "jpg":
		    	   response.setContentType("image/jpeg");
		    	   break;
		       case "png":
		    	   response.setContentType("image/png");
		    	   break;
		       case "bmp":
		    	   response.setContentType("image/bmp");
		    	   break;
		       case "gif":
		    	   response.setContentType("image/gif");
		    	   break;
		       default:
		    	   throw new Exception("不是支持的文件类型！只支持预览图片！");
		}
		
		ImageIO.write(image, fileType , response.getOutputStream());
	}
	
	
	/**
	 * 预览已上传的所有图片
	 * @return
	 */
	@RequestMapping(value="/uploaded-files/preview")
	private ModelAndView listUploadedImg(){
		File dir = new File(uploadpath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		//获取该文件夹下的图片
		File fileArr[] = dir.listFiles(new FileFilter(){

			@Override
			public boolean accept(File file) {
				String fileName = file.getName().toLowerCase();
				if(fileName.endsWith(".jpg") 
				    || fileName.endsWith(".png")
				    || fileName.endsWith(".bmp")
				    || fileName.endsWith(".gif")
				){
					return true;
				}else{
					return false;
				}
			}
			
		});
		
		List<File> fileList = Arrays.asList(fileArr);
		Collections.sort(fileList, new FileComparator());
		
		String imgFileNames[] = new String[fileArr.length];  //文件名，去除后缀
		String imgFileTypes[] = new String[fileArr.length];  //文件类型
		for(int i = 0; i < fileArr.length; i++){
			String fileName = fileArr[i].getName();
			imgFileNames[i] = fileName.substring(0, fileName.lastIndexOf("."));
			imgFileTypes[i] = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
			
		}
		
		ModelAndView modelAndView =  new ModelAndView("preview-uploaded-files");
		modelAndView.addObject("imgFileNames", imgFileNames);
		modelAndView.addObject("imgFileTypes", imgFileTypes);
		
		return modelAndView;
	}
	
}
