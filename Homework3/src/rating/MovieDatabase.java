package rating;

import java.util.*;
import java.io.*;

public class MovieDatabase {

    //INSTANCE VARIABLES
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorsList;

    //CONSTRUCTOR
    public MovieDatabase() {
	movieList = new ArrayList<Movie>();
	actorsList = new ArrayList<Actor>();
    }

    //METHODS
    public ArrayList<Movie> getMovieList() {
	return movieList;
    }
    public ArrayList<Actor> getActorsList() {
	return actorsList;
    }

    public void addMovie(String name, String[] actors) {

	//create instances of class Actor and add to actorList if new
	ArrayList <Actor> actorNames = new ArrayList<Actor>();
	for(String actor:actors) {
	    Actor currentActor = new Actor(actor);
	    actorNames.add(currentActor);
	    if (!actorsList.contains(currentActor)) {
		actorsList.add(currentActor);
	    }
	}

	//create instance of class Movie and add to movieList if new
	Movie currentMovie = new Movie(name);
	currentMovie.setActors(actorNames);
	if (!movieList.contains(currentMovie)) {
	    movieList.add(currentMovie);
	}
    }

    public void addRating(String name, double rating) {
	int i = movieList.indexOf(new Movie(name));
	movieList.get(i).setRating(rating);
	return;
    }

    public void updateRating(String name, double newRating) {
	int i = movieList.indexOf(new Movie(name));
	movieList.get(i).setRating(newRating);
	return;
    }

    public String getBestActor() {
	
	double max = 0.0;
	String maxName = "none";

	//String actors = actorsList.get(0).toString();
	for(int i = 0; i < actorsList.size(); i++) {
	    
	    double actorRating = 0;
	    int actorRatingCounter = 0;
	    
	    for (int j = 0; j < movieList.size(); j++) {
		if(movieList.get(j).getActors().contains(actorsList.get(i))) {
		    //System.out.println(actorsList.get(i) + " is in " + movieList.get(j).getActors());
		    if (movieList.get(j).getRating() > 0.0) {
			actorRating = actorRating + movieList.get(j).getRating();
			actorRatingCounter++;
		    }
		}
	    }
	    
	    double actorRatingAverage = actorRating / actorRatingCounter;
	    if (actorRatingAverage > max) {
		max = actorRatingAverage;
		maxName = actorsList.get(i).getName();
	    }
	    
	}
	
	return maxName;

    }

    public String getBestMovie() {
	
	double max = 0.0;
	//ArrayList<String> maxNames = new ArrayList<String>();
	String maxName = "none";
	for (int i = 0; i < movieList.size(); i++) {
	    double rating = movieList.get(i).getRating();
	    if (rating > max) {
		max = rating;
		maxName = movieList.get(i).getName();
	    }
	}
	
	return maxName;
	
    }

    public static void main(String[] args) {

	// create a new instance of a movieDatabase.
	MovieDatabase mdb = new MovieDatabase();

	//Add all movies in the file movies.txt.
	try {
	    Scanner txtMovies = new Scanner(new File("movies.txt"));
	    while (txtMovies.hasNextLine()) {

		String[] splitLine = txtMovies.nextLine().split(", ");
		ArrayList<Movie> currentMovieList = new ArrayList<Movie>();

		for (int i = 1; i < splitLine.length; i++) {
		    Movie currentMovie = new Movie(splitLine[i]);
		    currentMovieList.add(currentMovie);

		    Scanner txtActors = new Scanner(new File("movies.txt"));
		    ArrayList<String> theseActors = new ArrayList<String>();

		    while (txtActors.hasNextLine()) {
			String[] line = txtActors.nextLine().split(", ");
			if(Arrays.asList(line).contains(splitLine[i])) {
			    theseActors.add(line[0].toString());
			}
		    }

		    String[] theseActorsArray = new String[theseActors.size()];
		    for (int x = 0; x < theseActors.size(); x++) {
			theseActorsArray[x] = theseActors.get(x);
		    }

		    mdb.addMovie(splitLine[i], theseActorsArray);
		}
		//Actor currentActor = new Actor(splitLine[0]);
		//currentActor.setMovies(currentMovieList);
	    }

	    txtMovies.close();
	}
	catch(IOException e) {
	    e.printStackTrace();
	}

	//Go through the ratings of the movies in the file ratings.txt and add the ratings for the movies.

	try {
	    Scanner txtRatings = new Scanner(new File("ratings.txt"));

	    while (txtRatings.hasNextLine()) {

		String[] splitLine = txtRatings.nextLine().split("\t");
		if(mdb.movieList.contains(new Movie(splitLine[0]))) {
		    mdb.addRating(splitLine[0], Double.parseDouble(splitLine[1]));
		}
	    }

	    txtRatings.close();
	}
	catch(IOException e) {
	    e.printStackTrace();
	}

	//Now call the methods that you created and print out the name of the best actor and the name of the highest rated movie.
	String bestMovie = mdb.getBestMovie();
	System.out.println(bestMovie);
	
	String bestActor = mdb.getBestActor();
	System.out.println(bestActor);

    }




}
