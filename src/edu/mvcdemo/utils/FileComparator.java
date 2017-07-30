package edu.mvcdemo.utils;

import java.io.File;
import java.util.Comparator;

/**
 * @编写人： yh.zeng
 * @编写时间：2017-7-20 上午12:55:34
 * @文件描述: 文件列表按照最后修改时间降序排序
 */
public class FileComparator implements Comparator<File>  {

	@Override
	public int compare(File file1, File file2) {
		long time1 = file1.lastModified();  
		long time2 = file2.lastModified(); 
		
		if(time1 == time2){
			return 0;
		}else if(time1 > time2){
			return -1;
		}else{
			return 1;
		}
	}

}
