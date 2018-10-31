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
        actor.setName("new movie");
        actor.setRealName("adreano mores");
        actor.setAge("23");

        Set<Actor> actors = new HashSet<>();
        actors.add(actor);

        Movie movie = new Movie();
        movie.setTitle("old");
        movie.setYear(2017);
        movie.setDescription("Description about First Movie");
        movies.add(movie);
        movieRepository.save(movie);

        Movie othermovie = new Movie();
        othermovie.setTitle("mymovie");
        othermovie.setYear(2013);
        othermovie.setDescription("The second movie description");
        movies.add(othermovie);
        movieRepository.save(othermovie);

        Movie anOtherMovie = new Movie();
        anOtherMovie.setTitle("coming soon");
        anOtherMovie.setYear(2000);
        anOtherMovie.setDescription("Thrid movie description");

        //add the movie to an empty  list
         movies.add(anOtherMovie);
         movieRepository.save(anOtherMovie);

        // add the list of movies to the actor's movie list
        actor.setMovies(movies);
        // Save the actor to the database
        actorRepository.save(actor);

        //Grade all actors from the database and send them to the template.

        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("movie", movieRepository.findAll());
        return "index";
    }
}
