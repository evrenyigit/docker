package mindtro.helloworld.core.ubl;

import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.schematron.ISchematronResource;
import com.helger.schematron.SchematronHelper;
import com.helger.schematron.pure.SchematronResourcePure;
import com.helger.schematron.xslt.ISchematronXSLTBasedProvider;
import com.helger.schematron.xslt.SchematronProviderXSLTFromSCH;
import com.helger.schematron.xslt.SchematronResourceXSLT;
import com.helger.ubl21.*;
import net.sf.saxon.Configuration;
import net.sf.saxon.lib.FeatureKeys;
import net.sf.saxon.s9api.*;
import org.oclc.purl.dsdl.svrl.FailedAssert;
import org.oclc.purl.dsdl.svrl.SchematronOutputType;
import org.oclc.purl.dsdl.svrl.SuccessfulReport;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.validation.Schema;
import static org.aspectj.asm.internal.ProgramElement.trim;

@Component
public class SchematronValidator {


    public void validateWithSchematron(String xmlFilePath, String schematronFilePath) throws Exception {

        try {

            Processor processor = new Processor(false);


            processor.setConfigurationProperty(FeatureKeys.ERROR_LISTENER_CLASS, new MyErrorListener());

            FileSystemResource xmlResource = new FileSystemResource(xmlFilePath);
            FileSystemResource schematronResource = new FileSystemResource(schematronFilePath);

            ISchematronResource schematron = new SchematronResourcePure(schematronResource);

            SchematronOutputType outputType = SchematronHelper.applySchematron(schematron, new StreamSource(xmlResource.getInputStream()));

            //Schematron dosyasını yüklüyorum ?
//        Processor processor = new Processor(false);
//        XsltCompiler compiler = processor.newXsltCompiler();
//        XsltExecutable executable = compiler.compile(new StreamSource(new File(xmlFilePath)));
//        XsltTransformer transformer = executable.load();
//
//        //Saxon XQuery bağlamını yapılandırın
//        XdmNode source = processor.newDocumentBuilder().build(new StreamSource(new File(xmlFilePath)));
//        transformer.setSource((Source) source);
//
//        XdmDestination result = new XdmDestination();
//        transformer.setDestination(result);
//        transformer.transform();
//
//        XdmNode resultNode = result.getXdmNode();
//        SchematronOutputType output = new SchematronOutputType();

            List<Object> errors = outputType.getActivePatternAndFiredRuleAndFailedAssert();

            for (Object error : errors) {
                if (error instanceof FailedAssert) {
                    FailedAssert failedAssert = (FailedAssert) error;
                    System.out.println("Failed assertion: " + failedAssert.getText());
                } else if (error instanceof SuccessfulReport) {
                    SuccessfulReport successfulReport = (SuccessfulReport) error;
                    System.out.println("Successfull report " + successfulReport.getText());
                }
            }

            }catch(Exception e){
            System.out.println("hata");
        }

    }

}
