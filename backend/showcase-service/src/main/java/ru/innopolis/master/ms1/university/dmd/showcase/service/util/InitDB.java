package ru.innopolis.master.ms1.university.dmd.showcase.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.*;
import ru.innopolis.master.ms1.university.dmd.showcase.service.config.DataSourceConfig;
import ru.innopolis.master.ms1.university.dmd.showcase.service.config.PersistenceConfig;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.UserDAOCustom;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by dalv on 26.10.2016.
 */
@Component
@ComponentScan(basePackages = "ru.innopolis.master.ms1.university.dmd.showcase.service.service")
public class InitDB {

    @Autowired
    private UserDAOCustom userDAO;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private CityService cityService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private PersonService personService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private AwardService awardService;

    @Autowired
    private SpectacleEventService spectacleEventService;

    @Autowired
    private MovieEventService movieEventService;

    public static final String LOREM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse vitae venenatis sapien, sit amet scelerisque dui.";

    public static final Picture[] PICTURES = {
            new Picture(0, "https://images.unsplash.com/photo-1461567797193-e5b489ac026a?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=9294ccb662f5174d39da333d5025aa84"),
            new Picture(1, "https://images.unsplash.com/photo-1473396413399-6717ef7c4093?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=5d92910bd80f5d362f93337f5e2cc6bd"),
            new Picture(2, "https://images.unsplash.com/photo-1472589757312-2f192d867ee2?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=0776843e16055a640b8983a1ab38099b"),
            new Picture(3, "https://images.unsplash.com/photo-1452626038306-9aae5e071dd3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=f043061c9a5cdbd0fc2f114e2f52f0fd"),
            new Picture(4, "https://images.unsplash.com/photo-1447169685565-fedaa08420df?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=1d07c7e46fcd24c58667b80aed96b5e4"),
            new Picture(5, "https://images.unsplash.com/photo-1472584069410-35e46830b642?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=f518018805c27da0877a726eeb361a04"),
            new Picture(6, "https://images.unsplash.com/photo-1463415268136-e52a5af54519?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=df33064facbaa0e357950b11beb0674f"),
            new Picture(7, "https://images.unsplash.com/photo-1454908027598-28c44b1716c1?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=d9de0ce5f8eb714df8fee97045ab0153"),
            new Picture(8, "https://images.unsplash.com/17/unsplash_5252bb51404f8_1.JPG?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=8b039ddc4a423e54da613e8075b3c588"),
            new Picture(9, "https://images.unsplash.com/photo-1468869196565-78ea346a98ee?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=a97c6d93f742cfe38fc42c23ecbd29dc"),
            new Picture(10, "https://images.unsplash.com/photo-1458891216473-4f26bb4eb40e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=e6da5085d31b76323195e78284ab3f61"),

            //city
            new Picture(11, "https://images.unsplash.com/photo-1423589989400-cc0270157ed0?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=2a82500a87823929ccc2055a2b0f19f9"),
            //avatar
            new Picture(12, "https://images.unsplash.com/photo-1457706924510-773f3c796de3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=9d9045d15a89c81ce5b397e844d249f8"),
            //film
            new Picture(13, "https://images.unsplash.com/photo-1468857006728-bba1dba0eb7f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=f3f0f4c583e2d9b59681fccc5b8a24bc"),
            //person
            new Picture(14, "https://images.unsplash.com/photo-1443381301867-5a36ffaafc42?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=210b403c4bca16ba0ca21c46a9996bc0"),
            //group
            new Picture(15, "https://images.unsplash.com/photo-1469566918525-f615c354a7eb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=b9f1631c6d8eab30b90061dbd2ef3689")
    };

    public static final City[] CITIES = {
            new City(0, PICTURES[11], "Innopolis"),
    };


    public static final Location[] LOCATIONS = {
            new Location(0, "University", 124123, 124213, "Large porch near the university", CITIES[0])
    };


    public static final User[] USERS = {
            new User(0, "Anton", "Pertowich", "Nikita", "password", LocalDate.now(), "anton@gmail.com", PICTURES[12]),
            new User(1, "Anton", "Pertowich", "Anton", "password", LocalDate.now(), "anton@gmail.com", PICTURES[14]),
            new User(2, "Anton", "Pertowich", "Gosha", "password", LocalDate.now(), "anton@gmail.com", PICTURES[15]),
            new User(3, "Anton", "Pertowich", "Toxa", "password", LocalDate.now(), "anton@gmail.com", PICTURES[12]),
    };

    public static final Movie[] MOVIES = {
            new Movie(0, "Inception", LocalDate.now(), "Fantasy", "A cool story about dreams.", PICTURES[13])
    };

    public static final Person[] PERSONS = {
            new Person(0, "Your", "Dad", null, null, PICTURES[14], "Help everyone")
    };

    public static final Group[] GROUPS = {
            new Group(0, "PartyMakers", LocalDate.now(), "Free", PICTURES[15])
    };


    public static final Award[] AWARDS = {
            new Award(0, "Big pandus", LocalDate.now())
    };

    public static final String SPEC_EVENT_TYPE = "SPECTACLE";
    public static final String MOVIE_EVENT_TYPE = "MOVIE";
    public static final String GROUP_EVENT_TYPE = "GROUP";

    public static final SpectacleEvent[] SPECTACLE_EVENTS = {
            new SpectacleEvent(0, LocalDate.now(), 140, "Spectacle Event#1", 124, 241, LOREM, LOCATIONS[0], PICTURES[0], PERSONS[0], SPEC_EVENT_TYPE),
            new SpectacleEvent(1, LocalDate.now(), 140, "Spectacle Event#2", 124, 241, LOREM, LOCATIONS[0], PICTURES[1], PERSONS[0], SPEC_EVENT_TYPE),
            new SpectacleEvent(2, LocalDate.now(), 140, "Spectacle Event#3", 124, 241, LOREM, LOCATIONS[0], PICTURES[2], PERSONS[0], SPEC_EVENT_TYPE),
            new SpectacleEvent(3, LocalDate.now(), 140, "Spectacle Event#4", 124, 241, LOREM, LOCATIONS[0], PICTURES[3], PERSONS[0], SPEC_EVENT_TYPE),
            new SpectacleEvent(4, LocalDate.now(), 140, "Spectacle Event#5", 124, 241, LOREM, LOCATIONS[0], PICTURES[4], PERSONS[0], SPEC_EVENT_TYPE),
            new SpectacleEvent(5, LocalDate.now(), 140, "Spectacle Event#6", 124, 241, LOREM, LOCATIONS[0], PICTURES[5], PERSONS[0], SPEC_EVENT_TYPE),
            new SpectacleEvent(6, LocalDate.now(), 140, "Spectacle Event#7", 124, 241, LOREM, LOCATIONS[0], PICTURES[6], PERSONS[0], SPEC_EVENT_TYPE)
    };


    public static final MovieEvent[] MOVIE_EVENTS = {
            new MovieEvent(7, LocalDate.now(), 140, "Movie Event#1", 234, 241, LOREM, LOCATIONS[0], PICTURES[7], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[0]),
            new MovieEvent(8, LocalDate.now(), 160, "Movie Event#2", 164, 241, LOREM, LOCATIONS[0], PICTURES[8], MOVIE_EVENT_TYPE, "small", "russian", MOVIES[0]),
            new MovieEvent(9, LocalDate.now(), 170, "Movie Event#3", 126, 241, LOREM, LOCATIONS[0], PICTURES[9], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[0]),
            new MovieEvent(10, LocalDate.now(), 144, "Movie Event#4", 154, 241, LOREM, LOCATIONS[0], PICTURES[10], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[0]),
    };

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                InitDB.class,
                DataSourceConfig.class, // init test database
//                DataSourceConfig.class, // init non test database
                PersistenceConfig.class
        );

        InitDB initTestDatabase = context.getBean(InitDB.class);

        initTestDatabase.initDB();
    }


    public void initDB() {

        for (Picture picture : PICTURES) {
            pictureService.create(picture);
        }

        for (City city : CITIES) {
            cityService.create(city);
        }

        for (Location location : LOCATIONS) {
            locationService.create(location);
        }

        for (User user : USERS) {
            userService.create(user);
        }

        for (Movie movy : MOVIES) {
            movieService.create(movy);
        }

        for (Person person : PERSONS) {
            personService.create(person);
        }

        for (Group group : GROUPS) {
            groupService.create(group);
        }

        for (Award award : AWARDS) {
            awardService.create(award);
        }

        List<Group> all1 = groupService.findAll();

        List<User> all = userService.findAll();
        for (SpectacleEvent event : SPECTACLE_EVENTS) {
            SpectacleEvent spectacleEvent = spectacleEventService.create(event);
            spectacleEvent.setAuthors(all1.get(0));
            for (User user : all) {
                userDAO.userGoEvent(user.getId(), spectacleEvent.getId());
            }
        }

        for (MovieEvent movieEvent : MOVIE_EVENTS) {
            MovieEvent movieEvent1 = movieEventService.create(movieEvent);
            for (User user : all) {
                userDAO.userGoEvent(user.getId(), movieEvent1.getId());
            }
        }
    }

}
