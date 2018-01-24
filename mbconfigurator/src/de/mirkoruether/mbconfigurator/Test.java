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
package de.mirkoruether.mbconfigurator;

import de.mirkoruether.mbconfigurator.api.MBConfigurator;
import de.mirkoruether.mbconfigurator.pojo.Configuration;
import de.mirkoruether.mbconfigurator.pojo.Market;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.Selectables;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;

public class Test
{
    public static void main(String[] args)
    {
        Market[] markets = MBConfigurator.getMarkets("DE");
        VehicleClass[] classes = MBConfigurator.getVehicleClasses(markets[0].getMarketId(), null, null);
        VehicleBody[] bodies = MBConfigurator.getVehicleBodies(markets[0].getMarketId(), null, classes[0].getClassId());
        Model[] models = MBConfigurator.getModels(markets[0].getMarketId(), null, classes[0].getClassId(), bodies[0].getBodyId());
        Configuration config = MBConfigurator.getInitialConfiguration(markets[0].getMarketId(), models[0].getModelId());
        Selectables selectables = MBConfigurator.fromLink(config.getLinks(), "selectables", Selectables.class);
        System.out.println(selectables.getVehicleComponents().size());
    }
}
