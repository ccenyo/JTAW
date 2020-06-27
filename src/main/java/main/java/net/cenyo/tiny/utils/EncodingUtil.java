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
package main.java.net.cenyo.tiny.utils;

import main.java.net.cenyo.tiny.TinyClientException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public final class EncodingUtil {

	private static final String ENCODING = "UTF-8";

	private EncodingUtil() {}

	public static String encode(String unencodedString) {
		try {
			return URLEncoder.encode(unencodedString, ENCODING);
		}
		catch (UnsupportedEncodingException e) {
			throw new TinyClientException("Error encoding String '" + unencodedString + "' with charset '" + ENCODING + "'", e);
		}
	}
}
