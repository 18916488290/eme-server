package com.huihuan.eme.web.page.react;

import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@SuppressWarnings("restriction")
public class React {


	private ThreadLocal<NashornScriptEngine> engineHolder = new ThreadLocal<NashornScriptEngine>() {
        @Override
        protected NashornScriptEngine initialValue() {
            NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
            try {
                nashornScriptEngine.eval(read("static/js/react/nashorn-polyfill.js"));
                nashornScriptEngine.eval(read("static/js/react/react.js"));
                nashornScriptEngine.eval(read("static/js/react/showdown.min.js"));
                nashornScriptEngine.eval(read("static/js/react/commentBox.js"));
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
            return nashornScriptEngine;
        }
    };

    public  String renderCommentBox(List<Comment> comments) {
        try {
        	
            Object html = engineHolder.get().invokeFunction("renderServer", comments);
            String s= String.valueOf(html);
            System.out.println(s);
            return s;
        }
        catch (Exception e) {
            throw new IllegalStateException("failed to render react component", e);
        }
    }

    private Reader read(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }
}