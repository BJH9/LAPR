package edu.handong.csee.lapr;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;

public class APRMain {
	private String projectDirectoryPath;
	private String testCaseDirectoryPath;
	private boolean help;
	
	private String projectDirPath;
	private String testCasePath;
	
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
		Options options = createOptions();
		
		if(parseOption(options, args)) {
			if(help) {
				printHelp(options);
				return;
			}
			
			projectDirPath = projectDirectoryPath;
			testCasePath = testCaseDirectoryPath;
			
			
		}
		
		FaultLocalizer faultLocalizer = new FaultLocalizer();
		PatchGenerator patchGenerator = new PatchGenerator();
		PatchValidator patchValidator = new PatchValidator();
		Patcher patcher = new Patcher();
		
		//FaultLocalization: projectDirectoryPath�� �׽�Ʈ���̽��� �����ϴ� ������ ���� faultDirectoryPath faultFilePath�� faultLocationLineNumber�����Ѵ�.
		faultLocalizer.excute(projectDirPath, testCasePath);
		faultFilePath = faultLocalizer.getFaultFilePath(); // TODO
		faultLocationLineNumber = faultLocalizer.getFaultLocationLineNumber();
		
		//PatchGeneration: faultDirectoryPath,  faultFilePath, faultLocationLineNumber��ġ�� ���Կ� ���� testcase���� ������ ��ġ���� �����Ѵ�. candidate patch
		candidatePatches = patchGenerator.getPatches(faultDirectoryPath, faultFilePath, faultLocationLineNumber); // TODO
		
		//PatchValidation: candidate patch�� �׽�Ʈ���̽��� ������ ���������� final patch�� ã�´�.
		finalPatch = patchValidator.getFinalPatches(candidatePatches); // TODO
		
		//Patch apply: faultFilePath�� �������� ������ �����ڵ忡 correct patch�� ������� ���� �����Ѵ�.
		patcher.fixFaultCode(finalPatch); // TODO
	}
	
	private boolean parseOption(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		
		try {
			CommandLine cmd = parser.parse(options, args);
			
			projectDirectoryPath = cmd.getOptionValue("f");
			testCaseDirectoryPath = cmd.getOptionValue("t");
			help = cmd.hasOption("h");
		} catch(Exception e) {
			printHelp(options);
			return false;
		}
		
		return true;
		
		
	}
	
	private Options createOptions() {
		Options options = new Options();
		
		options.addOption(Option.builder("f").longOpt("projectDirectoryPath")
				.desc("set a path of a fault directory")
				.hasArg()
				.argName("Path name of fault directory")
				.required()
				.build());
		
		options.addOption(Option.builder("t").longOpt("testCaseDirectoryPath")
				.desc("set a path of a testCasePath")
				.hasArg()
				.argName("Path name of test case")
				.required()
				.build());
		
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());
		
		return options;
	}
	
	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "APR Test";
		String footer = "\nPlease report issues";
		formatter.printHelp("APR", header, options, footer, true);
	}
	
}
