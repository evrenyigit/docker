package mindtro.helloworld.core.ubl;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

public class MyErrorListener implements ErrorListener {
    @Override
    public void warning(TransformerException exception) throws TransformerException {
        // Uyarı durumunda ne yapılacağını burada belirtin
        System.out.println("Warning: " + exception.getMessage());
    }

    @Override
    public void error(TransformerException exception) throws TransformerException {
        // Hata durumunda ne yapılacağını burada belirtin
        System.out.println("Error: " + exception.getMessage());
    }

    @Override
    public void fatalError(TransformerException exception) throws TransformerException {
        // Kritik hata durumunda ne yapılacağını burada belirtin
        System.out.println("Fatal Error: " + exception.getMessage());
    }
}
