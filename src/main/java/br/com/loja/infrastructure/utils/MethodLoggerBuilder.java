package br.com.loja.infrastructure.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.lang.reflect.Method;

/**
 * Created by STELO\renato.5a on 9/12/17.
 */
public class MethodLoggerBuilder {

    private String clazz;
    private String method;
    private Object[] params;
    private Object _return;
    private Long dutarion;
    private long startTime;

    private MethodLoggerBuilder() {
    }

    public static MethodLoggerBuilder instance() {
        MethodLoggerBuilder methodLogger = new MethodLoggerBuilder();
        methodLogger.startTime = System.currentTimeMillis();
        return methodLogger;
    }

    public MethodLoggerBuilder withParams(Object... params) {
        this.params = params;
        return this;
    }

    public MethodLoggerBuilder withMethod(String method) {
        this.method = method;
        return this;
    }

    public MethodLoggerBuilder withClass(String clazz) {
        this.clazz = clazz;
        return this;
    }

    public MethodLoggerBuilder withReturn(Object _return) {
        this._return = _return;
        return this;
    }

    public String log() {
        MethodLogger logger = new MethodLogger(clazz,
                method,
                params,
                _return,
                (System.currentTimeMillis() - this.startTime));
        return new Gson().toJson(logger);

    }


    private class MethodLogger {
        private String clazz;
        private String method;
        private Object[] params;
        private Object _return;
        private Long dutarion;

        public MethodLogger(String clazz, String method, Object[] params, Object _return, Long dutarion) {
            this.clazz = clazz;
            this.method = method;
            this.params = params;
            this._return = _return;
            this.dutarion = dutarion;
        }

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public Object[] getParams() {
            return params;
        }

        public void setParams(Object[] params) {
            this.params = params;
        }

        public Object get_return() {
            return _return;
        }

        public void set_return(Object _return) {
            this._return = _return;
        }

        public Long getDutarion() {
            return dutarion;
        }

        public void setDutarion(Long dutarion) {
            this.dutarion = dutarion;
        }


    }
}

