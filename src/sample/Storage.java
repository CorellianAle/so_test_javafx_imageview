package sample;

public class Storage
{
    private static Storage instance = new Storage();

    private Storage()
    {

    }

    public static Storage getInstance()
    {
        return instance;
    }

    Repository getRepository()
    {
        Repository repository = new Repository();


        for (int i = 0; i < 5; ++i)
        {
            Section section = new Section();
            section.setName("Section " + Integer.toString(i));
            section.setDescription("Description " + Integer.toString(i));
            section.setDirectory("section_" + Integer.toString(i));

            for (int j = 0; j < 5; ++j)
            {
                Section subSection = new Section();
                subSection.setName("Sub-Section " + Integer.toString(j));
                subSection.setDescription("Description " + Integer.toString(j));
                subSection.setDirectory("sub_section_" + Integer.toString(j));

                for (int k = 0; k < 10; ++k)
                {
                    Entry entry = new Entry();
                    entry.setName("Entry " + Integer.toString(k));
                    entry.setDescription("Description " + Integer.toString(k));
                    entry.setFilename("entry_" + Integer.toString(k));

                    subSection.getEntries().add(entry);
                }

                section.getSections().add(subSection);
            }

            repository.getSections().add(section);
        }

        return repository;
    }

    Node getRepositoryRootNode()
    {
        Node rootNode = new Node();

        for (int i = 0; i < 10; ++i)
        {
            Node sectionNode = new Node();
            sectionNode.setName("Section " + Integer.toString(i));
            sectionNode.setDescription("Description " + Integer.toString(i));
            sectionNode.setFsName("section_" + Integer.toString(i));
            sectionNode.setSection(true);

            for (int j = 0; j < 10; ++j)
            {
                Node subSectionNode = new Node();
                subSectionNode.setName("Section" + Integer.toString(i) + " - Subsection " + Integer.toString(j));
                subSectionNode.setDescription("Description " + Integer.toString(j));
                subSectionNode.setFsName("section_" + Integer.toString(i) + "_subsection_" + Integer.toString(j));
                subSectionNode.setSection(true);

                for (int k = 0; k < 10; ++k)
                {
                    Node entryNode = new Node();
                    entryNode.setName("Section " + Integer.toString(i) + " -  Subsection " + Integer.toString(j) + " - Entry " + Integer.toString(k));
                    entryNode.setDescription("Description " + Integer.toString(k));
                    entryNode.setFsName("section_" + Integer.toString(i) + "_subsection_" + Integer.toString(j) + "_entry_" + Integer.toString(k) + ".txt");
                    entryNode.setSection(false);

                    subSectionNode.getNodes().add(entryNode);
                }

                sectionNode.getNodes().add(subSectionNode);
            }

            rootNode.getNodes().add(sectionNode);
        }

        return rootNode;
    }
}
