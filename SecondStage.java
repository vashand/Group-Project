import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class SecondStage extends Stage
{
	String playerName;
	int turnNum = 1; // Turn number
	int score = 0; // The players score

	// The SecondStage constructor
	public SecondStage(String playerName)
	{
		super ( );
		this.playerName = playerName;
	}

	public void start( Stage secondaryStage )
	{
		StackPane root = new StackPane ( );
		Scene scene = new Scene ( root, 1920, 1080 );
		Image image = new Image ( "Player Screen White.jpg" );

		// Quit button
		Button quit = new Button ( "Evacuate Colony" );
		quit.setTranslateX ( -800 );
		quit.setTranslateY ( -450 );
		quit.setOnAction ( new EventHandler<ActionEvent> ( )
		{
			@Override
			public void handle( ActionEvent event )
			{
				QuitStage quitWindow = new QuitStage ( );
				quitWindow.start ( quitWindow );
			}// end action
		} );

		// Guide button
		Button guide = new Button ( "Martian Colony \nBuilders Guide" );
		guide.setTranslateX ( -800 );
		guide.setTranslateY ( -400 );
		guide.setOnAction ( new EventHandler<ActionEvent> ( )
		{
			@Override
			public void handle( ActionEvent event )
			{
				GuideStage guideWindow = new GuideStage ( );
				guideWindow.start ( guideWindow );
			}// end action
		} );

		// Player name with dropshadow
		DropShadow shadow = new DropShadow ( );
		shadow.setRadius ( 10.0 );
		shadow.setOffsetX ( 5.0 );
		shadow.setOffsetY ( 5.0 );
		Text player = new Text ( );
		player.setEffect ( shadow );
		player.setCache ( true );
		player.setTranslateY ( -425 );
		player.setFill ( Color.GREEN );
		player.setText ( playerName );
		player.setFont ( Font.font ( null, 100 ) );

		// Number of turns & score text
		Text turn = new Text ( );
		turn.setCache ( true );
		turn.setTranslateY ( -325 );
		turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
		turn.setFont ( Font.font ( null, 35 ) );

		// Text area for in game console-type output
		TextArea inGameConsole = new TextArea ( );
		inGameConsole.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		inGameConsole.setFont ( Font.font ( null, 20 ) );
		inGameConsole.setText ( "\t\t" + playerName + "'s Game History\n" );
		inGameConsole.setMaxWidth ( 425 );
		inGameConsole.setMaxHeight ( 1000 );
		inGameConsole.setTranslateX ( 750 );

		// MAIN ROADS
		// -----------------------------------------------------
		// Road node 1
		Image road = new Image ( getClass ( ).getResourceAsStream ( "road.png" ) );
		Image roadC = new Image ( getClass ( ).getResourceAsStream ( "roadC.png" ) );
		Button roadNode1Btn = new Button ( );
		roadNode1Btn.setGraphic ( new ImageView ( road ) );
		roadNode1Btn.setPadding ( Insets.EMPTY );
		roadNode1Btn.getTransforms ( ).add ( new Rotate ( 135, 0, 0 ) );
		roadNode1Btn.setTranslateX ( -31 );
		roadNode1Btn.setTranslateY ( -55 );
		roadNode1Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				roadNode1Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased main road 1\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Road node 2
		Button roadNode2Btn = new Button ( );
		roadNode2Btn.setGraphic ( new ImageView ( road ) );
		roadNode2Btn.getTransforms ( ).add ( new Rotate ( 45, 0, 0 ) );
		roadNode2Btn.setPadding ( Insets.EMPTY );
		roadNode2Btn.setTranslateX ( -92 );
		roadNode2Btn.setTranslateY ( 14 );
		roadNode2Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				roadNode2Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased main road 2\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Road node 3
		Button roadNode3Btn = new Button ( );
		roadNode3Btn.setGraphic ( new ImageView ( road ) );
		roadNode3Btn.setPadding ( Insets.EMPTY );
		roadNode3Btn.setTranslateY ( 85 );
		roadNode3Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				roadNode3Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased main road 3\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Road node 4
		Button roadNode4Btn = new Button ( );
		roadNode4Btn.setGraphic ( new ImageView ( road ) );
		roadNode4Btn.setPadding ( Insets.EMPTY );
		roadNode4Btn.getTransforms ( ).add ( new Rotate ( 135, 0, 0 ) );
		roadNode4Btn.setTranslateX ( 192 );
		roadNode4Btn.setTranslateY ( 32 );
		roadNode4Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				roadNode4Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased main road 4\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Road node 5
		Button roadNode5Btn = new Button ( );
		roadNode5Btn.setGraphic ( new ImageView ( road ) );
		roadNode5Btn.setPadding ( Insets.EMPTY );
		roadNode5Btn.getTransforms ( ).add ( new Rotate ( 45, 0, 0 ) );
		roadNode5Btn.setTranslateX ( 134 );
		roadNode5Btn.setTranslateY ( -67 );
		roadNode5Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				roadNode5Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased main road 5\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Road node 6
		Button roadNode6Btn = new Button ( );
		roadNode6Btn.setGraphic ( new ImageView ( road ) );
		roadNode6Btn.setPadding ( Insets.EMPTY );
		roadNode6Btn.setTranslateY ( -85 );
		roadNode6Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				roadNode6Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased main road 6\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// SIDE ROADS
		// -----------------------------------------------------
		// Side Road node 1
		Button sideRoadNode1Btn = new Button ( );
		sideRoadNode1Btn.setGraphic ( new ImageView ( road ) );
		sideRoadNode1Btn.setPadding ( Insets.EMPTY );
		sideRoadNode1Btn.setTranslateX ( -220 );
		sideRoadNode1Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				sideRoadNode1Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased side road 1\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// Side Road node 2
		Button sideRoadNode2Btn = new Button ( );
		sideRoadNode2Btn.setGraphic ( new ImageView ( road ) );
		sideRoadNode2Btn.setPadding ( Insets.EMPTY );
		sideRoadNode2Btn.getTransforms ( ).add ( new Rotate ( 135, 0, 0 ) );
		sideRoadNode2Btn.setTranslateX ( -32 );
		sideRoadNode2Btn.setTranslateY ( 115 );
		sideRoadNode2Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				sideRoadNode2Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased side road 2\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Side Road node 3
		Button sideRoadNode3Btn = new Button ( );
		sideRoadNode3Btn.setGraphic ( new ImageView ( road ) );
		sideRoadNode3Btn.setPadding ( Insets.EMPTY );
		sideRoadNode3Btn.getTransforms ( ).add ( new Rotate ( 45, 0, 0 ) );
		sideRoadNode3Btn.setTranslateX ( 132 );
		sideRoadNode3Btn.setTranslateY ( 100 );
		sideRoadNode3Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				sideRoadNode3Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased side road 3\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Side Road node 4
		Button sideRoadNode4Btn = new Button ( );
		sideRoadNode4Btn.setGraphic ( new ImageView ( road ) );
		sideRoadNode4Btn.setPadding ( Insets.EMPTY );
		sideRoadNode4Btn.setTranslateX ( 216 );
		sideRoadNode4Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				sideRoadNode4Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased side road 4\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Side Road node 5
		Button sideRoadNode5Btn = new Button ( );
		sideRoadNode5Btn.setGraphic ( new ImageView ( road ) );
		sideRoadNode5Btn.setPadding ( Insets.EMPTY );
		sideRoadNode5Btn.getTransforms ( ).add ( new Rotate ( 135, 0, 0 ) );
		sideRoadNode5Btn.setTranslateX ( 192 );
		sideRoadNode5Btn.setTranslateY ( -140 );
		sideRoadNode5Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				sideRoadNode5Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased side road 5\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Side Road node 6
		Button sideRoadNode6Btn = new Button ( );
		sideRoadNode6Btn.setGraphic ( new ImageView ( road ) );
		sideRoadNode6Btn.setPadding ( Insets.EMPTY );
		sideRoadNode6Btn.getTransforms ( ).add ( new Rotate ( 45, 0, 0 ) );
		sideRoadNode6Btn.setTranslateX ( -90 );
		sideRoadNode6Btn.setTranslateY ( -150 );
		sideRoadNode6Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				sideRoadNode6Btn.setGraphic ( new ImageView ( roadC ) );
				inGameConsole.appendText("You purchased side road 6\n");
				score++;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// ASTRONAUTS
		// -----------------------------------------------------
		// Astronaut node 1
		Image astro1 = new Image ( getClass ( ).getResourceAsStream ( "astro1.png" ) );
		Image astro1C = new Image ( getClass ( ).getResourceAsStream ( "astro1C.png" ) );
		Button astroNode1Btn = new Button ( );
		astroNode1Btn.setGraphic ( new ImageView ( astro1 ) );
		astroNode1Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		astroNode1Btn.setTranslateX ( -218 );
		astroNode1Btn.setTranslateY ( -130 );
		astroNode1Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				astroNode1Btn.setGraphic ( new ImageView ( astro1C ) );
				inGameConsole.appendText("You purchased astronaut 1\n");
				score += 1;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Astronaut node 2
		Image astro2 = new Image ( getClass ( ).getResourceAsStream ( "astro2.png" ) );
		Image astro2C = new Image ( getClass ( ).getResourceAsStream ( "astro2C.png" ) );
		Button astroNode2Btn = new Button ( );
		astroNode2Btn.setGraphic ( new ImageView ( astro2 ) );
		astroNode2Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		astroNode2Btn.setTranslateX ( -218 );
		astroNode2Btn.setTranslateY ( 35 );
		astroNode2Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				astroNode2Btn.setGraphic ( new ImageView ( astro2C ) );
				inGameConsole.appendText("You purchased astronaut 2\n");
				score += 2;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Astronaut node 3
		Image astro3 = new Image ( getClass ( ).getResourceAsStream ( "astro3.png" ) );
		Image astro3C = new Image ( getClass ( ).getResourceAsStream ( "astro3C.png" ) );
		Button astroNode3Btn = new Button ( );
		astroNode3Btn.setGraphic ( new ImageView ( astro3 ) );
		astroNode3Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		astroNode3Btn.setTranslateY ( 118 );
		astroNode3Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				astroNode3Btn.setGraphic ( new ImageView ( astro3C ) );
				inGameConsole.appendText("You purchased astronaut 3\n");
				score += 3;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Astronaut node 4
		Image astro4 = new Image ( getClass ( ).getResourceAsStream ( "astro4.png" ) );
		Image astro4C = new Image ( getClass ( ).getResourceAsStream ( "astro4C.png" ) );
		Button astroNode4Btn = new Button ( );
		astroNode4Btn.setGraphic ( new ImageView ( astro4 ) );
		astroNode4Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		astroNode4Btn.setTranslateX ( 222 );
		astroNode4Btn.setTranslateY ( 37 );
		astroNode4Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				astroNode4Btn.setGraphic ( new ImageView ( astro4C ) );
				inGameConsole.appendText("You purchased astronaut 4\n");
				score += 4;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Astronaut node 5
		Image astro5 = new Image ( getClass ( ).getResourceAsStream ( "astro5.png" ) );
		Image astro5C = new Image ( getClass ( ).getResourceAsStream ( "astro5C.png" ) );
		Button astroNode5Btn = new Button ( );
		astroNode5Btn.setGraphic ( new ImageView ( astro5 ) );
		astroNode5Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		astroNode5Btn.setTranslateX ( 222 );
		astroNode5Btn.setTranslateY ( -130 );
		astroNode5Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				astroNode5Btn.setGraphic ( new ImageView ( astro5C ) );
				inGameConsole.appendText("You purchased astronaut 5\n");
				score += 5;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Astronaut node 6
		Image astro6 = new Image ( getClass ( ).getResourceAsStream ( "astro6.png" ) );
		Image astro6C = new Image ( getClass ( ).getResourceAsStream ( "astro6C.png" ) );
		Button astroNode6Btn = new Button ( );
		astroNode6Btn.setGraphic ( new ImageView ( astro6 ) );
		astroNode6Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		astroNode6Btn.setTranslateY ( -213 );
		astroNode6Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				astroNode6Btn.setGraphic ( new ImageView ( astro6C ) );
				inGameConsole.appendText("You purchased Mark Watney!\n");
				score += 9;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// DOMES
		// -----------------------------------------------------
		// Dome node 1
		Image dome1 = new Image ( getClass ( ).getResourceAsStream ( "dome1.png" ) );
		Image dome1C = new Image ( getClass ( ).getResourceAsStream ( "dome1C.png" ) );
		Button domeNode1Btn = new Button ( );
		domeNode1Btn.setGraphic ( new ImageView ( dome1 ) );
		domeNode1Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		domeNode1Btn.setTranslateX ( -150 );
		domeNode1Btn.setTranslateY ( -5 );
		domeNode1Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				domeNode1Btn.setGraphic ( new ImageView ( dome1C ) );
				inGameConsole.appendText("You purchased dome 1\n");
				score += 2;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Dome node 2
		Image dome2 = new Image ( getClass ( ).getResourceAsStream ( "dome2.png" ) );
		Image dome2C = new Image ( getClass ( ).getResourceAsStream ( "dome2C.png" ) );
		Button domeNode2Btn = new Button ( );
		domeNode2Btn.setGraphic ( new ImageView ( dome2 ) );
		domeNode2Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		domeNode2Btn.setTranslateX ( -65 );
		domeNode2Btn.setTranslateY ( 80 );
		domeNode2Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				domeNode2Btn.setGraphic ( new ImageView ( dome2C ) );
				inGameConsole.appendText("You purchased dome 2\n");
				score += 4;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Dome node 3
		Image dome3 = new Image ( getClass ( ).getResourceAsStream ( "dome3.png" ) );
		Image dome3C = new Image ( getClass ( ).getResourceAsStream ( "dome3C.png" ) );
		Button domeNode3Btn = new Button ( );
		domeNode3Btn.setGraphic ( new ImageView ( dome3 ) );
		domeNode3Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		domeNode3Btn.setTranslateX ( 66 );
		domeNode3Btn.setTranslateY ( 80 );
		domeNode3Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				domeNode3Btn.setGraphic ( new ImageView ( dome3C ) );
				inGameConsole.appendText("You purchased dome 3\n");
				score += 6;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Dome node 4
		Image dome4 = new Image ( getClass ( ).getResourceAsStream ( "dome4.png" ) );
		Image dome4C = new Image ( getClass ( ).getResourceAsStream ( "dome4C.png" ) );
		Button domeNode4Btn = new Button ( );
		domeNode4Btn.setGraphic ( new ImageView ( dome4 ) );
		domeNode4Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		domeNode4Btn.setTranslateX ( 148 );
		domeNode4Btn.setTranslateY ( -3 );
		domeNode4Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				domeNode4Btn.setGraphic ( new ImageView ( dome4C ) );
				inGameConsole.appendText("You purchased dome 4\n");
				score += 8;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Dome node 5
		Image dome5 = new Image ( getClass ( ).getResourceAsStream ( "dome5.png" ) );
		Image dome5C = new Image ( getClass ( ).getResourceAsStream ( "dome5C.png" ) );
		Button domeNode5Btn = new Button ( );
		domeNode5Btn.setGraphic ( new ImageView ( dome5 ) );
		domeNode5Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		domeNode5Btn.setTranslateX ( 68 );
		domeNode5Btn.setTranslateY ( -88 );
		domeNode5Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				domeNode5Btn.setGraphic ( new ImageView ( dome5C ) );
				inGameConsole.appendText("You purchased dome 5\n");
				score += 10;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Dome node 6
		Image dome6 = new Image ( getClass ( ).getResourceAsStream ( "dome6.png" ) );
		Image dome6C = new Image ( getClass ( ).getResourceAsStream ( "dome6C.png" ) );
		Button domeNode6Btn = new Button ( );
		domeNode6Btn.setGraphic ( new ImageView ( dome6 ) );
		domeNode6Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		domeNode6Btn.setTranslateX ( -65 );
		domeNode6Btn.setTranslateY ( -88 );
		domeNode6Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				domeNode6Btn.setGraphic ( new ImageView ( dome6C ) );
				inGameConsole.appendText("You purchased dome 6\n");
				score += 12;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// RESEARCH STATIONS
		// -----------------------------------------------------
		// Research node 1
		Image research1 = new Image ( getClass ( ).getResourceAsStream ( "research1.png" ) );
		Image research1C = new Image ( getClass ( ).getResourceAsStream ( "research1C.png" ) );
		Button researchNode1Btn = new Button ( );
		researchNode1Btn.setGraphic ( new ImageView ( research1 ) );
		researchNode1Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		researchNode1Btn.setTranslateX ( -285 );
		researchNode1Btn.setTranslateY ( -10 );
		researchNode1Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				researchNode1Btn.setGraphic ( new ImageView ( research1C ) );
				inGameConsole.appendText("You purchased research station 1\n");
				score += 4;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Research node 2
		Image research2 = new Image ( getClass ( ).getResourceAsStream ( "research2.png" ) );
		Image research2C = new Image ( getClass ( ).getResourceAsStream ( "research2C.png" ) );
		Button researchNode2Btn = new Button ( );
		researchNode2Btn.setGraphic ( new ImageView ( research2 ) );
		researchNode2Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		researchNode2Btn.setTranslateX ( -155 );
		researchNode2Btn.setTranslateY ( 160 );
		researchNode2Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				researchNode2Btn.setGraphic ( new ImageView ( research2C ) );
				inGameConsole.appendText("You purchased research station 2\n");
				score += 8;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Research node 3
		Image research3 = new Image ( getClass ( ).getResourceAsStream ( "research3.png" ) );
		Image research3C = new Image ( getClass ( ).getResourceAsStream ( "research3C.png" ) );
		Button researchNode3Btn = new Button ( );
		researchNode3Btn.setGraphic ( new ImageView ( research3 ) );
		researchNode3Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		researchNode3Btn.setTranslateX ( 155 );
		researchNode3Btn.setTranslateY ( 160 );
		researchNode3Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				researchNode3Btn.setGraphic ( new ImageView ( research3C ) );
				inGameConsole.appendText("You purchased research station 3\n");
				score += 12;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Research node 4
		Image research4 = new Image ( getClass ( ).getResourceAsStream ( "research4.png" ) );
		Image research4C = new Image ( getClass ( ).getResourceAsStream ( "research4C.png" ) );
		Button researchNode4Btn = new Button ( );
		researchNode4Btn.setGraphic ( new ImageView ( research4 ) );
		researchNode4Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		researchNode4Btn.setTranslateX ( 283 );
		researchNode4Btn.setTranslateY ( -10 );
		researchNode4Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				researchNode4Btn.setGraphic ( new ImageView ( research4C ) );
				inGameConsole.appendText("You purchased research station 4\n");
				score += 16;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Research node 5
		Image research5 = new Image ( getClass ( ).getResourceAsStream ( "research5.png" ) );
		Image research5C = new Image ( getClass ( ).getResourceAsStream ( "research5C.png" ) );
		Button researchNode5Btn = new Button ( );
		researchNode5Btn.setGraphic ( new ImageView ( research5 ) );
		researchNode5Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		researchNode5Btn.setTranslateX ( 155 );
		researchNode5Btn.setTranslateY ( -178 );
		researchNode5Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				researchNode5Btn.setGraphic ( new ImageView ( research5C ) );
				inGameConsole.appendText("You purchased research station 5\n");
				score += 20;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// -----------------------------------------------------
		// Research node 6
		Image research6 = new Image ( getClass ( ).getResourceAsStream ( "research6.png" ) );
		Image research6C = new Image ( getClass ( ).getResourceAsStream ( "research6C.png" ) );
		Button researchNode6Btn = new Button ( );
		researchNode6Btn.setGraphic ( new ImageView ( research6 ) );
		researchNode6Btn.setStyle ( "-fx-background-color: rgba(0, 0, 0, 0);" );
		researchNode6Btn.setTranslateX ( -155 );
		researchNode6Btn.setTranslateY ( -178 );
		researchNode6Btn.setOnMouseClicked ( new EventHandler<MouseEvent> ( )
		{
			@Override
			public void handle( MouseEvent e )
			{
				researchNode6Btn.setGraphic ( new ImageView ( research6C ) );
				inGameConsole.appendText("You purchased research station 6\n");
				score += 24;
				turn.setText ( "Turn: " + turnNum + "\tScore: " + score );
			}
		} );
		// -----------------------------------------------------

		// Add background & buttons here-----------------------------------------------------------
		root.getChildren ( ).add ( new ImageView ( image ) );
		root.getChildren ( ).add ( quit );
		root.getChildren ( ).add ( guide );
		root.getChildren ( ).add ( player );
		root.getChildren ( ).add ( turn );
		root.getChildren ( ).add ( inGameConsole );
		root.getChildren ( ).add ( roadNode1Btn );
		root.getChildren ( ).add ( roadNode2Btn );
		root.getChildren ( ).add ( roadNode3Btn );
		root.getChildren ( ).add ( roadNode4Btn );
		root.getChildren ( ).add ( roadNode5Btn );
		root.getChildren ( ).add ( roadNode6Btn );
		root.getChildren ( ).add ( sideRoadNode1Btn );
		root.getChildren ( ).add ( sideRoadNode2Btn );
		root.getChildren ( ).add ( sideRoadNode3Btn );
		root.getChildren ( ).add ( sideRoadNode4Btn );
		root.getChildren ( ).add ( sideRoadNode5Btn );
		root.getChildren ( ).add ( sideRoadNode6Btn );
		root.getChildren ( ).add ( astroNode1Btn );
		root.getChildren ( ).add ( astroNode2Btn );
		root.getChildren ( ).add ( astroNode3Btn );
		root.getChildren ( ).add ( astroNode4Btn );
		root.getChildren ( ).add ( astroNode5Btn );
		root.getChildren ( ).add ( astroNode6Btn );
		root.getChildren ( ).add ( domeNode1Btn );
		root.getChildren ( ).add ( domeNode2Btn );
		root.getChildren ( ).add ( domeNode3Btn );
		root.getChildren ( ).add ( domeNode4Btn );
		root.getChildren ( ).add ( domeNode5Btn );
		root.getChildren ( ).add ( domeNode6Btn );
		root.getChildren ( ).add ( researchNode1Btn );
		root.getChildren ( ).add ( researchNode2Btn );
		root.getChildren ( ).add ( researchNode3Btn );
		root.getChildren ( ).add ( researchNode4Btn );
		root.getChildren ( ).add ( researchNode5Btn );
		root.getChildren ( ).add ( researchNode6Btn );

		root.setVisible ( true );

		secondaryStage.setTitle ( playerName + "'s Martian Colony" ); // Set the stage title
		secondaryStage.setScene ( scene ); // Place the scene in the stage
		secondaryStage.show ( ); // Display the stage
		
		// Change color of the inGameConsole textarea after stage is shown
		//Region region = ( Region ) inGameConsole.lookup( ".content" );
		//region.setStyle( "-fx-background-color: black; -fx-text-fill: #00ff00;" ); //#00ff00

	}
}