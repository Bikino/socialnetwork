package com.mum.ea.socialnetwork.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class UtilityService {

	public static String saveFileToFolder(MultipartFile file) {
		String filePath = "";
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(file.getBytes());
			filePath = UUID.randomUUID() + file.getOriginalFilename();
			Path path = Paths.get(filePath);
			Files.copy(in, path);

//			filePath = UUID.randomUUID() + file.getOriginalFilename();
//			FileUtils.writeByteArrayToFile(new File("\\src\\files\\" + filePath), file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return filePath;
	}

	public static String saveFileToFolder(byte[] fileContent, String fileName) {
		String filePath = "";
		try {

			InputStream in = new ByteArrayInputStream(fileContent);
			filePath = UUID.randomUUID() + fileName;
			Path path = Paths.get(filePath);
			Files.copy(in, path);

//			filePath = UUID.randomUUID() + fileName;
//			FileUtils.writeByteArrayToFile(new File("\\src\\files\\" + filePath), fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}

	public static String getSystemFilePath() {
		return "";
	}

	public static byte[] readBytesFromFile(String fileName) throws Exception {
		byte[] fileContent = null;
		try {
			File file = new File(fileName);
			fileContent = Files.readAllBytes(file.toPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileContent;
	}

	public static byte[] readBytesFromFile(File file) throws Exception {
		byte[] fileContent = Files.readAllBytes(file.toPath());

			return fileContent;

	}

	public static String getPostType(String path) {
		try {
			String type = FilenameUtils.getExtension(path).toUpperCase();
			switch (type) {
			case "MP4":
			case "AVI":
			case "VOB:":
			case "3GP":
			case "OGG":
			case "WMV":
			case "WEBM":
			case "FLV":
			case "QUICKTIME":
			case "HDV":
			case "MXF":
			case "MPEG-TS":
			case "MPEG":
			case "WAV":
			case "LXF":
			case "GXF":
				return "video";
			case "JPEG":
			case "JPG":
			case "GIF":
			case "PNG":
			case "JFIF":
			case "EXIF":
			case "TIFF":
			case "BMP":
			case "PPM":
			case "PGM":
			case "PBM":
			case "PNM":
				return "photo";
			default:
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
