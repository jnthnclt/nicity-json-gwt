/*
 * UJsonClient.java.java
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

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class UJsonClient {
   
    static public void add(JSONObject _o,String _key,String _string) {
        if (_string != null) _o.put(_key, new JSONString(_string));
        else  _o.put(_key,JSONNull.getInstance());
    }
    static public void add(JSONObject _o,String _key,long _long) {
        _o.put(_key,new JSONNumber(_long));
    }
    static public void add(JSONObject _o,String _key,double _double) {
        _o.put(_key,new JSONNumber(_double));
    }
    static public void add(JSONObject _o,String _key,boolean _boolean) {
        _o.put(_key,JSONBoolean.getInstance(_boolean));
    }
    


    static public String getString(JSONObject _o,String _key,String _default) {
        JSONValue v = _o.get(_key);
        if (v == null) return _default;
        if (v.isString() == null) return _default;
        return v.isString().stringValue();
    }
    static public long getLong(JSONObject _o,String _key,long _default) {
        JSONValue v = _o.get(_key);
        if (v.isNumber() == null) return _default;
        return (long)v.isNumber().doubleValue();
    }
    static public double getDouble(JSONObject _o,String _key,double _default) {
        JSONValue v = _o.get(_key);
       if (v.isNumber() == null) return _default;
        return v.isNumber().doubleValue();
    }
    static public boolean getBoolean(JSONObject _o,String _key,boolean _default) {
        JSONValue v = _o.get(_key);
        if (v == null) return _default;
        if (v.isBoolean() == null) return _default;
        return v.isBoolean().booleanValue();
    }

    static public JSONArray getArray(JSONObject _o,String _key,JSONArray _default) {
        JSONValue v = _o.get(_key);
        if (v == null) return _default;
        if (v.isArray() == null) return _default;
        return v.isArray();
    }

    
}
