/**
 * 
 */
package com.reancloud.platform.feignclient;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kkadam
 *
 */
@RestController
@RequestMapping("/client")
//@Api(value = "CidrManagerController", description = "Cidr Manager Controllerr API", consumes = "application/json", produces = "application/json")
public class CidrManagerController {
	// @Autowired
	// private CidrManagerClient cidrClient;

	@PostConstruct
	public void postConstruct() throws URISyntaxException, IOException {
		URL sampleResource = this.getClass().getClassLoader().getResource("sample/a.txt");
		File file = new File(sampleResource.getPath());
		// File[] listFiles = file.listFiles();

		/*
		 * URL folderResource =
		 * this.getClass().getClassLoader().getResource("sample/*");
		 * System.out.println("URIIIIIIIIIIIIIIIIIIII" + folderResource); File
		 * folderfile = new File(folderResource.getPath()); File[] folderFiles =
		 * folderfile.listFiles();
		 * System.out.println("File size:::"+folderFiles.length); for (File file2 :
		 * folderFiles) { System.out.println(file2.getAbsolutePath()); }
		 */
		URI folderResource = this.getClass().getClassLoader().getResource("/sample").toURI();
		try (FileSystem jarFileSystem = FileSystems.newFileSystem(folderResource, Collections.emptyMap())) {
			String[] jarPath = folderResource.toString().split("!", 2);
			String jarReference = jarPath[1].replace("!", "");
			readContent(jarFileSystem.getPath(jarReference));
		}

	}

	public void readContent(Path path) {
		try {
			Stream<Path> list = Files.list(path);
			List<Path> paths = list.parallel().collect(Collectors.toList());
			paths.stream().parallel().forEach(filePath -> {
				if (Files.isDirectory(filePath)) {
					readContent(filePath);
				} else {
					try {
						String fileName = filePath.toString().split("classes")[1];
						String content = readFile(filePath);
						System.out.println("File: " + fileName + ": Content: " + content);
					} catch (Exception e) {
						System.out.println("Unable to read file " + e.getMessage());
					}
				}
			});
		} catch (Exception e) {
			System.out.println("Unable to read file " + e.getMessage());
		}
	}

	private String readFile(Path path) throws IOException {
		byte[] encoded = Files.readAllBytes(path);
		return new String(encoded, Charset.forName("UTF-8"));
	}

	// @GetMapping(value = "/test", produces = { MediaType.TEXT_PLAIN_VALUE })
	// @ApiOperation(value = "Testing API", notes = "Testing API", response =
	// String.class)
	public String test() {
		return "tesr";
		// return cidrClient.test();
	}

}
