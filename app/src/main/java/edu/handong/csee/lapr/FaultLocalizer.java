package edu.handong.csee.lapr;
import java.io.File;

public class FaultLocalizer {
	private String faultDirectoryPath;
	private String faultFilePath;
	private String faultLocationLineNumber;

	public void excute(String projectDirectoryPath, String testCasePath) {
		//테스트케이스를 projectdirectorypath에 적용한다.
		//faultfilepath와 faultlocationlinenumber를 출력한다.
		
		String a = testCasePath;
		File directory = new File(projectDirectoryPath);
		String[] contents = directory.list();
		File file = null;
		
		for(String content : contents) {
			file = new File(directory.getAbsolutePath() + File.separator + content);
			
			if(file.isDirectory()) {
				excute(file.getAbsolutePath(), a);
			} else{
				//test
			}
		}
		
	}
	
	public int getFaultFilePath() {
		return faultFilePath;
	}
	
	public int getFaultLocationLineNumber() {
		return faultLocationLineNumber;
	}
	
}
