package sample;

import java.util.ArrayList;
import java.util.Objects;

public class Repository
{
    private String name;
    private String description;
    private ArrayList<Section> sections;
    private ArrayList<Entry> entries;
    private String directory;

    public Repository()
    {
        name = "";
        description = "";
        sections = new ArrayList<>();
        entries = new ArrayList<>();
        directory = "";
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

    public ArrayList<Section> getSections()
    {
        return sections;
    }

    public void setSections(ArrayList<Section> sections)
    {
        this.sections = sections;
    }

    public ArrayList<Entry> getEntries()
    {
        return entries;
    }

    public void setEntries(ArrayList<Entry> entries)
    {
        this.entries = entries;
    }

    public String getDirectory()
    {
        return directory;
    }

    public void setDirectory(String directory)
    {
        this.directory = directory;
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
        Repository that = (Repository) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(sections, that.sections) &&
                Objects.equals(entries, that.entries) &&
                Objects.equals(directory, that.directory);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, description, sections, entries, directory);
    }


    //endregion
}
