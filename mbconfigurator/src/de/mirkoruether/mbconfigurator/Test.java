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

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

public class Test
{
    public static void main(String[] args) throws Throwable
    {
//        Market[] markets = MBConfigurator.getMarkets("DE");
//        VehicleClass[] classes = MBConfigurator.getVehicleClasses(markets[0].getMarketId(), null, null);
//        VehicleBody[] bodies = MBConfigurator.getVehicleBodies(markets[0].getMarketId(), null, classes[0].getClassId());
//        Model[] models = MBConfigurator.getModels(markets[0].getMarketId(), null, classes[0].getClassId(), bodies[0].getBodyId());
//        Configuration config = MBConfigurator.getInitialConfiguration(markets[0].getMarketId(), models[0].getModelId());
//        Selectables selectables = MBConfigurator.fromLink(config.getLinks(), "selectables", Selectables.class);
//        System.out.println(selectables.getVehicleComponents().size());

        String url = "https://europe.starconnect-ce.i.daimler.com/iris/iris?COSY-EU-100-1713d0VXq5WFqtyO35PobzIExXrItvsTQKkojUfGoo7GE11KFm9mWa9Q6FjcBXwOkXGEundJ0l3okOB2NbFbApj7pI5uVK2QC31SrkzNwlwm7jAeDhKV5YF%25vqCI9yLRzQmYax7kErH1eBdn8wszxoiZU%25oM4FGyQTg906E6PDMLoSeWTnRtsd7hNcUfKONXGE4ydJ0lCYJOB2znobQOcxwRs%25M4FsQkTSMp1P6tTUkpSeW9mhtsdDsDcUfWO6XGEdnXJ0lfolOB2EMEbApldRI5u2f2QC3pXrkzNuJNm7j3O3hKVuXQ%25vqat%25yLRHLVYax8bWrH1iIin8wzofoiZ6koM4F54JTg97Q96PDKksSeWvm9tsdMHQcUfTFyXGE6TjJ0lSOfOB2RBqbApxPbI5u1eDQC3wh1kzNZ%25bm7jF2mhKV9ch%25vqDcdyLRoYfYaxM48rH1Lmln8wah4oiZX7XM4FJmPTg9OY26PDTkFSeW6mhtsdTZTcUf6XfXGE0ymJ0lBYtOB2ABqbAp5dRI5gZ8lXhRjwQZz2H%25NUuoQ3pE77V9hDNt3DkSW9wUwopoL24PvEa2zq7XA5q&&IMGT=P27&POV=BE020,PZM";

        BufferedImage i = ImageIO.read(new URL(url));
        System.out.println(i.getWidth());
    }
}
