package main.java.net.cenyo.tiny.builder;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.net.cenyo.tiny.TinyClientException;
import main.java.net.cenyo.tiny.model.Response;
import main.java.net.cenyo.tiny.utils.JacksonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Request<T>{

    public String VERSION = "2.0.3";

    public String FORMAT = "json";

    /** Logger */
    private static final Logger LOG = LoggerFactory.getLogger(Request.class.getName());

    private static final ObjectMapper mapper = JacksonFactory.getMapper();

    /** the access token to be used for the request */
    protected final String accessToken;

    protected final String login;

    /** contains all query parameters to be added to the request */
    protected List<QueryParameter> queryParameters = new LinkedList<QueryParameter>();

    public Request(String accessToken, String login) {
        this.accessToken = accessToken;
        this.login = login;
    }


    public abstract String getEndpoint();

    protected abstract TypeReference getClassForMapper();


    public void addQueryParameter(String name, String value) {
        addQueryParameter(new QueryParameter(name, value));
    }

    public void addQueryParameter(String name, boolean value) {
        addQueryParameter(new QueryParameter(name, value));
    }


    public void addQueryParameter(String name, long value) {
        addQueryParameter(new QueryParameter(name, value));
    }


    public void addQueryParameter(String name, LocalDateTime value) {
        addQueryParameter(new QueryParameter(name, value.toString()));
    }


    public void addQueryParameter(QueryParameter queryParameter) {
        queryParameters.add(queryParameter);
    }



    public String buildUrl() {
        return buildUrl(queryParameters);
    }

    public String buildUrl(List<QueryParameter> queryParameters) {

        // TODO find a way to pass the collection to addQuery in a simple and
        // extensible way without breaking but extending the normal
        // addQueryParameter methods
        List<QueryParameter> params = new LinkedList<QueryParameter>(queryParameters);

        StringBuilder url = new StringBuilder();
        url.append(getEndpoint());
        url.append("&");
        Iterator<QueryParameter> paramIter = params.iterator();
        while (paramIter.hasNext()) {
            String param = paramIter.next().toString();
            url.append(param);
            if (paramIter.hasNext()) {
                url.append("&");
            }
        }

        return url.toString();
    }


    private Response<T> deserialize(String resp) throws JsonProcessingException {
        return (Response<T>) mapper.readValue(resp , getClassForMapper());
    }


    public Response<T> call() {
        try {
            prepareCall();
            String url = buildUrl();
            LOG.debug("Calling URL: {}", url);
            HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();

            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            System.out.println("POST Response Code :  " + responseCode);
            System.out.println("POST Response Message : " + conn.getResponseMessage());

            StringBuffer respBuf = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                respBuf.append(line);
            }

            String resp = respBuf.toString();
            LOG.trace("Response received: {}", resp);

            return deserialize(resp);

        }
        catch (IOException e) {
            e.printStackTrace();
            throw new TinyClientException(e);
        }
    }


    public void prepareCall() {
        addQueryParameter("format", getFormat());
        addQueryParameter("version", getApiVersion());
        addQueryParameter("login", login);
        addQueryParameter("apiKey", accessToken);
    }

    protected abstract String getApiVersion();

    protected abstract String getFormat();
}
