package pl.com.bottega.cms.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.com.bottega.cms.application.*;
import pl.com.bottega.cms.model.commands.CreateCinemaCommand;
import pl.com.bottega.cms.model.commands.CreateMovieCommand;
import pl.com.bottega.cms.model.commands.CreateShowsCommand;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CreateMovieTest extends AcceptanceTest {

    @Autowired
    private CreateMovieHandler createMovieHandler;

    @Autowired
    private MovieFinder movieFinder;

    @Test
    public void shouldCreateMovie() {
//        Set<String> actors = new HashSet<>();
//        actors.add("John");
//        actors.add("Samara");
//
//        Set<String> genres = new HashSet<>();
//        genres.add("a");
//        genres.add("b");
//
//        CreateMovieCommand creteCreateMovieCommand = new CreateMovieCommand();
//        creteCreateMovieCommand.setActors(actors);
//        creteCreateMovieCommand.setDescription("description");
//        creteCreateMovieCommand.setGenres(genres);
//        creteCreateMovieCommand.setLength(200);
//        creteCreateMovieCommand.setMinAge(16);
//        creteCreateMovieCommand.setTitle("title");
//        createMovieHandler.handle(creteCreateMovieCommand);
//
//        CreateShowsCommand createShowsCommand = new CreateShowsCommand();
//        createShowsCommand.setCinemaId(1L);
//        createShowsCommand.set;
//
//        List<CinemaDto> cinemas = movieFinder.getMovies(1, );
//        assertEquals(cinemas.get(0).getCity(), "Lublin");
//        assertEquals(cinemas.get(0).getName(), "Bajka");
//        assertEquals(cinemas.get(0).getId(), new Long(1));





    }
}
