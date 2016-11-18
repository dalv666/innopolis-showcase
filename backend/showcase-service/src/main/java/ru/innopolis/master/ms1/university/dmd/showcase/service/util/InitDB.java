package ru.innopolis.master.ms1.university.dmd.showcase.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.*;
import ru.innopolis.master.ms1.university.dmd.showcase.service.config.DataSourceConfig;
import ru.innopolis.master.ms1.university.dmd.showcase.service.config.PersistenceConfig;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.MovieDAO;
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
    private UserDAOCustom userDAO;
    private PictureService pictureService;
    private CityService cityService;
    private LocationService locationService;
    private UserService userService;
    private MovieService movieService;
    private PersonService personService;
    private GroupService groupService;
    private AwardService awardService;
    private SpectacleEventService spectacleEventService;
    private MovieEventService movieEventService;

    @Autowired
    public InitDB(UserDAOCustom userDAO,
                  PictureService pictureService,
                  CityService cityService,
                  LocationService locationService,
                  UserService userService,
                  MovieService movieService,
                  PersonService personService,
                  GroupService groupService,
                  AwardService awardService,
                  SpectacleEventService spectacleEventService,
                  MovieEventService movieEventService) {
        this.userDAO = userDAO;
        this.pictureService = pictureService;
        this.cityService = cityService;
        this.locationService = locationService;
        this.userService = userService;
        this.movieService = movieService;
        this.personService = personService;
        this.groupService = groupService;
        this.awardService = awardService;
        this.spectacleEventService = spectacleEventService;
        this.movieEventService = movieEventService;
    }

    public static final String LOREM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse vitae venenatis sapien, sit amet scelerisque dui.";

    public static final Picture[] PICTURES = {
            new Picture("https://images.unsplash.com/photo-1461567797193-e5b489ac026a?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=9294ccb662f5174d39da333d5025aa84"),
            new Picture("https://images.unsplash.com/photo-1473396413399-6717ef7c4093?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=5d92910bd80f5d362f93337f5e2cc6bd"),
            new Picture("https://images.unsplash.com/photo-1472589757312-2f192d867ee2?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=0776843e16055a640b8983a1ab38099b"),
            new Picture("https://images.unsplash.com/photo-1452626038306-9aae5e071dd3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=f043061c9a5cdbd0fc2f114e2f52f0fd"),
            new Picture("https://images.unsplash.com/photo-1447169685565-fedaa08420df?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=1d07c7e46fcd24c58667b80aed96b5e4"),
            new Picture("https://images.unsplash.com/photo-1472584069410-35e46830b642?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=f518018805c27da0877a726eeb361a04"),
            new Picture("https://images.unsplash.com/photo-1463415268136-e52a5af54519?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=df33064facbaa0e357950b11beb0674f"),
            new Picture("https://images.unsplash.com/photo-1454908027598-28c44b1716c1?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=d9de0ce5f8eb714df8fee97045ab0153"),
            new Picture("https://images.unsplash.com/17/unsplash_5252bb51404f8_1.JPG?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=8b039ddc4a423e54da613e8075b3c588"),
            new Picture("https://images.unsplash.com/photo-1468869196565-78ea346a98ee?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=a97c6d93f742cfe38fc42c23ecbd29dc"),
            new Picture("https://images.unsplash.com/photo-1458891216473-4f26bb4eb40e?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=e6da5085d31b76323195e78284ab3f61"),

            //city
            new Picture("https://images.unsplash.com/photo-1423589989400-cc0270157ed0?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=2a82500a87823929ccc2055a2b0f19f9"),
            //avatar
            new Picture("https://images.unsplash.com/photo-1457706924510-773f3c796de3?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=9d9045d15a89c81ce5b397e844d249f8"),
            //film
            new Picture("https://images.unsplash.com/photo-1468857006728-bba1dba0eb7f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=f3f0f4c583e2d9b59681fccc5b8a24bc"),
            //person
            new Picture("https://images.unsplash.com/photo-1443381301867-5a36ffaafc42?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=210b403c4bca16ba0ca21c46a9996bc0"),
            //group
            new Picture("https://images.unsplash.com/photo-1469566918525-f615c354a7eb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&s=b9f1631c6d8eab30b90061dbd2ef3689"),

            new Picture("http://www.meros.org/uploads/gallery/64/51/03/6465110380d1487aa4d8a8d60ada3128.jpg"),
            new Picture("https://img-fotki.yandex.ru/get/64120/169643165.13/0_10d4c7_15294d7e_XL.jpg"),
            new Picture("http://img-fotki.yandex.ru/get/6839/30348152.197/0_80d0d_8d5e86fd_orig"),
            new Picture("http://www.i-irk.com/upload/gallery/vechernee_foto_irkutska_(2)._71013_70.jpg"),
            new Picture("http://fb.ru/misc/i/gallery/5067/474776.jpg"),
            new Picture("http://img.travel.ru/images2/2004/06/object37298/dvorec_zemledelzev.jpg"),
            new Picture("http://bestvuz.ru/images/goroda/habarovsk1.jpg"),
            new Picture("http://kudago.com/media/images/news/03/68/03683b7cf4d02da61dc69bb0165dca10.jpg"),
            new Picture("http://rprs.sfu-kras.ru/sites/default/files/kommunalnyy_most.jpg"),
            new Picture("http://nesiditsa.ru/wp-content/uploads/2012/07/125.jpg"),
            new Picture("http://www.bankgorodov.ru/public//photos/places/Mah-44546.jpg"),
            new Picture("https://travel.rambler.ru/media/original_images/54aaf2696fb1e.jpg"),
            new Picture("http://stranadetstva30.ru/assets/images/naberezhnye-chelny.jpg"),
            new Picture("http://livepixel.org/wp-content/uploads/2015/03/nnovgorod05.jpeg"),
            new Picture("http://novokuznetsk.go2all.ru/imgs/55/1/83986.jpg"),
            new Picture("http://www.transsiberianfestival.com/media/upload/novosibirsk/Novosib_1.jpg"),
            new Picture("http://nesiditsa.ru/wp-content/uploads/2012/09/516.jpg"),
            new Picture("http://nesiditsa.ru/wp-content/uploads/2012/07/Nochnoy-Orenburg.jpg"),
            new Picture("http://www.my-miir.ru/upload/О%20городе2.jpg"),
            new Picture("http://ppjournal.ru/img/dostopr/dostoprimechatelnosti-permi.jpg"),
            new Picture("http://mama-predprinimatel.ru/upload/iblock/6be/6be0936fadf9bb7fffd37b21c0ccf987.png"),
            new Picture("http://strana.ru/media/images/uploaded/gallery_promo21250667.jpg"),
            new Picture("http://sakvoyage.perm.ru/userfiles/Image/Spb_osen.jpg"),
            new Picture("http://ntt.com.ru/images/gd/samara.jpeg"),
            new Picture("http://travelask.ru/system/images/files/000/052/437/wysiwyg/из_липок.jpg?1442480294"),
            new Picture("https://kudago.com/media/images/place/04/5c/045c736f8f8ec02ce86607af82580d9c.jpg"),
            new Picture("http://tonb.ru/local_history/local_history_images/78.jpg"),
            new Picture("http://nt22.ru/images/ufa-bashkiria.jpg"),
            new Picture("http://strana.ru/media/images/uploaded/gallery_promo20837434.jpg"),
            new Picture("http://deita.ru/upload/iblock/b03/most_zolotoy_rog.jpg"),
            new Picture("http://fifa-worldcup2018.ru/images/volgograd_dostop1.jpg"),
            new Picture("http://kobalt-tur.ru/images/yaroslavlzh.jpg"),
            new Picture("http://mcselect.ru/wp-content/uploads/2015/07/excursion-spain.jpg"),
            new Picture("https://university.innopolis.ru/upload/resize_cache/iblock/8a8/1920_869_275511db9cefbc414a902a46f1b8fae16/150807-DSC_9145-Platonov.jpg"),

    };

    public static final City[] CITIES = {
            new City(51, PICTURES[11], "Innopolis"),
            new City(52, PICTURES[11 + 1], "Astrakhan"),
            new City(53, PICTURES[11 + 2], "Barnaul"),
            new City(54, PICTURES[11 + 3], "Chelyabinsk"),
            new City(55, PICTURES[11 + 4], "Irkutsk"),
            new City(56, PICTURES[11 + 5], "Izhevsk"),
            new City(57, PICTURES[11 + 6], "Kazan"),
            new City(58, PICTURES[11 + 7], "Khabarovsk"),
            new City(59, PICTURES[11 + 8], "Krasnodar"),
            new City(60, PICTURES[11 + 9], "Krasnoyarsk"),
            new City(61, PICTURES[11 + 10], "Lipetsk"),
            new City(62, PICTURES[11 + 11], "Makhachkala"),
            new City(63, PICTURES[11 + 12], "Moscow"),
            new City(64, PICTURES[11 + 13], "Naberezhnyye"),
            new City(65, PICTURES[11 + 14], "Nizhniy Novgorod"),
            new City(66, PICTURES[11 + 15], "Novokuznetsk"),
            new City(67, PICTURES[11 + 16], "Novosibirsk"),
            new City(68, PICTURES[11 + 17], "Omsk"),
            new City(69, PICTURES[11 + 18], "Orenburg"),
            new City(70, PICTURES[11 + 19], "Penza"),
            new City(71, PICTURES[11 + 20], "Perm"),
            new City(72, PICTURES[11 + 21], "Rostov-na-Donu"),
            new City(73, PICTURES[11 + 22], "Ryazan"),
            new City(74, PICTURES[11 + 23], "Saint-Petersburg"),
            new City(75, PICTURES[11 + 24], "Samara"),
            new City(76, PICTURES[11 + 25], "Saratov"),
            new City(77, PICTURES[11 + 26], "Tolyatti"),
            new City(78, PICTURES[11 + 27], "Tyumen"),
            new City(79, PICTURES[11 + 28], "Ufa"),
            new City(80, PICTURES[11 + 29], "Ulyanovsk"),
            new City(81, PICTURES[11 + 30], "Vladivostok"),
            new City(82, PICTURES[11 + 31], "Volgograd"),
            new City(83, PICTURES[11 + 32], "Yaroslavl"),
            new City(84, PICTURES[11 + 33], "Yekaterinburg"),
    };


    public static final Location[] LOCATIONS = {
            new Location(0, "University", 124123, 124213, "Large porch near the university", CITIES[0]),
            new Location(1, "Hohoho", 124128, 124219, "Something strange", CITIES[0]),
            new Location(2, "Hohoho2", 124128, 124249, "Something!", CITIES[1]),
            new Location(3, "qwkejwq", 124128, 124249, "Kekeke!", CITIES[1]),
            new Location(4, "Gege", 124128, 124249, "loc4", CITIES[2]),
            new Location(5, "Meme", 124128, 124249, "loc5", CITIES[2]),
            new Location(6, "Pepe", 124128, 124249, "loc6", CITIES[3]),
            new Location(7, "Lele", 124128, 124249, "loc7", CITIES[3]),
            new Location(8, "Hehe", 124128, 124249, "loc8", CITIES[4]),
            new Location(9, "Dede", 124128, 124249, "loc9", CITIES[4]),
            new Location(10, "Zeze", 124128, 124249, "loc10", CITIES[5]),
            new Location(11, "Uran", 12128, 124249, "loc11", CITIES[5]),
    };

    public static final User[] USERS = {
            //new User(0, "Anton", "Pertowich", "Nikita", "password", LocalDate.now(), "anton@gmail.com", PICTURES[12]),
            //new User(1, "Anton", "Pertowich", "Anton", "password", LocalDate.now(), "anton@gmail.com", PICTURES[14]),
            //new User(2, "Anton", "Pertowich", "Gosha", "password", LocalDate.now(), "anton@gmail.com", PICTURES[15]),
            //new User(3, "Anton", "Pertowich", "Toxa", "password", LocalDate.now(), "anton@gmail.com", PICTURES[12]),
    };

    static int mn1 = 97;
    public static final Movie[] MOVIES = {
            new Movie(mn1 + 0, "Inception", LocalDate.now(), "Fantasy", "A cool story about dreams.", PICTURES[13]),
            new Movie(mn1 + 1, "Фантастические твари", LocalDate.now(), "Fantasy",
                    //"Фильм рассказывает о приключениях писателя Ньюта Скамандера в Нью-Йоркском секретном обществе волшебниц и волшебников, происходивших за 70 лет до того, как Гарри Поттер прочитает книгу этого писателя в школе.",
                    "Фильм рассказывает о приключениях писателя Ньюта Скамандера в Нью-Йоркском секретном обществе волшебниц и волшебников",
                    PICTURES[13]),
            new Movie(mn1 + 2, "Прибытие", LocalDate.now(), "Fantasy",
                    //"Неожиданное появление неопознанных летающих объектов в разных точках планеты повергает мир в трепет. Намерения пришельцев не ясны — вооружённые силы всего мира приведены в полную боевую готовность, а лучшие умы человечества пытаются понять, как разговаривать с непрошенными гостями. Правительство обращается за помощью к лингвисту Луизе Бэнкс и физику Яну Доннели, чтобы предотвратить глобальную катастрофу и найти общий язык с пришельцами. Отныне судьба человечества находится в их руках.",
                    "Неожиданное появление неопознанных летающих объектов в разных точках планеты повергает мир в трепет. Намерения пришельцев не ясны...",
                    PICTURES[13]
            ),
            new Movie(mn1 + 3, "Доктор Стрэндж", LocalDate.now(), "Fantasy",
                    //"Страшная автокатастрофа поставила крест на карьере успешного нейрохирурга Доктора Стрэнджа. Отчаявшись, он отправляется в путешествие в поисках исцеления и открывает в себе невероятные способности к трансформации пространства и времени. Теперь он — связующее звено между параллельными измерениями, а его миссия — защищать жителей Земли и противодействовать Злу, какое бы обличие оно ни принимало.",
                    "Страшная автокатастрофа поставила крест на карьере успешного нейрохирурга Доктора Стрэнджа. Отчаявшись, он отправляется в путешествие в поисках исцеления и открывает в себе невероятные способности к трансформации пространства и времени.",
                    PICTURES[13]
            ),
            new Movie(mn1 + 4, "Дама Пик", LocalDate.now(), "Drama",
                    //"Оперная дива Софья Майер после долгих лет эмиграции возвращается в Россию. Певица намерена поставить «Пиковую даму» Чайковского на сцене, где когда-то дебютировала. Спектакль, без сомнения, станет событием сезона, а все актеры постановки проснутся знаменитыми. О славе и деньгах мечтает молодой певец оперной труппы Андрей, и «Пиковая дама» для него шанс достичь желаемого. Он готов на всё, чтобы получить роль Германна, и об этом догадывается Софья, оставившая для себя роль Графини. Оперная дива начинает жестокую игру, в которую будут вовлечены все участники спектакля.",
                    "Оперная дива Софья Майер после долгих лет эмиграции возвращается в Россию. Певица намерена поставить «Пиковую даму» Чайковского на сцене...",
                    PICTURES[13]
            ),
            new Movie(mn1 + 5, "По соображениям совести", LocalDate.now(), "Drama",
                    //"Медик Американской армии времён Второй Мировой войны Дезмонд Досс, который служил во время битвы за Окинаву, отказывается убивать людей и становится первым идейным уклонистом в американской истории, удостоенным Медали Почёта.",
                    "Медик Американской армии времён Второй Мировой войны Дезмонд Досс, который служил во время битвы за Окинаву, отказывается убивать людей",
                    PICTURES[13]
            ),
            new Movie(mn1 + 6, "Хороший мальчик", LocalDate.now(), "Drama",
                    //"Обычная, казалось бы, неделя из жизни ничем не примечательного школьника Коли Смирнова превращается в череду невероятных происшествий: Коля влюбляется в учительницу английского, кто-то поджигает школьную пристройку с новыми компьютерами, а папа Коли заявляет семье о необходимости отказа от ночного сна, из-за чего никому в доме не удаётся выспаться и собраться с мыслями. Вдобавок в самого Колю влюбляется дочка директора, старшеклассница Ксюша, решившая, что это именно он поджёг школу. Остаётся всего несколько дней до субботнего праздника школы, где должны встретиться все действующие лица этого водоворота событий, и теперь хорошему мальчику Коле необходимо успеть разобраться со своей личной жизнью, расследовать поджог и наладить взаимоотношения с родителями. Фильм получил главный приз XXVII Открытого Российского кинофестиваля «Кинотавр» (2016).",
                    "Обычная, казалось бы, неделя из жизни ничем не примечательного школьника Коли Смирнова",
                    PICTURES[13]
            ),
            new Movie(mn1 + 7, "Хороdqwdqwший мальчик", LocalDate.now(), "Drama",
                    "Blablabla",
                    PICTURES[13]
            ),
            new Movie(mn1 + 8, "Старый мальчик", LocalDate.now(), "Drama",
                    "Людоед и паспорт",
                    PICTURES[13]
            ),
            new Movie(mn1 + 9, "Старый мальчик", LocalDate.now(), "Drama",
                    "Людоед и паспорт",
                    PICTURES[13]
            ),
            new Movie(mn1 + 10, "Напал дед", LocalDate.now(), "Horror",
                    "Напал дед",
                    PICTURES[13]
            ),

    };

    final static int mn2 = 108;
    public static final Person[] PERSONS = {
            new Person(mn2 + 0, "Your", "Dad", "qwdklwqdk@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 1, "anessa", "Jones", "vanessa.jones@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 2, "Robert", "Abraham", "robert.abraham@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 3, "Tim", "Wilkins", "tim.wilkins@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 4, "Madeleine", "Gill", "madeleine.gill@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 5, "Fiona", "White", "fiona.white@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 6, "Joe", "Glover", "joe.glover@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 7, "Amanda", "Walsh", "amanda.walsh@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 8, "Robert", "Robertson", "robert.robertson@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 9, "Lillian", "Ogden", "lillian.ogden@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 10, "Leah", "Mathis", "leah.mathis@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 11, "Piers", "Henderson", "piers.henderson@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 12, "Michael", "Pullman", "michael.pullman@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 13, "Vanessa", "Fraser", "vanessa.fraser@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 14, "Lauren", "Rutherford", "lauren.rutherford@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 15, "Blake", "Vaughan", "blake.vaughan@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 16, "Katherine", "Young", "katherine.young@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 17, "Ruth", "Terry", "ruth.terry@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 18, "Amanda", "Hardacre", "amanda.hardacre@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 19, "Christian", "Anderson", "christian.anderson@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 20, "Leonard", "Lee", "leonard.lee@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 21, "Joanne", "Hardacre", "joanne.hardacre@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 22, "Trevor", "Gibson", "trevor.gibson@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 23, "Ruth", "Brown", "ruth.brown@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 24, "David", "Howard", "david.howard@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 25, "Claire", "Rampling", "claire.rampling@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 26, "Alan", "Mathis", "alan.mathis@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 27, "Sophie", "Mills", "sophie.mills@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 28, "Kevin", "Newman", "kevin.newman@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 29, "Christopher", "Murray", "christopher.murray@gmail.com", null, null, PICTURES[14]),
            new Person(mn2 + 30, "Jennifer", "Turner", "jennifer.turner@gmail.com", null, null, PICTURES[14]),
    };

    public static final Group[] GROUPS = {
            new Group(0, "PartyMakers", LocalDate.now(), "Free", PICTURES[15])
    };


    public static final Award[] AWARDS = {
            new Award(0, "Big pandus", LocalDate.now()),
            new Award(1, "Golden drum", LocalDate.now()),
            new Award(2, "Oscar", LocalDate.now()),
            new Award(3, "Noble Price", LocalDate.now()),
            new Award(4, "Price #4", LocalDate.now()),
            new Award(5, "Price #5", LocalDate.now()),
            new Award(6, "Price $$$", LocalDate.now()),
            new Award(7, "Price SSS", LocalDate.now()),
            new Award(8, "Price QQQ", LocalDate.now()),
            new Award(9, "Price EEE", LocalDate.now()),
    };

    public static final String SPEC_EVENT_TYPE = "SPECTACLE";
    public static final String MOVIE_EVENT_TYPE = "MOVIE";
    public static final String GROUP_EVENT_TYPE = "GROUP";

    public static final SpectacleEvent[] SPECTACLE_EVENTS = {
            new SpectacleEvent(150 + 0, LocalDate.now(), 120, "Spectacle Event#1", 350, 100, LOREM, LOCATIONS[0], PICTURES[0], PERSONS[0], SPEC_EVENT_TYPE),
            new SpectacleEvent(150 + 1, LocalDate.now(), 180, "Spectacle Event#2", 50, 120, LOREM, LOCATIONS[0], PICTURES[1], PERSONS[1], SPEC_EVENT_TYPE),
            new SpectacleEvent(150 + 2, LocalDate.now(), 240, "Spectacle Event#3", 30, 110, LOREM, LOCATIONS[0], PICTURES[2], PERSONS[2], SPEC_EVENT_TYPE),
            new SpectacleEvent(150 + 3, LocalDate.now(), 100, "Spectacle Event#4", 20, 112, LOREM, LOCATIONS[0], PICTURES[3], PERSONS[3], SPEC_EVENT_TYPE),
            new SpectacleEvent(150 + 4, LocalDate.now(), 90, "Spectacle Event#5", 140, 119, LOREM, LOCATIONS[0], PICTURES[4], PERSONS[4], SPEC_EVENT_TYPE),
            new SpectacleEvent(150 + 5, LocalDate.now(), 70, "Spectacle Event#6", 10, 200, LOREM, LOCATIONS[0], PICTURES[5], PERSONS[5], SPEC_EVENT_TYPE),
            new SpectacleEvent(150 + 6, LocalDate.now(), 99, "Spectacle Event#7", 800, 50, LOREM, LOCATIONS[0], PICTURES[6], PERSONS[6], SPEC_EVENT_TYPE)
    };


    public static final MovieEvent[] MOVIE_EVENTS = {
            new MovieEvent(0, LocalDate.now(), 140, "Movie Event#1", 234, 241, LOREM, LOCATIONS[0], PICTURES[7], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[0]),
            new MovieEvent(1, LocalDate.now(), 160, "Movie Event#2", 164, 241, LOREM, LOCATIONS[0], PICTURES[8], MOVIE_EVENT_TYPE, "small", "russian", MOVIES[1]),
            new MovieEvent(2, LocalDate.now(), 170, "Movie Event#3", 126, 241, LOREM, LOCATIONS[1], PICTURES[9], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[2]),
            new MovieEvent(3, LocalDate.now(), 144, "Movie Event#4", 154, 241, LOREM, LOCATIONS[1], PICTURES[10], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[3]),
            new MovieEvent(4, LocalDate.now(), 140, "Movie Event#5", 234, 241, LOREM, LOCATIONS[0], PICTURES[7], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[4]),
            new MovieEvent(5, LocalDate.now(), 160, "Movie Event#6", 164, 241, LOREM, LOCATIONS[0], PICTURES[8], MOVIE_EVENT_TYPE, "small", "russian", MOVIES[5]),
            new MovieEvent(6, LocalDate.now(), 170, "Movie Event#7", 126, 241, LOREM, LOCATIONS[1], PICTURES[9], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[6]),
            new MovieEvent(7, LocalDate.now(), 144, "Movie Event#8", 154, 241, LOREM, LOCATIONS[1], PICTURES[10], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[7]),
            new MovieEvent(8, LocalDate.now(), 114, "Movie Event#9", 154, 241, LOREM, LOCATIONS[2], PICTURES[14], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[8]),
            new MovieEvent(9, LocalDate.now(), 124, "Movie Event#10", 154, 241, LOREM, LOCATIONS[2], PICTURES[14], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[9]),
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

        MovieEvent[] MovieEEE = {
                new MovieEvent(0, LocalDate.now(), 140, "Movie Event#1", 234, 241, LOREM, locationService.findById((long) 0), PICTURES[7], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[0]),
                new MovieEvent(1, LocalDate.now(), 160, "Movie Event#2", 164, 241, LOREM, locationService.findById((long) 0), PICTURES[8], MOVIE_EVENT_TYPE, "small", "russian", MOVIES[1]),
                new MovieEvent(2, LocalDate.now(), 170, "Movie Event#3", 126, 241, LOREM, locationService.findById((long) 1), PICTURES[9], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[2]),
                new MovieEvent(3, LocalDate.now(), 144, "Movie Event#4", 154, 241, LOREM, locationService.findById((long) 1), PICTURES[10], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[3]),
                new MovieEvent(4, LocalDate.now(), 140, "Movie Event#5", 234, 241, LOREM, locationService.findById((long) 2), PICTURES[7], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[4]),
                new MovieEvent(5, LocalDate.now(), 160, "Movie Event#6", 164, 241, LOREM, locationService.findById((long) 2), PICTURES[8], MOVIE_EVENT_TYPE, "small", "russian", MOVIES[5]),
                new MovieEvent(6, LocalDate.now(), 170, "Movie Event#7", 126, 241, LOREM, locationService.findById((long) 3), PICTURES[9], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[6]),
                new MovieEvent(7, LocalDate.now(), 144, "Movie Event#8", 154, 241, LOREM, locationService.findById((long) 3), PICTURES[10], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[7]),
                new MovieEvent(8, LocalDate.now(), 114, "Movie Event#9", 154, 241, LOREM, locationService.findById((long) 4), PICTURES[14], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[8]),
                new MovieEvent(9, LocalDate.now(), 124, "Movie Event#10", 154, 241, LOREM, locationService.findById((long) 4), PICTURES[14], MOVIE_EVENT_TYPE, "big", "russian", MOVIES[9]),
        };

        //for (MovieEvent movieEvent : MOVIE_EVENTS) {
        for (MovieEvent movieEvent : MovieEEE) {
            MovieEvent movieEvent1 = movieEventService.create(movieEvent);
            for (User user : all) {
                userDAO.userGoEvent(user.getId(), movieEvent1.getId());
            }
        }
    }

}
