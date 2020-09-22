package utilities.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesManager {

	public static String readFile(String path) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
		String text = "";
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			text += line;
		}
		bufferedReader.close();
		return text;
	}

	public static List<String> readFileLines(String path) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}
		bufferedReader.close();
		return lines;
	}

	public static void writeFile(String path, String text) {
		File file = new File(path);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(text);
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}