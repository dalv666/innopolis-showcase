
export class Chronology {
    id: string;
    calendarType: string;
}

export class Date {
    year: number;
    month: string;
    era: string;
    dayOfMonth: number;
    dayOfWeek: string;
    dayOfYear: number;
    leapYear: boolean;
    monthValue: number;
    chronology: Chronology;
}

export class Event {
    id: number;
    date: Date;
    capacity: number;
    title: string;
    price: number;
    duration: number;
    location: string;
    picture: string;
    type: string;
}

export class RegDate {
    year: number;
    month: string;
    era: string;
    dayOfMonth: number;
    dayOfWeek: string;
    dayOfYear: number;
    leapYear: boolean;
    monthValue: number;
    chronology: Chronology;
}

export class Avatar {
    id: number;
    picture: string;
}

export class User {
    id: number;
    firstName: string;
    secondName: string;
    login: string;
    password: string;
    regDate: RegDate;
    email: string;
    avatar: Avatar;
}

export class Picture {
    id: number;
    picture: string;
}

export class City {
    name: string;
    id: number;
    picture: Picture;
}

export class Person {
    id: number;
    firstName: string;
    lastName: string;
    photo: Picture;
    description: string;
}

export class Locatione {
    id: number;
    name: string;
    longitude: number;
    latitude: number;
    description: string;
    city: City;
}

export class EventStat {
    evt_id: number;
    evt_title: string;
    evt_type: string;
    evt_price: number;
    lct_name: string;
    visits: number;
    pic_url: string;
}

export class EventCityMaxStat {
    evt_id: number;
    evt_title: string;
    evt_price: number;
    lct_name: string;
    pic_url: string;
}


export class EventCatMaxStat {
    evt_id: number;
    evt_title: string;
    evt_type: string;
    evt_price: number;
    cty_name: string;
}

export class UsersActivityDTO {
    usr_id: number;
    usr_name: string;
    usr_scn_name: string;
    usr_fst_name: string;
    usr_email: string;
    visits: number;
}


export class SearchRequest{
    title: string;
    first: boolean;
    cityName: string;
    second: boolean;
    price: number;
    third: boolean;
    category: string;
}

export class EventDTO {
    id: number;
    title: string;
    type: string;
    pic_link: string;
    duration: number;
    price: number;
    lct_name: string;
    cty_name: string;
}
