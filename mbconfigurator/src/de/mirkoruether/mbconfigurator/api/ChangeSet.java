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
package de.mirkoruether.mbconfigurator.api;

import de.mirkoruether.util.LinqList;
import java.util.List;

public class ChangeSet
{
    private List<String> addedComponetIds;
    private List<String> removedComponetIds;

    public ChangeSet()
    {
    }

    public ChangeSet(List<String> addedComponetIds, List<String> removedComponetIds)
    {
        this.addedComponetIds = addedComponetIds;
        this.removedComponetIds = removedComponetIds;
    }

    public List<String> getAddedComponetIds()
    {
        return addedComponetIds;
    }

    public void setAddedComponetIds(List<String> addedComponetIds)
    {
        this.addedComponetIds = addedComponetIds;
    }

    public List<String> getRemovedComponetIds()
    {
        return removedComponetIds;
    }

    public void setRemovedComponetIds(List<String> removedComponetIds)
    {
        this.removedComponetIds = removedComponetIds;
    }

    public boolean isEmpty()
    {
        return (addedComponetIds == null || addedComponetIds.isEmpty())
               && (removedComponetIds == null || removedComponetIds.isEmpty());
    }

    @Override
    public String toString()
    {
        String added = (addedComponetIds == null || addedComponetIds.isEmpty()) ? ""
                       : "+" + CodeParser.build(addedComponetIds);
        String removed = (removedComponetIds == null || removedComponetIds.isEmpty()) ? ""
                         : "-" + CodeParser.build(addedComponetIds);
        if(!added.isEmpty() && !removed.isEmpty())
        {
            return added + "," + removed;
        }
        return added + removed;
    }

    public static ChangeSet build(List<String> oldIds, List<String> newIds)
    {
        return new ChangeSet(new LinqList<String>(newIds).where(id -> !oldIds.contains(id)),
                             new LinqList<String>(oldIds).where(id -> !newIds.contains(id)));
    }
}
