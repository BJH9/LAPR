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
		
		//FaultLocalization: projectDirectoryPath에 테스트케이스를 적용하는 과정을 거쳐 faultDirectoryPath faultFilePath와 faultLocationLineNumber생성한다.
		faultLocalizer.excute(projectDirPath, testCasePath);
		faultFilePath = faultLocalizer.getFaultFilePath(); // TODO
		faultLocationLineNumber = faultLocalizer.getFaultLocationLineNumber();
		
		//PatchGeneration: faultDirectoryPath,  faultFilePath, faultLocationLineNumber위치에 결함에 대한 testcase들을 적용해 패치들을 생성한다. candidate patch
		candidatePatches = patchGenerator.getPatches(faultDirectoryPath, faultFilePath, faultLocationLineNumber); // TODO
		
		//PatchValidation: candidate patch에 테스트케이스를 적용해 최종적으로 final patch를 찾는다.
		finalPatch = patchValidator.getFinalPatches(candidatePatches); // TODO
		
		//Patch apply: faultFilePath의 오리지널 파일의 결함코드에 correct patch를 적용시켜 최종 수정한다.
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
