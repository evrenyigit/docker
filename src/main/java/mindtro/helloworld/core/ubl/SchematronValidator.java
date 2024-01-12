import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmNode;

import javax.annotation.processing.Processor;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

//public class SchematronValidator {
//    public static boolean validateUBLDocument(String xmlDocument, String schematronSchema) throws SaxonApiException {
////        Processor processor = new Processor(false);
////        XdmNode xml = processor.newDocumentBuilder().build(new StreamSource(new StringReader(xmlDocument)));
//
//
////        SchemaValidator validator = processor.newSchemaValidator();
////        validator.setSchemaSource(new StreamSource(new StringReader(schematronSchema)));
////        try {
////            validator.validate(xml);
////            return true; // Geçerli
////        } catch (SaxonApiException e) {
////            System.err.println("Schematron doğrulama hatası: " + e.getMessage());
////            return false; // Geçersiz
//       }
   //}
