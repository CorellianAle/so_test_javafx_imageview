package sample;

import java.util.ArrayList;
import java.util.Objects;

public class Section
{
    private String name;
    private String description;
    private String directory;
    private ArrayList<Section> sections;
    private ArrayList<Entry> entries;

    public Section()
    {
        name = "";
        description = "";
        directory = "";
        sections = new ArrayList<>();
        entries = new ArrayList<>();
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

    public String getDirectory()
    {
        return directory;
    }

    public void setDirectory(String directory)
    {
        this.directory = directory;
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
        Section section = (Section) o;
        return Objects.equals(name, section.name) &&
                Objects.equals(description, section.description) &&
                Objects.equals(directory, section.directory) &&
                Objects.equals(sections, section.sections) &&
                Objects.equals(entries, section.entries);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, description, directory, sections, entries);
    }
}
