/*
 * Copyright (c) Patrick Huber (gmail: stackmagic)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.cenyo.bitly.test;

import main.java.net.cenyo.tiny.model.Response;
import main.java.net.cenyo.tiny.model.responses.ShortenResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_shorten">/v3/shorten</a> request.
 * </p>
 * @author Patrick Huber (gmail: stackmagic)
 */
public class ShortenTest extends AbstractClientTest {

	@Test
	public void callShorten() throws IOException {
		Response<ShortenResponse> resp = getClient().shorten() //
			.setLongUrl("https://www.example.com/tinycc-api-client-test") //
			.call();

		Assert.assertEquals(resp.statusCode, "OK");
		Assert.assertEquals(resp.errorCode, "0");

	}

}
