package edu.handong.csee.lapr;

import java.io.File;

public class FaultLocalizer {
	private String faultDirectoryPath;
	private String faultFilePath;
	private String faultLocationLineNumber;

	public void excute(String projectDirectoryPath, String testCasePath) {
		//테스트케이스를 projectdirectorypath에 적용한다.
		//faultfilepath와 faultlocationlinenumber를 출력한다.
		System.out.println("excute method");
		System.out.println("Test directory at projectDirectoryPath using test case at testCasePath .");
		System.out.println("investigate fault.");
		System.out.println("if code has fault, find faultFilePath which has fault.");
		System.out.println("if code has fault, find faultLoacationLineNumber which has fault.");		
		System.out.println("");
	}
	
	public String getFaultFilePath() {
		// TODO
		System.out.println("getFaultFilePath method");
		System.out.println("return file path which has fault");
		System.out.println("");
		return "a"; //faultFilePath;
	}
	
	public int getFaultLocationLineNumber() {
		// TODO
		System.out.println("getFaultLocationLineNumber method");
		System.out.println("return line number which has fault");
		System.out.println("");
		return 1; //faultLocationLineNumber;
	}
	
}
