/*
 * IAsyncJSON.java.java
 *
 * Created on 03-11-2010 07:39:09 PM
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

import com.google.gwt.json.client.JSONObject;

public interface IAsyncJSON {
    public void done(JSONObject _result);
    public void error(Throwable _t);
}
