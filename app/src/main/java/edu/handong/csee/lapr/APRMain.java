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

		//FaultLocalization: projectDirectoryPath�� �׽�Ʈ���̽��� �����ϴ� ������ ���� faultDirectoryPath faultFilePath�� faultLocationLineNumber�����Ѵ�.
		
		faultLocalizer.excute(projectDirectoryPath, testcaseDirectoryPath);
		faultFilePath = faultLocalizer.getFaultFilePath();
		faultLocationLineNumber = faultLocalizer.getFaultLocationLineNumber();
		
		
		//PatchGeneration: faultDirectoryPath,  faultFilePath, faultLocationLineNumber��ġ�� ���Կ� ���� testcase���� ������ ��ġ���� �����Ѵ�. candidate patch
		candidatePatches = patchGenerator.getPatches(faultDirectoryPath, faultFilePath, faultLocationLineNumber);
		
		
		//PatchValidation: candidate patch�� �׽�Ʈ���̽��� ������ ���������� final patch�� ã�´�.
		finalPatch = patchValidator.getFinalPatches(candidatePatches);
		
		
		//Patch apply: faultFilePath�� �������� ������ �����ڵ忡 correct patch�� ������� ���� �����Ѵ�.
		patcher.fixFaultCode(finalPatch);

		
		
	}
}