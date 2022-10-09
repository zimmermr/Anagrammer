package edu.institution.finalproj;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;

public class AnagramDataReaderImpl implements AnagramDataReader {

	@Override
	public Set<String> readData() {
		
		Set<String> tempList = new TreeSet<>();
		
		URL u = this.getClass().getResource("/anagram_data.txt");
		try(InputStream in = u.openStream(); BufferedReader anaDat = new BufferedReader(new InputStreamReader(in))){
			while(anaDat.ready()) {
				tempList.add(anaDat.readLine());
			}
			anaDat.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return tempList;
	}
}
