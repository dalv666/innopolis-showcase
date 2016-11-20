import {Injectable} from '@angular/core';

import {Event} from './../model/event';
import {User, EventStat, EventCityMaxStat,EventCatMaxStat,UsersActivityDTO} from './../model/models';
import { Headers, Http,Response } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import 'rxjs/Rx';

@Injectable()
export class EventService{

  private heroesUrl = 'http://localhost:8080/rest/events';  // URL to web api
  private heroeUrl = 'http://localhost:8080/rest/event/';  // URL to web api



  constructor(private http: Http) { }

  getEvents():Observable<Event[]> {
    return this.http.get(this.heroesUrl)
                    .map(this.extractData)
                    .catch(this.handleError);
  }


  private extractData(res: Response) {
    let body = res.json();
    console.error(body);
    return body || {};
  }

  private handleError (error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

  getEvent(id:number):Observable<Event>{
    return this.http.get(this.heroeUrl + "" + id)
                    .map(this.extractData)
                    .catch(this.handleError);
  }

  getEventUsers(id:number):Observable<User[]>{
    return this.http.get(this.heroeUrl + "" + id + "/users/")
                    .map(this.extractData)
                    .catch(this.handleError);
  }


  private eventAttendStat = 'http://localhost:8080/rest/event/attend/stat';  // URL to web api

  getEventStatAttendStat():Observable<EventStat[]>{
    return this.http.get(this.eventAttendStat)
                    .map(this.extractData)
                    .catch(this.handleError);
  }

  private eventMaxPriceURL = 'http://localhost:8080/rest/event/max/city';

  getEventMaxPriceCityDTO():Observable<EventCityMaxStat[]>{
    return this.http.get(this.eventMaxPriceURL)
                    .map(this.extractData)
                    .catch(this.handleError);
  }

private eventCatMaxStatURL = 'http://localhost:8080/rest/event/max/cat';

  getEventCatMaxStat():Observable<EventCatMaxStat[]>{
    return this.http.get(this.eventCatMaxStatURL)
                    .map(this.extractData)
                    .catch(this.handleError);
  }

private usersActivityDTOURL = 'http://localhost:8080/rest/user/actives';
  getUsersActivityDTO():Observable<UsersActivityDTO[]>{
    return this.http.get(this.usersActivityDTOURL)
                    .map(this.extractData)
                    .catch(this.handleError);
  }


}
