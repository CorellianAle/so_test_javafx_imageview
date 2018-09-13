package sample;

import java.util.Objects;

public class Entry
{
    protected String name;

    protected String description;

    protected String filename;

    public Entry()
    {
        name = "";
        description = "";
        filename = "";
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

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
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
        Entry entity = (Entry) o;
        return Objects.equals(name, entity.name) &&
                Objects.equals(description, entity.description) &&
                Objects.equals(filename, entity.filename);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, description, filename);
    }
}
