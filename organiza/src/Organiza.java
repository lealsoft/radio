import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Organiza {

	//static String directory = System.getProperty("user.home");
	static String directory = "./";
	static String fileName = "Homologadas.m3u8";
	static String absolutePath = directory + File.separator + fileName;

	static String dirWindows = "C:/Rádio/Homologadas/Seleção 02/";
	
	public static void main(String[] args) {
	
		System.out.println(System.getProperty("user.home"));
	
		Integer pula = 1;
		String vinheta = "RadioPazeVerdadeVinheta.mp3";
		//\n\r#EXTINF";
		
		Pattern pInf = Pattern.compile(".EXTINF");
		Pattern pM3u = Pattern.compile(".EXTM3U");
		
		ArrayList<String> lista = new ArrayList<>();
		ArrayList<String> listaVinheta = new ArrayList<>();
		
		// Read the content from file
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
		    String line = bufferedReader.readLine();
		    while(line != null) {
		    	Matcher mInf = pInf.matcher(line);
		    	//Matcher mM3u = pM3u.matcher(line);
	            if (!mInf.matches()) {
	            	//System.out.println(line);
	            	lista.add(line);
	            }
		        line = bufferedReader.readLine();
		    }
		    //Embaralhando a lista.
		    Collections.shuffle(lista);
		    
		    for (Object object : lista) {
				//System.out.println(object);
				listaVinheta.add((String) object);
				if (pula == 1) {
					//System.out.println(dirWindows + vinheta);
					listaVinheta.add(dirWindows + vinheta);
		        	pula = 0;
		        }
				pula++;
			}
		    for (Object object : listaVinheta) {
					System.out.println(object+"\n#EXTINF");
		    }
		    
		} catch (FileNotFoundException e) {
		    // Exception handling
		} catch (IOException e) {
		    // Exception handling
		}
	}

}
