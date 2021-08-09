package edu.handong.csee.lapr;

import java.io.File;

public class FaultLocalizer {
	private String faultDirectoryPath;
	private String faultFilePath;
	private String faultLocationLineNumber;

	public void excute(String projectDirectoryPath, String testCasePath) {
		//테스트케이스를 projectdirectorypath에 적용한다.
		//faultfilepath와 faultlocationlinenumber를 출력한다.
		System.out.println("//FAULTLOCALIZATION");
		System.out.println("excute method");
		System.out.println("Test directory at projectDirectoryPath using test case at testCasePath .");
		System.out.println("Investigate fault.");
		System.out.println("If code has fault, find faultFilePath which has fault.");
		System.out.println("If code has fault, find faultLoacationLineNumber which has fault.");		
		System.out.println("");
	}
	
	public String getFaultFilePath() {
		// TODO
		System.out.println("GetFaultFilePath method");
		System.out.println("Return file path which has fault");
		System.out.println("");
		return "a"; //faultFilePath;
	}
	
	public int getFaultLocationLineNumber() {
		// TODO
		System.out.println("GetFaultLocationLineNumber method");
		System.out.println("Return line number which has fault");
		System.out.println("");
		return 1; //faultLocationLineNumber;
	}
	
}
