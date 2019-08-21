package kr.co.arajeju.aracoupon3.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.co.arajeju.aracoupon3.dao.AttachFileDTO;
import net.coobird.thumbnailator.Thumbnailator;
import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

@Controller
@RequestMapping(value = "/file")
public class UploadController {

	private final Log log = LogFactory.getLog(getClass());

	private final String BASE_PATH = "/Users/kangmac";
	
	//AJAX
	@SuppressWarnings("unused")
	@Autowired
	private MappingJackson2JsonView jsonView;

	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/uploadForm.do")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction.do")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		String uploadFolder = BASE_PATH;
		
		for (MultipartFile multipartFile : uploadFile) {
			log.info("-----------------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File size: " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/uploadAjax.do")
	public void uploadAjax() {
		log.info("upload ajax");
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	private boolean checkImageType(File file) {
		Magic magic = new Magic();
		try {
			@SuppressWarnings("static-access")
			MagicMatch match = magic.getMagicMatch(file, false);
			return match.getMimeType().contains("image");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		/*
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
		*/
	}
	
	@PostMapping(value="/uploadAjaxAction.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = BASE_PATH;
		
		String uploadFolderPath = getFolder();
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		for (MultipartFile multipartFile : uploadFile) {
			AttachFileDTO attachDTO = new AttachFileDTO();
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name: " + uploadFileName);
			attachDTO.setFileName(uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);
				
				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);
				
				// check image type file
				if (checkImageType(saveFile)) {
					attachDTO.setImage(true);
					
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				
				// add to list
				list.add(attachDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	/////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/display.do")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {
		log.info("fileName: " + fileName);
		
		File file = new File(BASE_PATH + File.separator + fileName);
		log.info("file: " + file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	/////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value = "/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName) {
		Resource resource = new FileSystemResource(BASE_PATH + File.separator + fileName);
		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		String resourceName = resource.getFilename();
		// remove UUID
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);
		
		HttpHeaders headers = new HttpHeaders();
		try {
			boolean checkIE = (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1);
			
			String downloadName = null;
			if (checkIE) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF8").replaceAll("\\+", " ");
			} else {
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8856-1");
			}
			headers.add("Content-Disposition", "attachment); filename=" + downloadName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	/////////////////////////////////////////////////////////////////////////////////
	@PostMapping("/deleteFile.do")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type) {
		log.info("deleteFile: " + fileName);
		File file;
		try {
			file = new File(BASE_PATH + File.separator + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			if (type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				log.info("largeFileName: " + largeFileName);
				file = new File(largeFileName);
				file.delete();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
}





