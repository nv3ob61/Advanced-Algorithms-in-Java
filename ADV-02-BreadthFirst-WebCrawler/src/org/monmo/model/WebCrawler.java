/* 
 * Copyright (C) 2020 mon_mode   0mon.mode@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.monmo.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nv3ob61
 */
public class WebCrawler {

  private Queue<String> queue;
  private List<String> discWebsiteList;

  public WebCrawler() {
    this.queue = new LinkedList<>();
    this.discWebsiteList = new ArrayList<>();
  }

  public void discoverWeb(String root) {
    this.queue.add(root);
    this.discWebsiteList.add(root);

    while (!queue.isEmpty()) {
      String v = this.queue.remove();
      String rawHtml = readURL(v);

      String regexp = "http://(\\w+\\.)*(\\w+)";
      Pattern patt = Pattern.compile(regexp);
      Matcher matcher = patt.matcher(rawHtml);

      while (matcher.find()) {
        String actualUrl = matcher.group();

        if (!discWebsiteList.contains(actualUrl)) {
          discWebsiteList.add(actualUrl);
          System.out.println("Website found: " + actualUrl);
          queue.add(actualUrl);
        }
      }

    }
  }

  private String readURL(String v) {

    String rawHtml = "";
    String inputLine;

    try {

      URL url = new URL(v);
      try (BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()))) {

        while ((inputLine = bf.readLine()) != null) {
          rawHtml += inputLine;
        }
      }
    } catch (IOException e) {
      System.out.println("OOOOPS!");

    }
    return rawHtml;
  }
}
