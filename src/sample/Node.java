package sample;

import java.util.ArrayList;
import java.util.Objects;

public class Node
{
    protected String name;
    protected String description;
    protected boolean isSection;
    protected String fsName;
    protected ArrayList<Node> nodes;

    public Node()
    {
        name = "";
        description = "";
        isSection = false;
        fsName = "";
        nodes = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isSection()
    {
        return isSection;
    }

    public void setSection(boolean section)
    {
        isSection = section;
    }

    public String getFsName()
    {
        return fsName;
    }

    public void setFsName(String fsName)
    {
        this.fsName = fsName;
    }

    public ArrayList<Node> getNodes()
    {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes)
    {
        this.nodes = nodes;
    }

    @Override
    public String toString()
    {
        return name + " - " + fsName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Node node = (Node) o;
        return isSection == node.isSection &&
                Objects.equals(name, node.name) &&
                Objects.equals(description, node.description) &&
                Objects.equals(fsName, node.fsName) &&
                Objects.equals(nodes, node.nodes);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, description, isSection, fsName, nodes);
    }
}
