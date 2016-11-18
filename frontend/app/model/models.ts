
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
