package com.ata.interview.backend.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author dinhnn
 *a
 */
public class FileUtil {
	
	private FileUtil() {}
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	public static String readResource(String fileName) throws IOException {

		try (InputStream is = getResourceAsInputStream(fileName);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);) {

			List<String> lines = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			return String.join("\n", lines);
		} catch (IOException ex) {
			logger.error(fileName + " read error >>> " + ex.getMessage(), ex);
			throw new IOException(ex.getMessage(), ex);
		}
	}

	public static InputStream getResourceAsInputStream(String fileName) throws FileNotFoundException {

		try {
			InputStream is = FileUtil.class.getResourceAsStream(File.separator + fileName);
			if (is != null) {
				return is;
			}

			throw new Exception("is null");
		} catch (Exception ex) {

			String dirPath = new File("").getAbsolutePath();

			return new FileInputStream(dirPath + File.separator + "src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + fileName);
		}

	}

}
