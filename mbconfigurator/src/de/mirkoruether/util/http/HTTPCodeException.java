/*
MIT License

Copyright (c) 2018 Mirko RÃ¼ther

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package de.mirkoruether.util.http;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class HTTPCodeException extends RuntimeException
{
    private static final long serialVersionUID = -4967280586594680282L;

    private static HashMap<Integer, Constructor<? extends HTTPKnownCodeException>> knownErrorCodes;

    static
    {
        try
        {
            knownErrorCodes = new HashMap<>();
            addKnownErrorCodeClass(HTTPTooManyRequests.class);
        }
        catch(NoSuchMethodException ex)
        {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private int code;
    private String url;

    public HTTPCodeException(String url, int code, Throwable inner)
    {
        super("Server returned error code " + code + " for url '" + url + "'", inner);
        this.code = code;
        this.url = url;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public static RuntimeException buildException(IOException ex)
    {
        String message = ex.getMessage();
        if(message.matches("Server returned HTTP response code: \\d{3} for URL: .*"))
        {
            try
            {
                String[] parts = message.split(":", 3);
                int code = Integer.parseInt(parts[1].trim().substring(0, 3));
                String url = parts[2].trim();

                if(knownErrorCodes.containsKey(code))
                {
                    return knownErrorCodes.get(code).newInstance(url, code, ex);
                }

                return new HTTPCodeException(url, code, ex);
            }
            catch(Exception ex2)
            {
                return new RuntimeException(ex);
            }
        }
        else
        {
            return new RuntimeException(ex);
        }
    }

    private static void addKnownErrorCodeClass(Class<? extends HTTPKnownCodeException> cl) throws NoSuchMethodException
    {
        Constructor<? extends HTTPKnownCodeException> constr = cl.getConstructor(String.class, Integer.TYPE, Throwable.class);

        for(int errorCode : HTTPKnownCodeException.errorCodes(cl))
        {
            knownErrorCodes.put(errorCode, constr);
        }
    }
}
