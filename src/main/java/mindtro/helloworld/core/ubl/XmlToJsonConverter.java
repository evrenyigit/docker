package mindtro.helloworld.core.ubl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import mindtro.helloworld.core.utilities.Product;
import org.hibernate.engine.jdbc.env.spi.LobCreatorBuilder;
import org.hibernate.type.format.jackson.JacksonXmlFormatMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.camel.spi.RestConfiguration.RestBindingMode.xml;


public class XmlToJsonConverter {

    public static String convertXmlToJson(String xmlData) throws IOException {
//
//        XmlMapper xmlMapper = new XmlMapper();
//        byte[] xmlData = Files.readAllBytes(Paths.get(xmlFilePath));
//        JsonNode jsonNode = xmlMapper.readValue(xmlData);
//        //Product product = xmlMapper.readTree(xma,Pr);
//        ObjectMapper objectMapper = new ObjectMapper();
//        //String json = objectMapper.writeValueAsString(product);
//        return objectMapper.writeValueAsString(jsonNode);
//
//        //JsonNode jsonNode = xmlMapper.readValue(, Product.class);

        XmlMapper xmlMapper = new XmlMapper();
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = xmlMapper.readTree(xmlData);

        String jsonData = objectMapper.writeValueAsString(jsonNode);

        return jsonData;
    }
}
