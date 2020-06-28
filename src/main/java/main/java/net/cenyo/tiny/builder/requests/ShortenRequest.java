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
package main.java.net.cenyo.tiny.builder.requests;


import com.fasterxml.jackson.core.type.TypeReference;
import main.java.net.cenyo.tiny.builder.Request;
import main.java.net.cenyo.tiny.model.Response;
import main.java.net.cenyo.tiny.model.responses.ShortenResponse;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_shorten">/v3/shorten</a> request.
 * </p>
 * @author Patrick Huber (gmail: stackmagic)
 */
public class ShortenRequest extends Request<ShortenResponse> {


	public ShortenRequest(String accessToken, String login) {
		super(accessToken, login);
	}

	@Override
	public String getEndpoint() {
		return "https://tiny.cc/?c=rest_api&m=shorten";
	}

	@Override
	protected TypeReference getClassForMapper() {

		return new TypeReference<Response<ShortenResponse>>() {};
	}

	@Override
	protected String getApiVersion() {
		return VERSION;
	}

	@Override
	protected String getFormat() {
		return FORMAT;
	}

	public ShortenRequest setLongUrl(String longUrl) {
		addQueryParameter("longUrl", longUrl);
		return this;
	}

	public ShortenRequest setVersion(String version) {
		VERSION = version;
		return this;
	}

	public ShortenRequest setFormat(String format) {
		FORMAT = format;
		return this;
	}

}
