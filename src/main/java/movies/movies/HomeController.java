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
        Actor actor = new Actor();
        actor.setName("Sandra Bullocke");
        actor.setRealName("Sandra Mae Bullowski");

        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emoji movie");

        //add the movie to an empty  list

        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);


        // add the list of movies to the actor's movie list
        actor.setMovies(movies);
        // Save the actor to the database
        actorRepository.save(actor);

        //Grade all actors from the database and send them to the template.

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
