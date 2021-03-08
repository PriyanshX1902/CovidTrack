package Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class NotificationsController implements Initializable {
    @FXML private Hyperlink link1;
    @FXML private Hyperlink link2;
    @FXML private Hyperlink link3;
    @FXML private Hyperlink link4;
    @FXML private Hyperlink link5;
    @FXML private Hyperlink link6;
    @FXML private Hyperlink link7;
    @FXML private Hyperlink link8;
    @FXML private Hyperlink link9;
    @FXML private Hyperlink link10;
    @FXML private ListView<Hyperlink> listView;
    @FXML private Label TimeStamp;

    public void showData() {
        link1.setText("Revised guidelines for International Arrivals");
        link1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/RevisedguidelinesforInternationalArrivals02082020.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link2.setText("Revised Strategy for COVlD-19 testing in lndia");
        link2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/Revisedtestingguidelines.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link3.setText("When to wear mask?: English");
        link3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/Mask-Eng.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link4.setText("Handling Public Grievances pertaining to COVID-19 in M/o Health & Family Welfare");
        link4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/MoHFWCOVIDNODALOFFICER.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link5.setText("Guidelines for Hotels on preventive measures to contain spread of COVID-19");
        link5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/HotelsGuidelines11thJune.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link6.setText("Preventive measures to be taken to contain the spread of Novel Coronavirus (COVID-19)");
        link6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/PreventivemeasuresDOPT.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link7.setText("Guidelines on disinfection of common public places including offices");
        link7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/Guidelinesondisinfectionofcommonpublicplacesincludingoffices.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link8.setText("Guidelines for Quarantine facilities COVID-19");
        link8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/90542653311584546120quartineguidelines.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link9.setText("Revised advisory on the use of Hydroxychloroquine (HCQ) as prophylaxis for COVID-19 infection");
        link9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/RevisedadvisoryontheuseofhydroxychloroquineasprophylaxisforSARSCOVID19infection.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        link10.setText("SOP on preventive measures in Restaurants to contain spread of COVID-19");
        link10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/3SoPstobefollowedinRestaurants.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getTime());
        String timeStampString = timestamp.toString();
        TimeStamp.setText(timeStampString);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showData();
    }

    public void handleBtnRefreshAction(ActionEvent actionEvent) throws IOException, InterruptedException, URISyntaxException {
        showData();
    }

    public void bookmark1Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link1.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/RevisedguidelinesforInternationalArrivals02082020.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }

    public void bookmark2Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link2.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/Revisedtestingguidelines.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }

    public void bookmark3Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link3.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/Mask-Eng.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }

    public void bookmark4Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link4.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/MoHFWCOVIDNODALOFFICER.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }

    public void bookmark5Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link5.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/HotelsGuidelines11thJune.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }

    public void bookmark6Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link6.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/PreventivemeasuresDOPT.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }

    public void bookmark7Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link7.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/Guidelinesondisinfectionofcommonpublicplacesincludingoffices.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }

    public void bookmark8Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link8.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/90542653311584546120quartineguidelines.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }

    public void bookmark9Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link9.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/RevisedadvisoryontheuseofhydroxychloroquineasprophylaxisforSARSCOVID19infection.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }

    public void bookmark10Action(ActionEvent actionEvent) {
        Hyperlink link = new Hyperlink(link10.getText());
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.mohfw.gov.in/pdf/3SoPstobefollowedinRestaurants.pdf"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        listView.getItems().add(link);
    }
}

