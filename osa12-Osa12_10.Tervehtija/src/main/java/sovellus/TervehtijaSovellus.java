package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TervehtijaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {

      // 1.1 luodaan käytettävät komponentit
      Label ohjeteksti = new Label("Kirjoita nimesi ja aloita");
      TextField nimikentta = new TextField();
      Button aloitusnappi = new Button("Aloita");
      Label virheteksti = new Label("");

      // 1.2 luodaan asettelu ja lisätään komponentit siihen
      GridPane asettelu = new GridPane();

      asettelu.add(ohjeteksti, 0, 0);
      asettelu.add(nimikentta, 0, 1);
      asettelu.add(aloitusnappi, 0, 2);
      asettelu.add(virheteksti, 0, 3);

      // 1.3 tyylitellään asettelua
      asettelu.setPrefSize(300, 180);
      asettelu.setAlignment(Pos.CENTER);
      asettelu.setVgap(10);
      asettelu.setHgap(10);
      asettelu.setPadding(new Insets(20, 20, 20, 20));

      // 1.4 luodaan itse näkymä ja asetetaan asettelu siihen
      Scene ekaNakyma = new Scene(asettelu);

      String nimi = "";
      
      // 2. Luodaan tervetuloa-tekstin näyttämiseen käytetty näkymä
      Label tervetuloaTeksti = new Label("Tervetuloa " + nimi + "!");

      StackPane tervetuloaAsettelu = new StackPane();
      tervetuloaAsettelu.setPrefSize(300, 180);
      tervetuloaAsettelu.getChildren().add(tervetuloaTeksti);
      tervetuloaAsettelu.setAlignment(Pos.CENTER);

      Scene tervetuloaNakyma = new Scene(tervetuloaAsettelu);


      // 3. Lisätään salasanaruudun nappiin tapahtumankäsittelijä
      //    näkymää vaihdetaan jos salasana on oikein
      aloitusnappi.setOnAction((event) -> {
            if (nimikentta.getText().trim().equals("")) {
                virheteksti.setText("Elä syötä tyhjää!");
                return;
            }
            
            tervetuloaTeksti.setText("Tervetuloa " + nimikentta.getText() + "!");
            ikkuna.setScene(tervetuloaNakyma);
          
      });

      ikkuna.setScene(ekaNakyma);
      ikkuna.show();
    }

    public static void main(String[] args) {
        launch(TervehtijaSovellus.class);
    }
}