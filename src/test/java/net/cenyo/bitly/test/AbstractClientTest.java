package net.cenyo.bitly.test;

import main.java.net.cenyo.tiny.TinyClient;
import net.cenyo.bitly.test.util.AccessTokenUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public abstract class AbstractClientTest {

    private String accessToken;
    private String login;

    private TinyClient client;

    @BeforeClass
    public void beforeClass() throws IOException {
        accessToken = AccessTokenUtil.readFrom(".accesstoken");
        login = AccessTokenUtil.readFrom(".login");
    }

    @BeforeMethod
    public void beforeMethod() {
        client = new TinyClient(accessToken, login);
    }

    public TinyClient getClient() {
        return client;
    }
}
