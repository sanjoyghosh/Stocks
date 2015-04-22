package com.sanjoyghosh.stocksgather;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class JsoupUtils {

	private static final Logger logger = LogManager.getLogger(JsoupUtils.class);
	private static final int MAX_RETRIES = 12;
	
	
	static Document fetchDocument(String url) throws IOException {
		Document doc = null;
		for (int i = 0; i < MAX_RETRIES; i++) {
			try {
				doc = Jsoup.connect(url).get();
				return doc;
			}
			catch (IOException e) {
				logger.error("Jsoup cannot fetch Document at url: " + url, e);
				if (i == (MAX_RETRIES - 1)) {
					throw e;
				}
			}
		}
		return null;
	}
}
