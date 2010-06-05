/*
 * JsonClient.java.java
 *
 * Created on 03-11-2010 07:08:42 PM
 *
 * Copyright 2010 Jonathan Colt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package colt.json.gwt.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

public class JsonClient {
    public void invoke(String _url,String _serviceName, JSONObject requestData, final IAsyncJSON result) {
        invoke(_url,_serviceName, "JSON=" + requestData.toString(), result);
    }
    public void invoke(final String _url,final String _serviceName, String requestData, final IAsyncJSON result) {
        try {
            RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, URL.encode(_url+_serviceName));
            requestBuilder.setHeader("content-type", "application/x-www-form-urlencoded");

            Request request = requestBuilder.sendRequest(requestData, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                    result.error(exception);
                }
                public void onResponseReceived(Request request, Response response) {
                    if (200 == response.getStatusCode()) {
                        String text = response.getText();
                        JSONValue parser = JSONParser.parse(text);
                        JSONObject jobj = parser.isObject();
                        result.done(jobj);
                    } else {
                        result.error(new RuntimeException(_url+_serviceName+" :("));
                    }
                }
            });
        } catch (RequestException e) {
            Window.alert(e.getMessage());
            result.error(e);
        }
    }
}
