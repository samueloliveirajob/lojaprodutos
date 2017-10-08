package br.com.loja.infrastructure.javascript;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import br.com.loja.infrastructure.utils.FileReader;

public class JSReader {

    public Invocable invoque() {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval(new FileReader().name("script.js"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        Invocable invocable = (Invocable) engine;

        return invocable;
    }

}
