package sample;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Screen implements Initializable
{
    @FXML
    GridPane gridPane_header;
    @FXML GridPane gridPane_content;

    private final int imageView_titleImage_fitWidth;
    private final int imageView_titleImage_fitHeight;
    private final int gridPane_content_columnWidth;

    //endregion


    //region constructors

    public Screen()
    {
        imageView_titleImage_fitWidth = 300;
        imageView_titleImage_fitHeight = 40;
        gridPane_content_columnWidth = 300;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ImageView imageView_logo = new ImageView("/sample/_logo1.png");
        gridPane_header.add(imageView_logo, 0, 0);

        generateMenu();
    }

    public void generateMenu()
    {
        sample.Node rootNode = Storage.getInstance().getRepositoryRootNode();

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100);
        rowConstraints.setValignment(VPos.CENTER);
        rowConstraints.setVgrow(Priority.NEVER);
        gridPane_content.getRowConstraints().add(rowConstraints);

        int columnIndex = 0;

        for (sample.Node sectionNode : rootNode.getNodes())
        {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0 / rootNode.getNodes().size());
            columnConstraints.setHalignment(HPos.CENTER);
            columnConstraints.setHgrow(Priority.NEVER);
            gridPane_content.getColumnConstraints().add(columnConstraints);

            javafx.scene.Node node = getMenuSectionNode(sectionNode);

            gridPane_content.add(node, columnIndex++, 0);
        }
    }

    public javafx.scene.Node getMenuSectionNode(sample.Node rootSection)
    {
        VBox vBox = new VBox();
        vBox.setSpacing(5.0);

        StackPane titleStackPane = new StackPane();

        //title
        Hyperlink titleHyperlink = new Hyperlink();
        titleHyperlink.setFont(Font.font(30));
        titleHyperlink.setText(rootSection.getName());
        titleHyperlink.setOnAction(event -> {
            vBox.getChildren().setAll(getMenuSectionNode(rootSection));
        });

        ImageView titleImage = new ImageView("/sample/section_title_background.png");
        //titleImage.setFitHeight(imageView_titleImage_fitHeight);
        //titleImage.setFitWidth(imageView_titleImage_fitWidth);
        //titleImage.fitWidthProperty().bind(titleHyperlink.widthProperty());
        //titleImage.fitHeightProperty().bind(titleHyperlink.heightProperty());
        titleImage.setPreserveRatio(true);
        titleImage.setSmooth(true);

        titleStackPane.getChildren().add(titleImage);
        titleStackPane.getChildren().add(titleHyperlink);

        vBox.getChildren().add(titleStackPane);

        //tooltip
        if (!rootSection.getDescription().equals(""))
        {
            Tooltip titleTooltip = new Tooltip();
            titleTooltip.setText(rootSection.getDescription());
            titleHyperlink.setTooltip(titleTooltip);
        }

        //list
        javafx.scene.Node subSectionsListNode = getSubSectionsListNode(rootSection);
        vBox.getChildren().add(subSectionsListNode);

        return vBox;
    }

    public javafx.scene.Node getSubSectionsListNode(sample.Node section)
    {
        VBox vBox = new VBox();
        vBox.setSpacing(5.0);

        //list
        for (sample.Node subSection : section.getNodes())
        {
            //title
            Hyperlink itemHyperlink = new Hyperlink();
            itemHyperlink.setText(subSection.getName());
            itemHyperlink.setFont(Font.font(20));

            if (subSection.isSection())
            {
                //navigate down
                itemHyperlink.setOnAction(event -> {
                    System.out.println(subSection.getName());

                    if (subSection.getNodes().size() > 0 && subSection.isSection())
                    {
                        //navigate up
                        Button button = new Button();
                        button.setText("Navigate up");
                        button.setOnAction(event2 -> {
                            vBox.getChildren().setAll(getSubSectionsListNode(section));
                        });

                        //delete previous
                        vBox.getChildren().clear();

                        //add new
                        vBox.getChildren().add(button);
                        vBox.getChildren().add(getSubSectionsListNode(subSection));
                    }
                    else
                    {
                        System.err.println("Nothing to show.");
                    }
                });
            }
            else
            {
                //open content
                itemHyperlink.setOnAction(event -> {
                    System.out.println(subSection.getName());
                });
            }

            vBox.getChildren().add(itemHyperlink);
        }

        return vBox;
    }
}
