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
package main.java.net.cenyo.tiny;


import main.java.net.cenyo.tiny.builder.requests.LinkEditRequest;
import main.java.net.cenyo.tiny.builder.requests.ShortenRequest;

public class TinyClient {

	private final String accessToken;
	private final String login;

	public TinyClient(String accessToken, String login) {
		this.accessToken = accessToken;
		this.login = login;
	}

	public ShortenRequest shorten() {
		return new ShortenRequest(accessToken, login);
	}
	public LinkEditRequest editLink() {
		return new LinkEditRequest(accessToken, login);
	}

}
