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
package de.mirkoruether.mbconfigurator.logic;

import de.mirkoruether.mbconfigurator.api.ChangeSet;
import de.mirkoruether.mbconfigurator.api.MBConfigurator;
import de.mirkoruether.mbconfigurator.pojo.Configuration;
import de.mirkoruether.mbconfigurator.pojo.ConfigurationAlternative;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;
import java.util.function.Consumer;
import java.util.function.Supplier;
import static de.mirkoruether.mbconfigurator.gui.Main.MARKET;

public class AsyncApiCall
{
    private final String market;
    private final Consumer<Runnable> callbackThread;
    private final Consumer<Throwable> errorCallback;

    public AsyncApiCall(String market, Consumer<Runnable> callbackThread, Consumer<Throwable> errorCallback)
    {
        this.market = market;
        this.callbackThread = callbackThread;
        this.errorCallback = errorCallback;
    }

    public void getClasses(Consumer<VehicleClass[]> callback)
    {
        exec(() -> MBConfigurator.getVehicleClasses(MARKET, null, null), callback);
    }

    public void getBodies(VehicleClass cl, Consumer<VehicleBody[]> callback)
    {
        String clId = cl == null ? null : cl.getClassId();
        if(clId != null)
        {
            exec(() -> MBConfigurator.getVehicleBodies(market, null, clId), callback);
        }
    }

    public void getModels(VehicleClass cl, VehicleBody bdy, Consumer<Model[]> callback)
    {
        String clId = cl == null ? null : cl.getClassId();
        String bdyId = bdy == null ? null : bdy.getBodyId();

        if(clId != null && !clId.trim().isEmpty()
           && bdyId != null && !bdyId.trim().isEmpty())
        {
            exec(() -> MBConfigurator.getModels(MARKET, null, clId, bdyId), callback);
        }
    }

    public void getAlternatives(Configuration currentCfg, ChangeSet cs, Consumer<ConfigurationAlternative[]> callback)
    {
        if(currentCfg != null && !cs.isEmpty())
        {
            exec(() -> MBConfigurator.getAlternatives(MARKET, currentCfg.getModelId(), currentCfg.getConfigurationId(), cs.toString()), callback);
        }
    }

    public void getConfig(ConfigurationAlternative alt, Consumer<Configuration> callback)
    {
        if(alt != null)
        {
            getConfig(alt.getModelId(), alt.getConfigurationId(), callback);
        }
    }

    public void getConfig(Configuration cfg, Consumer<Configuration> callback)
    {
        if(cfg != null)
        {
            getConfig(cfg.getModelId(), cfg.getConfigurationId(), callback);
        }
    }

    public void getConfig(String modelId, String cfgid, Consumer<Configuration> callback)
    {
        exec(() -> MBConfigurator.getConfiguration(MARKET, modelId, cfgid), callback);
    }

    private <T> void exec(Supplier<T> func, Consumer<T> callback)
    {
        new Thread(()
                ->
        {
            try
            {
                T obj = func.get();
                callbackThread.accept(() -> callback.accept(obj));
            }
            catch(Throwable t)
            {
                if(errorCallback == null)
                    t.printStackTrace();
                else
                    callbackThread.accept(() -> errorCallback.accept(t));
            }
        }).start();
    }
}
