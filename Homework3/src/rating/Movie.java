package rating;

import java.util.*;

public class Movie {
    
    //INSTANCE VARIABLES
    private String name;
    private ArrayList<Actor> actors;
    private double rating;
    
    //CONSTRUCTOR
    public Movie(String name) {
	this.name = name;
	this.actors = new ArrayList<Actor>();
	this.rating = 0.0;
    }
    
    //METHODS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Actor> getActors() {
        return actors;
    }
    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    @Override
    public boolean equals(Object o) {
	Movie otherMovie = (Movie)o;
	return this.name.equals(otherMovie.name); //works
	//return this.name == otherMovie.name; //doesn't work
    }
    
    @Override
    public String toString() {
	return name;
    }

}
