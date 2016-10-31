import {Injectable} from '@angular/core';

import {Event} from './../model/event';
import {User} from './../model/models';
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
}
