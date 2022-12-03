package rating;

import java.util.*;

public class Actor {
    
    //INSTANCE VARIABLES
    private String name;
    private ArrayList<Movie> movies;
    
    //CONSTRUCTOR
    public Actor(String name) {
	this.name = name;
	this.movies = new ArrayList<Movie>();
    }
    
    //METHODS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    
    @Override
    public boolean equals(Object o) {
	Actor otherActor = (Actor)o;
	return this.name.equals(otherActor.name); //works
	//return this.name == otherActor.name; //works
    }
    
    @Override
    public String toString() {
	return name;
    }

}
