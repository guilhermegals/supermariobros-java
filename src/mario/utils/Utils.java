package mario.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Classe para ler os arquivos de texto
public class Utils {
	
	//Carrega o arquivo de texto
	public static String loadFileAsString(String path) {
		StringBuilder b = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				b.append(line+ "\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return b.toString();
	}
	
	//Converte o dado de String para Int
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
}
