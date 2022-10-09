package edu.institution.finalproj;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Anagrammer {

	public static void main(String[] args) {
		
		// Create command line options
		Options options = new Options();
		
		options.addOption(new Option("a", "anagram", true, "Supplies the anagram to evaluate."));
		options.addOption(new Option("nf", "no-filter", false, "Output all anagram values with no filter."));
		options.addOption(new Option("words", "filter-words", false, "Output only values that are known words."));
		options.addOption(new Option("h", "help", false, "Displays the help for this program."));
		
		// Create the help
		HelpFormatter formatter = new HelpFormatter();

		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			String header = new String();
			AnagramEvaluatorImpl implement = new AnagramEvaluatorImpl();
			List<String> list = new ArrayList<>();
			
			if(!cmd.hasOption("a") && cmd.getOptionValue("a").isEmpty()) {
				System.out.println("You must supply an anagram to evaluate with the '-a' option.");
			} else 
			if(cmd.hasOption("words") && cmd.hasOption("nf")) {
				System.out.println("You cannot use both option '-a' and '-nf'. Use only one.");
			} else if(cmd.hasOption("a")) {
				String anagramToEvaluate = cmd.getOptionValue("a").toUpperCase();
				if(cmd.hasOption("nf")) {
					list = implement.evaluate(anagramToEvaluate, "nf");
					header = "All possible combinations of letters in " + anagramToEvaluate;
				} else {
					list = implement.evaluate(anagramToEvaluate, "words");
					header = "All known words that are anagrams of " + anagramToEvaluate;
				}
				System.out.println(header);
				int count = 0;
				for(String s : list) {
					if(count % 7 == 0 && count != 0) {
						System.out.println();
					}
					System.out.print(s + "    ");
					count++;
				}
			}
			if(cmd.hasOption("h")) {
				formatter.printHelp("Anagrammer", options);
			}
			
			
		} catch (ParseException exp) {
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
			main(args);
		}
	}

}
