package edu.handong.csee.lapr;

import java.io.File;

public class FaultLocalizer {
	private String faultDirectoryPath;
	private String faultFilePath;
	private String faultLocationLineNumber;

	public void excute(String projectDirectoryPath, String testCasePath) {
		//�׽�Ʈ���̽��� projectdirectorypath�� �����Ѵ�.
		//faultfilepath�� faultlocationlinenumber�� ����Ѵ�.
		System.out.println("excute method");
		System.out.println("testCasePath�� �׽�Ʈ���̽��� projectDirectorypath�� directory�� �����Ų��.");
		System.out.println("������ �ִ� ������ path�� faultFilePath�� ã�´�.");
		System.out.println("������ �ִ� ������ ���� �ѹ��� faultLocationLineNumber�� ã�´�");		
		System.out.println("");
	}
	
	public String getFaultFilePath() {
		// TODO
		System.out.println("getFaultFilePath method");
		System.out.println("������ �ִ� ������ path�� �����Ѵ�");
		System.out.println("");
		return "a"; //faultFilePath;
	}
	
	public int getFaultLocationLineNumber() {
		// TODO
		System.out.println("getFaultLocationLineNumber method");
		System.out.println("������ �ִ� ������ ���γѹ��� �����Ѵ�");
		System.out.println("");
		return 1; //faultLocationLineNumber;
	}
	
}
