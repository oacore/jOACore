package uk.ac.core.oacore4j;

/**
 * @author Giorgio Basile
 * @since 07/06/2017
 */
public class BaseTest {

    protected String readApiKey() throws NullPointerException{
        String apiKey = System.getProperty("apiKey");
        if(apiKey == null){
            throw new NullPointerException("Please provide a valid CORE API key");
        }
        return apiKey;
    }

}
