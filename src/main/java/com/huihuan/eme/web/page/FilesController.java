package com.huihuan.eme.web.page;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.common.io.ByteStreams;


/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */

@Controller
public class FilesController {
	
	private static final Log logger = LogFactory.getLog(FilesController.class);

	@RequestMapping(value = "/getimage/{img}", method = RequestMethod.GET)
	public void getImage(@PathVariable("img") String img,HttpServletResponse response ) throws IOException
	{
		//FileInputStream fs = new FileInputStream(new File("/Users/renhongtao/eme_files/"+img));
		FileInputStream fs = new FileInputStream(new File("c:/eme_files/"+img));
	    ByteStreams.copy(fs,response.getOutputStream() );
	}

}
