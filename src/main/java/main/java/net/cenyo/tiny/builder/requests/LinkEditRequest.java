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

;

import main.java.net.cenyo.tiny.builder.Request;
import main.java.net.cenyo.tiny.model.Response;
import main.java.net.cenyo.tiny.model.responses.LinkEditResponse;


public class LinkEditRequest extends Request<LinkEditResponse> {


	public LinkEditRequest(String accessToken, String login) {
		super(accessToken, login);
	}

	@Override
	public String getEndpoint() {
		return "https://tiny.cc/?c=rest_api&m=edit";
	}

	@Override
	protected Class getClassForMapper() {
		Response<LinkEditResponse> responseResponse = new Response<LinkEditResponse>();
		return responseResponse.getClass();
	}



	public LinkEditRequest setShortUrl(String link) {
		addQueryParameter("shortUrl", link);
		return this;
	}


	public LinkEditRequest setLongUrl(String url) {
		addQueryParameter("longUrl", url);
		return this;
	}

	public LinkEditRequest setHash(String hash) {
		addQueryParameter("hash", hash);
		return this;
	}

	public LinkEditRequest setVersion(String version) {
		VERSION = version;
		return this;
	}

	public LinkEditRequest setFormat(String format) {
		FORMAT = format;
		return this;
	}

	@Override
	protected String getApiVersion() {
		return VERSION;
	}

	@Override
	protected String getFormat() {
		return FORMAT;
	}
}
