package edu.handong.csee.lapr;
public class APRMain {

	private String projectDirectoryPath;
	private String testcaseDirectoryPath;
	
	private String faultDirectoryPath;
	private String faultFilePath;
	private int faultLocationLineNumber;
	
	private String[] candidatePatches;
	private String finalPatch;
	
	
	
	public static void main(String[] args) {

		 
        APRMain runner = new APRMain();
        runner.run(args);



	}

	private void run(String[] args) {
		
		projectDirectoryPath = args[0];
		testcaseDirectoryPath = args[1];
		
		FaultLocalizer faultLocalizer = new FaultLocalizer();
		PatchGenerator patchGenerator = new PatchGenerator();
		PatchValidator patchValidator = new PatchValidator();
		Patcher patcher = new Patcher();

		//FaultLocalization: projectDirectoryPath에 테스트케이스를 적용하는 과정을 거쳐 faultDirectoryPath faultFilePath와 faultLocationLineNumber생성한다.
		
		faultLocalizer.excute(projectDirectoryPath, testcaseDirectoryPath);
		faultFilePath = faultLocalizer.getFaultFilePath();
		faultLocationLineNumber = faultLocalizer.getFaultLocationLineNumber();
		
		
		//PatchGeneration: faultDirectoryPath,  faultFilePath, faultLocationLineNumber위치에 결함에 대한 testcase들을 적용해 패치들을 생성한다. candidate patch
		candidatePatches = patchGenerator.getPatches(faultDirectoryPath, faultFilePath, faultLocationLineNumber);
		
		
		//PatchValidation: candidate patch에 테스트케이스를 적용해 최종적으로 final patch를 찾는다.
		finalPatch = patchValidator.getFinalPatches(candidatePatches);
		
		
		//Patch apply: faultFilePath의 오리지널 파일의 결함코드에 correct patch를 적용시켜 최종 수정한다.
		patcher.fixFaultCode(finalPatch);

		
		
	}
}