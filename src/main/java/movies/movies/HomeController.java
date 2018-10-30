package movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;
@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;


    @RequestMapping("/")
    public String index(Model model){
        Set<Movie> movies = new HashSet<Movie>();

        Actor actor = new Actor();
        actor.setName("Sandra Bullocke");
        actor.setRealName("Sandra Mae Bullowski");
        actor.setAge("24");

        Set<Actor> actors = new HashSet<>();
        actors.add(actor);



        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emoji movie");

        movies.add(movie);
        Movie othermovie = new Movie();
        movie.setTitle("Big Bang");
        movie.setYear(2013);
        movie.setDescription("The best movies i hav ever seen");
        movies.add(othermovie);


        Movie anOtherMovie = new Movie();
        anOtherMovie.setTitle("anOtherMovie");
        anOtherMovie.setYear(2000);
        anOtherMovie.setDescription("She is a cop who goes undercover");


        //add the movie to an empty  list
        movies.add(anOtherMovie);


        // add the list of movies to the actor's movie list
        actor.setMovies(movies);
        // Save the actor to the database
        actorRepository.save(actor);

        //Grade all actors from the database and send them to the template.

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
