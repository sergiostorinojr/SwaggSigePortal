import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.swaggsige.model.domain.Cliente;


public class TesteCLiente {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://localhost:8080/SwaggSigePortal/rest/cliente/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int responseCode = con.getResponseCode();
			
			if(responseCode == 200){
				
				BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
				JAXBContext jaxbContext = JAXBContext.newInstance(Cliente.class);
				
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Cliente cliente =  (Cliente) jaxbUnmarshaller.unmarshal(br);
                
                
                System.out.println();


			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
