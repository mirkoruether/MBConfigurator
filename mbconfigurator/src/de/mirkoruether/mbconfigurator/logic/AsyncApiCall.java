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
import static de.mirkoruether.mbconfigurator.gui.Main.MARKET;

public class AsyncApiCall
{
    private final String market;
    private final Consumer<Runnable> callbackThread;

    public AsyncApiCall(String market, Consumer<Runnable> callbackThread)
    {
        this.market = market;
        this.callbackThread = callbackThread;
    }

    public void getClasses(Consumer<VehicleClass[]> callback)
    {
        new Thread(()
                ->
        {
            VehicleClass[] classes = MBConfigurator.getVehicleClasses(MARKET, null, null);
            doCallback(callback, classes);
        }).start();
    }

    public void getBodies(VehicleClass cl, Consumer<VehicleBody[]> callback)
    {
        String clId = cl == null ? null : cl.getClassId();
        if(clId != null)
        {
            new Thread(()
                    ->
            {
                VehicleBody[] bodies = MBConfigurator.getVehicleBodies(market, null, clId);
                doCallback(callback, bodies);
            }).start();
        }
    }

    public void getModels(VehicleClass cl, VehicleBody bdy, Consumer<Model[]> callback)
    {
        String clId = cl == null ? null : cl.getClassId();
        String bdyId = bdy == null ? null : bdy.getBodyId();

        if(clId != null && !clId.trim().isEmpty()
           && bdyId != null && !bdyId.trim().isEmpty())
        {
            new Thread(()
                    ->
            {
                Model[] models = MBConfigurator.getModels(MARKET, null, clId, bdyId);
                doCallback(callback, models);
            }).start();
        }
    }

    public void getAlternatives(Configuration currentCfg, ChangeSet cs, Consumer<ConfigurationAlternative[]> callback)
    {
        if(currentCfg != null && !cs.isEmpty())
        {
            new Thread(()
                    ->
            {
                ConfigurationAlternative[] alts = MBConfigurator
                        .getAlternatives(MARKET, currentCfg.getModelId(), currentCfg.getConfigurationId(), cs.toString());
                doCallback(callback, alts);
            }).start();
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
        new Thread(()
                ->
        {
            Configuration conf = MBConfigurator.getConfiguration(MARKET, modelId, cfgid);
            doCallback(callback, conf);
        }).start();
    }

    private <T> void doCallback(Consumer<T> callback, T obj)
    {
        callbackThread.accept(() -> callback.accept(obj));
    }
}
