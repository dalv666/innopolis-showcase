
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
}
