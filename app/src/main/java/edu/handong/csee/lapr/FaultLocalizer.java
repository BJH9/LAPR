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
		System.out.println("testCasePath의 테스트케이스를 projectDirectorypath의 directory에 적용시킨다.");
		System.out.println("결함이 있는 파일의 path인 faultFilePath를 찾는다.");
		System.out.println("결함이 있는 파일의 라인 넘버인 faultLocationLineNumber를 찾는다");		
		System.out.println("");
	}
	
	public String getFaultFilePath() {
		// TODO
		System.out.println("getFaultFilePath method");
		System.out.println("결함이 있는 파일의 path를 리턴한다");
		System.out.println("");
		return "a"; //faultFilePath;
	}
	
	public int getFaultLocationLineNumber() {
		// TODO
		System.out.println("getFaultLocationLineNumber method");
		System.out.println("결함이 있는 파일의 라인넘버를 리턴한다");
		System.out.println("");
		return 1; //faultLocationLineNumber;
	}
	
}
